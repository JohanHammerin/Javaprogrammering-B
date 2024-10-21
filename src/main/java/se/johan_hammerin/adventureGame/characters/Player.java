package se.johan_hammerin.adventureGame.characters;


public abstract class Player {
    private String name;
    private int health;
    private int damage;
    private int currency;
    private boolean beenAttacked = false;  // Ny variabel

    // Metod för attack
    public void attack(Player target) {
        target.setHealth(target.getHealth() - damage);
        target.setBeenAttacked(true);  // Markera att målet har blivit attackerat
        System.out.printf("[%s] attacked [%s]%n", name, target.getName());
        System.out.printf("[%s]: %d hp left%n", target.getName(), target.getHealth());
    }

    // Getter för att se om spelaren har blivit attackerad
    public boolean hasBeenAttacked() {
        return beenAttacked;
    }

    // Setter för att uppdatera om spelaren har blivit attackerad
    public void setBeenAttacked(boolean beenAttacked) {
        this.beenAttacked = beenAttacked;
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
