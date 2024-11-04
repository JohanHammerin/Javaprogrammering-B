package se.johan_hammerin.projektarbete.model;

public abstract class Entity {
    private String role;
    private int health;
    private int damage;

    // Constructor
    protected Entity(String role, int health, int damage) {
        setRole(role);
        setHealth(health);
        setDamage(damage);

    }

    public boolean isConscious() {
        return getHealth() > 0;
    }

    // Getters & Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
