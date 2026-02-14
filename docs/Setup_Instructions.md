# Setup Instructions

## Prerequisites
- JDK 17+ installed
- `java -version` and `javac -version` should both work

## Compile
```bash
javac -d out $(find src/com -name "*.java")
```

## Run Main App
```bash
java -cp out com.airtribe.meditrack.Main
```

## Run With CSV Load
```bash
java -cp out com.airtribe.meditrack.Main --loadData
```

## Run Manual Test Runner
```bash
java -cp out com.airtribe.meditrack.test.TestRunner
```

## Screenshots
Add your local setup screenshots here for grading:
- JDK installation proof
- `java -version`
- compile/run output
