package system.rental.car;

import system.rental.car.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    void shouldCreateBookingCorrectly() {
        Customer customer = new Customer("John", "LIC001");
        Vehicle vehicle = new Vehicle("Toyota Corolla", 500.0);

        Booking booking = new Booking(1, customer, vehicle, 5);

        assertEquals(1, booking.bookingId());
        assertEquals(customer, booking.customer());
        assertEquals(vehicle, booking.vehicle());
        assertEquals(5, booking.days());
        assertEquals(BookingStatus.PENDING, booking.status());
    }

    @Test
    void shouldCalculateTotalCost() {
        Customer customer = new Customer("John", "LIC001");
        Vehicle vehicle = new Vehicle("BMW X5", 1000.0);

        Booking booking = new Booking(1, customer, vehicle, 3);

        assertEquals(3000.0, booking.totalCost());
    }

    @Test
    void shouldUpdateBookingStatus() {
        Customer customer = new Customer("John", "LIC001");
        Vehicle vehicle = new Vehicle("BMW X5", 1000.0);

        Booking booking = new Booking(1, customer, vehicle, 2);

        booking.updateStatus(BookingStatus.APPROVED);

        assertEquals(BookingStatus.APPROVED, booking.status());
    }

    @Test
    void shouldReturnCorrectToString() {
        Customer customer = new Customer("John", "LIC001");
        Vehicle vehicle = new Vehicle("BMW X5", 1000.0);

        Booking booking = new Booking(1, customer, vehicle, 2);

        String result = booking.toString();

        assertTrue(result.contains("John"));
        assertTrue(result.contains("BMW X5"));
    }
}
