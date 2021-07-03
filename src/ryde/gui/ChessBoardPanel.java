package ryde.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ryde.InternetChess.Chess;
import ryde.InternetChess.Lion;
import ryde.InternetChess.Cat;
import ryde.InternetChess.Dog;
import ryde.InternetChess.Chick;


/**
 * 8*8棋盘按钮
 * @author Ryde_L
 *
 */
public class ChessBoardPanel extends JPanel implements ActionListener{
	private ImageIcon myChickIcon,myCatIcon,myDogIcon,myLionIcon;
	private ImageIcon AIChickIcon,AICatIcon,AIDogIcon,AILionIcon;
	private ChessBoard presentChessBoard=null;
	private JLabel chessboardLabel;
	static JTextArea coverPanel;
	private static Chess myKing;
	private static Chess enemyKing;
	public static boolean isSinglePlayer,isPlayerTurn;
	public static  ChessBoard [][]  chessboard;
	public static List<Chess> UpPlayerCapturedChessList=new ArrayList<Chess>();
	public static List<Chess> DownPlayerCapturedChessList=new ArrayList<Chess>();


	public ChessBoardPanel(boolean isEnemy,boolean isSinglePlayer){
	//	UpPlayerCapturedChessList.add(null);
	//	DownPlayerCapturedChessList.add(null);


		setLayout(null);
		//棋盘按钮 
		chessboard=new ChessBoard[6][11];
		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 3; j++) {
				chessboard[i][j] = new ChessBoard(i,j,1);
				chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);
				chessboard[i][j].addActionListener(this);
				add(chessboard[i][j]);
			}
			for (int j = 3; j < 8; j++) {
				chessboard[i][j] = new ChessBoard(i,j,0);
				chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);
				chessboard[i][j].addActionListener(this);
				add(chessboard[i][j]);
			}
			for (int j = 8; j < 11; j++) {
				chessboard[i][j] = new ChessBoard(i,j,2);
				chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);
				chessboard[i][j].addActionListener(this);
				add(chessboard[i][j]);
			}
		}		
		presentChessBoard=chessboard[3][5];
		initAllChesses(isEnemy);
		chessboardLabel=new JLabel(new ImageIcon("images/shogiBoard.jpg"));
		chessboardLabel.setBounds(160, -10, 350, 400);
		add(chessboardLabel);


		/**
		coverPanel=new JTextArea();
		coverPanel.setBounds(0, 0, 350, 450);
		coverPanel.setOpaque(false);
		coverPanel.setEditable(false);
		coverPanel.setVisible(true);
		add(coverPanel);
		setComponentZOrder(coverPanel, 0);//设置遮罩在最上0
		 */
	}


	public void initAllChesses(boolean isEnemy){


		 myChickIcon=new ImageIcon("images/chickenDown.png");
		myCatIcon=new ImageIcon("images/catDown.png");
		myDogIcon=new ImageIcon("images/dogDown.png");
		myLionIcon=new ImageIcon("images/lionDown.png");
		 AIChickIcon=new ImageIcon("images/chickenUp.png");
		 AICatIcon=new ImageIcon("images/catUp.png");
		AIDogIcon=new ImageIcon("images/dogUp.png");
		AILionIcon=new ImageIcon("images/lionUp.png");

		/////////////////////////////////////////////p2
		Cat cat1=new Cat( 0,3,!isEnemy);
		chessboard[0][3].setIcon(AICatIcon);
		chessboard[0][3].setChess(cat1);

		Dog dog=new Dog( 0,4,!isEnemy);
		chessboard[0][4].setIcon(AIDogIcon);
		chessboard[0][4].setChess(dog);
		
		Lion lion=new Lion( 0,5,!isEnemy);
		chessboard[0][5].setIcon(AILionIcon);
		chessboard[0][5].setChess(lion);

		Dog dog2=new Dog( 0,6,!isEnemy);
		chessboard[0][6].setIcon(AIDogIcon);
		chessboard[0][6].setChess(dog2);

		Cat cat2=new Cat( 0,7,!isEnemy);
		chessboard[0][7].setIcon(AICatIcon);
		chessboard[0][7].setChess(cat2);

		Chick chick1 =new Chick( 2,4,!isEnemy);
		chessboard[2][4].setIcon(AIChickIcon);
		chessboard[2][4].setChess(chick1);

		Chick chick2 =new Chick( 2,5,!isEnemy);
		chessboard[2][5].setIcon(AIChickIcon);
		chessboard[2][5].setChess(chick2);

		Chick chick3 =new Chick( 2,6,!isEnemy);
		chessboard[2][6].setIcon(AIChickIcon);
		chessboard[2][6].setChess(chick3);



		////////////////////////////////////////////p1
		Cat cat3=new Cat( 5,3,isEnemy);
		chessboard[5][3].setIcon(myCatIcon);
		chessboard[5][3].setChess(cat3);

		Dog dog3=new Dog( 5,4,isEnemy);
		chessboard[5][4].setIcon(myDogIcon);
		chessboard[5][4].setChess(dog3);

		Lion lion2=new Lion( 5,5,isEnemy);
		chessboard[5][5].setIcon(myLionIcon);
		chessboard[5][5].setChess(lion2);

		Dog dog4=new Dog( 5,6,isEnemy);
		chessboard[5][6].setIcon(myDogIcon);
		chessboard[5][6].setChess(dog4);


		Cat cat4=new Cat( 5,7,isEnemy);
		chessboard[5][7].setIcon(myCatIcon);
		chessboard[5][7].setChess(cat4);

		Chick chick4 =new Chick( 3,4,isEnemy);

		chessboard[3][4].setIcon(myChickIcon);
		chessboard[3][4].setChess(chick4);

		Chick chick5 =new Chick( 3,5,isEnemy);

		chessboard[3][5].setIcon(myChickIcon);
		chessboard[3][5].setChess(chick5);

		Chick chick6 =new Chick( 3,6,isEnemy);

		chessboard[3][6].setIcon(myChickIcon);
		chessboard[3][6].setChess(chick6);



		if (isEnemy) {
			myKing=lion2;
			enemyKing=lion;
		}else {
			myKing=lion;
			enemyKing=lion2;
		}
		
 	}
	
	public static void moveChess(ChessBoard presentChessBoard, ChessBoard clickBoard) {


		if (clickBoard.getChess()!=null) {//吃到棋子,从棋子List中移除
			Chess chessExange= clickBoard.getChess();
			//change the chess enemy state
			chessExange.setEnemy(!chessExange.isEnemy());
			if (clickBoard.getChess().isEnemy()) {
				UpPlayerCapturedChessList.add(chessExange);

			}else {
				DownPlayerCapturedChessList.add(chessExange);

			}
			System.out.println("single eat enemy :CBPanel moveChess");
		}

		//update the chess
		Chess chess=presentChessBoard.getChess();
		Chess chess2=clickBoard.getChess();
		chess.setCoor(clickBoard);//更新坐标
		chess.setStep(chess.getStep()+1);
		Icon icon=presentChessBoard.getIcon();
		presentChessBoard.setChess(null);//棋子移动
		presentChessBoard.setIcon(null);//去除图案
		presentChessBoard = clickBoard;// 当前位置更新
		presentChessBoard.setChess(chess);//棋子移动
		presentChessBoard.setIcon(icon);//更新棋子图案
		isGameOver(chess2);
	}

	/**
	 * 接受服务端发来的对方棋子的移动
	 * @param present
	 * @param click
	 */
