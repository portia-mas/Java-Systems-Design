package cargo.logistics.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cargo.logistics.model.Cargo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CargoTest {     
    @Test
    void shouldCreateCargo() {
        Cargo cargo =
            new Cargo(
                "C1",
                100,
                "Food"
            );

        assertEquals(
            "C1",
            cargo.cargoId()
        );

        assertEquals(
            100,
            cargo.weight()
        );
    }

    @Test
    void shouldRejectInvalidWeight() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Cargo(
                "C1",
                0,
                "Food"
            )
        );
    }
}


