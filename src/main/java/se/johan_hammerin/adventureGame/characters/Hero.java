package se.johan_hammerin.adventureGame.characters;

import java.util.Random;

public class Hero extends Player {
    //Random
    private static final Random random = new Random();

    // Attributes
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean hasAttacked;

    // Constructor
    public Hero(String name) {
        setName(name);
        setDamage(10);
        setHealth(100);
        setCurrency(5);
        resetPosition();
    }

    // Method to get the position as a string
    public String getPosition() {
        return String.format("N%d.S%d.E%d.W%d", north, south, east, west);
    }

    // Reset hero's position
    private void resetPosition() {
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
        if (positiveMove == 1) {  // Positive movement
            if (isNorthSouth) {
                if (south > 0) south--;
                else north++;
            } else {
                if (west > 0) west--;
                else east++;
            }
        } else if (negativeMove == 1) {  // Negative movement
            if (isNorthSouth) {
                if (north > 0) north--;
                else south++;
            } else {
                if (east > 0) east--;
                else west++;
            }
        }
    }

    // Exempel på logik som gör det svårare att fly om spelaren har attackerat
    public boolean checkForRetreat() {
        if (this.isHasAttacked()) {
            return random.nextInt(100) < 30;  // 30% chans att fly efter attack
        } else {
            return random.nextInt(100) < 70;  // 70% chans att fly innan attack
        }
    }

    public void endBattle() {
        this.hasAttacked = false;
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
}
