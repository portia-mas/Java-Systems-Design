🚀 Interplanetary Cargo Logistics System — Advanced Java OOP Assessment

This assessment is significantly harder than the Library and Coffee Machine projects and is closer to what you'd encounter in a challenging WeThinkCode OOP assessment.

It tests:

Greenfield Development
Encapsulation
Inheritance
Polymorphism
Abstract Classes
Collections (List, Map, Queue)
Defensive Copying
Validation
UML Design
JUnit Testing
Maven
Object-Oriented Design
System Documentation
Time Limit

4 Hours

Assessment Structure
Component	Weight
Implementation	65%
UML Diagram	20%
Unit Tests	5%
Theory Questions	10%
Project Structure
cargo-logistics/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com/logistics
    │           ├── model
    │           │   ├── Cargo.java
    │           │   ├── Route.java
    │           │   ├── Shipment.java
    │           │   ├── Pilot.java
    │           │   └── ShipmentStatus.java
    │           └── service
    │               ├── LogisticsHub.java
    │               ├── EarthHub.java
    │               └── MarsHub.java
    └── test
        └── java
Step 1 — Implement Cargo
Fields
private String cargoId;
private double weight;
private String description;
Constructor
Cargo(
    String cargoId,
    double weight,
    String description
)
Validation

Throw IllegalArgumentException if:

weight <= 0
Methods
String cargoId()
double weight()
String description()

void updateWeight(double weight)

String toString()
Step 2 — Implement Pilot
Fields
private int pilotId;
private String name;
private int experienceYears;
private List<String> certifications;
Validation
experienceYears >= 0

Certifications list may not be empty.

Methods
int pilotId()

String name()

int experienceYears()

List<String> certifications()

boolean hasCertification(String cert)

void addCertification(String cert)

String toString()
Requirement

Return a defensive copy.

Step 3 — Implement Route

Represents a transport route.

Fields
private String origin;
private String destination;
private double distance;
Validation
distance > 0
Methods
String origin()

String destination()

double distance()

double estimatedFuelRequired()

Fuel formula:

distance * 2.5
Step 4 — Implement Shipment
Fields
private int shipmentId;
private Cargo cargo;
private Route route;
private Pilot pilot;
private ShipmentStatus status;
Constructor

Default:

status = ShipmentStatus.PENDING;
Methods
int shipmentId()

Cargo cargo()

Route route()

Pilot pilot()

ShipmentStatus status()

void updateStatus(
    ShipmentStatus status
)

double estimatedRevenue()

Revenue:

cargo.weight() * route.distance()
ShipmentStatus Enum
PENDING
IN_TRANSIT
DELIVERED
CANCELLED
Step 5 — Implement LogisticsHub (Abstract)
Fields
private String hubName;

private Map<Integer, Shipment> shipments;

private Queue<Shipment> queue;

private int completedShipments;
Constructor

Initialize collections.

Methods
void addShipment(
    Shipment shipment
)

Shipment getShipment(
    int shipmentId
)

Map<Integer, Shipment> shipments()

Queue<Shipment> shipmentQueue()

Shipment processNextShipment()

int completedShipments()

String hubName()
Processing Rules

When processing:

Find first pending shipment.
Set status to IN_TRANSIT.
Call:
dispatch(shipment);
Set status to DELIVERED.
Increment completedShipments.
Return shipment.

If no pending shipment exists:

return null;
Abstract Method
protected abstract void dispatch(
    Shipment shipment
);
Step 6 — Implement EarthHub

Dispatch rule:

Pilot must have certification:

EARTH_ROUTE

Otherwise:

throw new IllegalStateException();

Print:

Dispatching shipment from Earth.
Step 7 — Implement MarsHub

Dispatch rule:

Pilot must have certification:

MARS_ROUTE

AND

experienceYears >= 5

Otherwise:

throw new IllegalStateException();

Print:

Dispatching shipment to Mars.

Required Unit Tests

These tests must pass if your implementation is correct.

UML Diagram

Produce:

uml.pdf

Must include:

all fields
methods
visibility
inheritance
associations
multiplicities
Theory Questions

Create:

answers.txt
Question 1

Explain how encapsulation is used in:

Cargo
Pilot
Shipment
Question 2

Explain inheritance and polymorphism using:

LogisticsHub
EarthHub
MarsHub
Question 3

Explain why defensive copying is important.

Question 4

Explain what a version control system is, how it works and its benefits. Highlight the difference between a local and remote repo. Name 4 git commands and what they do.

Question 5

What is a build tool and what does it do. Explain the lifecycle of a build tool like Maven.
Name 3 maven commands and explain what they do

