package se.johan_hammerin.adventureGame.characters;

public class Sheep extends Player {
    // Constants
    private static final int DAMAGE_PER_ATTACK = 10;
    private static final int STARTING_HEALTH = 25;

    // Constructor
    public Sheep() {
        setName("Sheep");
        setDamage(DAMAGE_PER_ATTACK);
        setHealth(STARTING_HEALTH);
    }
}
