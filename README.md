# Animania NeoForge 1.21.1 Port Status

This repository is an in-progress port of Animania from Forge 1.12.2 to NeoForge 1.21.1. It builds with Java 21 and NeoForge ModDevGradle, but it is not a release-ready replacement for the original mod.

## Build

Requirements:

- Java 21
- The local CraftStudioAPI port JAR at `libs/craftstudioapi-0.1.0.jar`

Commands:

```powershell
.\gradlew.bat classes
.\gradlew.bat runClient
```

`classes` is the baseline compile check. In-game testing is required for every rendering or interaction change.

## Project layout

| Path | Purpose |
| --- | --- |
| `src/main/java/com/animania/common` | Shared systems: configuration, fluids, blocks, recipes, entities, and common AI. |
| `src/main/java/com/animania/addons/farm` | Farm animals, crops, pullable vehicles, cheese, hives, and related content. |
| `src/main/java/com/animania/addons/extra` | Wildlife, peafowl, rodents, amphibians, and extra content. |
| `src/main/java/com/animania/addons/catsdogs` | Cats & Dogs addon. This addon is incomplete. |
| `src/main/java/com/animania/client` | Client registration and shared render layers. |
| `src/main/resources/assets/animania` | Models, textures, sounds, language files, and client assets. |
| `src/main/resources/data/animania` | Recipes, loot tables, tags, biome modifiers, and other data. |
| `tools` | Asset-audit utility and its rules. |

## Current state

The common framework, registries, most content definitions, data files, and a large part of the original animal logic have been moved to NeoForge APIs. The project compiles, and the client can be launched from Gradle.

Compilation is not evidence of feature parity. The port contains work that has only been checked statically or by limited manual testing.

## Known incomplete or unreliable areas

### Pullable vehicles

The cart, wagon, and tiller (plough) are not fully ported. Their CraftStudio geometry, animation timing, towing behaviour, collision, and interaction handling need a complete 1.12.2-to-1.21.1 comparison and in-game validation. Treat their current behaviour as unreliable.

The wagon sleep interaction and wheel animation code have been adapted for modern APIs, but neither should be considered final.

### Cats & Dogs addon

The Cats & Dogs addon is not fully ported. Breed-specific models, pose transforms, head movement, blinking, and sound behaviour require further validation and fixes. Do not treat visual correctness of cats, dogs, foxes, or wolves as complete.

### Rendering and assets

The following areas still need in-game verification or replacement with exact original assets:

- Hamster balls have no inventory texture; their use and recovery flow also needs verification.
- Honey bucket presentation; the 1.12.2 source tree does not provide a dedicated bucket texture.
- Cheese mold milk-fluid rendering.
- Mooshroom mushroom size and placement.
- Peachick model visibility and scale.
- Species-specific models, UVs, animations, blinking layers, and sounds, especially where prior game testing reported defects.

### Gameplay checks

Verify these systems against the 1.12.2 reference before declaring them finished:

- Nest egg insertion, extraction, and hatching.
- Cheese molds and cheese wheels, including block and item forms.
- Beehive and wild-hive models, item forms, extraction, and fluid output.
- Salt lick consumption and AI targeting.
- Mod wool blocks: placement, drops, recipes, and tags.
- Pullable vehicle hitching, self-pulling, collision, storage, sleeping, and destruction.

## Reference material

Use the 1.12.2 Animania source as the primary behavioural and asset reference. The 1.18 source is only a secondary comparison point. CraftStudio-dependent content must be checked against both the original CraftStudioAPI and the NeoForge CraftStudioAPI port.

When a model or texture differs, compare its geometry, hierarchy, pivot, offset, Euler order, UV layout, resource path, and renderer transform before changing values by eye.

## Contribution guidelines

1. Keep changes scoped to one feature or defect.
2. Preserve original resource names and data where NeoForge permits it.
3. Add or update data-driven content under `src/main/resources`; avoid hard-coded substitutes when the original has data assets.
4. Run `.\gradlew.bat classes` before submitting changes.
5. Test affected content in a clean client world and document the result in the pull request.
6. Do not commit IDE settings, Gradle caches, build output, local run directories, logs, or saves.
