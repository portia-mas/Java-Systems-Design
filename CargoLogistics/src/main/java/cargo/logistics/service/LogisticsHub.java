package cargo.logistics.service;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import cargo.logistics.model.Shipment;
import cargo.logistics.model.ShipmentStatus;

public abstract  class LogisticsHub {
    private String hubName;
    private Map<Integer, Shipment> shipments;
    private Queue<Shipment> queue;
    private int completedShipments;

    public void addShipment(Shipment shipment){
        this.queue.add(shipment);
    }
    public int completedShipments(){return this.completedShipments;}

    public Map<Integer, Shipment> shipments(){return new HashMap<>(this.shipments);}

    public Queue<Shipment> shipmentQueue(){return new LinkedList<>(this.queue);}
    public Shipment processNextShipment(){
        for (Shipment shipment : this.shipments.values()){
            if(shipment.status() == ShipmentStatus.PENDING){
                shipment.updateStatus(status);
            }
        }
    }
}


/*
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
); */
