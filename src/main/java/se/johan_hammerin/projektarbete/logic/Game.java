package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.*;


public class Game {
    private final Hero hero;  // Använd hjälten som passeras in
    private boolean foundKitchen;
    private boolean foundHallway;
    private boolean foundOffice;

    // Constructor tar emot hjälten
    public Game(Hero hero) {
        this.hero = hero;  // Spara referensen till hjälten
    }


    // Kontrollera om strid ska startas
    public boolean checkForBattle() {
        return false;
    }

    // Skapa en fiende (Sheep för detta exempel)
    public Entity createOpponent() {
        /*
        int randomOpponent = random.nextInt(100) + 1;
        //25% chans för lejon
        if (randomOpponent >= 75) return new Lion();
            //20% chans för fisk
        else if (randomOpponent <= 20) return new Fish();
            //5% för doktor
        else if (randomOpponent >= 70) return new Doctor();
*/
        return new Burglar();
    }

    // Stridslogik
    public void battleRound(Hero hero, Entity opponent) {
        // Hjälten attackerar
        opponent.setHealth(opponent.getHealth() - hero.getDamage());
        // Motståndaren attackerar hjälten
        hero.setHealth(hero.getHealth() - opponent.getDamage());

        // Kontrollera om striden är över och uppdatera status
        if (hero.getHealth() <= 0) {
            hero.setHealth(0);  // Sätt HP till 0 om hjälten besegras
            hero.endBattle();  // Återställ hjälteattacksstatus när striden är över
        } else if (opponent.getHealth() <= 0) {
            opponent.setHealth(0);  // Sätt HP till 0 om motståndaren besegras
        }
    }


    // Används för att hantera motståndarens attack mot hjälten
    public void battleRound(Entity opponent) {
        hero.setHealth(hero.getHealth() - opponent.getDamage());
    }


}
