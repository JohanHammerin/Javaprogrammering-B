package se.johan_hammerin.lambda;

import javax.swing.*;

public class MyFrame extends JFrame {
    JButton myButton = new JButton("My Button");
    JButton myButton2 = new JButton("My Button 2");

    MyFrame() {
        //myButton
        myButton.setBounds(100, 50, 200, 100);
        myButton.addActionListener(_ -> System.out.println("Du klickade på den första knappen!"));

        //myButton2
        myButton2.setBounds(100, 150, 200, 100);
        myButton2.addActionListener(_ -> System.out.println("Du klickade på den andra knappen"));


        this.add(myButton);
        this.add(myButton2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);
    }
}
