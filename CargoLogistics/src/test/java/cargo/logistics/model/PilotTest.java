package cargo.logistics.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PilotTest {
    @Test
    void shouldHaveCertification() {

        Pilot pilot =
            new Pilot(
                1,
                "Alice",
                6,
                List.of(
                    "EARTH_ROUTE"
                )
            );

        assertTrue(
            pilot.hasCertification(
                "EARTH_ROUTE"
            )
        );
    }

    @Test
    void shouldUseDefensiveCopy() {

        Pilot pilot =
            new Pilot(
                1,
                "Alice",
                6,
                List.of(
                    "EARTH_ROUTE"
                )
            );

        List<String> certs =
            pilot.certifications();

        certs.clear();

        assertEquals(
            1,
            pilot.certifications()
                .size()
        );
}
}
