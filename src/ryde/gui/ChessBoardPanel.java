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
import ryde.InternetChess.Boar;
import ryde.InternetChess.Rabbit;
import ryde.battle.ChessInfo;


/**
 *
 *
 */
public class ChessBoardPanel extends JPanel implements ActionListener{
	//Locale.setDefault(new Locale("en","US"));
	private static ImageIcon myChickIcon,myCatIcon,myDogIcon,myLionIcon,myChickPromoted,myCatPromoted,myElephant,myGiraffe,myBoar,myRabbit;
	private static ImageIcon AIChickIcon,AICatIcon,AIDogIcon,AILionIcon,AIChickPromoted,AICatPromoted,AIElephant,AIGiraffe,AIBoar,AIRabbit;
	private ChessBoard presentChessBoard=null;
	private JLabel chessboardLabel;
	//private ChessInfo chessInfo=null;
	static JTextArea coverPanel;
	private static Chess myKing;
	private static Chess enemyKing;
	public static boolean isSinglePlayer,isPlayerTurn;
	public static  ChessBoard [][]  chessboard;
	private static int variantsNumber;
	private  List<Chess> ChessList = new ArrayList<Chess>();
	private boolean isEnemy;

	//public static List<Chess> UpPlayerCapturedChessList=new ArrayList<Chess>();
	//public static List<Chess> DownPlayerCapturedChessList=new ArrayList<Chess>();


	public ChessBoardPanel(boolean isEnemy,boolean isSinglePlayer,int variantsNumber){

		this.isEnemy=isEnemy;
		//at beginning the IsEnemy is false
		this.isSinglePlayer=isSinglePlayer;
		//so at beginning the isplayerTurn is ture,
		isPlayerTurn=!isEnemy;
		this.variantsNumber=variantsNumber;
		setLayout(null);

		ChessInfo.AIChessList.clear();
		ChessInfo.playerChessList.clear();
		ChessInfo.PlayerCapturedPieceList.clear();
		ChessInfo.AICapturedPieceList.clear();

		//if it is 5*6 chess board shoji
		if(variantsNumber==0) {
			chessboard = new ChessBoard[6][11];
			//chess board setting
			for (int i = 0; i < 6; i++) {

				//left waiting board setting
				for (int j = 0; j < 3; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 1);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}

				//main chess play board
				for (int j = 3; j < 8; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 0);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}

				//right waiting board
				for (int j = 8; j < 11; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 2);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
			}

