package se.johan_hammerin.projektarbete.gui;

import se.johan_hammerin.projektarbete.logic.Game;
import se.johan_hammerin.projektarbete.model.*;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class GUI {
    private JTextPane battleStatusTextPane;
    private JPanel centerPanel;
    private JTextPane positionTextPane;
    // Knappar
    private JButton attackButton;
    private JButton retreatButton;
    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    // Attribut
    private Game game;
    private Entity currentOpponent;

    // Skapa GUI
    public void createGUI(Hero hero) {
        game = new Game(hero);

        JFrame frame = new JFrame("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new BorderLayout());

        // Skapa riktningsknappar och ställ in större storlek och font
        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");

        Font buttonFont = new Font("Arial", Font.BOLD, 20); // Större font för knapparna
        Dimension buttonSize = new Dimension(100, 50); // Större dimensioner för knapparna

        northButton.setFont(buttonFont);
        northButton.setPreferredSize(buttonSize);
        southButton.setFont(buttonFont);
        southButton.setPreferredSize(buttonSize);
        eastButton.setFont(buttonFont);
        eastButton.setPreferredSize(buttonSize);
        westButton.setFont(buttonFont);
        westButton.setPreferredSize(buttonSize);

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


        attackButton.addActionListener(_ -> {
            if (currentOpponent != null) {
                disableBattleButtons();
                game.battleRound(hero, currentOpponent);
                updateBattleStatus(hero, currentOpponent);
                appendCombatLog(showCombatLog(hero, currentOpponent));

                if (currentOpponent != null && currentOpponent.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, currentOpponent.getName() + " defeated!");
                    updateHeroStatus(hero);
                    hideBattleOptions();
                    currentOpponent = null;
                    hero.setDefeatedEnemy(true);
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
                JOptionPane.showMessageDialog(null, "Du lyckades fly!");
                hero.endBattle();
                hideBattleOptions();
                updateHeroStatus(hero);
            } else {
                JOptionPane.showMessageDialog(null, "Du lyckades inte fly!\n" + currentOpponent.getClass().getSimpleName() + " attackerade dig!");
                game.battleRound(currentOpponent);
                updateBattleStatus(hero, currentOpponent);
            }
        });


        // TextPane
        positionTextPane = new JTextPane();
        positionTextPane.setText(game.updateRoom());
        positionTextPane.setEditable(false);
        positionTextPane.setFont(new Font("Arial", Font.BOLD, 16));
        centerText(positionTextPane);
        centerPanel.add(positionTextPane);

        battleStatusTextPane = new JTextPane();
        battleStatusTextPane.setEditable(false);
        battleStatusTextPane.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(battleStatusTextPane);


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


    private void updatePosition(Hero hero, int north, int south, int east, int west) {
        hero.moveHero(north, south, east, west);
        positionTextPane.setText(game.updateRoom());

        switch (game.updateRoom()) {
            case "Köket" -> enterKitchen(hero);
            case "Hallen" -> enterHallway(hero);
            case "Kontor" -> enterOffice();
            case "Balkong" -> enterBalcony();
            case "Vardagsrum" -> enterLivingRoom();
            default -> System.out.println("Fel i updatePosition metoden");
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


    private void updateBattleStatus(Hero hero, Entity opponent) {
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
        String heroStatus = hero.getName() + " - Health: " + hero.getHealth();
        battleStatusTextPane.setText(heroStatus);
    }

    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    private String showCombatLog(Entity hero, Entity opponent) {
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


    private void enterKitchen(Hero hero) {
        disableMovementButtons();
        eastButton.setEnabled(true);

        if (!hero.isFoundFryingPan()) {
            int answer = JOptionPane.showConfirmDialog(null, "Vill du plocka upp en stekpanna?", "Val", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                hero.setDamage(hero.getDamage() + 3);
                hero.setFoundFryingPan(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Köket är tomt!");
        }
    }

    private void enterHallway(Hero hero) {
        disableMovementButtons();
        southButton.setEnabled(true);

        if(!hero.isDefeatedEnemy()) {
            int answer = JOptionPane.showConfirmDialog(null, "Du hittade en inbrottstjuv i hallen!\nVågar du slåss?", "Val", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION) {
                if (game.checkForBattle()) {
                    currentOpponent = game.createOpponent();
                    showBattleOptions();
                    disableMovementButtons();
                    updateBattleStatus(hero, currentOpponent);
                    disableMovementButtons();
                    southButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Leta efter ett hjälpmedel i köket!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Du borde ringa polisen!");
        }

    }

    private void enterOffice() {
        disableMovementButtons();
        westButton.setEnabled(true);
    }

    private void enterLivingRoom() {
        enableMovementButtons();
    }

    private void enterBalcony() {
        disableMovementButtons();
        northButton.setEnabled(true);
    }

}
