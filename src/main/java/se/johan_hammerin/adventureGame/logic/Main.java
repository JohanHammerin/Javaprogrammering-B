package se.johan_hammerin.adventureGame.logic;

import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.GUI.GUI;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero");
        Game game = new Game(hero);  // Skapa Game med hjälten
        GUI gui = new GUI();
        gui.createGUI(hero);  // Passera hjälten till GUI
    }
}
