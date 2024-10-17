package se.johan_hammerin.adventureGame.characters;

public abstract class Player {

    //Constants


    //Attributes
    private String name;
    private int health;
    private int damage;


    //Methods
    public void attack(Player player) {
        player.setHealth(player.getHealth() - getDamage());
        System.out.println("[" + getName()+ "]" + " attacked [" + player.getName() + "]");
        System.out.println("[" + player.getName() + "]:" + player.getHealth() + " hp left");
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    //toString


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
