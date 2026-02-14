# Design Decisions

## 1. Keep Existing Structure
Decision: Keep original `meditrack` package and extend it.
Reason: Minimal change, easier for beginner understanding, preserves existing code.

## 2. Static Service/Repository Style
Decision: Continue using static methods and in-memory `DataStore<T>`.
Reason: Simple calling style and easy testing with menu-driven app.

## 3. Defensive Fixes, Not Full Rewrite
Decision: Patch bugs in-place (validation checks, bill saving, listing, search overloads).
Reason: Avoid breaking behavior that already works.

## 4. Streams + Lambdas Added in Service Layer
Decision: Add stream analytics in services.
Reason: Keeps menu code simple and concentrates logic in one place.

Implemented:
- `DoctorService.getDoctorsBySpeciality(...)`
- `DoctorService.getAverageConsultationFee()`
- `AppointmentService.getAppointmentCountPerDoctor()`

## 5. CSV Persistence
Decision: Use simple CSV with `split(",")` and try-with-resources.
Reason: Matches project rubric and beginner readability.

## 6. Concurrency Intro
Decision: Use `AtomicInteger` in `IdGenerator`.
Reason: Demonstrates thread-safe counter usage with minimal complexity.

## 7. Deep Copy Demo
Decision: Add `clone()` in Patient and Appointment.
Reason: Matches rubric requirement for deep vs shallow copy.
