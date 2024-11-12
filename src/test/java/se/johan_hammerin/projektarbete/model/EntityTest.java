package se.johan_hammerin.projektarbete.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void testIsConscious() {
        Entity resident = new Resident();
        resident.setHealth(0);
        assertFalse(resident.isConscious());
        resident.setHealth(1);
        assertTrue(resident.isConscious());
    }
}