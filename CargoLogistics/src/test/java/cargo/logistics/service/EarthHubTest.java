package cargo.logistics.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EarthHubTest {
    @Test
    void shouldProcessShipment() {

        EarthHub hub =
            new EarthHub(
                "Earth One"
            );

        Shipment shipment =
            createEarthShipment();

        hub.addShipment(
            shipment
        );

        Shipment processed =
            hub.processNextShipment();

        assertEquals(
            ShipmentStatus.DELIVERED,
            processed.status()
        );

        assertEquals(
            1,
            hub.completedShipments()
        );
    }
}
