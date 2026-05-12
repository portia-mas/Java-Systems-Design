# Java-Systems-Design
Assessment to test the concepts of OOP and Systems Design

# 🚗 Vehicle Rental System — Java OOP Assessment

## Overview

In this assessment you will design and implement a vehicle rental management system in Java. The system stores vehicles, manages customer bookings, and processes rentals through different rental branches.

The skeleton project is provided. Your task is to implement the classes described in the steps below, following the principles of **Encapsulation**, **Inheritance**, and basic collection management.

### Learning Outcomes

* OOP (Encapsulation, inheritance, polymorphism)
* Greenfield Development
* Unit testing
* System Design
* Working with Collections (`List`, `Map`)

---

## Time Limit

**3 hours**

---

# Assessment Structure

This assessment has three components. You may complete them in any order.

| Component | Weight | Recommended Time |
| ----------------- | ------- | ---------------- |
| Implementation | **60%** | 2 hours |
| UML Class Diagram | **25%** | 45 minutes |
| Long Question | **15%** | 15 minutes |

---

## Scoring

```text
Coding Score = (tests passed / total tests) × 60%
UML Score = (marks earned / total UML marks) × 25%
Long Q Score = (marks earned / 10) × 15%

Final Score = Coding Score + UML Score + Long Q Score
```

To pass, your Final Score must be **60% or higher**.

---

# Project Structure

```text
vehicle-rental/
├── pom.xml
└── src/
    ├── main/
    │ └── java/
    │ └── com/
    │ └── rental/
    │ ├── Main.java
    │ ├── model/
    │ │ ├── Vehicle.java
    │ │ ├── Customer.java
    │ │ └── Booking.java
    │ └── service/
    │ ├── RentalBranch.java
    │ ├── LuxuryBranch.java
    │ └── EconomyBranch.java
    └── test/
        └── java/
            └── com/
                └── rental/
                    ├── VehicleTest.java
                    ├── CustomerTest.java
                    ├── BookingTest.java
                    └── RentalBranchTest.java
```

---

As you implement each step, run the full test suite:

```bash
mvn clean compile test
```

Your goal is to reach **100% of tests passing** before submission.

---

# Implementation Steps

Work through the steps **in order** — later classes depend on earlier ones.

---

# Step 1 — Implement `Vehicle`

**File:** `src/main/java/com/rental/model/Vehicle.java`

The `Vehicle` class represents a single vehicle available for rental.

---

## Fields

| Field | Type | Details |
| ----------- | --------- | -------------------------------------------------------------------------------------- |
| `model` | `String` | Vehicle model name (e.g. `"Toyota Corolla"`). Must be **private**. |
| `dailyRate` | `double` | Cost per day. Must be **private**. |
| `available` | `boolean` | Whether the vehicle is available for booking. Defaults to `true`. Must be **private**. |

---

## Constructor

Accepts:

* `model`
* `dailyRate`

Initialises `available` to `true`.

---

## Methods

| Method | Details |
| ------------------------- | ---------------------------------------------------------------------------------- |
| `model()` | Returns the vehicle model. |
| `dailyRate()` | Returns the rental price per day. |
| `isAvailable()` | Returns whether the vehicle is available. |
| `setAvailable(boolean)` | Updates availability. |
| `updateDailyRate(double)` | Updates the daily rate. Throws `IllegalArgumentException` if the rate is negative. |
| `toString()` | Returns a readable summary. Example: `"Toyota Corolla - R450.0/day"` |

---

# Step 2 — Implement `Customer`

**File:** `src/main/java/com/rental/model/Customer.java`

A `Customer` stores personal information and rental history.

---

## Fields

| Field | Type | Details |
| --------------- | --------------- | ----------------------------------------------- |
| `name` | `String` | Customer name. Must be **private**. |
| `licenseNumber` | `String` | Driver’s license number. Must be **private**. |
| `bookings` | `List<Booking>` | List of customer bookings. Must be **private**. |

---

## Constructor

Accepts:

* `name`
* `licenseNumber`

Initialises `bookings` as an empty `ArrayList`.

---

## Methods

| Method | Details |
| --------------------- | ------------------------------------------- |
| `name()` | Returns customer name. |
| `licenseNumber()` | Returns license number. |
| `bookings()` | Returns a defensive copy of bookings. |
| `addBooking(Booking)` | Adds a booking to the booking list. |
| `toString()` | Returns a readable summary of the customer. |

---

## Design Tip — Defensive Copies

Returning the actual booking list would allow outside code to modify internal state directly.

This is bad:

```java
return bookings;
```

This is safer:

```java
return new ArrayList<>(bookings);
```

---

# Step 3 — Implement `Booking`

**File:** `src/main/java/com/rental/model/Booking.java`

A `Booking` links a customer to a vehicle rental.

---

## Fields

