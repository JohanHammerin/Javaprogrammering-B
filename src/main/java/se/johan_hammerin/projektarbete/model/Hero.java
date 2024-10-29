package se.johan_hammerin.projektarbete.model;

import java.util.HashMap;
import java.util.Random;

public class Hero extends Entity {
    // Random
    private static final Random random = new Random();

    // Attributes
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean hasAttacked;
    private final HashMap<String, Integer> defeatedEnemyCount = new HashMap<>(); // Lägger till en HashMap för besegrade fiender

    // Constructor
    public Hero() {
        super("Hero", 12, 3);
        resetPosition();
    }

    // Method to get the position as a string
    public String getPosition() {
        return String.format("N%d.S%d.E%d.W%d", getNorth(), getSouth(), getEast(), getWest());
    }


    // Reset hero's position
    public void resetPosition() {
        setNorth(0);
        setSouth(0);
        setEast(0);
        setWest(0);
    }

    // Move the hero
    public void moveHero(int northMove, int southMove, int eastMove, int westMove) {
        moveInDirection(northMove, southMove, true);
        moveInDirection(eastMove, westMove, false);
    }

    private void moveInDirection(int positiveMove, int negativeMove, boolean isNorthSouth) {
        if (positiveMove == 1) {
            if (isNorthSouth) {
                if (getSouth() > 0) setSouth(getSouth() - 1);
                else setNorth(getNorth() + 1);
            } else {
                if (getWest() > 0) setWest(getWest() - 1);
                else setEast(getEast() + 1);
            }
        } else if (negativeMove == 1) {
            if (isNorthSouth) {
                if (getNorth() > 0) setNorth(getNorth() - 1);
                else setSouth(getSouth() + 1);
            } else {
                if (getEast() > 0) setEast(getEast() - 1);
                else setWest(getWest() + 1);
            }
        }
    }

    // Exempel på logik som gör det svårare att fly om spelaren har attackerat
    public boolean checkForRetreat() {
        if (this.isHasAttacked()) {
            return random.nextInt(100) + 1 <= 20;  // 20% chans att fly efter attack
        } else {
            return random.nextInt(100) + 1 <= 70;  // 70% chans att fly innan attack
        }
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
