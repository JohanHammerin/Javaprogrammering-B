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
        setNorth(0);
        setSouth(0);
        setEast(0);
        setWest(0);
    }

    //Method to get the position as a string
    public String getPosition() {
        return "N" + getNorth() + ".S" + getSouth() + ".E" + getEast() + ".W" + getWest();
    }

    //Method to move the hero
    public void moveHero(int north, int south, int east, int west) {
        // Hantera nord-syd rörelse
        if (north == 1) {  // Rörelse norrut
            if (getSouth() > 0) {
                setSouth(getSouth() - 1);  // Minska South först
            } else {
                setNorth(getNorth() + 1);  // Öka North om South är 0
            }
        } else if (south == 1) {  // Rörelse söderut
            if (getNorth() > 0) {
                setNorth(getNorth() - 1);  // Minska North först
            } else {
                setSouth(getSouth() + 1);  // Öka South om North är 0
            }
        }

        // Hantera öst-väst rörelse
        if (east == 1) {  // Rörelse österut
            if (getWest() > 0) {
                setWest(getWest() - 1);  // Minska West först
            } else {
                setEast(getEast() + 1);  // Öka East om West är 0
            }
        } else if (west == 1) {  // Rörelse västerut
            if (getEast() > 0) {
                setEast(getEast() - 1);  // Minska East först
            } else {
                setWest(getWest() + 1);   // Öka West om East är 0
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
