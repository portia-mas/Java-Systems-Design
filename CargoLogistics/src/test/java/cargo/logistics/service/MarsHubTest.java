package cargo.logistics.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarsHubTest {
    @Test
    void shouldRejectInexperiencedPilot() {

        MarsHub hub =
            new MarsHub(
                "Mars Prime"
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
                "Mars",
                50
            );

        Pilot pilot =
            new Pilot(
                1,
                "Bob",
                2,
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

        hub.addShipment(
            shipment
        );

        assertThrows(
            IllegalStateException.class,
            hub::processNextShipment
        );
    }
}
