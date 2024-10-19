package se.johan_hammerin.adventureGame.logic;

import se.johan_hammerin.adventureGame.characters.Hero;
import java.util.Random;

public class Game {
    private final static Random random = new Random();
    private final Hero hero;  // Använd hjälten som passeras in

    // Konstruktorn tar emot hjälten
    public Game(Hero hero) {
        this.hero = hero;  // Spara referensen till hjälten
    }

    // Kontrollera om strid ska startas
    public boolean checkForBattle() {
        // 20% chans att en strid startas vid varje steg
        return random.nextInt(10) < 2;  // 0, 1 ger träff (2/10 chans)
    }
}
