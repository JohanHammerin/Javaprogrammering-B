package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.Resident;
import se.johan_hammerin.projektarbete.gui.GUI;


public class Main {
    public static void main(String[] args) {
        Resident resident = new Resident();
        GUI gui = new GUI();
        gui.createGUI(resident);
    }
}
