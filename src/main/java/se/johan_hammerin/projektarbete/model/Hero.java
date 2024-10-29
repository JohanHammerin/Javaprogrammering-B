package se.johan_hammerin.projektarbete.model;

import java.util.HashMap;
import java.util.Random;
import se.johan_hammerin.projektarbete.logic.Direction;

public class Hero extends Entity {
    // Random
    private static final Random random = new Random();

    // Attributes
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean hasAttacked;
    private final int initialHealth;
    private final HashMap<String, Integer> defeatedEnemyCount = new HashMap<>();

    // Constructor
    public Hero() {
        super("Hero", 12, 3);
        this.initialHealth = 12;
        setHealth(initialHealth);
        resetPosition();
    }

    // Method to get the position as a string
    public String getPosition() {
        return String.format("N%d.S%d.E%d.W%d", getNorth(), getSouth(), getEast(), getWest());
    }

    public void restoreHealth() {
        setHealth(initialHealth);  // Återställ till det ursprungliga hälsovärdet
    }

    // Reset hero's position
    public void resetPosition() {
        setNorth(0);
        setSouth(0);
        setEast(0);
        setWest(0);
    }

    // Move the hero
    public void moveHero(Direction northSouth, Direction eastWest) {
        moveInDirection(northSouth);
        moveInDirection(eastWest);
    }

    public void moveHero(Direction direction) {
        moveInDirection(direction);
    }

    private void moveInDirection(Direction direction) {
        if (direction == null) {
            return;  // Gör ingenting om riktningen är null
        }

        switch (direction) {
            case NORTH:
                if (getSouth() > 0) {
                    setSouth(getSouth() - 1);
                } else {
                    setNorth(getNorth() + 1);
                }
                break;
            case SOUTH:
                if (getNorth() > 0) {
                    setNorth(getNorth() - 1);
                } else {
                    setSouth(getSouth() + 1);
                }
                break;
            case EAST:
                if (getWest() > 0) {
                    setWest(getWest() - 1);
                } else {
                    setEast(getEast() + 1);
                }
                break;
            case WEST:
                if (getEast() > 0) {
                    setEast(getEast() - 1);
                } else {
                    setWest(getWest() + 1);
                }
                break;
        }
    }

    // Exempel på logik som gör det svårare att fly om spelaren har attackerat
    public boolean checkForRetreat() {
        return random.nextInt(100) + 1 <= (isHasAttacked() ? 20 : 70);
    }

    public void endBattle() {
        setHasAttacked(false);
    }

    // Getters & Setters
    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public boolean isHasAttacked() {
        return hasAttacked;
    }

    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }

    // Lägg till besegrad fiende och uppdatera räknaren
    public void addDefeatedOpponent(Entity opponent) {
        String opponentType = opponent.getClass().getSimpleName();
        defeatedEnemyCount.put(opponentType, defeatedEnemyCount.getOrDefault(opponentType, 0) + 1);
    }
}