package se.johan_hammerin.projektarbete.logic;

import se.johan_hammerin.projektarbete.model.Resident;
import se.johan_hammerin.projektarbete.gui.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (greeting(input)) {
            Resident hero = new Resident();
            new Game(hero);
            GUI gui = new GUI();
            gui.createGUI(hero);
        } else {
            System.out.println("Synd för dig.\nSpelet stängs av...");
            System.exit(0);
        }
    }

    public static boolean greeting(Scanner input) {
        System.out.println("Välkommen till äventyrsspelet!");
        System.out.println("Är det inte lite tråkigt om hela spelet skulle bestå av text i konsolen?");
        return input.next().equals("jo");
    }
}
