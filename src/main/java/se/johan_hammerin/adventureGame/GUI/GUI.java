package se.johan_hammerin.adventureGame.GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.logic.Game;

public class GUI {
    private JTextPane positionTextPane;  // Textrutan för att visa spelarens position
    private JPanel centerPanel;  // Panel för mitten-innehåll
    private JButton attackButton;
    private JButton retreatButton;
    private Game game;  // Använd samma game-instanser

    // Skapa GUI
    public void createGUI(Hero hero) {
        game = new Game(hero);  // Passera hjälten till spelet

        // Skapa en ny JFrame
        JFrame frame = new JFrame("Adventure Game");
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

        // Skapa en JPanel för mitten-innehållet med GridLayout (för flera komponenter)
        centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));  // 4 rader, 1 kolumn

        // Skapa två knappar för "Attack" och "Retreat"
        attackButton = new JButton("Attack");
        retreatButton = new JButton("Retreat");

        // Skapa en JTextPane för att visa spelarens koordinater
        positionTextPane = new JTextPane();
        positionTextPane.setText(hero.getPosition());  // Sätt initial position
        positionTextPane.setEditable(false);  // Gör textområdet ej redigerbart
        positionTextPane.setFont(new Font("Arial", Font.BOLD, 16));  // Ändra fontstorlek
        centerText(positionTextPane);  // Centrera texten

        // Lägg till koordinaterna (de ska visas hela tiden)
        centerPanel.add(positionTextPane);

        // Lägg till centerPanel i mitten av BorderLayout
        panel.add(centerPanel, BorderLayout.CENTER);

        // Lägg till JPanel till JFrame
        frame.add(panel);

        // Gör fönstret icke-resizable
        frame.setResizable(false);

        // Centrera fönstret på skärmen
        frame.setLocationRelativeTo(null);

        // Gör fönstret synligt
        frame.setVisible(true);

        // Lägg till ActionListeners för knapparna som uppdaterar spelarens position
        northButton.addActionListener(e -> updatePosition(hero, game, 1, 0, 0, 0));
        southButton.addActionListener(e -> updatePosition(hero, game, 0, 1, 0, 0));
        eastButton.addActionListener(e -> updatePosition(hero, game, 0, 0, 1, 0));
        westButton.addActionListener(e -> updatePosition(hero, game, 0, 0, 0, 1));
    }

    // Metod för att uppdatera spelarens position och textrutan
    private void updatePosition(Hero hero, Game game, int north, int south, int east, int west) {
        hero.moveHero(north, south, east, west);  // Flytta hjälten
        positionTextPane.setText(hero.getPosition());  // Uppdatera positionen i GUI:t

        // Kontrollera om strid ska startas efter att hjälten rört sig
        if (game.checkForBattle()) {
            showBattleOptions();  // Visa knapparna för "Attack" och "Retreat"
        } else {
            hideBattleOptions();  // Göm stridsknappar om ingen strid pågår
        }
    }

    // Visa knapparna för "Attack" och "Retreat"
    private void showBattleOptions() {
        if (!centerPanel.isAncestorOf(attackButton)) {
            centerPanel.add(attackButton);  // Lägg till "Attack"-knappen
        }
        if (!centerPanel.isAncestorOf(retreatButton)) {
            centerPanel.add(retreatButton);  // Lägg till "Retreat"-knappen
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // Göm knapparna för strid
    private void hideBattleOptions() {
        centerPanel.remove(attackButton);  // Ta bort "Attack"-knappen
        centerPanel.remove(retreatButton);  // Ta bort "Retreat"-knappen
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // Metod för att centrera text i JTextPane
    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
