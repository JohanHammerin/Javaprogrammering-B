package se.johan_hammerin.adventureGame.characters;


public abstract class Player {
    private String name;
    private int health;
    private int damage;
    private int currency;


    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getCurrency() {
        return this.currency;
    }

    public void setCurrency(int currency) {
        if (currency < 0) {
            currency = 0;
        }
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', health=%d, damage=%d}", name, health, damage);
    }
}
