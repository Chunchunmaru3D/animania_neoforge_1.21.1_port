[CmdletBinding()]
param(
	[string] $ReferenceRoot = 'X:\MODS\AnimaniaChatGPT\AnimaniaWorkspace\reference\animaniamod-1.12\animaniamod-1.12',
	[string] $PortRoot,
	[ValidateSet('Summary', 'Missing', 'Changed', 'New', 'Identical', 'Relocated', 'Collisions', 'All')]
	[string] $View = 'Summary',
	[string] $TopLevel,
	[switch] $IncludeLegacyData,
	[string] $RulesPath,
	[switch] $AsJson
)

<#
.SYNOPSIS
Compares the effective 1.12 Animania asset namespaces with the 1.21.1 port.

.DESCRIPTION
Forge 1.12 kept the farm, extra and catsdogs addon resources in separate source
trees. At runtime all four trees contributed to the animania namespace. This
script flattens those trees first, then compares normalized relative paths and
SHA-256 hashes with src/main/resources/assets/animania.

player_anim is deliberately excluded: it is a separate legacy dependency, not
an Animania namespace source tree. The script reports any source-path collision
instead of silently choosing one addon over another.

By default this is an asset audit: 1.12 advancement, recipe and loot-table JSON
are excluded because their modern counterparts belong under data/animania and
are audited separately. Pass -IncludeLegacyData only to inspect those legacy
data files as raw resources.

.EXAMPLE
.\tools\Compare-AnimaniaAssets.ps1
.\tools\Compare-AnimaniaAssets.ps1 -View Missing
.\tools\Compare-AnimaniaAssets.ps1 -View All -AsJson
#>

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

if ([string]::IsNullOrWhiteSpace($PortRoot))
{
	$PortRoot = Join-Path $PSScriptRoot '..\src\main\resources\assets\animania'
}
if ([string]::IsNullOrWhiteSpace($RulesPath))
{
	$RulesPath = Join-Path $PSScriptRoot 'asset-audit-rules.json'
}

