package se.johan_hammerin.projektarbete.model;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ResidentTest extends TestCase {
    public void testIsConscious() {
        Entity resident = new Resident();
        resident.setHealth(0);
        Assert.assertFalse(resident.isConscious());
        resident.setHealth(1);
        Assert.assertTrue(resident.isConscious());
    }
}