package se.johan_hammerin.adventureGame.characters;

public abstract class Player {
    // Attributes
    private String name;
    private int health;
    private int damage;

    // Methods
    public void attack(Player target) {
        target.setHealth(target.getHealth() - damage);
        System.out.printf("[%s] attacked [%s]%n", name, target.getName());
        System.out.printf("[%s]: %d hp left%n", target.getName(), target.getHealth());
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    @Override
    public String toString() {
        return String.format("Player{name='%s', health=%d, damage=%d}", name, health, damage);
    }
}
