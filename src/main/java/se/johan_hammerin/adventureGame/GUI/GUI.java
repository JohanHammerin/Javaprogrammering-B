package se.johan_hammerin.adventureGame.GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import se.johan_hammerin.adventureGame.characters.Hero;

public class GUI {
    private JTextPane positionTextPane; // Textrutan för att visa spelarens position

    // Skapa GUI
    public void createGUI(Hero hero) {
        // Skapa en ny JFrame
        JFrame frame = new JFrame("Directional Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);  // Sätt storlek på fönstret

        // Skapa en JPanel med BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Skapa fyra knappar, en för varje riktning
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");

        // Lägg till knapparna i respektive position i BorderLayout
        panel.add(northButton, BorderLayout.NORTH);
        panel.add(southButton, BorderLayout.SOUTH);
        panel.add(eastButton, BorderLayout.EAST);
        panel.add(westButton, BorderLayout.WEST);

        // Skapa en JTextPane för att visa spelarens koordinater
        positionTextPane = new JTextPane();
        positionTextPane.setText(hero.getPosition());  // Sätt initial position
        positionTextPane.setEditable(false);  // Gör textområdet ej redigerbart
        positionTextPane.setFont(new Font("Arial", Font.BOLD, 16));  // Ändra fontstorlek
        centerText(positionTextPane);  // Centrera texten

        // Lägg till JTextPane i mitten av BorderLayout
        panel.add(positionTextPane, BorderLayout.CENTER);

        // Lägg till JPanel till JFrame
        frame.add(panel);

        // Gör fönstret icke-resizable
        frame.setResizable(false);

        // Centrera fönstret på skärmen
        frame.setLocationRelativeTo(null);

        // Gör fönstret synligt
        frame.setVisible(true);

        // Lägg till ActionListeners för knapparna som uppdaterar spelarens position
        northButton.addActionListener(e -> moveHero(hero, 1, 0, 0, 0));
        southButton.addActionListener(e -> moveHero(hero, 0, 1, 0, 0));
        eastButton.addActionListener(e -> moveHero(hero, 0, 0, 1, 0));
        westButton.addActionListener(e -> moveHero(hero, 0, 0, 0, 1));
    }

    // Metod för att uppdatera spelarens position och textrutan
    private void moveHero(Hero hero, int north, int south, int east, int west) {
        // Hantera nord-syd rörelse
        if (north == 1) {  // Rörelse norrut
            if (hero.getSouth() > 0) {
                hero.setSouth(hero.getSouth() - 1);  // Minska South först
            } else {
                hero.setNorth(hero.getNorth() + 1);  // Öka North om South är 0
            }
        } else if (south == 1) {  // Rörelse söderut
            if (hero.getNorth() > 0) {
                hero.setNorth(hero.getNorth() - 1);  // Minska North först
            } else {
                hero.setSouth(hero.getSouth() + 1);  // Öka South om North är 0
            }
        }

        // Hantera öst-väst rörelse
        if (east == 1) {  // Rörelse österut
            if (hero.getWest() > 0) {
                hero.setWest(hero.getWest() - 1);  // Minska West först
            } else {
                hero.setEast(hero.getEast() + 1);  // Öka East om West är 0
            }
        } else if (west == 1) {  // Rörelse västerut
            if (hero.getEast() > 0) {
                hero.setEast(hero.getEast() - 1);  // Minska East först
            } else {
                hero.setWest(hero.getWest() + 1);  // Öka West om East är 0
            }
        }

        // Uppdatera textrutan med spelarens nya position
        positionTextPane.setText(hero.getPosition());
    }

    // Metod för att centrera text i JTextPane
    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
