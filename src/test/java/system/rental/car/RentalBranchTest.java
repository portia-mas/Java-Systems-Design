package com.rental;

import com.rental.model.*;
import com.rental.service.EconomyBranch;
import com.rental.service.RentalBranch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalBranchTest {

    @Test
    void shouldAddVehicle() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);

        branch.addVehicle(vehicle);

        assertEquals(vehicle,
                branch.getVehicle("Toyota Corolla"));
    }

    @Test
    void shouldReturnNullForUnknownVehicle() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        assertNull(branch.getVehicle("BMW"));
    }

    @Test
    void shouldCreateBooking() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);
        Customer customer = new Customer("John", "LIC001");

        branch.addVehicle(vehicle);

        Booking booking =
                branch.createBooking(customer,
                        "Toyota Corolla",
                        3);

        assertNotNull(booking);
        assertEquals(1, booking.bookingId());
        assertEquals(BookingStatus.PENDING,
                booking.status());
    }

    @Test
    void shouldThrowExceptionWhenVehicleNotFound() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Customer customer = new Customer("John", "LIC001");

        assertThrows(IllegalArgumentException.class,
                () -> branch.createBooking(customer,
                        "BMW",
                        2));
    }

    @Test
    void shouldThrowExceptionWhenVehicleUnavailable() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);
        vehicle.setAvailable(false);

        Customer customer = new Customer("John", "LIC001");

        branch.addVehicle(vehicle);

        assertThrows(IllegalArgumentException.class,
                () -> branch.createBooking(customer,
                        "Toyota Corolla",
                        2));
    }

    @Test
    void shouldProcessNextBooking() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);
        Customer customer = new Customer("John", "LIC001");

        branch.addVehicle(vehicle);

        branch.createBooking(customer,
                "Toyota Corolla",
                3);

        Booking processed =
                branch.processNextBooking();

        assertEquals(BookingStatus.APPROVED,
                processed.status());

        assertFalse(vehicle.isAvailable());
    }

    @Test
    void shouldReturnNullWhenNoPendingBookings() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        assertNull(branch.processNextBooking());
    }

    @Test
    void shouldReturnUnmodifiableVehicleMap() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);

        branch.addVehicle(vehicle);

        assertThrows(UnsupportedOperationException.class,
                () -> branch.getAllVehicles().clear());
    }

    @Test
    void shouldReturnUnmodifiableBookingsList() {
        RentalBranch branch = new EconomyBranch("Budget Rentals");

        assertThrows(UnsupportedOperationException.class,
                () -> branch.bookings().clear());
    }
}
