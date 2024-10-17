package se.johan_hammerin.adventureGame.characters;

import java.util.Random;

public class Hero extends Player {
    //Constants
    private static final int DAMAGE_PER_ATTACK = 10;
    private static final int STARTING_HEALTH = 100;
    private static final Random random = new Random();

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


    //Method(fight)
    public boolean retreat() {
        //40% chans att fly
        return (random.nextInt(10) + 1 > 6);
    }

    //Method(position)
    public String getPosition() {
        return "N" + getNorth() + ".S" + getSouth() + ".E" + getEast() + ".W" + getWest();
    }

    private void updatePosition(int north, int south, int east, int west) {
        setNorth(north);
        setSouth(south);
        setEast(east);
        setWest(west);
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
