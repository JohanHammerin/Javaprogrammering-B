package se.johan_hammerin.adventureGame.characters;

public class Hero extends Player {
    //Constants
    private static final int DAMAGE_PER_ATTACK = 10;
    private static final int STARTING_HEALTH = 100;

    //Attributes
    private int north;
    private int south;
    private int east;
    private int west;

    //Constructor
    public Hero(String name) {
        setName(name);
        setDamage(DAMAGE_PER_ATTACK);
        setHealth(STARTING_HEALTH);
    }

    //Method to get the position as a string
    public String getPosition() {
        return "N" + getNorth() + ".S" + getSouth() + ".E" + getEast() + ".W" + getWest();
    }

    //Method to move the hero
    public void moveHero(int north, int south, int east, int west) {
        // Hantera nord-syd rörelse
        if (north == 1) {  // Rörelse norrut
            if (this.south > 0) {
                this.south--;  // Minska South först
            } else {
                this.north++;  // Öka North om South är 0
            }
        } else if (south == 1) {  // Rörelse söderut
            if (this.north > 0) {
                this.north--;  // Minska North först
            } else {
                this.south++;  // Öka South om North är 0
            }
        }

        // Hantera öst-väst rörelse
        if (east == 1) {  // Rörelse österut
            if (this.west > 0) {
                this.west--;  // Minska West först
            } else {
                this.east++;  // Öka East om West är 0
            }
        } else if (west == 1) {  // Rörelse västerut
            if (this.east > 0) {
                this.east--;  // Minska East först
            } else {
                this.west++;  // Öka West om East är 0
            }
        }
    }

    //Getters & Setters
    public int getNorth() {
        return this.north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return this.south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getEast() {
        return this.east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getWest() {
        return this.west;
    }

    public void setWest(int west) {
        this.west = west;
    }
}
