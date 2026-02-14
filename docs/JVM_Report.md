# JVM Report

## Class Loader
The class loader loads `.class` files into JVM memory when needed. It uses parent delegation to avoid duplicate loading of core Java classes.

## Runtime Data Areas
- Heap: stores objects (Doctor, Patient, Appointment, Bill).
- Stack: stores method call frames and local variables.
- Method Area: stores class metadata and static members.
- PC Register: stores current instruction position for each thread.

## Execution Engine
The execution engine runs bytecode using interpreter + JIT optimization.

## Interpreter vs JIT
- Interpreter runs bytecode line-by-line quickly at startup.
- JIT compiles hot code paths to native machine code for better performance.

## Write Once, Run Anywhere
Java source compiles to bytecode. Any OS with compatible JVM can execute the same bytecode.