/**
	public static void acceptFromServerAndMoveChess(ChessBoard present, ChessBoard click) {

		System.out.println("44444444444444444444444444444444444444");
		ChessBoard presentChessBoard=chessboard[present.getCoorY()][present.getCoorX()];
		ChessBoard clickBoard=chessboard[click.getCoorY()][click.getCoorX()];
		Chess chess=presentChessBoard.getChess();
		Chess chess2=click.getChess();
		if (chess.getName().equals("pawn")&&chess.getStep()==0
				&&Math.abs(present.getCoorY()-click.getCoorY())==2){
			//兵
			//((Pawn) chess).setFirstStep(2);
		}
		chess.setCoor(clickBoard);//更新坐标
		chess.setStep(chess.getStep()+1);
		Icon icon=presentChessBoard.getIcon();
		presentChessBoard.setChess(null);//棋子移动
		presentChessBoard.setIcon(null);//去除图案
		presentChessBoard = clickBoard;// 当前位置更新
		presentChessBoard.setChess(chess);//棋子移动
		presentChessBoard.setIcon(icon);//更新棋子图案
	
		if (chess2 != null) {
			if (chess2.getCoorY() == myKing.getCoorY() && chess2.getCoorX() == myKing.getCoorX()) {
				System.out.println("我方获胜");
				JOptionPane.showMessageDialog(null, "我方获胜");
//				MainPlayFrame.newGame();
				System.exit(0);
			} else if (chess2.getCoorY() == enemyKing.getCoorY() && chess2.getCoorX() == enemyKing.getCoorX()) {
				JOptionPane.showMessageDialog(null, "敌方获胜");
				System.exit(0);
//				MainPlayFrame.newGame();
			}
		}
		
		//我的计时开始，未考虑特殊走法
		turnToMyTrun(!isPlayerTurn);
	}
 */
	/**
	 * 
	 */
	public static void isGameOver(Chess chess){
		if (chess==myKing) {
			JOptionPane.showMessageDialog(null, "we win");
			System.exit(0);
//			MainPlayFrame.newGame();
		}else if (chess==enemyKing) {
			JOptionPane.showMessageDialog(null, "we lose");
			System.exit(0);
//			MainPlayFrame.newGame();
		}
	}

	/**
	 * 转到我的回合
	 * @param isEnable true可点击，false不可
	 */
	public static void turnToMyTrun(boolean isEnable) {
		//System.out.println("2222222222222222222222222222222222222222222");
		MainPlayFrame.player1InfoJpanel.setMyTurn(isEnable);
		MainPlayFrame.player2InfoJpanel.setMyTurn(!isEnable);
	//	ChessBoardPanel.coverPanel.setVisible(!isEnable);
		isPlayerTurn = isEnable;
	}
	
	/**
	 * 点击棋盘
	 */

	public void actionPerformed(ActionEvent e) {
   //  System.out.println("3233333333333333333333333333333333333333");
		ChessBoard clickBoard=(ChessBoard) e.getSource();//当前所点击的位置
		System.out.println(clickBoard);
		System.out.println(((ChessBoard) e.getSource()).getCoorX());
		System.out.println(((ChessBoard) e.getSource()).getCoorY());
		//System.out.println(presentChessBoard.getChess().getName());
		//若当前有已选的棋盘位置


		// checking if it is for down player
		if(MainPlayFrame.player1InfoJpanel.getMyTurn()) {

			//checking the click area
			if (presentChessBoard != null && presentChessBoard.getChess() != null) {
				//checking is the chess at the main play area
				//0 is main play area
				//1 is up players waiting board
				//2 is down players waiting board
				if(presentChessBoard.getIsWaitingBorad()==0 ) {
					//must at the main board
					if( clickBoard.getIsWaitingBorad()==0 ){
						System.out.println("566666666666666666666666666666");
						if (clickBoard != presentChessBoard) {
						 //这里可以有一个判断类型,是否是已经死过的棋子
						 //而且还要先判断这个棋子是不是真dead棋盘上先，因为不能跟main棋盘混合，不然不好判断，所以多写一个判断程序判断一下，可以写在这里
						 //写这里 稍微改变下格式
						  boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
						  //点击位置可以前进
						   if (walkable) {
							   System.out.println("7777777777777777777777733333333333333333333");
							  moveChess(presentChessBoard, clickBoard);
							  //我的回合结束，停止计时
							  turnToMyTrun(!isPlayerTurn);
						   } else if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
							  System.out.println("2233333333333333333333333333333333333333");
							  presentChessBoard = clickBoard;// 更换操作棋子
							  System.out.println("change the operated chess");
						   } else if (presentChessBoard.getChess() != null && presentChessBoard.getChess().isHasSpecialWalkWay()) {
						   	presentChessBoard.getChess().specialWalkWay(presentChessBoard, clickBoard, chessboard);
							  System.out.println("special move");
						} else {
							System.out.println("can not move");
						}
					  }
					}else {
						System.out.println("can not move");
					}


				}
				// if the current Chess board is at up players waiting chess board
				// and must click at main play area
				else if(presentChessBoard.getIsWaitingBorad()==1 && clickBoard.getIsWaitingBorad()==0 ){
					System.out.println("544444444444444444444444444444444444");
					// there need to check more
					moveChess(presentChessBoard, clickBoard);
				}
			} else {// get a new presentChessBoard from the main board area or the option chess area
				if (clickBoard.getChess() != null && (!clickBoard.getChess().isEnemy())||clickBoard.getIsWaitingBorad()==2) {
					presentChessBoard = clickBoard;// 当前操作位置更新
				}
			}
			updateCapturedChessList();
			return;
		}

		// for up player
		if(!MainPlayFrame.player1InfoJpanel.getMyTurn()) {
			//System.out.println("544444444444444444444444444444444444");
			if (presentChessBoard != null && presentChessBoard.getChess() != null) {//原来的棋盘点上不为空
			//	System.out.println("566666666666666666666666666666");
				if (clickBoard != presentChessBoard) {
					//所以要去down player
					boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
				//	System.out.println("2233333333333333333333333333333333333333");
					//点击位置可以前进
					if (walkable) {
						moveChess(presentChessBoard, clickBoard);
						//我的回合结束，停止计时
						turnToMyTrun(!isPlayerTurn);
					} else if (clickBoard.getChess() != null && clickBoard.getChess().isEnemy()) {
						presentChessBoard = clickBoard;// 更换操作棋子
						System.out.println("change the operated chess");
					} else if (presentChessBoard.getChess() != null && presentChessBoard.getChess().isHasSpecialWalkWay()) {
						presentChessBoard.getChess().specialWalkWay(presentChessBoard, clickBoard, chessboard);
						System.out.println("special move");
					} else {
						System.out.println("can not move");
					}
				}
			} else {//过后尝试和前面的合并
				//the chess must be the up players chess
				if (clickBoard.getChess() != null && clickBoard.getChess().isEnemy()) {
					presentChessBoard = clickBoard;// 当前操作位置更新
				}
			}
			updateCapturedChessList();
			return;
		}


		
		//王被将军
	}

	public  void updateCapturedChessList(){
		//becasue the k=0 is null

		System.out.println("UpPlayerCapturedChessList"+UpPlayerCapturedChessList.size());
		System.out.println("DownPlayerCapturedChessList"+DownPlayerCapturedChessList.size());

		Icon icon=presentChessBoard.getIcon();
		int k=0;


			  for (int i = 0; i < 6; i++) {
				  for (int j = 0; j < 3; j++) {
					  if ( k<UpPlayerCapturedChessList.size()&& UpPlayerCapturedChessList.get(k) != null ) {
						chessboard[i][j].setChess(UpPlayerCapturedChessList.get(k));
						chessboard[i][j].setIcon(getChessImage(UpPlayerCapturedChessList.get(k)));
						k++;
					}
				 }
			 }
	     k=0;


			   for (int i = 5; i > 2; i--) {
				  for (int j = 10; j > 7; j--) {
					  if ( k<DownPlayerCapturedChessList.size()&& DownPlayerCapturedChessList.get(k) != null ) {
						chessboard[i][j].setChess(DownPlayerCapturedChessList.get(k));
						chessboard[i][j].setIcon(getChessImage(DownPlayerCapturedChessList.get(k)));
						k++;
				  }

			}
		}

	};

	//get image Icon for waiting chess
	public ImageIcon getChessImage(Chess chess){

		if(chess.getName()=="Dog"){
			if(chess.isEnemy()){
				return AIDogIcon;
			}else {
				return myDogIcon;
			}
		}

		if(chess.getName()=="Cat"){
			if(chess.isEnemy()){
				return AICatIcon;
			}else {
				return myCatIcon;
			}
		}

		if(chess.getName()=="Lion"){
			if(chess.isEnemy()){
				return AILionIcon;
			}else {
				return myLionIcon;
			}
		}

		if(chess.getName()=="Chick"){
			if(chess.isEnemy()){
				return AIChickIcon;
			}else {
				return myChickIcon;
			}
		}
           // this is useless return
        return myLionIcon ;

	}

	public static void killChess(ChessBoard killedChessBoard) {
		chessboard[killedChessBoard.getCoorY()][killedChessBoard.getCoorX()].setIcon(null);
		chessboard[killedChessBoard.getCoorY()][killedChessBoard.getCoorX()].setChess(null);
	}

	public static boolean isPlayerTurn() {
		return isPlayerTurn;
	}

	public static void setPlayerTurn(boolean isPlayerTurn) {
		ChessBoardPanel.isPlayerTurn = isPlayerTurn;
	}

}
