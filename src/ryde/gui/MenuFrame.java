package ryde.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class MenuFrame extends JFrame implements ActionListener {
    static MenuFrame menuFrame;
    static VariantsOptionFrame variantsOptionFrame;
    //****************************************
    JPanel contentPane;
    JButton playSingalButton, playDoubleButton, helpButton, exitButton, playSingalButton2;

    public MenuFrame() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        // adding button
        playSingalButton = new JButton("Play with Simple AI");
        playSingalButton2 = new JButton("Play with Middle AI");
        helpButton = new JButton("help");
        exitButton = new JButton("exit");
        addButton(playSingalButton, 150, 150, 150, 30);
        addButton(playSingalButton2, 150, 200, 150, 30);
        //	addButton(playDoubleButton,200, 200, 100, 30);
        addButton(helpButton, 150, 250, 150, 30);
        addButton(exitButton, 150, 300, 150, 30);
        setContentPane(contentPane);
        setSize(510, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        menuFrame = new MenuFrame();
    }

    public void addButton(JButton b, int x, int y, int width, int hight) {
        b.setBounds(x, y, width, hight);
        b.addActionListener(this);
        contentPane.add(b);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playSingalButton) {
            setVisible(false);
            variantsOptionFrame = new VariantsOptionFrame(false, true, 0);
            //ChessBoardPanel.coverPanel.setVisible(false);
        } else if (e.getSource() == playDoubleButton) {

            this.setVisible(false);

        } else if (e.getSource() == helpButton) {
            JOptionPane.showMessageDialog(contentPane, "nothing could help");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == playSingalButton2) {
            setVisible(false);
            variantsOptionFrame = new VariantsOptionFrame(false, true, 1);
        }
    }
}
