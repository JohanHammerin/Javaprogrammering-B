package se.johan_hammerin.projektarbete.logic;

import junit.framework.Assert;
import junit.framework.TestCase;
import se.johan_hammerin.projektarbete.model.*;

public class GameTest extends TestCase {

    public void testBattleRound() {
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
        Assert.assertTrue(heroHealthAfterBattleRound < heroHealthBeforeBattleRound);
        Assert.assertTrue(burglarHealthAfterBattleRound < burglarHealthBeforeBattleRound);

        // Kontrollera att hälsan inte är mindre än noll
        Assert.assertTrue(heroHealthAfterBattleRound >= 0);
        Assert.assertTrue(burglarHealthAfterBattleRound >= 0);
    }
}
