package se.johan_hammerin.adventureGame.GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.logic.Game;
import se.johan_hammerin.adventureGame.characters.Player;

public class GUI {
    // TextPane
    private JTextPane positionTextPane;  // Textrutan för att visa spelarens position
    private JTextPane battleStatusTextPane;  // Textruta för att visa stridsinformation och hjälteinformation
    private JPanel centerPanel;  // Panel för mitten-innehåll
    // Knappar
    private JButton attackButton;
    private JButton retreatButton;
    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    private JButton townCentreButton; // Town Centre knapp
    // Attribut
    private Game game;
    private Player currentOpponent;

    // Skapa GUI
    public void createGUI(Hero hero) {
        game = new Game(hero);

        JFrame frame = new JFrame("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new BorderLayout());

        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");

        panel.add(northButton, BorderLayout.NORTH);
        panel.add(southButton, BorderLayout.SOUTH);
        panel.add(eastButton, BorderLayout.EAST);
        panel.add(westButton, BorderLayout.WEST);

        centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        attackButton = new JButton("Attack");
        retreatButton = new JButton("Retreat");
        townCentreButton = new JButton("Town Centre"); // Skapa townCentreButton

        // Hantera attack-logik
        attackButton.addActionListener(_ -> {
            if (currentOpponent != null) {
                disableBattleButtons();  // Inaktivera knappar medan vi väntar

                // Båda attackerar samtidigt
                game.battleRound(hero, currentOpponent);
                if (currentOpponent.getHealth() > 0) {
                    game.battleRound(currentOpponent);
                }

                // Uppdatera HP-status efter attacker
                updateBattleStatus(hero, currentOpponent);

                // Visa hela stridsloggen efter båda har attackerat
                appendCombatLog(showCombatLog(hero, currentOpponent));

                // Kontrollera om striden är över
                if (currentOpponent != null && currentOpponent.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, currentOpponent.getName() + " defeated!");
                    updateHeroStatus(hero);
                    hideBattleOptions();
                    enableMovementButtons();
                    currentOpponent = null;
                    showTownCentreButton(); // Visa townCentreButton efter striden
                } else if (hero.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, "You have been defeated!");
                    updateHeroStatus(hero);
                    System.exit(0);
                }
                enableBattleButtons();  // Återaktivera knappar efter striden
            }
        });

        retreatButton.addActionListener(_ -> {
            if (hero.checkForRetreat()) {
                JOptionPane.showMessageDialog(null, "Du lyckades fly!");
                hero.endBattle();  // Återställ hjälteattacksstatus
                hideBattleOptions();
                enableMovementButtons();
                updateHeroStatus(hero);
                showTownCentreButton(); // Visa townCentreButton efter flykt
            } else {
                JOptionPane.showMessageDialog(null, "Du lyckades inte fly!\n" + currentOpponent.getClass().getSimpleName() + " attackerade dig!");
                game.battleRound(currentOpponent);  // Motståndaren attackerar
                updateBattleStatus(hero, currentOpponent);
            }
        });

        townCentreButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Welcome to the Town Centre!");
            hero.setHealth(100); // Återställ hälsan till 100
            updateHeroStatus(hero); // Uppdaterar hjältestatusen'
            hero.resetPosition();
            System.out.println(hero.getNorth());
            positionTextPane.setText(hero.getPosition());
            
        });

        positionTextPane = new JTextPane();
        positionTextPane.setText(hero.getPosition());
        positionTextPane.setEditable(false);
        positionTextPane.setFont(new Font("Arial", Font.BOLD, 16));
        centerText(positionTextPane);
        centerPanel.add(positionTextPane);

        battleStatusTextPane = new JTextPane();
        battleStatusTextPane.setEditable(false);
        battleStatusTextPane.setFont(new Font("Arial", Font.PLAIN, 14));
        centerPanel.add(battleStatusTextPane);

        panel.add(centerPanel, BorderLayout.CENTER);





        // Lägga till Town Centre-knappen i sydpanelen
        JPanel bottomPanel = new JPanel();
        centerPanel.add(townCentreButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        northButton.addActionListener(_ -> updatePosition(hero, 1, 0, 0, 0));
        southButton.addActionListener(_ -> updatePosition(hero, 0, 1, 0, 0));
        eastButton.addActionListener(_ -> updatePosition(hero, 0, 0, 1, 0));
        westButton.addActionListener(_ -> updatePosition(hero, 0, 0, 0, 1));

        updateHeroStatus(hero);
    }

    private void updatePosition(Hero hero, int north, int south, int east, int west) {
        hero.moveHero(north, south, east, west); // Rörelse
        positionTextPane.setText(hero.getPosition()); // Uppdaterar positionen på skärmen

        if (game.checkForBattle()) {
            currentOpponent = game.createOpponent();
            showBattleOptions();
            disableMovementButtons();
            hideTownCentreButton(); // Döljer townCentreButton under strid
            updateBattleStatus(hero, currentOpponent);
        } else {
            hideBattleOptions();
            showTownCentreButton(); // Visar townCentreButton när det inte pågår någon strid
        }
    }
    // Visa knapparna för strid
    private void showBattleOptions() {
        if (!centerPanel.isAncestorOf(attackButton)) {
            centerPanel.add(attackButton);
        }
        if (!centerPanel.isAncestorOf(retreatButton)) {
            centerPanel.add(retreatButton);
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // Göm knapparna för strid
    private void hideBattleOptions() {
        centerPanel.remove(attackButton);
        centerPanel.remove(retreatButton);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // Visa townCentre-knappen
    private void showTownCentreButton() {
        centerPanel.add(townCentreButton);


    }

    // Göm townCentre-knappen
    private void hideTownCentreButton() {
        centerPanel.remove(townCentreButton);
    }

    // Uppdatera stridsstatus (HP-information visas alltid överst)
    private void updateBattleStatus(Hero hero, Player opponent) {
        if (opponent != null) {
            // Uppdatera HP-informationen för både hjälten och motståndaren
            String hpStatus = "Hero: " + hero.getName() + " - Health: " + hero.getHealth() + "\n" +
                    "Opponent: " + opponent.getName() + " - Health: " + opponent.getHealth() + "\n";
            battleStatusTextPane.setText(hpStatus);  // Visa HP överst
        }

        // Kontrollera om hjälten är besegrad
        if (hero.getHealth() <= 0) {
            JOptionPane.showMessageDialog(null, "You have been defeated!");
            hideBattleOptions();
            currentOpponent = null;
            System.exit(0);
        }
    }

    // Lägg till stridslogg under HP-informationen
    private void appendCombatLog(String combatLog) {
        String currentText = battleStatusTextPane.getText();  // Hämta nuvarande text (HP status)
        battleStatusTextPane.setText(currentText + "\n" + combatLog);  // Lägg till stridslogg under HP-status
    }

    // Uppdatera hjälteinformationen när striden är över
    private void updateHeroStatus(Hero hero) {
        String heroStatus = "Hero: " + hero.getName() + " - Health: " + hero.getHealth() + " - Gold: " + hero.getCurrency();
        battleStatusTextPane.setText(heroStatus);
    }

    // Generera stridslogg efter bådas attacker
    private String showCombatLog(Player hero, Player opponent) {
        if (hero.getHealth() < 0 || opponent.getHealth() < 0) {
            return "";
        } else {
            return hero.getName() + " attacks " + opponent.getName() +
                    " for " + hero.getDamage() + " damage ⚔️\n" +
                    opponent.getName() + " attacks " + hero.getName() +
                    " for " + opponent.getDamage() + " damage ⚔️";
        }
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

    // Centrera text i JTextPane
    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
