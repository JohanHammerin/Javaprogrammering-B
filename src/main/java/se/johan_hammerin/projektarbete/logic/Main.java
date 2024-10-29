package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.Hero;
import se.johan_hammerin.projektarbete.gui.GUI;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        new Game(hero);
        GUI gui = new GUI();
        gui.createGUI(hero);
    }
}
