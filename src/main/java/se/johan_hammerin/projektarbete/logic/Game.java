package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.*;


public class Game {
    private final Resident resident;


    // Constructor tar emot hjälten
    public Game(Resident resident) {
        this.resident = resident;  // Spara referensen till hjälten
    }


    public boolean foundFryingPan() {
        return resident.isFoundFryingPan();
    }

    // Skapa en fiende
    public Entity createOpponent() {
        return new Burglar();
    }

    // Stridslogik
    public void battleRound(Resident resident, Entity opponent) {
        // Hjälten attackerar
        opponent.setHealth(opponent.getHealth() - resident.getDamage());
        // Motståndaren attackerar hjälten
        resident.setHealth(resident.getHealth() - opponent.getDamage());

        // Kontrollera om striden är över och uppdatera status
        if (!resident.isConscious()) {
            resident.endBattle();  // Återställ hjälteattacksstatus när striden är över
        } else if (!opponent.isConscious()) {
            opponent.setHealth(0);  // Sätt HP till 0 om motståndaren besegras
        }
    }


    // Används för att hantera motståndarens attack mot hjälten om hjälten försöker fly
    public void battleRound(Entity opponent) {
        resident.setHealth(resident.getHealth() - opponent.getDamage());
    }

    public String updateRoom() {
        if (resident.getWest() == 1) return "Köket";
        if (resident.getNorth() == 1) return "Hallen";
        if (resident.getEast() == 1) return "Kontor";
        if (resident.getSouth() == 1) return "Sovrum";
        if (resident.getNorth() == 0 && resident.getSouth() == 0 && resident.getWest() == 0 && resident.getEast() == 0)
            return "Vardagsrum";
        else return "Inget";
    }
}
