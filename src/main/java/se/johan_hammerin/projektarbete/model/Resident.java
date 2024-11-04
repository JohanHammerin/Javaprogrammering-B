package se.johan_hammerin.projektarbete.model;

import java.util.Random;

public class Resident extends Entity {
    // Random
    private static final Random random = new Random();

    // Attributes
    private int north;
    private int south;
    private int east;
    private int west;
    private boolean hasAttacked;
    private boolean foundFryingPan;
    private boolean defeatedEnemy;

    // Constructor
    public Resident() {
        super("Resident", 12, 3);
        resetPosition();
    }


    // Reset resident's position
    public void resetPosition() {
        setNorth(0);
        setSouth(0);
        setEast(0);
        setWest(0);
    }

    // Move the resident
    public void moveResident(int x, int y) {
        moveInDirection(x, y);
    }

    private void moveInDirection(int x, int y) {
        if (y > 0) {
            if (getSouth() > 0) {
                setSouth(getSouth() - 1);
            } else {
                setNorth(getNorth() + 1);
            }
        } else if (y < 0) {
            if (getNorth() > 0) {
                setNorth(getNorth() - 1);
            } else {
                setSouth(getSouth() + 1);
            }
        }


        if (x > 0) {
            if (getWest() > 0) {
                setWest(getWest() - 1);
            } else {
                setEast(getEast() + 1);
            }
        } else if (x < 0) {
            if (getEast() > 0) {
                setEast(getEast() - 1);
            } else {
                setWest(getWest() + 1);
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

    public boolean isFoundFryingPan() {
        return this.foundFryingPan;
    }

    public void setFoundFryingPan(boolean foundFryingPan) {
        this.foundFryingPan = foundFryingPan;
    }

    public boolean isDefeatedEnemy() {
        return this.defeatedEnemy;
    }

    public void setDefeatedEnemy(boolean defeatedEnemy) {
        this.defeatedEnemy = defeatedEnemy;
    }


}
