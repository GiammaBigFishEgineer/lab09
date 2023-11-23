package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private Controller controller = new SimpleController();

    public SimpleGUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField field = new JTextField("Scrivi una stringa");
        panel.add(field,BorderLayout.NORTH);
        
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton button1 = new JButton("Print");
        JButton button2 = new JButton("Show History");
        southPanel.add(button1);
        southPanel.add(button2);
        panel.add(southPanel,BorderLayout.SOUTH);
        frame.setContentPane(panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(e -> {
            SimpleGUI.this.controller.setString(field.getText());
            SimpleGUI.this.controller.printString();
        });
        
        button2.addActionListener(e -> {
            var list = SimpleGUI.this.controller.getPrintedStrings();
            textArea.setText(list.toString());
        });
    }

    private void display(){
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