function Get-RelativeAssetPath
{
	param([string] $Root, [string] $FullName)
	return $FullName.Substring($Root.Length).TrimStart('\', '/').Replace('\', '/').ToLowerInvariant()
}

function Get-AssetRecord
{
	param([string] $Root, [string] $FullName, [string] $Origin)
	return [pscustomobject]@{
		Path = Get-RelativeAssetPath $Root $FullName
		Hash = (Get-FileHash -LiteralPath $FullName -Algorithm SHA256).Hash.ToLowerInvariant()
		Bytes = (Get-Item -LiteralPath $FullName).Length
		Origin = $Origin
	}
}

function New-ComparisonEntry
{
	param([string] $Status, $Source, $Port, [string] $Classification, [string] $Reason)
	$path = if ($null -ne $Source) { $Source.Path } else { $Port.Path }
	$resolved = Resolve-AssetClassification $Status $path $Classification $Reason
	return [pscustomobject]@{
		Status = $Status
		Path = $path
		CounterpartPath = if ($null -ne $Source -and $null -ne $Port) { $Port.Path } else { '' }
		Classification = $resolved.Classification
		Reason = $resolved.Reason
		SourceOrigin = if ($null -ne $Source) { $Source.Origin } else { '' }
		SourceBytes = if ($null -ne $Source) { $Source.Bytes } else { 0 }
		PortBytes = if ($null -ne $Port) { $Port.Bytes } else { 0 }
	}
}

if (-not (Test-Path -LiteralPath $ReferenceRoot))
{
	throw "Reference root does not exist: $ReferenceRoot"
}
if (-not (Test-Path -LiteralPath $PortRoot))
{
	throw "Port assets root does not exist: $PortRoot"
}

# Resolve before deriving relative paths: the default contains tools\\.. and
# therefore has a different string length from every normalized child path.
$ReferenceRoot = (Resolve-Path -LiteralPath $ReferenceRoot).Path
$PortRoot = (Resolve-Path -LiteralPath $PortRoot).Path

$assetRules = @()
if (Test-Path -LiteralPath $RulesPath)
{
	$assetRules = @((Get-Content -LiteralPath $RulesPath -Raw | ConvertFrom-Json).rules)
}

function Resolve-AssetClassification
{
	param([string] $Status, [string] $Path, [string] $DefaultClassification, [string] $DefaultReason)
	foreach ($rule in $assetRules)
	{
		if (($rule.status -eq '*' -or $rule.status -eq $Status) -and $Path -like $rule.path)
		{
			return [pscustomobject]@{ Classification = $rule.classification; Reason = $rule.reason }
		}
	}
	return [pscustomobject]@{ Classification = $DefaultClassification; Reason = $DefaultReason }
}

$sourceTrees = @(
	[pscustomobject]@{ Origin = 'base'; Path = (Join-Path $ReferenceRoot 'src\main\resources\assets\animania') },
	[pscustomobject]@{ Origin = 'farm'; Path = (Join-Path $ReferenceRoot 'src\main\resources\assets\farm\animania') },
	[pscustomobject]@{ Origin = 'extra'; Path = (Join-Path $ReferenceRoot 'src\main\resources\assets\extra\animania') },
	[pscustomobject]@{ Origin = 'catsdogs'; Path = (Join-Path $ReferenceRoot 'src\main\resources\assets\catsdogs\animania') }
)

$sourceByPath = @{}
$sourceCollisions = [System.Collections.Generic.List[object]]::new()
$legacyDataExcluded = 0
foreach ($tree in $sourceTrees)
{
	if (-not (Test-Path -LiteralPath $tree.Path))
	{
		throw "Expected 1.12 source tree does not exist: $($tree.Path)"
	}
	Get-ChildItem -LiteralPath $tree.Path -Recurse -File | ForEach-Object {
		$record = Get-AssetRecord $tree.Path $_.FullName $tree.Origin
		if (-not $IncludeLegacyData -and $record.Path -match '^(advancements|loot_tables|recipes)/')
		{
			$legacyDataExcluded++
			return
		}
		if ($sourceByPath.ContainsKey($record.Path))
		{
			$existing = $sourceByPath[$record.Path]
			if ($existing.Hash -ne $record.Hash)
			{
				$sourceCollisions.Add([pscustomobject]@{
					Path = $record.Path
					FirstOrigin = $existing.Origin
					SecondOrigin = $record.Origin
					FirstHash = $existing.Hash
					SecondHash = $record.Hash
				})
			}
			return
		}
		$sourceByPath[$record.Path] = $record
	}
}

$portByPath = @{}
Get-ChildItem -LiteralPath $PortRoot -Recurse -File | ForEach-Object {
	$record = Get-AssetRecord $PortRoot $_.FullName 'port'
	$portByPath[$record.Path] = $record
}

function New-HashIndex
{
	param([hashtable] $ByPath)
	$index = @{}
	foreach ($record in $ByPath.Values)
	{
		if (-not $index.ContainsKey($record.Hash))
		{
			$index[$record.Hash] = [System.Collections.Generic.List[object]]::new()
		}
		$index[$record.Hash].Add($record)
	}
	return $index
}

$sourceByHash = New-HashIndex $sourceByPath
$portByHash = New-HashIndex $portByPath

$entries = [System.Collections.Generic.List[object]]::new()
foreach ($path in $sourceByPath.Keys)
{
	$source = $sourceByPath[$path]
	if (-not $portByPath.ContainsKey($path))
	{
		if ($portByHash.ContainsKey($source.Hash))
		{
			$target = $portByHash[$source.Hash][0]
			$entries.Add((New-ComparisonEntry 'relocated_identical' $source $target 'source_exact_relocated' 'SHA-256 is identical; the asset was moved or renamed for the port.'))
		}
		else
		{
			$entries.Add((New-ComparisonEntry 'missing' $source $null 'unclassified' 'No equal-hash asset exists in the port.'))
		}
		continue
	}

	$port = $portByPath[$path]
	if ($source.Hash -eq $port.Hash)
	{
		$entries.Add((New-ComparisonEntry 'identical' $source $port 'source_exact' 'SHA-256 is identical to the 1.12 source asset.'))
	}
	else
	{
		$entries.Add((New-ComparisonEntry 'changed' $source $port 'unclassified' 'Same effective path, but SHA-256 differs; inspect before calling this intentional.'))
	}
}
foreach ($path in $portByPath.Keys)
{
	if (-not $sourceByPath.ContainsKey($path))
	{
		$port = $portByPath[$path]
		if (-not $sourceByHash.ContainsKey($port.Hash))
		{
			$entries.Add((New-ComparisonEntry 'new' $null $port 'unclassified' 'No equal-hash asset exists in the 1.12 source trees.'))
		}
	}
}
foreach ($collision in $sourceCollisions)
{
	$entries.Add([pscustomobject]@{
		Status = 'collision'
		Path = $collision.Path
		Classification = 'source_ambiguity'
		Reason = "Different 1.12 assets occupy the same effective namespace path ($($collision.FirstOrigin), $($collision.SecondOrigin))."
		SourceOrigin = "$($collision.FirstOrigin),$($collision.SecondOrigin)"
		SourceBytes = 0
		PortBytes = 0
	})
}

$orderedEntries = @($entries | Sort-Object Status, Path)
$summary = [ordered]@{
	ReferenceRoot = (Resolve-Path -LiteralPath $ReferenceRoot).Path
	PortRoot = (Resolve-Path -LiteralPath $PortRoot).Path
	ExcludedSourceTree = (Join-Path $ReferenceRoot 'src\main\resources\assets\player_anim')
	RulesPath = if (Test-Path -LiteralPath $RulesPath) { (Resolve-Path -LiteralPath $RulesPath).Path } else { '' }
	LegacyDataFilesExcluded = $legacyDataExcluded
	SourceFiles = $sourceByPath.Count
	PortFiles = $portByPath.Count
	Identical = @($orderedEntries | Where-Object Status -eq 'identical').Count
	RelocatedIdentical = @($orderedEntries | Where-Object Status -eq 'relocated_identical').Count
	Changed = @($orderedEntries | Where-Object Status -eq 'changed').Count
	Missing = @($orderedEntries | Where-Object Status -eq 'missing').Count
	New = @($orderedEntries | Where-Object Status -eq 'new').Count
	SourceCollisions = @($orderedEntries | Where-Object Status -eq 'collision').Count
}

if ($AsJson)
{
	[pscustomobject]@{ Summary = [pscustomobject]$summary; Entries = $orderedEntries } | ConvertTo-Json -Depth 5
	return
}

if ($View -eq 'Summary')
{
	[pscustomobject]$summary | Format-List
	return
}

$status = switch ($View)
{
	'Missing' { 'missing' }
	'Changed' { 'changed' }
	'New' { 'new' }
	'Identical' { 'identical' }
	'Relocated' { 'relocated_identical' }
	'Collisions' { 'collision' }
	'All' { $null }
}

if ($null -eq $status)
{
	$filteredEntries = $orderedEntries
}
else
{
	$filteredEntries = @($orderedEntries | Where-Object Status -eq $status)
}

if (-not [string]::IsNullOrWhiteSpace($TopLevel))
{
	$prefix = $TopLevel.Trim('/').ToLowerInvariant() + '/'
	$filteredEntries = @($filteredEntries | Where-Object { $_.Path.StartsWith($prefix) })
}

if ($null -eq $status)
{
	$filteredEntries | Format-Table Status, Path, CounterpartPath, Classification, SourceOrigin, SourceBytes, PortBytes -AutoSize
}
else
{
	$filteredEntries | Format-Table Path, CounterpartPath, Classification, SourceOrigin, SourceBytes, PortBytes, Reason -AutoSize
}
