package com.rental;

import com.rental.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void shouldCreateCustomerCorrectly() {
        Customer customer = new Customer("John Doe", "ABC123");

        assertEquals("John Doe", customer.name());
        assertEquals("ABC123", customer.licenseNumber());
    }

    @Test
    void shouldAddBooking() {
        Customer customer = new Customer("John Doe", "ABC123");
        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);

        Booking booking = new Booking(1, customer, vehicle, 3);

        customer.addBooking(booking);

        assertEquals(1, customer.bookings().size());
    }

    @Test
    void shouldReturnDefensiveCopy() {
        Customer customer = new Customer("John Doe", "ABC123");

        List<Booking> bookings = customer.bookings();

        bookings.clear();

        assertEquals(0, bookings.size());
        assertEquals(0, customer.bookings().size());
    }

    @Test
    void shouldReturnCorrectToString() {
        Customer customer = new Customer("Alice", "XYZ789");

        String result = customer.toString();

        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("XYZ789"));
    }
}
