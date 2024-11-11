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
    public void createGUI(Resident resident) {
        game = new Game(resident);

        JFrame frame = new JFrame("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JOptionPane.showMessageDialog(null, "Du vaknade upp i soffan av massa prassel från hallen!");

        JPanel panel = new JPanel(new BorderLayout());

        // Skapa riktningsknappar och ställ in större storlek och font
        northButton = new JButton("Hall");
        southButton = new JButton("Sovrum");
        eastButton = new JButton("Kontor");
        westButton = new JButton("Kök");

        Font buttonFont = new Font("Arial", Font.BOLD, 22); // Större font för knapparna
        Dimension buttonSize = new Dimension(200, 50); // Större dimensioner för knapparna

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

        attackButton = new JButton("Attackera");
        retreatButton = new JButton("Fly");


        attackButton.addActionListener(_ -> {
            if (currentOpponent != null) {
                disableBattleButtons();
                game.battleRound(resident, currentOpponent);
                updateBattleStatus(resident, currentOpponent);
                appendCombatLog(showCombatLog(resident, currentOpponent));

                if (currentOpponent != null && !currentOpponent.isConscious()) {
                    JOptionPane.showMessageDialog(null, currentOpponent.getRole() + " blev besegrad!");
                    updateResidentStatus(resident);
                    hideBattleOptions();
                    currentOpponent = null;
                    resident.setDefeatedEnemy(true);
                    southButton.setEnabled(true);
                } else if (resident.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(null, "Du förlorade striden");
                    updateResidentStatus(resident);
                    System.exit(0);
                }
                enableBattleButtons();
            }
        });

        retreatButton.addActionListener(_ -> {
            if (resident.checkForRetreat()) {
                JOptionPane.showMessageDialog(null, "Du lyckades fly!");
                resident.endBattle();
                hideBattleOptions();
                updateResidentStatus(resident);
                southButton.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Du lyckades inte fly!\n" + currentOpponent.getClass().getSimpleName() + " attackerade dig!");
                game.battleRound(currentOpponent);
                updateBattleStatus(resident, currentOpponent);
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

        northButton.addActionListener(_ -> updatePosition(resident, 0, 1));
        southButton.addActionListener(_ -> updatePosition(resident, 0, -1));
        eastButton.addActionListener(_ -> updatePosition(resident, 1, 0));
        westButton.addActionListener(_ -> updatePosition(resident, -1, 0));

        updateResidentStatus(resident);
    }


    private void updatePosition(Resident resident, int x, int y) {
        resident.moveResident(x, y);
        positionTextPane.setText(game.updateRoom());

        switch (game.updateRoom()) {
            case "Köket" -> enterKitchen(resident);
            case "Hallen" -> enterHallway(resident);
            case "Kontor" -> enterOffice(resident);
            case "Sovrum" -> enterBedroom(resident);
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


    private void updateBattleStatus(Resident resident, Entity opponent) {
        if (opponent != null) {
            String hpStatus = resident.getRole() + ": " + resident.getHealth() + " hp\n" +
                    opponent.getRole() + ": " + opponent.getHealth() + " hp\n";
            battleStatusTextPane.setText(hpStatus);
        }

        if (!resident.isConscious()) {
            JOptionPane.showMessageDialog(null, "Du har blivit besegrad!");
            hideBattleOptions();
            currentOpponent = null;
            System.exit(0);
        }
    }

    private void appendCombatLog(String combatLog) {
        String currentText = battleStatusTextPane.getText();
        battleStatusTextPane.setText(currentText + "\n" + combatLog);
    }

    private void updateResidentStatus(Resident resident) {
        String residentStatus = resident.getRole() + ": " + resident.getHealth() + " hp";
        battleStatusTextPane.setText(residentStatus);
    }

    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    private String showCombatLog(Entity resident, Entity opponent) {
        if (!resident.isConscious() || !opponent.isConscious()) {
            return "";
        } else {
            return resident.getRole() + " attackerar " + opponent.getRole() +
                    " med " + resident.getDamage() + " skada ⚔️\n" +
                    opponent.getRole() + " attackerar " + resident.getRole() +
                    " med " + opponent.getDamage() + " skada ⚔️";
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


    private void enterKitchen(Resident resident) {
        eastButton.setText("Vardagsrum");
        disableMovementButtons();
        eastButton.setEnabled(true);

        if (!resident.isFoundFryingPan()) {
            int answer = JOptionPane.showConfirmDialog(null, "Vill du plocka upp en stekpanna?", "Val", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                resident.setDamage(resident.getDamage() + 3);
                resident.setFoundFryingPan(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Köket är tomt!");
        }
    }

    // In enterHallway method (add this check at the beginning of the method)
    private void enterHallway(Resident resident) {
        southButton.setText("Vardagsrum");
        disableMovementButtons();

        // Om tjuven är besegrad, aktivera southButton direkt
        if (resident.isDefeatedEnemy()) {
            JOptionPane.showMessageDialog(null, "Du borde ringa polisen!");
            southButton.setEnabled(true);
            return;
        }

        // Resterande logik om tjuven inte är besegrad
        int answer = JOptionPane.showConfirmDialog(null, "Du hittade en inbrottstjuv i hallen!\nVågar du slåss?", "Val", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            if (!game.foundFryingPan()) {
                answer = JOptionPane.showConfirmDialog(null, "Du är trött!\nVill du leta efter ett hjälpmedel i köket!", "Val", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.NO_OPTION) {
                    battleBurglar(resident);
                } else {
                    southButton.setEnabled(true);
                }
            } else {
                battleBurglar(resident);
                if (resident.isDefeatedEnemy()) {
                    southButton.setEnabled(true);
                }
            }
        } else {
            southButton.setEnabled(true);
        }
    }

    private void enterOffice(Resident resident) {
        westButton.setText("Vardagsrum");
        disableMovementButtons();

        if (resident.isDefeatedEnemy()) {
            int answer = JOptionPane.showConfirmDialog(null, "Vill du ringa polisen?", "Val", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Du ringde polisen!\nSpelet avslutas...");
                System.exit(0);
            } else {
                westButton.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kontoret är låst!");
        }
    }

    private void enterLivingRoom() {
        enableMovementButtons();
        northButton.setText("Hall");
        southButton.setText("Sovrum");
        eastButton.setText("Kontor");
        westButton.setText("Kök");
    }

    private void enterBedroom(Resident resident) {
        disableMovementButtons();
        northButton.setEnabled(true);
        northButton.setText("Vardagsrum");

        int answer = JOptionPane.showConfirmDialog(null, "Vill du vila i sängen? ", "Val", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            if (resident.getHealth() < 12) {
                JOptionPane.showMessageDialog(null, "Du tog en liten tupplur!");

                resident.setHealth(resident.getHealth() + 3);
                if (resident.getHealth() > 12) {
                    resident.setHealth(12);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du måste förtjäna din sömn.");
            }
            updateResidentStatus(resident);
        }
    }

    private void battleBurglar(Resident resident) {
        currentOpponent = game.createOpponent();
        showBattleOptions();
        disableMovementButtons();
        updateBattleStatus(resident, currentOpponent);
    }

}
