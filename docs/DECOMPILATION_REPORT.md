# Decompilation Report

## Package Overview

- Input package root: `C:\Users\grand\Downloads\they\sonicjar`
- Reconstruction root: `sonic_reconstruction/`
- Decompiled classes: `5`
- Preserved non-class resources: `214` files, `686098` bytes
- Original copy: `original/sonicjar/`
- Runtime assets copy: `res/`
- Manifest profile: `MIDP-2.0 / CLDC-1.1`
- MIDlet name/version/vendor: `SONIC THE HEDGEHOG` / `1.0.9` / `(C)SEGA`
- Manifest Created-By: `1.4.2_08 (Sun Microsystems Inc.)`
- Class-file version(s): `46.0 (Java 1.2)`

Confirmed observation: the Java classes are in the default package and target Java ME MIDP/CLDC APIs.

Assumption: proprietary `.bmd`, `.blt`, `.act`, `.bct`, and `.scd` formats are interpreted by filename patterns and loader code, not by a full binary format specification.

## Decompiled Classes

| Class | Superclass | Interfaces | Fields | Methods | Source lines | Interpretation confidence |
| --- | --- | --- | --- | --- | --- | --- |
| DistantBg | java.lang.Object | (none) | 11 | 12 | 297 | High |
| DistantBgTbl1 | java.lang.Object | (none) | 12 | 2 | 18 | Medium-high |
| DistantBgTbl2 | java.lang.Object | (none) | 8 | 2 | 14 | Medium-high |
| MainCanvas | javax.microedition.lcdui.game.GameCanvas | javax.microedition.lcdui.CommandListener, javax.microedition.media.PlayerListener, java.lang.Runnable | 700 | 506 | 19639 | High |
| sonic | javax.microedition.midlet.MIDlet | java.lang.Runnable | 3 | 8 | 73 | High |

## Entry Point Or Likely Entry Point

- Confirmed manifest MIDlet entry: `sonic`
- Runtime path observed in decompiled code: `sonic` constructs `MainCanvas`, sets it on `Display`, starts a thread, and `run()` calls `MainCanvas.initAll()` then `MainCanvas.GameMain()`.

## Class Inheritance Tree

```text
java.lang.Object
  javax.microedition.midlet.MIDlet
    sonic implements java.lang.Runnable
  javax.microedition.lcdui.game.GameCanvas
    MainCanvas implements javax.microedition.lcdui.CommandListener, javax.microedition.media.PlayerListener, java.lang.Runnable
  DistantBg
  DistantBgTbl1
  DistantBgTbl2
```

## Resource Inventory

| Category | Count |
| --- | --- |
| audio | 29 |
| graphics | 153 |
| level data | 9 |
| manual/help | 2 |
| maps | 18 |
| metadata | 1 |
| text/localization | 2 |

| Extension | Count |
| --- | --- |
| .act | 6 |
| .bct | 1 |
| .blt | 13 |
| .bmd | 6 |
| .mf | 1 |
| .mmf | 29 |
| .png | 153 |
| .scd | 1 |
| .txt | 4 |

## Suspected Purpose Of Each Class

- `DistantBg`: Parallax/distant-background renderer. It selects table data per zone/stage and draws regions from MainCanvas.m_imgMimg using DistantBgTbl1 and DistantBgTbl2 arrays.
- `DistantBgTbl1`: Static integer table holder for distant background draw commands used by DistantBg.
- `DistantBgTbl2`: Second static integer table holder for distant background draw commands used by DistantBg.
- `MainCanvas`: Primary MIDP GameCanvas. It owns the game loop, input, rendering, state transitions, resource loading, RMS persistence, audio playback, stage/map loading, collision tables, and most gameplay object logic.
- `sonic`: MIDlet entry point and lifecycle wrapper. It creates MainCanvas, sets it as the display, starts the game thread, exposes vibration, and delegates exit handling.

## Suspected Purpose Of Major Resource Groups

- `graphics`: PNG sprites, tiles, title/licensing screens, HUD elements, objects, enemies, bosses, effects, and zone tilesets. Confirmed by Image.createImage calls in MainCanvas.
- `audio`: MMF audio assets under bgm/, loaded through javax.microedition.media.Manager.
- `maps`: Zone map, block-link, and front-layer binary tables read by DataInputStream.
- `level data`: ACT/object/collision/script tables used for stage layout and collision behavior.
- `text/localization`: Language text sets selected through lang_<language>.txt.
- `manual/help`: Manual/help text selected through manual_<language>.txt.
- `metadata`: JAR/MIDlet manifest metadata.
- `unknown binary data`: No files were left only in this bucket; proprietary binary formats remain structurally undocumented.

## Unresolved Or Unclear Areas

- Binary formats `.bmd`, `.blt`, `.act`, `.bct`, and `.scd` were preserved byte-for-byte but not structurally decoded.
- Many `MainCanvas` fields and methods retain compact original names or decompiler parameter names (`n`, `n2`, `byArray`, etc.); these were preserved rather than renamed.
- Some resource paths are constructed dynamically (`/zone` + number + `.bmd`, `/bgm/` + hex-like id + `.mmf`, `/lang_` + language + `.txt`), so exact runtime selections depend on game state.
- CFR reported missing Java ME API classes because no MIDP/CLDC SDK was on the decompiler classpath; this is expected and does not indicate missing game classes.

## Decompilation Warnings

- Decompiler used: `CFR 0.152`
- Runtime used to run decompiler: `Temurin OpenJDK Runtime 21.0.11+10`
- CFR process exit: success, see `build/decompilation_cfr.log`.
- CFR source headers list missing `javax.microedition.*` classes for `sonic`, `MainCanvas`, and `DistantBg` because Java ME libraries were not present locally.

## Syntax Errors, If Any

- No CFR fatal-decompilation markers were found and all generated `.java` files have balanced braces by a simple source scan.
- A Java compiler was not run, so this is not a full syntax verification.

## Build Blockers, If Any

- Compilation was not attempted in this pass.
- Main blocker: a Java ME MIDP 2.0 / CLDC 1.1 SDK or equivalent API classpath is required for `javax.microedition.*` imports.
- Additional blocker: the current local environment initially had no `java`, `javac`, or `javap` on `PATH`; a temporary JRE was downloaded only to run CFR.
- If a future build is attempted, the source should be compiled against MIDP 2.0 + CLDC 1.1 APIs, then packaged with `res/` and the manifest metadata.
