package se.johan_hammerin.adventureGame.characters;

public class Hero extends Player {
    // Constants
    private static final int DAMAGE_PER_ATTACK = 10;
    private static final int STARTING_HEALTH = 100;

    // Attributes
    private int north;
    private int south;
    private int east;
    private int west;

    // Constructor
    public Hero(String name) {
        setName(name);
        setDamage(DAMAGE_PER_ATTACK);
        setHealth(STARTING_HEALTH);
        resetPosition();
    }

    // Method to get the position as a string
    public String getPosition() {
        return String.format("N%d.S%d.E%d.W%d", north, south, east, west);
    }

    // Reset hero's position
    private void resetPosition() {
        north = south = east = west = 0;
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

    // Getters & Setters
    public int getNorth() { return north; }
    public void setNorth(int north) { this.north = north; }

    public int getSouth() { return south; }
    public void setSouth(int south) { this.south = south; }

    public int getEast() { return east; }
    public void setEast(int east) { this.east = east; }

    public int getWest() { return west; }
    public void setWest(int west) { this.west = west; }
}
