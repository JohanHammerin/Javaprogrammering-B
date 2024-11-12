package se.johan_hammerin.projektarbete.logic;

import org.junit.jupiter.api.Test;
import se.johan_hammerin.projektarbete.model.Burglar;
import se.johan_hammerin.projektarbete.model.Entity;
import se.johan_hammerin.projektarbete.model.Resident;


import static org.junit.jupiter.api.Assertions.*;
class GameTest {

    @Test
    void testBattleRound() {
        // Skapa resident och burglar
        Resident resident = new Resident();
        Entity burglar = new Burglar();

        // Hämta ursprunglig hälsa
        int heroHealthBeforeBattleRound = resident.getHealth();
        int burglarHealthBeforeBattleRound = burglar.getHealth();

        // Skapa Game-instans och kör en omgång av battleRound
        Game game = new Game(resident);
        game.battleRound(resident, burglar);

        // Hämta hälsa efter striden
        int heroHealthAfterBattleRound = resident.getHealth();
        int burglarHealthAfterBattleRound = burglar.getHealth();

        // Kontrollera att hjälten och motståndaren har förlorat hälsa efter striden
        assertTrue(heroHealthAfterBattleRound < heroHealthBeforeBattleRound);
        assertTrue(burglarHealthAfterBattleRound < burglarHealthBeforeBattleRound);

        // Kontrollera att hälsan inte är mindre än noll
        assertTrue(heroHealthAfterBattleRound >= 0);
        assertTrue(burglarHealthAfterBattleRound >= 0);
    }
}