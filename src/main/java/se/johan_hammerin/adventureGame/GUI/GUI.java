package se.johan_hammerin.adventureGame.GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import se.johan_hammerin.adventureGame.characters.Hero;
import se.johan_hammerin.adventureGame.logic.Game;
import se.johan_hammerin.adventureGame.characters.Player;

public class GUI {
    // TextPane
    private JTextPane positionTextPane;
    private JTextPane battleStatusTextPane;
    private JPanel centerPanel;
    // Knappar
    private JButton attackButton;
    private JButton retreatButton;
    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    private JButton townCentreButton;
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

        // Skapa en separat panel för riktningsknapparna
        JPanel movementPanel = new JPanel(new BorderLayout());
        movementPanel.add(northButton, BorderLayout.NORTH);
        movementPanel.add(southButton, BorderLayout.SOUTH);
        movementPanel.add(eastButton, BorderLayout.EAST);
        movementPanel.add(westButton, BorderLayout.WEST);
        panel.add(movementPanel, BorderLayout.SOUTH);

        centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        attackButton = new JButton("Attack");
        retreatButton = new JButton("Retreat");
        townCentreButton = new JButton("Town Centre (25)");
        updateTownCentreButton(hero);

        attackButton.addActionListener(_ -> {
            if (currentOpponent != null) {
                disableBattleButtons();
                game.battleRound(hero, currentOpponent);
                if (currentOpponent.getHealth() > 0) {
                    game.battleRound(currentOpponent);
                }
                updateBattleStatus(hero, currentOpponent);
                appendCombatLog(showCombatLog(hero, currentOpponent));

                if (currentOpponent != null && currentOpponent.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, currentOpponent.getName() + " defeated!");
                    updateHeroStatus(hero);
                    hideBattleOptions();
                    enableMovementButtons();
                    currentOpponent = null;
                    updateTownCentreButton(hero);
                    showTownCentreButton();
                } else if (hero.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, "You have been defeated!");
                    updateHeroStatus(hero);
                    System.exit(0);
                }
                enableBattleButtons();
            }
        });

        retreatButton.addActionListener(_ -> {
            if (hero.checkForRetreat()) {
                hero.endBattle();
                hideBattleOptions();
                enableMovementButtons();
                updateHeroStatus(hero);
                updateTownCentreButton(hero);
                showTownCentreButton();
            } else {
                JOptionPane.showMessageDialog(null, "Du lyckades inte fly!\n" + currentOpponent.getClass().getSimpleName() + " attackerade dig!");
                game.battleRound(currentOpponent);
                updateBattleStatus(hero, currentOpponent);
            }
        });

        townCentreButton.addActionListener(_ -> {
            if (game.returnToTownCentre(hero)) {
                JOptionPane.showMessageDialog(frame, "Welcome to the Town Centre!");
                hero.restoreHealth();
                updateHeroStatus(hero);
                hero.resetPosition();
                positionTextPane.setText(hero.getPosition());
            } else {
                JOptionPane.showMessageDialog(null, "Lågt saldo.");
            }
            updateTownCentreButton(hero);
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

        // Lägg till Town Centre-knappen i centerPanel
        centerPanel.add(townCentreButton);

        panel.add(centerPanel, BorderLayout.CENTER);

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

    private void updateTownCentreButton(Hero hero) {
        townCentreButton.setEnabled(hero.getCurrency() >= 25);
    }

    private void updatePosition(Hero hero, int north, int south, int east, int west) {
        hero.moveHero(north, south, east, west);
        positionTextPane.setText(hero.getPosition());

        if (game.checkForBattle()) {
            currentOpponent = game.createOpponent();
            showBattleOptions();
            disableMovementButtons();
            hideTownCentreButton();
            updateBattleStatus(hero, currentOpponent);
        } else {
            hideBattleOptions();
            updateTownCentreButton(hero);
        }
    }

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

    private void hideBattleOptions() {
        centerPanel.remove(attackButton);
        centerPanel.remove(retreatButton);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void hideTownCentreButton() {
        centerPanel.remove(townCentreButton);
    }

    private void updateBattleStatus(Hero hero, Player opponent) {
        if (opponent != null) {
            String hpStatus = hero.getName() + " - Health: " + hero.getHealth() + "\n" +
                    "Opponent: " + opponent.getName() + " - Health: " + opponent.getHealth() + "\n";
            battleStatusTextPane.setText(hpStatus);
        }

        if (hero.getHealth() <= 0) {
            JOptionPane.showMessageDialog(null, "You have been defeated!");
            hideBattleOptions();
            currentOpponent = null;
            System.exit(0);
        }
    }

    private void appendCombatLog(String combatLog) {
        String currentText = battleStatusTextPane.getText();
        battleStatusTextPane.setText(currentText + "\n" + combatLog);
    }

    private void updateHeroStatus(Hero hero) {
        String heroStatus = hero.getName() + " - Health: " + hero.getHealth() + " - Gold: " + hero.getCurrency();
        battleStatusTextPane.setText(heroStatus);
        updateTownCentreButton(hero);
    }

    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

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

    private void disableMovementButtons() {
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
    }

    private void enableMovementButtons() {
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        eastButton.setEnabled(true);
        westButton.setEnabled(true);
    }

    private void disableBattleButtons() {
        attackButton.setEnabled(false);
        retreatButton.setEnabled(false);
    }

    private void enableBattleButtons() {
        attackButton.setEnabled(true);
        retreatButton.setEnabled(true);
    }

    private void showTownCentreButton() {
        if (!centerPanel.isAncestorOf(townCentreButton)) {
            centerPanel.add(townCentreButton);
            centerPanel.revalidate();
            centerPanel.repaint();
        }
    }
}
