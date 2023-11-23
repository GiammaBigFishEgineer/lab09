package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private Controller controller = new Controller();

    public SimpleGUIWithFileChooser(){
        frame.setTitle("My GUI app");
        
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        JTextField field = new JTextField();
        field.setEditable(false);
        JButton browseButton = new JButton("Browse");
        northPanel.add(field,BorderLayout.CENTER);
        northPanel.add(browseButton,BorderLayout.LINE_END);

        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(frame);
            if(chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
                SimpleGUIWithFileChooser.this.controller.setFile(chooser.getSelectedFile().getPath());
                field.setText(SimpleGUIWithFileChooser.this.controller.getFile().getPath());
            }
            if(chooser.showSaveDialog(frame) == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(field, "Non è stato possibile salvare il file");
            }
        });

        canvas.add(northPanel, BorderLayout.NORTH);

        frame.setContentPane(canvas);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
