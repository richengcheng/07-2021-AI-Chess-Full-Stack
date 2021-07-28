package ryde.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import ryde.InternetChess.Elephant;
import ryde.InternetChess.Giraffe;
import ryde.battle.ChessInfo;


/**
 *
 *
 */
public class ChessBoardPanel extends JPanel implements ActionListener{
	//Locale.setDefault(new Locale("en","US"));
	private static ImageIcon myChickIcon,myCatIcon,myDogIcon,myLionIcon,myChickPromoted,myCatPromoted,myElephant,myGiraffe;
	private static ImageIcon AIChickIcon,AICatIcon,AIDogIcon,AILionIcon,AIChickPromoted,AICatPromoted,AIElephant,AIGiraffe;
	private ChessBoard presentChessBoard=null;
	private JLabel chessboardLabel;
	//private ChessInfo chessInfo=null;
	static JTextArea coverPanel;
	private static Chess myKing;
	private static Chess enemyKing;
	public static boolean isSinglePlayer,isPlayerTurn;
	public static  ChessBoard [][]  chessboard;
	//public static List<Chess> UpPlayerCapturedChessList=new ArrayList<Chess>();
	//public static List<Chess> DownPlayerCapturedChessList=new ArrayList<Chess>();


	public ChessBoardPanel(boolean isEnemy,boolean isSinglePlayer,int variantsNumber){


		//at beginning the IsEnemy is false
		this.isSinglePlayer=isSinglePlayer;
		//so at beginning the isplayerTurn is ture,
		isPlayerTurn=!isEnemy;
		setLayout(null);

		//if it is 5*6 chess board shoji
		if(variantsNumber==0) {
			chessboard = new ChessBoard[6][11];
			//chess board setting
			for (int i = 0; i < 6; i++) {
				//left waiting board setting
				for (int j = 0; j < 3; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 1);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
				//main chess play board
				for (int j = 3; j < 8; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 0);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
				//right waiting board
				for (int j = 8; j < 11; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 2);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
			}



			//set current board
			presentChessBoard = chessboard[0][0];
			initAllChesses(isEnemy,variantsNumber);
			chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard.jpg"));
			chessboardLabel.setBounds(160, -10, 350, 400);
			add(chessboardLabel);

		}


		//if it is 9*9 chess board shoji
		if(variantsNumber==2) {
			chessboard = new ChessBoard[9][15];
			//chess board setting
			for (int i = 0; i < 9; i++) {
				//left waiting board setting
				for (int j = 0; j < 3; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 1);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
				//main chess play board
				for (int j = 3; j < 12; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 0);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
				//right waiting board
				for (int j = 12; j < 15; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 2);
					chessboard[i][j].setBounds(j * 53 + 40, i * 53 + 35, 54, 54);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
			}



			//set current board
			presentChessBoard = chessboard[0][0];
			initAllChesses(isEnemy,variantsNumber);
			chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard.jpg"));
			chessboardLabel.setBounds(160, -10, 350, 400);
			add(chessboardLabel);

		}


        // cover the
		coverPanel=new JTextArea();
		coverPanel.setBounds(0, 0, 750, 450);
		coverPanel.setOpaque(false);
		coverPanel.setEditable(false);
		coverPanel.setVisible(false);
		add(coverPanel);
		setComponentZOrder(coverPanel, 0);//set cover the board

	}


