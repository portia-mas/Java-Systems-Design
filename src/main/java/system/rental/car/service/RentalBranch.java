package system.rental.car.service;

import system.rental.car.model.Booking;
import system.rental.car.model.Customer;
import system.rental.car.model.Vehicle;

import java.util.*;

public abstract class RentalBranch{
    private String branchName;
    private Map<String, Vehicle> vehicles;
    private List<Booking> bookings;
    private int bookingCounter = 0;

    public RentalBranch(String branchName) {
        this.branchName = branchName;
        this.vehicles = new HashMap<>();
        this.bookings = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.model(), vehicle);
    }

    public Vehicle getVehicle(String model) {
        return vehicles.getOrDefault(model, null);
    }

    public Map<String, Vehicle> getAllVehicles(){
        return Collections.unmodifiableMap(vehicles);
    }

    public void createBooking(Customer customerName, String model, int days) {
        Vehicle vehicle = vehicles.get(model);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle does not exist: " + model);
        }
        if (!vehicle.isAvailable()) {
            throw new IllegalArgumentException("Vehicle is unavailable: " + model);
        }
        Booking b = new Booking(++bookingCounter, customerName, vehicle, days);
        bookings.add(b);
    }

    public void processNextBooking(){
//        if (bookings)

//        bookings.add(booking);
    }

    public List<Booking> bookings() {
        return Collections.unmodifiableList(bookings);
    }

    public String branchName(){ return branchName;}

    protected abstract void processRental(Booking booking);
}