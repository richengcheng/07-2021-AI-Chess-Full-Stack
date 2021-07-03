package ryde.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import ryde.battle.ChessInfo;

/**
 * 8*8棋盘按钮
 * @author Ryde_L
 *
 */
public class ChessBoardPanel extends JPanel implements ActionListener{
	private ImageIcon myPawnIcon,myKingIcon,myRookIcon,myBishopIcon,myQueenIcon,myKnigthIcon;
	private ImageIcon p2PawnIcon,p2KingIcon,p2RookIcon,p2BishopIcon,p2QueenIcon,p2KnigthIcon;
	private ChessBoard presentChessBoard=null;
	private JLabel chessboardLabel;
	static JTextArea coverPanel;
	private ChessInfo chessInfo=null;
	private static Chess myKing;
	private static Chess enemyKing;
	public static boolean isSinglePlayer,isPlayerTurn;
	public static  ChessBoard [][]  chessboard;

	public ChessBoardPanel(boolean isEnemy,boolean isSinglePlayer){
		this.isSinglePlayer=isSinglePlayer;
		isPlayerTurn=!isEnemy;
		if (isSinglePlayer) {
			ChessInfo chessInfo=new ChessInfo();
		}
		setLayout(null);
		//棋盘按钮 
		chessboard=new ChessBoard[6][5];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				chessboard[i][j] = new ChessBoard(i,j);
				chessboard[i][j].setBounds(j * 53+40, i * 53+35, 54, 54);
				chessboard[i][j].addActionListener(this);
				add(chessboard[i][j]);

			}
		}		
		presentChessBoard=chessboard[2][0];
		initAllChesses(isEnemy);
		chessboardLabel=new JLabel(new ImageIcon("images/shogiBoard.jpg"));
		chessboardLabel.setBounds(0, 0, 350, 400);
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



		/////////////////////////////////////////////p2
		Cat cat1=new Cat( 0,0,!isEnemy);
		ChessInfo.AIChessListAdd(cat1);
		chessboard[0][0].setIcon(new ImageIcon("images/catUp.png"));
		chessboard[0][0].setChess(cat1);

		Dog dog=new Dog( 0,1,!isEnemy);
		ChessInfo.AIChessListAdd(dog);
		chessboard[0][1].setIcon(new ImageIcon("images/dogUp.png"));
		chessboard[0][1].setChess(dog);
		
		Lion lion=new Lion( 0,2,!isEnemy);
		ChessInfo.AIChessListAdd(lion);
		chessboard[0][2].setIcon(new ImageIcon("images/lionUp.png"));
		chessboard[0][2].setChess(lion);

		Dog dog2=new Dog( 0,3,!isEnemy);
		ChessInfo.AIChessListAdd(dog2);
		chessboard[0][3].setIcon(new ImageIcon("images/dogUp.png"));
		chessboard[0][3].setChess(dog2);

		Cat cat2=new Cat( 0,4,!isEnemy);
		ChessInfo.AIChessListAdd(cat2);
		chessboard[0][4].setIcon(new ImageIcon("images/catUp.png"));
		chessboard[0][4].setChess(cat2);

		Chick chick1 =new Chick( 2,1,!isEnemy);
		ChessInfo.AIChessListAdd(chick1);
		chessboard[2][1].setIcon(new ImageIcon("images/chickenUp.png"));
		chessboard[2][1].setChess(chick1);

		Chick chick2 =new Chick( 2,2,!isEnemy);
		ChessInfo.AIChessListAdd(chick2);
		chessboard[2][2].setIcon(new ImageIcon("images/chickenUp.png"));
		chessboard[2][2].setChess(chick2);

		Chick chick3 =new Chick( 2,3,!isEnemy);
		ChessInfo.AIChessListAdd(chick3);
		chessboard[2][3].setIcon(new ImageIcon("images/chickenUp.png"));
		chessboard[2][3].setChess(chick3);



		////////////////////////////////////////////p1
		Cat cat3=new Cat( 5,0,isEnemy);
		ChessInfo.playerChessList.add(cat3);
		chessboard[5][0].setIcon(new ImageIcon("images/catDown.png"));
		chessboard[5][0].setChess(cat3);

		Dog dog3=new Dog( 5,1,isEnemy);
		ChessInfo.AIChessListAdd(dog3);
		chessboard[5][1].setIcon(new ImageIcon("images/dogDown.png"));
		chessboard[5][1].setChess(dog3);

		Lion lion2=new Lion( 5,2,isEnemy);
		ChessInfo.AIChessListAdd(lion2);
		chessboard[5][2].setIcon(new ImageIcon("images/lionDown.png"));
		chessboard[5][2].setChess(lion2);

		Dog dog4=new Dog( 5,3,isEnemy);
		ChessInfo.AIChessListAdd(dog4);
		chessboard[5][3].setIcon(new ImageIcon("images/dogDown.png"));
		chessboard[5][3].setChess(dog4);


		Cat cat4=new Cat( 5,4,isEnemy);
		ChessInfo.playerChessList.add(cat4);
		chessboard[5][4].setIcon(new ImageIcon("images/catDown.png"));
		chessboard[5][4].setChess(cat4);

		Chick chick4 =new Chick( 3,1,isEnemy);
		ChessInfo.AIChessListAdd(chick4);
		chessboard[3][1].setIcon(new ImageIcon("images/chickenDown.png"));
		chessboard[3][1].setChess(chick4);

		Chick chick5 =new Chick( 3,2,isEnemy);
		ChessInfo.AIChessListAdd(chick5);
		chessboard[3][2].setIcon(new ImageIcon("images/chickenDown.png"));
		chessboard[3][2].setChess(chick5);

		Chick chick6 =new Chick( 3,3,isEnemy);
		ChessInfo.AIChessListAdd(chick6);
		chessboard[3][3].setIcon(new ImageIcon("images/chickenDown.png"));
		chessboard[3][3].setChess(chick6);



		if (isEnemy) {
			myKing=lion2;
			enemyKing=lion;
		}else {
			myKing=lion;
			enemyKing=lion2;
		}
		
 	}
	
	public static void moveChess(ChessBoard presentChessBoard, ChessBoard clickBoard) {
	//	System.out.println("1111111111111111111111111111111111111111111");

		if (clickBoard.getChess()!=null) {//吃到棋子,从棋子List中移除
			if (clickBoard.getChess().isEnemy()) {
				ChessInfo.AIChessListRemove(clickBoard.getChess());
			}else {
				ChessInfo.playerChessListRemove(clickBoard.getChess());
			}
			System.out.println("single eat enemy :CBPanel moveChess");
		}

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
em.out.println("2222222222222222222222222222222222222222222");
		MainPlayFrame.player1InfoJpanel.setMyTurn(isEnable);
		MainPlayFrame.player2InfoJpanel.setMyTurn(!isEnable);
	//	ChessBoardPanel.coverPanel.setVisible(!isEnable);
		isPlayerTurn = isEnable;
	}

	public void actionPerformed(ActionEvent e) {
   //  System.out.println("3233333333333333333333333333333333333333");
		ChessBoard clickBoard=(ChessBoard) e.getSource();//当前所点击的位置
		System.out.println(clickBoard);
		System.out.println(((ChessBoard) e.getSource()).getCoorX());
		System.out.println(((ChessBoard) e.getSource()).getCoorY());
		//System.out.println(presentChessBoard.getChess().getName());
		//若当前有已选的棋盘位置
		// for down player
		if(MainPlayFrame.player1InfoJpanel.getMyTurn()) {
			if (presentChessBoard != null && presentChessBoard.getChess() != null) {
				if (clickBoard != presentChessBoard) {
					boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
					//点击位置可以前进
					if (walkable) {
						moveChess(presentChessBoard, clickBoard);
						//我的回合结束，停止计时
						turnToMyTrun(!isPlayerTurn);
					} else if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
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
				if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
					presentChessBoard = clickBoard;// 当前操作位置更新
				}
			}
			return;
		}

		// for up player
		if(!MainPlayFrame.player1InfoJpanel.getMyTurn()) {
			System.out.println("544444444444444444444444444444444444");
			if (presentChessBoard != null && presentChessBoard.getChess() != null) {
				System.out.println("566666666666666666666666666666");
				if (clickBoard != presentChessBoard) {

					boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
					System.out.println("2233333333333333333333333333333333333333");

					if (walkable) {
						moveChess(presentChessBoard, clickBoard);

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
			} else {
				if (clickBoard.getChess() != null && clickBoard.getChess().isEnemy()) {
					presentChessBoard = clickBoard;//
				}
			}
			return;
		}



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
