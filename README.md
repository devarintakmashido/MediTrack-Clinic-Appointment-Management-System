# MediTrack

This project now uses your original codebase package structure:
- `src/meditrack/Entity`
- `src/meditrack/Service`
- `src/meditrack/Repositories`
- `src/meditrack/util`
- `src/meditrack/Exception`
- `src/meditrack/constants`
- `src/meditrack/test`

## Compile
```bash
javac -d out $(find src -name "*.java")
```

## Run Main
```bash
java -cp out meditrack.Main
```

## Run Manual Test Runner
```bash
java -cp out meditrack.test.TestRunner
```

## Load persisted CSV data
```bash
java -cp out meditrack.Main --loadData
```

## Notes
- Existing code was retained and extended with minimal refactoring.
- Additional helper code from previous migration is preserved in `legacy/meditrack_backup`.