			//set current board
			presentChessBoard = chessboard[0][0];
			initAllChesses(isEnemy,variantsNumber);
			chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard1.png"));
			chessboardLabel.setBounds(-90, -125, 900, 700);
			add(chessboardLabel);
		}



		//if it is 9*9 chess board shoji
		if(variantsNumber==1) {
			chessboard = new ChessBoard[9][15];
			//chess board setting
			for (int i = 0; i < 9; i++) {
				//left waiting board setting
				for (int j = 0; j < 3; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 1);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}

				//main chess play board
				for (int j = 3; j < 12; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 0);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
				//right waiting board
				for (int j = 12; j < 15; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 2);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
			}



			//set current board
			presentChessBoard = chessboard[0][0];
			initAllChesses(isEnemy,variantsNumber);
			chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard3.png"));
			chessboardLabel.setBounds(20, -39, 900, 700);
			add(chessboardLabel);
		}



		//if it is 7*8  chess board shoji
		if(variantsNumber==2) {
			chessboard = new ChessBoard[8][13];
			//chess board setting
			for (int i = 0; i < 8; i++) {
				//left waiting board setting
				for (int j = 0; j < 3; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 1);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}

				//main chess play board
				for (int j = 3; j < 10; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 0);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}

				//right waiting board
				for (int j = 10; j < 13; j++) {
					chessboard[i][j] = new ChessBoard(i, j, 2);
					chessboard[i][j].setBounds(j * 55 + 54, i * 56+ 53, 63, 63);
					chessboard[i][j].addActionListener(this);
					add(chessboard[i][j]);
				}
			}



			//set current board
			presentChessBoard = chessboard[0][0];
			initAllChesses(isEnemy,variantsNumber);
			chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard2.png"));
			chessboardLabel.setBounds(-35, -66, 900, 700);
			add(chessboardLabel);
		}


        // cover the
		coverPanel=new JTextArea();
		coverPanel.setBounds(0, 0, 1000, 1000);
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
		myElephant=new ImageIcon("images/elephantDown.png");
		myGiraffe=new ImageIcon("images/giraffeDown.png");
		myBoar=new ImageIcon("images/boarDown.png");
		myRabbit=new ImageIcon("images/rabbitDown.png");

		AIChickIcon=new ImageIcon("images/chickenUp.png");
		AICatIcon=new ImageIcon("images/catUp.png");
		AIDogIcon=new ImageIcon("images/dogUp.png");
		AILionIcon=new ImageIcon("images/lionUp.png");
		AIChickPromoted=new ImageIcon("images/chickPromotedUp.png");
		AICatPromoted=new ImageIcon("images/catPromotedUp.png");
		AIElephant=new ImageIcon("images/elephantUp.png");
		AIGiraffe=new ImageIcon("images/giraffeUp.png");
		AIBoar=new ImageIcon("images/boarUp.png");
		AIRabbit=new ImageIcon("images/rabbitUp.png");


		int chessTypeChecking=0;
		int countNumberOfPiece=0;


		if(variantsNumber==0) {
		Lion lion=new Lion(0, 5, !isEnemy);
			chessboard[0][5].setIcon(AILionIcon);
			chessboard[0][5].setChess(lion);
			ChessInfo.AIChessListAdd(lion);

			/////////////////////////////////////////////AI
			for(int i=0;i<8;i++){
			 double b;
			 b= Math.random()*10;
			 b=b/2;
			 int numberOfCurrentTypeOfPiece = (int)b;
			 countNumberOfPiece = setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
					 countNumberOfPiece,variantsNumber);
			 chessTypeChecking++;
			}
			////////////////////////////////////////////player
			chessTypeChecking=0;
			countNumberOfPiece=0;

			Lion lion2 = new Lion(5, 5, isEnemy);
			chessboard[5][5].setIcon(myLionIcon);
			chessboard[5][5].setChess(lion2);
			ChessInfo.playerChessList.add(lion2);


			setPlayerChess(variantsNumber);



			if (isEnemy) {
				myKing = lion2;
				enemyKing = lion;
			} else {
				myKing = lion;
				enemyKing = lion2;
			}


		}



		if(variantsNumber==1) {
			Lion lion=new Lion(0, 7, !isEnemy);
			chessboard[0][7].setIcon(AILionIcon);
			chessboard[0][7].setChess(lion);
			ChessInfo.AIChessListAdd(lion);

			/////////////////////////////////////////////AI
			for(int i=0;i<10;i++){
				double b;
				b= Math.random()*10;
				b=b/2;
				int numberOfCurrentTypeOfPiece = (int)b;
				countNumberOfPiece = setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
						countNumberOfPiece,variantsNumber);
				chessTypeChecking++;
			}
			////////////////////////////////////////////player
			chessTypeChecking=0;
			countNumberOfPiece=0;

			Lion lion2 = new Lion(8, 7, isEnemy);
			chessboard[8][7].setIcon(myLionIcon);
			chessboard[8][7].setChess(lion2);
			ChessInfo.playerChessList.add(lion2);


		setPlayerChess(variantsNumber);


			if (isEnemy) {
				myKing = lion2;
				enemyKing = lion;
			} else {
				myKing = lion;
				enemyKing = lion2;
			}


		}



		if(variantsNumber==2) {
			Lion lion=new Lion(0, 6, !isEnemy);
			chessboard[0][6].setIcon(AILionIcon);
			chessboard[0][6].setChess(lion);
			ChessInfo.AIChessListAdd(lion);

			/////////////////////////////////////////////AI
			for(int i=0;i<13;i++){
				double b;
				b= Math.random()*10;
				b=b/2;
				int numberOfCurrentTypeOfPiece = (int)b;
				countNumberOfPiece = setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
						countNumberOfPiece,variantsNumber);
				chessTypeChecking++;
			}
			////////////////////////////////////////////player
			chessTypeChecking=0;
			countNumberOfPiece=0;

			Lion lion2 = new Lion(7, 6, isEnemy);
			chessboard[7][6].setIcon(myLionIcon);
			chessboard[7][6].setChess(lion2);
			ChessInfo.playerChessList.add(lion2);


			 setPlayerChess(variantsNumber);


			if (isEnemy) {
				myKing = lion2;
				enemyKing = lion;
			} else {
				myKing = lion;
				enemyKing = lion2;
			}


		}


		
 	}



	public int  setAIChess (boolean isEnemy,int chessTypeChecking,int numberOfCurrentTypeOfPiece,
							int countNumberOfPiece,int variantsNumber){

		int X=0,Y=0;




		if(variantsNumber==0) {

				for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

					Y = countNumberOfPiece / 3;
					X = countNumberOfPiece % 3 + 3;

					if (countNumberOfPiece == 2) {
						countNumberOfPiece++;//because lion is already set
						break;
					}

					if(chessTypeChecking==0) {

						Cat cat1 = new Cat(Y, X, !isEnemy);
						ChessInfo.AIChessListAdd(cat1);
						chessboard[Y][X].setIcon(AICatIcon);
						chessboard[Y][X].setChess(cat1);
						ChessList.add(cat1);
						System.out.println("cat11!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+chessboard[Y][X].getChess().isEnemy());
						countNumberOfPiece++;

						if(X!=5){
							int BetweenX = Math.abs(5 - X);
							int newX=5+BetweenX;

							Cat cat2 = new Cat(Y, newX, !isEnemy);
							ChessInfo.AIChessListAdd(cat2);
							ChessList.add(cat2);
							chessboard[Y][newX].setIcon(AICatIcon);
							chessboard[Y][newX].setChess(cat2);

							System.out.println("cat2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+chessboard[Y][newX].getChess().isEnemy());
						}

					}

					if(chessTypeChecking==1) {
						Dog dog =new Dog(Y, X, !isEnemy);
						ChessInfo.AIChessListAdd(dog);
						ChessList.add(dog);
						chessboard[Y][X].setIcon(AIDogIcon);
						chessboard[Y][X].setChess(dog);
						countNumberOfPiece++;

						if(X!=5){
							int BetweenX = Math.abs(5 - X);
							int newX=5+BetweenX;

							Dog dog2 =new Dog(Y, newX, !isEnemy);
							ChessInfo.AIChessListAdd(dog2);
							ChessList.add(dog2);
							chessboard[Y][newX].setIcon(AIDogIcon);
							chessboard[Y][newX].setChess(dog2);
						}


					}

					if(chessTypeChecking>1&&countNumberOfPiece<7) {
						Chick chick3 = new Chick(Y, X, !isEnemy);
						ChessInfo.AIChessListAdd(chick3);
						ChessList.add(chick3);
						chessboard[Y][X].setIcon(AIChickIcon);
						chessboard[Y][X].setChess(chick3);
						countNumberOfPiece++;

						if(X!=5){
							int BetweenX = Math.abs(5 - X);
							int newX=5+BetweenX;

							Chick chick4 = new Chick(Y, newX, !isEnemy);
							ChessInfo.AIChessListAdd(chick4);
							ChessList.add(chick4);
							chessboard[Y][newX].setIcon(AIChickIcon);
							chessboard[Y][newX].setChess(chick4);
						}

					}


			}


		}



		if(variantsNumber==1) {

			for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

				Y = countNumberOfPiece / 5;
				X = countNumberOfPiece % 5 + 3;

				if(countNumberOfPiece==4){
					countNumberOfPiece++;//because lion is already set
					break;
				}

				if(chessTypeChecking==0) {

					Cat cat1 = new Cat(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(cat1);
					chessboard[Y][X].setIcon(AICatIcon);
					chessboard[Y][X].setChess(cat1);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Cat cat2 = new Cat(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(cat2);
						chessboard[Y][newX].setIcon(AICatIcon);
						chessboard[Y][newX].setChess(cat2);
					}

				}

				if(chessTypeChecking==1) {
					Dog dog =new Dog(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(dog);
					chessboard[Y][X].setIcon(AIDogIcon);
					chessboard[Y][X].setChess(dog);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Dog dog2 =new Dog(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(dog2);
						chessboard[Y][newX].setIcon(AIDogIcon);
						chessboard[Y][newX].setChess(dog2);
					}

				}

				if(chessTypeChecking==2) {
					Elephant elephant = new Elephant(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(elephant);
					chessboard[Y][X].setIcon(AIElephant);
					chessboard[Y][X].setChess(elephant);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Elephant elephant2 = new Elephant(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(elephant2);
						chessboard[Y][newX].setIcon(AIElephant);
						chessboard[Y][newX].setChess(elephant2);
					}

				}

				if(chessTypeChecking==3) {
					Giraffe giraffe = new Giraffe(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(giraffe);
					chessboard[Y][X].setIcon(AIGiraffe);
					chessboard[Y][X].setChess(giraffe);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Giraffe giraffe2 = new Giraffe(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(giraffe2);
						chessboard[Y][newX].setIcon(AIGiraffe);
						chessboard[Y][newX].setChess(giraffe2);
					}

				}

				if(chessTypeChecking==4) {
					Boar boar =new Boar(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(boar);
					chessboard[Y][X].setIcon(AIBoar);
					chessboard[Y][X].setChess(boar);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Boar boar2 =new Boar(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(boar2);
						chessboard[Y][newX].setIcon(AIBoar);
						chessboard[Y][newX].setChess(boar2);
					}

				}



				if(chessTypeChecking==5) {

					Rabbit rabbit =new Rabbit(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(rabbit);
					chessboard[Y][X].setIcon(AIRabbit);
					chessboard[Y][X].setChess(rabbit);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Rabbit rabbit2 =new Rabbit(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(rabbit2);
						chessboard[Y][newX].setIcon(AIRabbit);
						chessboard[Y][newX].setChess(rabbit2);
					}


				}

				if(chessTypeChecking>5&&countNumberOfPiece<10) {
					Chick chick3 = new Chick(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(chick3);
					chessboard[Y][X].setIcon(AIChickIcon);
					chessboard[Y][X].setChess(chick3);
					countNumberOfPiece++;

					if(X!=7){
						int BetweenX = Math.abs(7 - X);
						int newX=7+BetweenX;

						Chick chick4 = new Chick(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(chick4);
						chessboard[Y][newX].setIcon(AIChickIcon);
						chessboard[Y][newX].setChess(chick4);

					}


				}


			}


		}




		if(variantsNumber==2) {

			for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

				Y = countNumberOfPiece / 4;
				X = countNumberOfPiece % 4 + 3;

				if(countNumberOfPiece==3){
					countNumberOfPiece++;//because lion is already set
					break;
				}

				if(chessTypeChecking==0) {

					Cat cat1 = new Cat(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(cat1);
					chessboard[Y][X].setIcon(AICatIcon);
					chessboard[Y][X].setChess(cat1);
					countNumberOfPiece++;

					if(X!=6){
						int BetweenX = Math.abs(6 - X);
						int newX=6+BetweenX;

						Cat cat2 = new Cat(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(cat2);
						chessboard[Y][newX].setIcon(AICatIcon);
						chessboard[Y][newX].setChess(cat2);
					}


				}

				if(chessTypeChecking==1) {
					Dog dog =new Dog(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(dog);
					chessboard[Y][X].setIcon(AIDogIcon);
					chessboard[Y][X].setChess(dog);
					countNumberOfPiece++;

					if(X!=6){
						int BetweenX = Math.abs(6 - X);
						int newX=6+BetweenX;

						Dog dog2 =new Dog(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(dog2);
						chessboard[Y][newX].setIcon(AIDogIcon);
						chessboard[Y][newX].setChess(dog2);
					}

				}


				if(chessTypeChecking==2) {
					Boar boar =new Boar(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(boar);
					chessboard[Y][X].setIcon(AIBoar);
					chessboard[Y][X].setChess(boar);
					countNumberOfPiece++;

					if(X!=6){
						int BetweenX = Math.abs(6 - X);
						int newX=6+BetweenX;

						Boar boar2 =new Boar(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(boar2);
						chessboard[Y][newX].setIcon(AIBoar);
						chessboard[Y][newX].setChess(boar2);
					}

				}



				if(chessTypeChecking==3) {

					Rabbit rabbit =new Rabbit(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(rabbit);
					chessboard[Y][X].setIcon(AIRabbit);
					chessboard[Y][X].setChess(rabbit);
					countNumberOfPiece++;

					if(X!=6){
						int BetweenX = Math.abs(6 - X);
						int newX=6+BetweenX;

						Rabbit rabbit2 =new Rabbit(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(rabbit2);
						chessboard[Y][newX].setIcon(AIRabbit);
						chessboard[Y][newX].setChess(rabbit2);
					}

				}

				if(chessTypeChecking>3&&countNumberOfPiece<8) {
					Chick chick3 = new Chick(Y, X, !isEnemy);
					ChessInfo.AIChessListAdd(chick3);
					chessboard[Y][X].setIcon(AIChickIcon);
					chessboard[Y][X].setChess(chick3);
					countNumberOfPiece++;

					if(X!=6){
						int BetweenX = Math.abs(6 - X);
						int newX=6+BetweenX;

						Chick chick4 = new Chick(Y, newX, !isEnemy);
						ChessInfo.AIChessListAdd(chick4);
						chessboard[Y][newX].setIcon(AIChickIcon);
						chessboard[Y][newX].setChess(chick4);
					}

				}


			}


		}



		return countNumberOfPiece;
	}


	public void setPlayerChess(int variantsNumber ){

		int X=0,Y=0;
/*
		for (int i = 0; i < 6; i++) {
			for (int j = 3; j < 8; j++) {
				if(chessboard[i][j].getChess()!=null)
					System.out.println(		chessboard[i][j].getChess().isEnemy());
			}
		}
*/
		if(variantsNumber==0) {
          for(int i=0; i<ChessInfo.AIChessList.size();i++) {
			  Chess chess1 = ChessInfo.AIChessList.get(i);


			  if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
			         continue;
			  }

			  int newY=0;

			  if(chess1.getCoorY()==0) {
				  newY =5;
			  }

			  if(chess1.getCoorY()==1) {
				  newY =4;
			  }

			  if(chess1.getCoorY()==2) {
				  newY =3;
			  }

			 // chess2.setEnemy(isEnemy);
			  Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
			  chessboard[newY][chess1.getCoorX()].setChess(chess3);
			  chessboard[newY][chess1.getCoorX()].setIcon(getChessImage(chess3));
			  ChessInfo.playerChessList.add(chess3);
		  }

		}


		if(variantsNumber==1) {

			for(int i=0; i<ChessInfo.AIChessList.size();i++) {
				Chess chess1 = ChessInfo.AIChessList.get(i);


				if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
					continue;
				}

				int newY=0;

				if(chess1.getCoorY()==0) {
					newY =8;
				}

				if(chess1.getCoorY()==1) {
					newY =7;
				}

				if(chess1.getCoorY()==2) {
					newY =6;
				}

				if(chess1.getCoorY()==3) {
					newY =5;
				}

				if(chess1.getCoorY()==4) {
					newY =4;
				}


				// chess2.setEnemy(isEnemy);
				Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
				chessboard[newY][chess1.getCoorX()].setChess(chess3);
				chessboard[newY][chess1.getCoorX()].setIcon(getChessImage(chess3));
				ChessInfo.playerChessList.add(chess3);
			}


		}

		if(variantsNumber==2) {

			for(int i=0; i<ChessInfo.AIChessList.size();i++) {
				Chess chess1 = ChessInfo.AIChessList.get(i);


				if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
					continue;
				}

				int newY=0;

				if(chess1.getCoorY()==0) {
					newY =6;
				}

				if(chess1.getCoorY()==1) {
					newY =5;
				}

				if(chess1.getCoorY()==2) {
					newY =4;
				}

				if(chess1.getCoorY()==3) {
					newY =3;
				}

				// chess2.setEnemy(isEnemy);
				Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
				chessboard[newY][chess1.getCoorX()].setChess(chess3);
				chessboard[newY][chess1.getCoorX()].setIcon(getChessImage(chess3));
				ChessInfo.playerChessList.add(chess3);
			}



		}

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

		System.out.println("AICapturedPieceList.size():"+ChessInfo.AICapturedPieceList.size());
		if(ChessInfo.AICapturedPieceList.size()>0){
			System.out.println(ChessInfo.AICapturedPieceList.get(0).getCoorX()+ChessInfo.AICapturedPieceList.get(0).getCoorY());
		}

	}

	public static void isGameOver(Chess chess){
		if (chess==myKing) {
			JOptionPane.showMessageDialog(null, "we win","infor",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}else if (chess==enemyKing) {
			JOptionPane.showMessageDialog(null, "we lose","infor",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);

		}
	}


	public static void turnToMyTrun(boolean isEnable) {
		MainPlayFrame.player1InfoJpanel.setMyTurn(isEnable);
		MainPlayFrame.player2InfoJpanel.setMyTurn(!isEnable);
		ChessBoardPanel.coverPanel.setVisible(!isEnable);
		isPlayerTurn = isEnable;
	}


	public void actionPerformed(ActionEvent e) {


		//main chess play board
		for (int i = 0; i < 6; i++) {
			for (int j = 3; j < 8; j++) {
				if(chessboard[i][j].getChess()!=null)
					System.out.println(		chessboard[i][j].getChess().isEnemy());
			}
		}

		updateCapturedChessList(variantsNumber );
		ChessBoard clickBoard=(ChessBoard) e.getSource();//The current clicked position

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
						if (clickBoard != presentChessBoard) {
						 //Here there is a judgment type, whether it is a piece that has died,
							// and also to determine whether the piece is really dead on the board first,
							// because it can not be mixed with the main board,
							// otherwise it is not easy to judge, so write a more judgment program to judge, can be written here
						  boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
						  //Click on the location to advance
						   if (walkable) {
							  moveChess(presentChessBoard, clickBoard);
							  updateCapturedChessList(variantsNumber);
							  //My turn is over, stop the clock
							  turnToMyTrun(!isPlayerTurn);
						   } else if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
							  presentChessBoard = clickBoard;// Changing operating pieces
							   System.out.println(clickBoard.getChess().isEnemy());
							   System.out.println(clickBoard.getChess().getName());
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
					System.out.println("drop captured chess");
					if(clickBoard.getChess()==null) {
						moveChess(presentChessBoard, clickBoard);
						turnToMyTrun(!isPlayerTurn);
					}else {
						System.out.println("can not move");
					}
				}
				else if(presentChessBoard.getIsWaitingBorad()==2 && clickBoard.getIsWaitingBorad()==2 ){
					presentChessBoard = clickBoard;// update
					System.out.println("update captured  piece");
				}
			} else {// get a new presentChessBoard from the main board area or the option chess area
				if (clickBoard.getChess() != null && (!clickBoard.getChess().isEnemy())||clickBoard.getIsWaitingBorad()==2) {
					presentChessBoard = clickBoard;// update
				}
			}
			updateCapturedChessList(variantsNumber);

			System.out.println("ChessBoardPanel the size of AIChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.AIChessList.size());

			System.out.println("ChessBoardPanel the size of playerChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(ChessInfo.playerChessList.size());

			return;
		}

	}


	public  static void updateCapturedChessList( int variantsNumber){
		//clear waiting board

		if(variantsNumber==0) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {

					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);
				}
			}

			for (int i = 5; i > 0; i--) {
				for (int j = 10; j > 7; j--) {
					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);

				}
			}


			//set chess
			int k = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.AICapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.AICapturedPieceList.get(k).setCoorX(j);
						ChessInfo.AICapturedPieceList.get(k).setCoorY(i);
						k++;
					}
				}
			}
			k = 0;


			for (int i = 5; i > 2; i--) {
				for (int j = 10; j > 7; j--) {
					if (k < ChessInfo.PlayerCapturedPieceList.size() && ChessInfo.PlayerCapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorX(j);
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorY(i);
						k++;
					}

				}
			}
		}



		if(variantsNumber==1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 3; j++) {

					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);
				}
			}

			for (int i = 8; i > 0; i--) {
				for (int j = 14; j > 11; j--) {
					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);

				}
			}

			//set chess
			int k = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 3; j++) {
					if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.AICapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.AICapturedPieceList.get(k).setCoorX(j);
						ChessInfo.AICapturedPieceList.get(k).setCoorY(i);
						k++;
					}
				}
			}
			k = 0;


			for (int i = 8; i > 0; i--) {
				for (int j = 14; j > 11; j--) {
					if (k < ChessInfo.PlayerCapturedPieceList.size() && ChessInfo.PlayerCapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorX(j);
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorY(i);
						k++;
					}

				}
			}
		}



		if(variantsNumber==2) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 3; j++) {

					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);
				}
			}

			for (int i = 7; i > 0; i--) {
				for (int j = 12; j > 9; j--) {
					chessboard[i][j].setChess(null);
					chessboard[i][j].setIcon(null);

				}
			}


			//set chess
			int k = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 3; j++) {
					if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.AICapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.AICapturedPieceList.get(k).setCoorX(j);
						ChessInfo.AICapturedPieceList.get(k).setCoorY(i);
						k++;
					}
				}
			}


			k = 0;
			for (int i = 7; i > 0; i--) {
				for (int j = 12; j > 9; j--) {
					if (k < ChessInfo.PlayerCapturedPieceList.size() && ChessInfo.PlayerCapturedPieceList.get(k) != null) {
						chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
						chessboard[i][j].setIcon(getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
						//updateChess infor
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorX(j);
						ChessInfo.PlayerCapturedPieceList.get(k).setCoorY(i);
						k++;
					}

				}
			}
		}


	};


	public static int getIndexFromWatingList(ChessBoard presentChessBoard){

			int k = 0;

			if(variantsNumber==0) {
				if (presentChessBoard.getIsWaitingBorad() == 1) {

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 3; j++) {
							if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
								return k;
							}
							k++;
						}
					}
				}

				k = 0;

				if (presentChessBoard.getIsWaitingBorad() == 2) {

					for (int i = 5; i > 2; i--) {
						for (int j = 10; j > 7; j--) {
							if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
								return k;
							}
							k++;
						}
					}
				}


			}



		if(variantsNumber==1) {
			if (presentChessBoard.getIsWaitingBorad() == 1) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
							return k;
						}
						k++;
					}
				}
			}

			k = 0;

			if (presentChessBoard.getIsWaitingBorad() == 2) {

				for (int i = 8; i > 0; i--) {
					for (int j = 14; j > 11; j--) {
						if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
							return k;
						}
						k++;
					}
				}
			}


		}


		if(variantsNumber==2) {
			if (presentChessBoard.getIsWaitingBorad() == 1) {
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 3; j++) {
						if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
							return k;
						}
						k++;
					}
				}
			}

			k = 0;

			if (presentChessBoard.getIsWaitingBorad() == 2) {

				for (int i =7; i > 0; i--) {
					for (int j = 12; j > 9; j--) {
						if (presentChessBoard.getCoorX() == j && presentChessBoard.getCoorY() == i) {
							return k;
						}
						k++;
					}
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

		if(chess.getName()=="Boar"){
			if(chess.isEnemy()){
				return AIBoar;
			}else {
				return myBoar;
			}
		}

		if(chess.getName()=="Rabbit"){
			if(chess.isEnemy()){
				return AIRabbit;
			}else {
				return myRabbit;
			}
		}

           // this is useless return
        return myLionIcon ;

	}

	public Chess  SetNewPiece (Chess chess,int Y,int X ){

		if(chess.getName()=="Dog"){

			Dog dog = new Dog(Y, X, isEnemy);
				return dog;

		}

		if(chess.getName()=="Cat"){

			Cat cat = new Cat(Y, X, isEnemy);
			return cat;
		}

		if(chess.getName()=="Lion"){
			Lion Lion = new Lion(Y, X, isEnemy);
			return Lion;
		}

		if(chess.getName()=="Chick"){
			Chick Chick = new Chick(Y, X, isEnemy);
			return Chick;
		}

		if(chess.getName()=="Elephant"){
			Elephant Elephant = new Elephant(Y, X, isEnemy);
			return Elephant;
		}

		if(chess.getName()=="Giraffe"){
			Giraffe Giraffe = new Giraffe(Y, X, isEnemy);
			return Giraffe;
		}

		if(chess.getName()=="Boar"){
			Boar Boar = new Boar(Y, X, isEnemy);
			return Boar;
		}

		if(chess.getName()=="Rabbit"){
			Rabbit Rabbit = new Rabbit(Y, X, isEnemy);
			return Rabbit;
		}

		// this is useless return
		Rabbit Rabbit = new Rabbit(Y, X, isEnemy);
		return Rabbit;

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
