package se.johan_hammerin.projektarbete.model;

import junit.framework.Assert;
import junit.framework.TestCase;

public class HeroTest extends TestCase {

    public void testIsConscious() {
        Entity hero = new Resident();
        hero.setHealth(0);
        Assert.assertFalse(hero.isConscious());
        hero.setHealth(1);
        Assert.assertTrue(hero.isConscious());
    }
}