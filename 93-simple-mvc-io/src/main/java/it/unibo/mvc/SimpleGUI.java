package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private Controller controller = new Controller();

    public SimpleGUI(){
        frame.setTitle("My app");
        
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.NORTH);

        JButton button = new JButton("Save");
        canvas.add(button, BorderLayout.SOUTH);
        button.addActionListener(e -> {
            SimpleGUI.this.controller.saveStream(textArea.getText());
        });

        frame.setContentPane(canvas);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