	public void initAllChesses(boolean isEnemy,int variantsNumber){


		 myChickIcon=new ImageIcon("images/chickenDown.png");
		myCatIcon=new ImageIcon("images/catDown.png");
		myDogIcon=new ImageIcon("images/dogDown.png");
		myLionIcon=new ImageIcon("images/lionDown.png");
		myChickPromoted=new ImageIcon("images/chickPromotedDown.png");
		myCatPromoted=new ImageIcon("images/catPromotedDown.png");
		myElephant=new ImageIcon("images/elephantUp.png");
		myGiraffe=new ImageIcon("images/giraffeUp.png");

		 AIChickIcon=new ImageIcon("images/chickenUp.png");
		 AICatIcon=new ImageIcon("images/catUp.png");
		AIDogIcon=new ImageIcon("images/dogUp.png");
		AILionIcon=new ImageIcon("images/lionUp.png");
		AIChickPromoted=new ImageIcon("images/chickPromotedUp.png");
		AICatPromoted=new ImageIcon("images/catPromotedUp.png");
		AIElephant=new ImageIcon("images/elephantDown.png");
		AIGiraffe=new ImageIcon("images/giraffeDown.png");

		int chessTypeChecking=0;
		int countNumberOfPiece=0;
		if(variantsNumber==0) {
			List<Lion> lion = new ArrayList<Lion>();

			 lion.add(new Lion(0, 5, !isEnemy));
			chessboard[0][5].setIcon(AILionIcon);
			chessboard[0][5].setChess(lion.get(0));
			ChessInfo.AIChessListAdd(lion.get(0));

			/////////////////////////////////////////////p2

			for(int i=0;i<20;i++){
			 double b;
			 b= Math.random()*10;
			 b=b/2;
			 int numberOfCurrentTypeOfPiece = (int)b;
			 countNumberOfPiece = setChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
					 countNumberOfPiece);
			 chessTypeChecking++;
			}




			////////////////////////////////////////////p1

			Lion lion2 = new Lion(5, 5, isEnemy);
			chessboard[5][5].setIcon(myLionIcon);
			chessboard[5][5].setChess(lion2);
			ChessInfo.playerChessList.add(lion2);

			Cat cat3 = new Cat(5, 3, isEnemy);
			chessboard[5][3].setIcon(myCatIcon);
			chessboard[5][3].setChess(cat3);
			ChessInfo.playerChessListAdd(cat3);

			Dog dog3 = new Dog(5, 4, isEnemy);
			chessboard[5][4].setIcon(myDogIcon);
			chessboard[5][4].setChess(dog3);
			ChessInfo.playerChessListAdd(dog3);



			Dog dog4 = new Dog(5, 6, isEnemy);
			chessboard[5][6].setIcon(myDogIcon);
			chessboard[5][6].setChess(dog4);
			ChessInfo.playerChessList.add(dog4);

			Cat cat4 = new Cat(5, 7, isEnemy);
			chessboard[5][7].setIcon(myCatIcon);
			chessboard[5][7].setChess(cat4);
			ChessInfo.playerChessList.add(cat4);

			Chick chick4 = new Chick(3, 4, isEnemy);
			chessboard[3][4].setIcon(myChickIcon);
			chessboard[3][4].setChess(chick4);
			ChessInfo.playerChessList.add(chick4);

			Chick chick5 = new Chick(3, 5, isEnemy);
			chessboard[3][5].setIcon(myChickIcon);
			chessboard[3][5].setChess(chick5);
			ChessInfo.playerChessList.add(chick5);

			Chick chick6 = new Chick(3, 6, isEnemy);
			chessboard[3][6].setIcon(myChickIcon);
			chessboard[3][6].setChess(chick6);
			ChessInfo.playerChessList.add(chick6);


			if (isEnemy) {
				myKing = lion2;
				enemyKing = lion.get(0);
			} else {
				myKing = lion.get(0);
				enemyKing = lion2;
			}


		}
		
 	}

	public int  setChess(boolean isEnemy,int chessTypeChecking,int numberOfCurrentTypeOfPiece,int countNumberOfPiece){

		int X,Y;



		if(chessTypeChecking==0) {

             for(int i=0;i<numberOfCurrentTypeOfPiece;i++) {

				 if(countNumberOfPiece==2){
					 countNumberOfPiece++;//because lion is already set
				 }

				 Y = countNumberOfPiece / 5 ;
				 X = countNumberOfPiece % 5+3;
				 Cat cat1 =new Cat(Y, X, !isEnemy);
				 ChessInfo.AIChessListAdd(cat1);
				 chessboard[Y][X].setIcon(AICatIcon);
				 chessboard[Y][X].setChess(cat1);
				 countNumberOfPiece++;
			 }
		}

		if(chessTypeChecking==1) {

			for(int i=0;i<numberOfCurrentTypeOfPiece;i++) {

				if(countNumberOfPiece==2){
					countNumberOfPiece++;//because lion is already set
				}

				Y = countNumberOfPiece / 5 ;
				X = countNumberOfPiece % 5+3;
				Dog dog =new Dog(Y, X, !isEnemy);
				ChessInfo.AIChessListAdd(dog);
				chessboard[Y][X].setIcon(AIDogIcon);
				chessboard[Y][X].setChess(dog);
				countNumberOfPiece++;
			}
		}

		if(chessTypeChecking==2) {
			for(int i=0;i<numberOfCurrentTypeOfPiece;i++) {

				if(countNumberOfPiece==2){
					countNumberOfPiece++;//because lion is already set
				}

				Y = countNumberOfPiece / 5 ;
				X = countNumberOfPiece % 5+ 3;
				Elephant elephant =new Elephant(Y, X, !isEnemy);
				ChessInfo.AIChessListAdd(elephant);
				chessboard[Y][X].setIcon(AIElephant);
				chessboard[Y][X].setChess(elephant);
				countNumberOfPiece++;
			}
		}


		if(chessTypeChecking==3) {
			for(int i=0;i<numberOfCurrentTypeOfPiece;i++) {

				if(countNumberOfPiece==2){
					countNumberOfPiece++;//because lion is already set
				}

				Y = countNumberOfPiece / 5 ;
				X = countNumberOfPiece % 5+ 3;
				Giraffe giraffe =new Giraffe(Y, X, !isEnemy);
				ChessInfo.AIChessListAdd(giraffe);
				chessboard[Y][X].setIcon(AIGiraffe);
				chessboard[Y][X].setChess(giraffe);
				countNumberOfPiece++;
			}
		}

		if(chessTypeChecking==4) {
			for(int i=0;i<numberOfCurrentTypeOfPiece;i++) {

				if(countNumberOfPiece==2){
					countNumberOfPiece++;//because lion is already set
				}

				Y = countNumberOfPiece / 5 ;
				X = countNumberOfPiece % 5+ 3;
				Chick chick3 =new Chick(Y, X, !isEnemy);
				ChessInfo.AIChessListAdd(chick3);
				chessboard[Y][X].setIcon(AIChickIcon);
				chessboard[Y][X].setChess(chick3);
				countNumberOfPiece++;
			}
		}

		if(chessTypeChecking>4&&countNumberOfPiece<12){

			if(countNumberOfPiece==2){
				countNumberOfPiece++;//because lion is already set
			}

			Y = countNumberOfPiece / 5 ;
			X = countNumberOfPiece % 5+ 3;
			Chick chick3 =new Chick(Y, X, !isEnemy);
			ChessInfo.AIChessListAdd(chick3);
			chessboard[Y][X].setIcon(AIChickIcon);
			chessboard[Y][X].setChess(chick3);
			countNumberOfPiece++;

		}

		return countNumberOfPiece;
	}

	public static void moveChess(ChessBoard presentChessBoard, ChessBoard clickBoard) {

        // if current board contain a chess and this board is main working board
		if (clickBoard.getChess()!=null&&(presentChessBoard.getIsWaitingBorad()==0)) {//
			Chess chessExange= clickBoard.getChess();
			Chess chessExange2= clickBoard.getChess();
			//change the chess enemy state
			chessExange.setEnemy(!chessExange.isEnemy());
		//	ChessInfo.AIChessList.remove(chessExange2);
			//set the chess to be no promoted because it is the chess dead
			chessExange.setIsPromoted(false);
			if (clickBoard.getChess().isEnemy()) {

				ChessInfo.playerChessList.remove(chessExange2);
				ChessInfo.AICapturedPieceList.add(chessExange);
			}else {

				ChessInfo.AIChessList.remove(chessExange2);
				ChessInfo.PlayerCapturedPieceList.add(chessExange);
			}
			System.out.println("chess moved by moveChess function ");

		}else if//Set captured piece to AI
		(clickBoard.getChess()==null &&(presentChessBoard.getIsWaitingBorad()==1)) {
            Chess chess = ChessInfo.AICapturedPieceList.get(getIndexFromWatingList(presentChessBoard));
			chess.setCoor(clickBoard);

			ChessInfo.AIChessList.add(chess);
			ChessInfo.AICapturedPieceList.remove(getIndexFromWatingList(presentChessBoard));
		}else if//Set captured piece to player
		(clickBoard.getChess()==null &&(presentChessBoard.getIsWaitingBorad()==2)){

			Chess chess = ChessInfo.PlayerCapturedPieceList.get(getIndexFromWatingList(presentChessBoard));
			chess.setCoor(clickBoard);

			ChessInfo.playerChessList.add(chess);
			ChessInfo.PlayerCapturedPieceList.remove(getIndexFromWatingList(presentChessBoard));
		}

		//update the chess
		Chess chess=presentChessBoard.getChess();
		Chess chess2=clickBoard.getChess();
		chess.setCoor(clickBoard);//update chess
		chess.setStep(chess.getStep()+1);
		Icon icon=presentChessBoard.getIcon();
		presentChessBoard.setChess(null);//clean the chess at this current board
		presentChessBoard.setIcon(null);//clean the icon at this current board
		presentChessBoard = clickBoard;//
		presentChessBoard.setChess(chess);//set new chess at current board
		presentChessBoard.setIcon(icon);// set new icon at current board

		isGameOver(chess2);

		checkIsPromoted(presentChessBoard);// check if the chess is promoted

		updateCapturedChessList();

		System.out.println("AICapturedPieceList.size():"+ChessInfo.AICapturedPieceList.size());
		if(ChessInfo.AICapturedPieceList.size()>0){
			System.out.println(ChessInfo.AICapturedPieceList.get(0).getCoorX()+ChessInfo.AICapturedPieceList.get(0).getCoorY());
		}

	}

	public static void isGameOver(Chess chess){
		if (chess==myKing) {
			JOptionPane.showMessageDialog(null, "we win","infor",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
//			MainPlayFrame.newGame();
		}else if (chess==enemyKing) {
			JOptionPane.showMessageDialog(null, "we lose","infor",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
//			MainPlayFrame.newGame();
		}
	}


	public static void turnToMyTrun(boolean isEnable) {
		//System.out.println("2222222222222222222222222222222222222222222");
		MainPlayFrame.player1InfoJpanel.setMyTurn(isEnable);
		MainPlayFrame.player2InfoJpanel.setMyTurn(!isEnable);
		ChessBoardPanel.coverPanel.setVisible(!isEnable);
		isPlayerTurn = isEnable;
	}


	public void actionPerformed(ActionEvent e) {
		updateCapturedChessList();
   //  System.out.println("3233333333333333333333333333333333333333");
		ChessBoard clickBoard=(ChessBoard) e.getSource();//当前所点击的位置
	//	System.out.println(clickBoard);
	//	System.out.println(((ChessBoard) e.getSource()).getCoorX());
	//	System.out.println(((ChessBoard) e.getSource()).getCoorY());
		//System.out.println(presentChessBoard.getChess().getName());

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
						//	   System.out.println("7777777777777777777777733333333333333333333");
							  moveChess(presentChessBoard, clickBoard);
							  //我的回合结束，停止计时
							  turnToMyTrun(!isPlayerTurn);
						   } else if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
							  //System.out.println("2233333333333333333333333333333333333333");
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
						System.out.println("can not move");
					}

				}
				// if the current Chess board is at up players waiting chess board
				// and must click at main play area
				else if(presentChessBoard.getIsWaitingBorad()==2 && clickBoard.getIsWaitingBorad()==0 ){
			//		System.out.println("544444444444444444444444444444444444");
					// there need to check more
					moveChess(presentChessBoard, clickBoard);
					turnToMyTrun(!isPlayerTurn);
				}
			} else {// get a new presentChessBoard from the main board area or the option chess area
				if (clickBoard.getChess() != null && (!clickBoard.getChess().isEnemy())||clickBoard.getIsWaitingBorad()==2) {
					presentChessBoard = clickBoard;// update
				}
			}
			updateCapturedChessList();

			System.out.println("ChessBoardPanel the size of AIChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.AIChessList.size());

			System.out.println("ChessBoardPanel the size of playerChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.playerChessList.size());

			return;
		}

		// for up player
	/**	if(!MainPlayFrame.player1InfoJpanel.getMyTurn()) {
			//System.out.println("544444444444444444444444444444444444");
			if (presentChessBoard != null && presentChessBoard.getChess() != null) {//原来的棋盘点上不为空
			//	System.out.println("566666666666666666666666666666");
				if(presentChessBoard.getIsWaitingBorad()==0 ) {
					if (clickBoard.getIsWaitingBorad() == 0) {
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
					}else {
						System.out.println("can not move");
					}

				}
				// if the current Chess board is at up players waiting chess board
				// and must click at main play area
				else if(presentChessBoard.getIsWaitingBorad()==1 && clickBoard.getIsWaitingBorad()==0 ){
				//	System.out.println("544444444444444444444444444444444444");
					// there need to check more
					moveChess(presentChessBoard, clickBoard);
					turnToMyTrun(!isPlayerTurn);
				}

			} else {
				// update the presentChessBoard
				//the chess must be the AI players chess
				// get a new presentChessBoard from the main board area or the option chess area
				if (clickBoard.getChess() != null && (clickBoard.getChess().isEnemy())||clickBoard.getIsWaitingBorad()==1) {
					presentChessBoard = clickBoard;// 当前操作位置更新
				}
			}
			updateCapturedChessList();


			System.out.println("ChessBoardPanel the size of AIChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.AIChessList.size());

			System.out.println("ChessBoardPanel the size of playerChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.playerChessList.size());
			return;
		}

*/

		
		//王被将军
	}


	public  static void updateCapturedChessList(){
		//clear waiting board

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {

					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);
			}
		}

		for (int i = 5; i > 2; i--) {
			for (int j = 10; j > 7; j--) {
					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);

			}
		}


		//set chess
		int k=0;
			  for (int i = 0; i < 6; i++) {
				  for (int j = 0; j < 3; j++) {
					  if ( k<ChessInfo.AICapturedPieceList.size()&& ChessInfo.AICapturedPieceList.get(k) != null ) {
						chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.AICapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.AICapturedPieceList.get(k).setCoorX(j);
						ChessInfo.AICapturedPieceList.get(k).setCoorY(i);
						  k++;
					}
				 }
			 }
	     k=0;


			   for (int i = 5; i > 2; i--) {
				  for (int j = 10; j > 7; j--) {
					  if ( k<ChessInfo.PlayerCapturedPieceList.size()&& ChessInfo.PlayerCapturedPieceList.get(k) != null ) {
						chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
						  //updateChess infor
						  ChessInfo.PlayerCapturedPieceList.get(k).setCoorX(j);
						  ChessInfo.PlayerCapturedPieceList.get(k).setCoorY(i);
						  k++;
				  }

			}
		}

	};

	public static int getIndexFromWatingList(ChessBoard presentChessBoard){

		int k=0;
		if(presentChessBoard.getIsWaitingBorad()==1){

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if(presentChessBoard.getCoorX()==j&&presentChessBoard.getCoorY()==i){
						return k;
					}
					k++;
				}
			}
		}

		k=0;

		if(presentChessBoard.getIsWaitingBorad()==2){

			for (int i = 5; i > 2; i--) {
				for (int j = 10; j > 7; j--) {
					if(presentChessBoard.getCoorX()==j&&presentChessBoard.getCoorY()==i){
						return k;
					}
					k++;
				}
			}
		}

		//it is useless return;
		return k;


	}

	//get image Icon for waiting chess
	public static ImageIcon getChessImage(Chess chess){

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

		if(chess.getName()=="Elephant"){
			if(chess.isEnemy()){
				return AIElephant;
			}else {
				return myElephant;
			}
		}

		if(chess.getName()=="Giraffe"){
			if(chess.isEnemy()){
				return AIGiraffe;
			}else {
				return myGiraffe;
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

	public  static void checkIsPromoted(ChessBoard presentChessBoard ){
		//check if it is the chess that have promoted fucntion
		if (presentChessBoard.getChess().getName() == "Chick") {
			//check if this board can lead chess promoted
			if(presentChessBoard.getChess().checkIsPromotedNow()) {
				presentChessBoard.setIcon(null);//clean the icon at this current board
				if (presentChessBoard.getChess().isEnemy()) {
					presentChessBoard.setIcon(new ImageIcon("images/ChickPromotedUp.png"));// set new icon at current board
				}else {
					presentChessBoard.setIcon(new ImageIcon("images/ChickPromotedDown.png"));// set new icon at current board
				}
			}
		}else if(presentChessBoard.getChess().getName() == "Cat"){
			if(presentChessBoard.getChess().checkIsPromotedNow()){
				presentChessBoard.setIcon(null);//clean the icon at this current board
				if(presentChessBoard.getChess().isEnemy()) {
					presentChessBoard.setIcon(new ImageIcon("images/catPromotedUp.png"));// set new icon at current board
				}else {
					presentChessBoard.setIcon(new ImageIcon("images/catPromotedDown.png"));// set new icon at current board
				}
			}
		}
	};

	public static void setPlayerTurn(boolean isPlayerTurn) {
		ChessBoardPanel.isPlayerTurn = isPlayerTurn;
	}

}
