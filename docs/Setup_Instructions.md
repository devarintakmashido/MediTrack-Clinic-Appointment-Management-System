# Setup Instructions

## 1. Install Java
Install JDK 17+.

Check:
```bash
java -version
javac -version
```

## 2. Open Project
```bash
cd /Users/arindamrathore26/IdeaProjects/MediTrackGroup
```

## 3. Compile
```bash
rm -rf out
javac -d out $(find src -name '*.java')
```

## 4. Run
```bash
java -cp out meditrack.Main
```

## 5. Load CSV Data (Optional)
```bash
java -cp out meditrack.Main --loadData
```

## 6. Run Manual Test Runner
```bash
java -cp out meditrack.test.TestRunner
```

## 7. Suggested Screenshots for Submission
- `java -version` output
- `javac -version` output
- Compile command success
- Main menu running