| Field | Type | Details |
| ----------- | --------------- | ------------------------------------------------------------------- |
| `bookingId` | `int` | Unique booking ID. Must be **private**. |
| `customer` | `Customer` | Customer making the booking. Must be **private**. |
| `vehicle` | `Vehicle` | Vehicle being rented. Must be **private**. |
| `days` | `int` | Number of rental days. Must be **private**. |
| `status` | `BookingStatus` | Current booking status. Defaults to `PENDING`. Must be **private**. |

---

## Constructor

Accepts:

* `bookingId`
* `customer`
* `vehicle`
* `days`

Initialises status to `BookingStatus.PENDING`.

---

## Methods

| Method | Details |
| ----------------------------- | --------------------------- |
| `bookingId()` | Returns booking ID. |
| `customer()` | Returns customer. |
| `vehicle()` | Returns vehicle. |
| `days()` | Returns number of days. |
| `status()` | Returns booking status. |
| `totalCost()` | Returns `dailyRate × days`. |
| `updateStatus(BookingStatus)` | Updates booking status. |
| `toString()` | Returns a booking summary. |

---

# Step 4 — Implement `RentalBranch` (Abstract Class)

**File:** `src/main/java/com/rental/service/RentalBranch.java`

`RentalBranch` is an abstract base class responsible for managing vehicles and bookings.

Subclasses will implement branch-specific rental processing.

---

## Fields

| Field | Type | Details |
| ---------------- | ---------------------- | ---------------------------------------------- |
| `branchName` | `String` | Name of the branch. Must be **private**. |
| `vehicles` | `Map<String, Vehicle>` | Stores vehicles by model. Must be **private**. |
| `bookings` | `List<Booking>` | Stores all bookings. Must be **private**. |
| `bookingCounter` | `int` | Starts at `0`. Must be **private**. |

---

## Constructor

Accepts `branchName`.

Initialises:

* `vehicles` as `HashMap`
* `bookings` as `ArrayList`

---

# Concrete Methods

| Method | Details |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `addVehicle(Vehicle)` | Adds vehicle to map using model name as key. |
| `getVehicle(String)` | Returns vehicle by model or `null`. |
| `getAllVehicles()` | Returns an unmodifiable map of vehicles. |
| `createBooking(Customer, String, int)` | Creates booking using `++bookingCounter`. Throws `IllegalArgumentException` if vehicle does not exist OR is unavailable. |
| `processNextBooking()` | Finds first `PENDING` booking, updates status to `APPROVED`, calls `processRental(booking)`, marks vehicle unavailable, then returns booking. Returns `null` if no pending bookings exist. |
| `bookings()` | Returns an unmodifiable list of bookings. |
| `branchName()` | Returns branch name. |

---

# Abstract Method

```java
protected abstract void processRental(Booking booking);
```

Subclasses must implement rental-specific behaviour.

---

# Step 5 — Implement `LuxuryBranch` & `EconomyBranch`

**Files:**

* `service/LuxuryBranch.java`
* `service/EconomyBranch.java`

These concrete classes extend `RentalBranch`.

---

## LuxuryBranch

| | Details |
| -------------------------------- | -------------------------------------------------------------------------------------------------- |
| Extends | `RentalBranch` |
| Constructor | Accepts `branchName`, passes to `super()`. |
| `processRental(Booking booking)` | Prints: `"[branchName] preparing premium vehicle [vehicleModel] for VIP customer [customerName]."` |

---

## EconomyBranch

| | Details |
| -------------------------------- | -------------------------------------------------------------------------------------------------- |
| Extends | `RentalBranch` |
| Constructor | Accepts `branchName`, passes to `super()`. |
| `processRental(Booking booking)` | Prints: `"[branchName] processing economy rental for [customerName] with vehicle [vehicleModel]."` |

---

# UML Class Diagram

Produce a UML class diagram for this project using a digital tool such as [draw.io](https://app.diagrams.net/?utm_source=chatgpt.com), no other tool is allowed.

Your diagram must include all six classes and show the following for each:

* Class name
* All fields with their types and access modifiers (`+` public, `-` private, `#` protected)
* All methods with their return types and parameters
* Relationships between classes

  * Inheritance arrows where one class extends another
  * Association arrows where one class holds references to another

Export your diagram as a **PNG or PDF** and place it in the root of your project named:

```text
uml.pdf
```

---

# Long Question

Answer this question in `answers.txt`.

**Do not remove comments and do not change the format.**

---

## Question — Problem Statement

Based on the system you implemented, write a brief problem statement explaining:

* What real-world problem this system solves
* Who would use the system
* What advantages the system provides compared to a manual rental process

---

# Submission Notes

Before pushing your solution for grading, make sure it compiles successfully:

```bash
mvn clean compile
```

---

# Bonus Challenge (Optional)

Add a method to calculate the branch’s total expected income from all approved bookings.

Example:

```java
public double totalRevenue()
```

---

*Good luck, drive safely, and enjoy the rentals! 🚗*
