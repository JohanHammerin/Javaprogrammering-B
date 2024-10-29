package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.*;

import java.util.HashMap;
import java.util.Map;
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
        return random.nextInt(100) + 1 <= 10;  // 10% chans att starta en strid
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
            rewardForWinning(opponent);
            hero.addDefeatedOpponent(opponent);
        }
    }

    public boolean returnToTownCentre(Entity hero) {
        if (hero.getCurrency() >= 25) {
            hero.setCurrency(hero.getCurrency() - 25);
            return true;
        }
        return false;
    }

    // Används för att hantera motståndarens attack mot hjälten
    public void battleRound(Entity opponent) {
        hero.setHealth(hero.getHealth() - opponent.getDamage());
    }

    private void rewardForWinning(Entity opponent) {
        hero.setCurrency(hero.getCurrency() + opponent.getCurrency());
    }


    public int getScore() {
        HashMap<String, Integer> defeatedCount = hero.getDefeatedEnemyCount();
        int score = 0;
        for (Map.Entry<String, Integer> entry : defeatedCount.entrySet()) {
            switch (entry.getKey()) {
                //Ingen bonus för fish eller doctor
                case "Fish", "Doctor" -> score += (entry.getValue() * 100);
                //10% bonus för sheep
                case "Sheep" -> score += (entry.getValue() * 110);
                //25% bonus för lion
                case "Lion" -> score += (entry.getValue() * 125);
            }
        }
        return score;
    }

    public StringBuilder printDefeatedEnemies() {
        StringBuilder returnString = new StringBuilder();
        HashMap<String, Integer> defeatedCount = hero.getDefeatedEnemyCount();

        if (defeatedCount.isEmpty()) {
            return returnString.append("Inga fiender besegrade :(");
        } else {
            for (Map.Entry<String, Integer> entry : defeatedCount.entrySet()) {
                returnString.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
            }
        }
        return returnString;
    }

}
