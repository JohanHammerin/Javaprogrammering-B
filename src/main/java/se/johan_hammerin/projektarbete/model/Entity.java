package se.johan_hammerin.projektarbete.model;

public abstract class Entity {
    private String name;
    private int health;
    private int damage;

    // Constructor
    protected Entity(String name, int health, int damage) {
        setName(name);
        setHealth(health);
        setDamage(damage);

    }

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

    @Override
    public String toString() {
        return String.format("Player{name='%s', health=%d, damage=%d}", name, health, damage);
    }
}
