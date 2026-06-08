package cargo.logistics.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cargo.logistics.model.Cargo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipmentTest {
    @Test
    void shouldCalculateRevenue() {

        Cargo cargo =
            new Cargo(
                "C1",
                100,
                "Food"
            );

        Route route =
            new Route(
                "Earth",
                "Mars",
                50
            );

        Pilot pilot =
            new Pilot(
                1,
                "Alice",
                6,
                List.of(
                    "MARS_ROUTE"
                )
            );

        Shipment shipment =
            new Shipment(
                1,
                cargo,
                route,
                pilot
            );

        assertEquals(
            5000,
            shipment.estimatedRevenue()
        );
    }
}
