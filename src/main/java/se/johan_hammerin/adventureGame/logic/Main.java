package se.johan_hammerin.adventureGame.logic;

import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.gui.GUI;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        new Game(hero);
        GUI gui = new GUI();
        gui.createGUI(hero);
    }
}
