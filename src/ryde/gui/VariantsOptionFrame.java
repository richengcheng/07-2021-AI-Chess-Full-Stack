package ryde.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VariantsOptionFrame extends JFrame implements ActionListener  {

    private boolean isEnemy;
    private boolean isSinglePlayer;
    private int AIlevel;
    MainPlayFrame mainPlayFrame;
    JButton fiveTimesSix,threeTimesFour,fiveTimesFive;
    JPanel contentPane;



    public VariantsOptionFrame(boolean isEnemy,boolean isSinglePlayer,int AIlevel){


    this.AIlevel=AIlevel;
    this.isEnemy=isEnemy;
    this.isSinglePlayer=isSinglePlayer;
    this.contentPane = new JPanel();
    this.contentPane.setLayout(null);

    fiveTimesSix=new JButton("Play fiveTimesSix board");
    threeTimesFour=new JButton("Play Dobutsu shogi");
    fiveTimesFive=new JButton("Play Minishogi");
    addButton(fiveTimesSix,130, 150, 190, 30);
    addButton(threeTimesFour,150, 200, 150, 30);
    addButton(fiveTimesFive,150, 250, 150, 30);

    setContentPane(contentPane);
    setSize(510, 620);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

    }


    public void addButton(JButton b,int x,int y,int width,int hight){
        b.setBounds(x, y, width, hight);
        b.addActionListener(this);
        contentPane.add(b);
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fiveTimesSix) {
            this.setVisible(false);
            mainPlayFrame = new MainPlayFrame(this.isEnemy, this.isSinglePlayer,this.AIlevel,0);
            //ChessBoardPanel.coverPanel.setVisible(false);
        } else if (e.getSource() == threeTimesFour) {

            mainPlayFrame = new MainPlayFrame(this.isEnemy, this.isSinglePlayer,this.AIlevel,1);

            this.setVisible(false);

        }
        else if(e.getSource() == fiveTimesFive){
            this.setVisible(false);
            mainPlayFrame = new MainPlayFrame(this.isEnemy,  this.isSinglePlayer,this.AIlevel,2);
        }

    }

}
