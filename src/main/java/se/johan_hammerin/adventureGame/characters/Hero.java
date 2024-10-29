package se.johan_hammerin.adventureGame.characters;

import java.util.HashMap;
import java.util.Random;

public class Hero extends Player {
    private static final Random random = new Random();

    private int north;
    private int south;
    private int east;
    private int west;
    private boolean hasAttacked;
    private final int initialHealth;
    private final HashMap<String, Integer> defeatedEnemyCount = new HashMap<>();

    // Constructor
    public Hero(String name) {
        super(name, 100, 10, 0);
        this.initialHealth = 100;
        resetPosition();
    }

    public String getPosition() {
        return String.format("N%d.S%d.E%d.W%d", north, south, east, west);
    }

    public void restoreHealth() {
        setHealth(initialHealth);
    }

    public void resetPosition() {
        north = south = east = west = 0;
    }

    public void moveHero(int northMove, int southMove, int eastMove, int westMove) {
        moveInDirection(northMove, southMove, true);
        moveInDirection(eastMove, westMove, false);
    }

    private void moveInDirection(int positiveMove, int negativeMove, boolean isNorthSouth) {
        if (positiveMove == 1) {
            if (isNorthSouth) {
                setNorth(getSouth() > 0 ? south - 1 : north + 1);
            } else {
                setEast(getWest() > 0 ? west - 1 : east + 1);
            }
        } else if (negativeMove == 1) {
            if (isNorthSouth) {
                setSouth(getNorth() > 0 ? north - 1 : south + 1);
            } else {
                setWest(getEast() > 0 ? east - 1 : west + 1);
            }
        }
    }

    public boolean checkForRetreat() {
        int chance = hasAttacked ? 20 : 70;
        return random.nextInt(100) < chance;
    }

    public void endBattle() {
        hasAttacked = false;
    }

    public void addDefeatedOpponent(Player opponent) {
        String opponentType = opponent.getClass().getSimpleName();
        defeatedEnemyCount.put(opponentType, defeatedEnemyCount.getOrDefault(opponentType, 0) + 1);
    }

    public HashMap<String, Integer> getDefeatedEnemyCount() {
        return defeatedEnemyCount;
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
}
