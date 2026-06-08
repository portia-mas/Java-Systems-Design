package cargo.logistics.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteTest {
    @Test
    void shouldCalculateFuel() {

        Route route =
            new Route(
                "Earth",
                "Mars",
                100
            );

        assertEquals(
            250,
            route.estimatedFuelRequired()
        );
    }
}
