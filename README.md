# SONIC THE HEDGEHOG Java ME Reconstruction

This workspace contains a decompilation and preservation pass for the extracted Java ME package at `C:\Users\grand\Downloads\they\sonicjar`.

## What Was Decompiled

- Five `.class` files were decompiled with CFR 0.152 into `src/`.
- The manifest identifies the target as `MIDP-2.0` / `CLDC-1.1` and the MIDlet entry as `sonic`.
- The largest recovered source is `src/MainCanvas.java`, which contains most game logic, rendering, resource loading, audio, RMS persistence, and stage handling.

## What Was Preserved

- All non-class runtime files were copied to `res/` with original filenames and relative paths intact.
- An untouched copy of the extracted package, including the original `.class` files, is under `original/sonicjar/`.
- No PNG, MMF, TXT, BLT, BMD, ACT, BCT, SCD, or manifest file was converted or renamed.

## Folder Organization

- `src/`: Decompiled Java source files.
- `res/`: Runtime assets/resources copied from the extracted package, excluding `.class` files.
- `original/sonicjar/`: Untouched copy of the extracted input package.
- `docs/`: Reconstruction reports and technical maps.
- `build/`: Decompiler logs, inventories, hashes, and sanity-check metadata.

## How To Inspect The Code

- Start with `docs/DECOMPILATION_REPORT.md` for architecture, entry point, warnings, and blockers.
- Use `docs/CLASS_MAP.md` for fields, constructors, methods, class relationships, and identifiable resource calls.
- Use `docs/RESOURCE_MAP.md` or `build/resource_inventory.csv` for asset inventory and classification.
- The original binary classes remain available under `original/sonicjar/` for bytecode-level comparison.

## Compilation Status

- Compilation was not attempted in this pass.
- Required build dependency: a Java ME MIDP 2.0 / CLDC 1.1 SDK or equivalent API classpath for `javax.microedition.*` packages.
- CFR ran successfully, and a simple sanity scan found balanced braces with no fatal decompiler markers in the generated `.java` files.

## Remaining Unresolved

- Proprietary binary data formats were preserved but not fully decoded.
- Many parameter/local names are decompiler-generated because debug local-variable metadata was not available.
- Dynamically assembled resources depend on runtime zone/stage/language/audio state.