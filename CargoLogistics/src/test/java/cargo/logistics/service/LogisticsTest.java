package cargo.logistics.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogisticsTest {
    @Test
void shouldAddShipment() {

    EarthHub hub =
        new EarthHub(
            "Earth One"
        );

    Cargo cargo =
        new Cargo(
            "C1",
            100,
            "Food"
        );

    Route route =
        new Route(
            "Earth",
            "Moon",
            10
        );

    Pilot pilot =
        new Pilot(
            1,
            "Alice",
            3,
            List.of(
                "EARTH_ROUTE"
            )
        );

    Shipment shipment =
        new Shipment(
            1,
            cargo,
            route,
            pilot
        );

    hub.addShipment(
        shipment
    );

    assertEquals(
        shipment,
        hub.getShipment(1)
    );
}
}
