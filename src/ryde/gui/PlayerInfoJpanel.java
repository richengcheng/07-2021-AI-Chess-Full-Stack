package ryde.gui;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 *
 *
 */
public class PlayerInfoJpanel extends JPanel implements Runnable{
	private int time=0;
	private  boolean isMyTurn;
	private  boolean isEnemyChekcing;
	private JLabel headPictureLabel,backgroundLabel;
	private JLabel[] LabelOfClock;
	private ImageIcon TheheadIcon;
	private ImageIcon[] clockImage;
	private static boolean isNameUsed=false;
	public PlayerInfoJpanel(boolean isEnemy,boolean isEnemyChekcing){
		this.isEnemyChekcing=isEnemyChekcing;
		//super();
		TheheadIcon=new ImageIcon("images/default1.jpg");
		clockImage=new ImageIcon[10];
		for (int i = 0; i < clockImage.length; i++) {
			clockImage[i]=new ImageIcon("images/"+i+".png");
		}
		this.setLayout(null);
		headPictureLabel =new JLabel();
		headPictureLabel.setIcon(TheheadIcon);
		headPictureLabel.setBounds(0, 0, 50, 50);
		//headPicLabel.setSize(50, 50);
		String name="human beings";
		if (isNameUsed) {
			name="AI";
		}
		isNameUsed=true;
		backgroundLabel=new JLabel(name);
		backgroundLabel.setBounds(50, 0, 50, 50);
		backgroundLabel.setBackground(new Color(0,0,0));
		this.add(headPictureLabel);
		this.add(backgroundLabel);
		LabelOfClock=new JLabel[4];
		for(int i=0;i<4;i++){
			LabelOfClock[i]=new JLabel();
			LabelOfClock[i].setIcon(clockImage[0]);
			LabelOfClock[i].setBounds(100+i*25, 0, 25, 50);
			this.add(LabelOfClock[i]);
		}
		
		this.setSize(200, 50);
		this.setVisible(true);
		isMyTurn=!isEnemy;
	}

	public boolean getisEnemyChekcingy(){
		return  this.isEnemyChekcing;
	}
	//count timing
	public void run() {
		while (true) {
			if (isMyTurn) {
				int sec1 = time % 60 % 10;
				int sec2 = time % 60 / 10;
				int min1 = time / 60 % 60 % 10;
				int min2 = time / 60 % 60 / 10;
				LabelOfClock[3].setIcon(clockImage[sec1]);
				LabelOfClock[2].setIcon(clockImage[sec2]);
				LabelOfClock[1].setIcon(clockImage[min1]);
				LabelOfClock[0].setIcon(clockImage[min2]);
				time++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	


	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
		
	}
	public boolean getMyTurn() {
		return this.isMyTurn ;

	}


}
