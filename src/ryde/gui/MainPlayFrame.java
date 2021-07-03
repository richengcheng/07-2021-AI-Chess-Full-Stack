package ryde.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import  ryde.ai.AI;


public class MainPlayFrame extends JFrame implements ActionListener {

	private static JPanel chessBoardPanel;
	static JPanel contentPane;
	//private MesAndOperaJpanel mesAndOperaPanel;
	private JButton backButton;
	static PlayerInfoJpanel player1InfoJpanel,player2InfoJpanel;
	static MainPlayFrame frame;
	static boolean isSinglePlayer;
//	public static boolean isGameOver=false;
	
	private static boolean isEnemy;

	/**
	 * Create the frame.
	 */
	public MainPlayFrame(boolean isEnemy,boolean isSinglePlayer) {

		super("shogi");
		this.isEnemy=isEnemy;
		contentPane = new JPanel();
		contentPane.setLayout(null);
	
		//chess board
		chessBoardPanel=new ChessBoardPanel(isEnemy,isSinglePlayer);
		chessBoardPanel.setBounds(0, 50, 500, 500);
		contentPane.add(chessBoardPanel);
		//timing


		player1InfoJpanel=new PlayerInfoJpanel(isEnemy,isEnemy);
		player2InfoJpanel=new PlayerInfoJpanel(!isEnemy,!isEnemy);
		player1InfoJpanel.setBounds(0, 0, 250, 50);
		player2InfoJpanel.setBounds(250, 0, 250, 50);
	 	contentPane.add(player1InfoJpanel);
		contentPane.add(player2InfoJpanel);

		new Thread(player1InfoJpanel).start();
		new Thread(player2InfoJpanel).start();

		
		backButton=new JButton("Exit");
		backButton.setBounds(0, 555, 500, 30);
		backButton.addActionListener(this);
		contentPane.add(backButton);
		
		setContentPane(contentPane);
		setSize(510, 620);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
}
