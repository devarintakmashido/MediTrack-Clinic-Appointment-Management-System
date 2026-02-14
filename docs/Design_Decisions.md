# Design Decisions


## 1. In-Memory Repository Design
Decision: Use in-memory repositories backed by a generic `DataStore<T>`.
Reason: As a core Java console application (without Spring Boot or a database), in-memory storage simplifies development and testing while clearly demonstrating repository and service layering.


## 2. Streams and Lambdas in Service Layer
Decision: Implement stream-based analytics within the Service layer.
Reason: Business logic and analytical processing belong in services, not in the UI layer. This keeps the Console/Menu code minimal and centralizes computation.

Implemented methods:
- `DoctorService.getDoctorsBySpeciality(...)`
- `DoctorService.getAverageConsultationFee()`
- `AppointmentService.getAppointmentCountPerDoctor()`

This demonstrates modern Java features including:
•	Streams
•	Lambda expressions
•	Method references
•	Collectors for grouping and aggregation


## 5. CSV Persistence
Decision: Use simple CSV with `split(",")` and try-with-resources.
Reason: Matches project rubric and beginner readability.

Decision: Implement CSV persistence using `split(",")` and try-with-resources.
Reason:
This approach satisfies the rubric requirements while maintaining beginner readability. It demonstrates:
•	File I/O handling
•	Exception management
•	Resource-safe programming using try-with-resources

The system supports saving and loading data without introducing database complexity.

## 6. Concurrency Intro
Decision: Use `AtomicInteger` in `IdGenerator`.
Reason: This demonstrates thread-safe ID generation without introducing advanced concurrency constructs, fulfilling the concurrency requirement with minimal complexity.

## 7. Deep Copy Demo
Decision: Implemented `clone()` in Patient and Appointment.
Reason: To demonstrate the conceptual difference between shallow and deep copying. Deep copying ensures nested objects are independently duplicated, preventing unintended shared references between instances.


