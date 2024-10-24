package se.johan_hammerin.adventureGame.logic;

import se.johan_hammerin.adventureGame.characters.*;

import java.util.Random;

public class Game {
    private final static Random random = new Random();
    private final Hero hero;  // Använd hjälten som passeras in

    // Constructor tar emot hjälten
    public Game(Hero hero) {
        this.hero = hero;  // Spara referensen till hjälten
    }

    // Kontrollera om strid ska startas
    public boolean checkForBattle() {
        return random.nextInt(100) + 1 < 10;  // 10% chans att starta en strid
    }

    // Skapa en fiende (Sheep för detta exempel)
    public Player createOpponent() {
        int randomOpponent = random.nextInt(100) + 1;
        //20% chans för lejon
        if (randomOpponent >= 80) return new Lion();
            //20% chans för fisk
        else if (randomOpponent <= 20) return new Fish();
            //60% för sheep
        else return new Sheep();


    }

    // Stridslogik
    public void battleRound(Hero hero, Player opponent) {
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
            rewardForWinning(opponent);
        }
    }


    public boolean returnToTownCentre(Player hero) {
        if (hero.getCurrency() >= 25) {
            hero.setCurrency(hero.getCurrency() - 25);
            return true;
        }
        return false;
    }

    // Används för att hantera motståndarens attack mot hjälten
    public void battleRound(Player opponent) {
        hero.setHealth(hero.getHealth() - opponent.getDamage());
    }

    private void rewardForWinning(Player opponent) {
        hero.setCurrency(hero.getCurrency() + opponent.getCurrency());
    }
}
