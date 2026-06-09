package cargo.logistics.model;

public class Shipment {
    private int shipmentId;
    private Cargo cargo;
    private Route route;
    private Pilot pilot;
    private ShipmentStatus status;

    public Shipment(int id, Cargo cargo, Route route, Pilot pilot){
        this.shipmentId = id;
        this.cargo = cargo;
        this.route = route;
        this.pilot = pilot;
        this.status = ShipmentStatus.PENDING;
    }

    public int shipmentId(){return this.shipmentId;}
    public Cargo cargo(){return this.cargo;}
    public Route route(){return this.route;}
    public Pilot pilot(){return this.pilot;}
    public ShipmentStatus status(){return this.status;}
    public void updateStatus(ShipmentStatus status){this.status = status;}
    public double estimatedRevenue(){return this.cargo.weight()*this.route.distance();}
}
/*
double estimatedRevenue()
Revenue:
cargo.weight() * route.distance()
ShipmentStatus Enum
PENDING
IN_TRANSIT
DELIVERED
CANCELLED */
