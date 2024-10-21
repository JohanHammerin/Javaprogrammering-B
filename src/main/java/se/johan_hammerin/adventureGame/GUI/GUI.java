package se.johan_hammerin.adventureGame.GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.logic.Game;
import se.johan_hammerin.adventureGame.characters.Player;

public class GUI {
    private JTextPane positionTextPane;  // Textrutan för att visa spelarens position
    private JTextPane battleStatusTextPane;  // Textruta för att visa stridsinformation och hjälteinformation
    private JPanel centerPanel;  // Panel för mitten-innehåll
    private JButton attackButton;
    private JButton retreatButton;
    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    private Game game;  // Använd samma game-instans
    private Player currentOpponent; // Håll koll på motståndaren

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
        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");

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

        // Lägg till action för attackknappen
        attackButton.addActionListener(e -> {
            if (currentOpponent != null) {
                disableBattleButtons();  // Inaktivera knappar medan vi väntar
                new BattleWorker(hero, currentOpponent).execute();  // Starta stridsrunda i bakgrunden
            }
        });
        // Lägg till action för retreatknappen
        retreatButton.addActionListener(e -> {
            if (currentOpponent.hasBeenAttacked()) {  // Kontrollera om motståndaren har blivit attackerad
                JOptionPane.showMessageDialog(null, "Det är svårare att fly om man slår folk");
                // Öka svårigheten att fly, t.ex. genom att lägga till en extra kontroll
                if (!hero.checkForRetreatBeforeAttacking()) {
                    JOptionPane.showMessageDialog(null, "Du lyckades inte fly!");
                } else {
                    hideBattleOptions();  // Göm stridsknapparna när spelaren retirerar
                    enableMovementButtons();  // Återaktivera rörelseknappar
                    updateHeroStatus(hero);  // Visa bara hjälteinformationen
                }
            } else {  // Om motståndaren inte har blivit attackerad, enklare att fly
                if (hero.checkForRetreatBeforeAttacking()) {
                    hideBattleOptions();  // Göm stridsknapparna när spelaren retirerar
                    enableMovementButtons();  // Återaktivera rörelseknappar
                    updateHeroStatus(hero);  // Visa bara hjälteinformationen
                } else {
                    JOptionPane.showMessageDialog(null, "Du lyckades inte fly!");
                }
            }
        });

        // Skapa en JTextPane för att visa spelarens koordinater
        positionTextPane = new JTextPane();
        positionTextPane.setText(hero.getPosition());  // Sätt initial position
        positionTextPane.setEditable(false);  // Gör textområdet ej redigerbart
        positionTextPane.setFont(new Font("Arial", Font.BOLD, 16));  // Ändra fontstorlek
        centerText(positionTextPane);  // Centrera texten

        // Skapa en JTextPane för att visa stridsstatus (hjälte och motståndare)
        battleStatusTextPane = new JTextPane();
        battleStatusTextPane.setEditable(false);  // Gör stridsstatus-området ej redigerbart
        battleStatusTextPane.setFont(new Font("Arial", Font.PLAIN, 14));  // Sätt fonten för stridsstatus

        // Lägg till koordinaterna (de ska visas hela tiden)
        centerPanel.add(positionTextPane);

        // Lägg till stridsstatusrutan till centerPanel
        centerPanel.add(battleStatusTextPane);

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
        northButton.addActionListener(e -> updatePosition(hero, 1, 0, 0, 0));
        southButton.addActionListener(e -> updatePosition(hero, 0, 1, 0, 0));
        eastButton.addActionListener(e -> updatePosition(hero, 0, 0, 1, 0));
        westButton.addActionListener(e -> updatePosition(hero, 0, 0, 0, 1));
    }

    // Metod för att uppdatera spelarens position och textrutan
    private void updatePosition(Hero hero, int north, int south, int east, int west) {
        hero.moveHero(north, south, east, west);  // Flytta hjälten
        positionTextPane.setText(hero.getPosition());  // Uppdatera positionen i GUI:t

        // Kontrollera om strid ska startas efter att hjälten rört sig
        if (game.checkForBattle()) {
            currentOpponent = game.createOpponent();  // Skapa en motståndare
            showBattleOptions();  // Visa knapparna för "Attack" och "Retreat"
            disableMovementButtons();  // Inaktivera rörelseknapparna under striden
            updateBattleStatus(hero, currentOpponent);  // Uppdatera stridsstatusen
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

    // Uppdatera stridens status i textrutan under striden
    private void updateBattleStatus(Hero hero, Player opponent) {
        String battleStatus = "Hero: " + hero.getName() + " - Health: " + hero.getHealth() + "\n" +
                "Opponent: " + opponent.getName() + " - Health: " + opponent.getHealth() + "\n";
        battleStatusTextPane.setText(battleStatus);  // Uppdatera stridsstatusrutan

        if (opponent.getHealth() <= 0) {
            JOptionPane.showMessageDialog(null, opponent.getName() + " defeated!");
            hideBattleOptions();  // Göm knapparna när motståndaren besegras
            enableMovementButtons();  // Återaktivera rörelseknappar
            currentOpponent = null;
            updateHeroStatus(hero);  // Visa bara hjälteinformationen
        } else if (hero.getHealth() <= 0) {
            JOptionPane.showMessageDialog(null, "You have been defeated!");
            hideBattleOptions();  // Göm knapparna när hjälten besegras
            currentOpponent = null;
            System.exit(0);  // Stänger spelet när hjälten är besegrad
        }
    }

    // Uppdatera hjälteinformationen när striden är över
    private void updateHeroStatus(Hero hero) {
        String heroStatus = "Hero: " + hero.getName() + " - Health: " + hero.getHealth();
        battleStatusTextPane.setText(heroStatus);  // Visa bara hjälteinformationen i stridsstatusrutan
    }

    // Inaktivera rörelseknappar
    private void disableMovementButtons() {
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
    }

    // Aktivera rörelseknappar
    private void enableMovementButtons() {
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        eastButton.setEnabled(true);
        westButton.setEnabled(true);
    }

    // Inaktivera stridsknappar
    private void disableBattleButtons() {
        attackButton.setEnabled(false);
        retreatButton.setEnabled(false);
    }

    // Aktivera stridsknappar
    private void enableBattleButtons() {
        attackButton.setEnabled(true);
        retreatButton.setEnabled(true);
    }

    // Metod för att centrera text i JTextPane
    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    // SwingWorker för att hantera stridsrundor
    private class BattleWorker extends SwingWorker<String, String> {
        private final Hero hero;
        private final Player opponent;

        public BattleWorker(Hero hero, Player opponent) {
            this.hero = hero;
            this.opponent = opponent;
        }

        @Override
        protected String doInBackground() throws Exception {
            // Gör en runda av striden
            return game.battleRound(hero, opponent);
        }

        @Override
        protected void process(List<String> chunks) {
            for (String message : chunks) {
                battleStatusTextPane.setText(battleStatusTextPane.getText() + message);
            }
        }

        @Override
        protected void done() {
            try {
                String result = get();
                publish(result);  // Publicera resultatet
                Thread.sleep(500);  // Vänta 2.5 sekunder för nästa strid
                enableBattleButtons();  // Återaktivera stridsknappar
                updateBattleStatus(hero, opponent);  // Uppdatera status
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();  // Hantera undantag
            }
        }
    }
}
