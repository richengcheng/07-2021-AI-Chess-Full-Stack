package ryde.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ryde.ai.SimpleLevelAI;
import ryde.ai.MinimaxAI;

public class MainPlayFrame extends JFrame implements ActionListener {

	private static JPanel chessBoardPanel;
	static JPanel contentPane;
	//private MesAndOperaJpanel mesAndOperaPanel;
	private JButton backButton,reStartButton;
	static PlayerInfoJpanel player1InfoJpanel,player2InfoJpanel;
	static MainPlayFrame frame;
	static boolean isSinglePlayer;
//	public static boolean isGameOver=false;
	
	private static boolean isEnemy;
	private int AIlevel,variantsNumber;

	MainPlayFrame mainPlayFrame;

	/**
	 * Create the frame.
	 */
	public MainPlayFrame(boolean isEnemy,boolean isSinglePlayer,int AIlevel,int variantsNumber) {

		super("shogi");
		this.isEnemy=isEnemy;
		this.isSinglePlayer=isSinglePlayer;
		this.AIlevel=AIlevel;
		this.variantsNumber=variantsNumber;
		contentPane = new JPanel();
		contentPane.setLayout(null);
	
		//chess board
		chessBoardPanel=new ChessBoardPanel(isEnemy,isSinglePlayer,variantsNumber);
		chessBoardPanel.setBounds(0, 50, 900, 1000);
		contentPane.add(chessBoardPanel);
		//timing


		player1InfoJpanel=new PlayerInfoJpanel(isEnemy,isEnemy);
		player2InfoJpanel=new PlayerInfoJpanel(!isEnemy,!isEnemy);
		player1InfoJpanel.setBounds(100, 0, 250, 50);
		player2InfoJpanel.setBounds(350, 0, 250, 50);
	 	contentPane.add(player1InfoJpanel);
		contentPane.add(player2InfoJpanel);

		new Thread(player1InfoJpanel).start();
		new Thread(player2InfoJpanel).start();

		
		backButton=new JButton("Restart Game");
		reStartButton=new JButton("Restart Game");
		backButton.setBounds(0, 640, 950, 30);
		reStartButton.setBounds(0, 670, 950, 30);
		backButton.addActionListener(this);
		contentPane.add(backButton);
		//contentPane.add(reStartButton);
		
		setContentPane(contentPane);
		setSize(950, 700);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		if (AIlevel==0) {
			SimpleLevelAI middleLevelAI=new SimpleLevelAI();
			Thread thread=new Thread(middleLevelAI);
			thread.start();
		}

		if (AIlevel==1) {
			MinimaxAI minimaxAI=new MinimaxAI();
			Thread thread=new Thread(minimaxAI);
			thread.start();
		}

	}
	/**
	 * game over and start new game
	 */
//	public static void newGame(){
//			contentPane.remove(chessBoardPanel);
//			ChessBoardPanel chessBoardPanel=new ChessBoardPanel(isEnemy,isSinglePlayer);
//			chessBoardPanel.setBounds(0, 50, 500, 500);
//			contentPane.add(chessBoardPanel);
//	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==reStartButton  ) {
			this.setVisible(false);
		//	System.exit(0);
		}else if((e.getSource() == backButton)){

			this.setVisible(false);
			mainPlayFrame=new MainPlayFrame(this.isEnemy,  this.isSinglePlayer,this.AIlevel,this.variantsNumber);

		}
	}
	
}
