package system.rental.car;

import system.rental.car.model.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void shouldCreateVehicleCorrectly() {
        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);

        assertEquals("Toyota Corolla", vehicle.model());
        assertEquals(450.0, vehicle.dailyRate());
        assertTrue(vehicle.isAvailable());
    }

    @Test
    void shouldUpdateAvailability() {
        Vehicle vehicle = new Vehicle("BMW X5", 1200.0);

        vehicle.setAvailable(false);

        assertFalse(vehicle.isAvailable());
    }

    @Test
    void shouldUpdateDailyRate() {
        Vehicle vehicle = new Vehicle("Honda Civic", 500.0);

        vehicle.updateDailyRate(650.0);

        assertEquals(650.0, vehicle.dailyRate());
    }

    @Test
    void shouldThrowExceptionForNegativeRate() {
        Vehicle vehicle = new Vehicle("Ford Ranger", 800.0);

        assertThrows(IllegalArgumentException.class,
                () -> vehicle.updateDailyRate(-100.0));
    }

    @Test
    void shouldReturnCorrectToString() {
        Vehicle vehicle = new Vehicle("Toyota Corolla", 450.0);

        assertEquals("Toyota Corolla - R450.0/day",
                vehicle.toString());
    }
}
