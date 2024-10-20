package se.johan_hammerin.adventureGame.logic;

import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.characters.Player;
import se.johan_hammerin.adventureGame.characters.Sheep;

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
        return random.nextInt(10) < 1;  // 10% chans att starta en strid
    }

    // Skapa en fiende (Sheep för detta exempel)
    public Player createOpponent() {
        return new Sheep();  // Skapa en ny Sheep
    }

    // Stridslogik
    public String battleRound(Hero hero, Player opponent) {
        StringBuilder battleMessages = new StringBuilder();

        // Hjälten attackerar
        opponent.setHealth(opponent.getHealth() - hero.getDamage());
        battleMessages.append(hero.getName()).append(" attacks ").append(opponent.getName())
                .append(" for ").append(hero.getDamage()).append(" damage. \n");

        // Kontrollera om motståndaren är besegrad
        if (opponent.getHealth() <= 0) {
            battleMessages.append(opponent.getName()).append(" is defeated!");
            return battleMessages.toString();
        }

        // Motståndaren attackerar hjälten
        hero.setHealth(hero.getHealth() - opponent.getDamage());
        battleMessages.append(opponent.getName()).append(" attacks ").append(hero.getName())
                .append(" for ").append(opponent.getDamage()).append(" damage. \n");

        // Kontrollera om hjälten är besegrad
        if (hero.getHealth() <= 0) {
            battleMessages.append(hero.getName()).append(" is defeated!");
        }

        return battleMessages.toString();
    }

    // Initiera strid om det behövs
    public void tryToStartBattle() {
        if (checkForBattle()) {
            Player opponent = createOpponent();  // Skapa en motståndare (Sheep)
            battleRound(hero, opponent);  // Starta striden
        }
    }
}
