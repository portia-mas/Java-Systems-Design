package system.rental.car.model;

import java.util.ArrayList;
import java.util.List;

public class Customer{
    private String name;
    private String licenseNumber;
    private List<Booking> bookings;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.bookings = new ArrayList<>();
    }

    public String name(){return name;}

    public String licenseNumber() {
        return licenseNumber;
    }

    public List<Booking> bookings() {
        return new ArrayList<>(bookings);
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    @Override
    public String toString() {
        return name() + licenseNumber();
    }
}