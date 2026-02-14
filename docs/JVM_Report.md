# JVM Report

## 1. Class Loader
The Class Loader Subsystem loads `.class` files into memory and verifies class metadata before execution. It follows parent delegation to avoid duplicate core class loading.

## 2. Runtime Data Areas
- Heap: Stores objects and class instances (`Doctor`, `Patient`, `Appointment`, etc.).
- Stack: Stores method frames, local variables, and call stack for each thread.
- Method Area: Stores class-level metadata, static fields, and bytecode.
- PC Register: Holds current bytecode instruction address for each thread.

## 3. Execution Engine
The execution engine reads bytecode and executes it using either interpretation or JIT-compiled native instructions.

## 4. JIT Compiler vs Interpreter
- Interpreter executes bytecode line-by-line and starts quickly.
- JIT compiler identifies hot code paths and compiles them to native code for faster repeated execution.

## 5. Write Once, Run Anywhere
Java compiles source to platform-independent bytecode. Any OS with a compatible JVM can run the same compiled program without source changes.
