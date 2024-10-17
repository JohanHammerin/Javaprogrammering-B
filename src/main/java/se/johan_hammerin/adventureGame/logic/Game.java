package se.johan_hammerin.adventureGame.logic;
import se.johan_hammerin.adventureGame.GUI.GUI;
import se.johan_hammerin.adventureGame.characters.*;

public class Game {


    void start() {
        Hero hero = new Hero("Johan");
        GUI gui = new GUI();
        gui.createGUI(hero);
    }
}

