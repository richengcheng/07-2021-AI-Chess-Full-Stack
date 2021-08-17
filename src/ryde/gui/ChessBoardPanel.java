package ryde.gui;

import ryde.InternetChess.Chess;
import ryde.InternetChess.Lion;
import ryde.battle.ChessInfo;
import ryde.controller.PieceCreatingController;
import ryde.controller.PieceUpdatingController;
import ryde.controller.boardCreatingController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class ChessBoardPanel extends JPanel implements ActionListener {
    //Locale.setDefault(new Locale("en","US"));
    public static ImageIcon myChickIcon, myCatIcon, myDogIcon, myLionIcon, myChickPromoted, myCatPromoted, myElephant, myGiraffe, myBoar, myRabbit;
    public static ImageIcon AIChickIcon, AICatIcon, AIDogIcon, AILionIcon, AIChickPromoted, AICatPromoted, AIElephant, AIGiraffe, AIBoar, AIRabbit;
    public static boolean isSinglePlayer, isPlayerTurn;
    public static ChessBoard[][] chessboard;
    //private ChessInfo chessInfo=null;
    static JTextArea coverPanel;
    private static Chess myKing;
    private static Chess enemyKing;
    private static int variantsNumber;
    private static boolean isEnemy;
    private ChessBoard presentChessBoard = null;
    private JLabel chessboardLabel;
    private List<Chess> ChessList = new ArrayList<Chess>();

    //public static List<Chess> UpPlayerCapturedChessList=new ArrayList<Chess>();
    //public static List<Chess> DownPlayerCapturedChessList=new ArrayList<Chess>();


    public ChessBoardPanel(boolean isEnemy, boolean isSinglePlayer, int variantsNumber) {

        this.isEnemy = isEnemy;
        //at beginning the IsEnemy is false
        this.isSinglePlayer = isSinglePlayer;
        //so at beginning the isplayerTurn is ture,
        isPlayerTurn = !isEnemy;
        this.variantsNumber = variantsNumber;
        setLayout(null);

        ChessInfo.AIChessList.clear();
        ChessInfo.playerChessList.clear();
        ChessInfo.PlayerCapturedPieceList.clear();
        ChessInfo.AICapturedPieceList.clear();

        boardCreatingController BoardCreatingController = new boardCreatingController(this.variantsNumber);

        //controller set chess board
        BoardCreatingController.creatingBorad();




        //if it is 9*9 chess board shoji
        if (variantsNumber == 1) {

            //chess board setting
            for (int i = 0; i < 9; i++) {
                //left waiting board setting
                for (int j = 0; j < 15; j++) {
                    chessboard[i][j].addActionListener(this);
                    add(chessboard[i][j]);
                }
            }

            //set current board
            presentChessBoard = chessboard[0][0];
            initAllChesses(isEnemy, variantsNumber);
            chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard3.png"));
            chessboardLabel.setBounds(20, -39, 900, 700);
            add(chessboardLabel);
        }


        //if it is 5*6 chess board shoji
        if (variantsNumber == 0) {
            //chess board setting
            for (int i = 0; i < 6; i++) {
                //left waiting board setting
                for (int j = 0; j < 11; j++) {
                    chessboard[i][j].addActionListener(this);
                    add(chessboard[i][j]);
                }
            }

            //set current board
            presentChessBoard = chessboard[0][0];
            initAllChesses(isEnemy, variantsNumber);
            chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard1.png"));
            chessboardLabel.setBounds(-90, -125, 900, 700);
            add(chessboardLabel);
        }


        //if it is 7*8  chess board shoji
        if (variantsNumber == 2) {
            //chess board setting
            for (int i = 0; i < 8; i++) {
                //left waiting board setting
                for (int j = 0; j < 13; j++) {
                    chessboard[i][j].addActionListener(this);
                    add(chessboard[i][j]);
                }
            }


            //set current board
            presentChessBoard = chessboard[0][0];
            initAllChesses(isEnemy, variantsNumber);
            chessboardLabel = new JLabel(new ImageIcon("images/shogiBoard2.png"));
            chessboardLabel.setBounds(-35, -66, 900, 700);
            add(chessboardLabel);
        }


        // cover the
        coverPanel = new JTextArea();
        coverPanel.setBounds(0, 0, 1000, 1000);
        coverPanel.setOpaque(false);
        coverPanel.setEditable(false);
        coverPanel.setVisible(false);
        add(coverPanel);
        setComponentZOrder(coverPanel, 0);//set cover the board

        PieceUpdatingController PieceUpdatingController = new PieceUpdatingController(variantsNumber);

    }

    public static void moveChess(ChessBoard presentChessBoard, ChessBoard clickBoard) {

        // if current board contain a chess and this board is main working board
        if (clickBoard.getChess() != null && (presentChessBoard.getIsWaitingBorad() == 0)) {//
            Chess chessExange = clickBoard.getChess();
            Chess chessExange2 = clickBoard.getChess();
            //change the chess enemy state
            chessExange.setEnemy(!chessExange.isEnemy());
            //	ChessInfo.AIChessList.remove(chessExange2);
            //set the chess to be no promoted because it is the chess dead
            chessExange.setIsPromoted(false);
            if (clickBoard.getChess().isEnemy()) {

				PieceUpdatingController.AIgetpiece(chessExange2,chessExange);

            } else {

				PieceUpdatingController.Playergetpiece(chessExange2,chessExange);

            }
            System.out.println("chess moved by moveChess function ");

        } else if//Set captured piece to AI
        (clickBoard.getChess() == null && (presentChessBoard.getIsWaitingBorad() == 1)) {

            Chess chess = ChessInfo.AICapturedPieceList.get(getIndexFromWatingList(presentChessBoard));
            chess.setCoor(clickBoard);

            ChessInfo.AIChessList.add(chess);
            ChessInfo.AICapturedPieceList.remove(getIndexFromWatingList(presentChessBoard));

        } else if//Set captured piece to player
        (clickBoard.getChess() == null && (presentChessBoard.getIsWaitingBorad() == 2)) {

            Chess chess = ChessInfo.PlayerCapturedPieceList.get(getIndexFromWatingList(presentChessBoard));
            chess.setCoor(clickBoard);

            ChessInfo.playerChessList.add(chess);
            ChessInfo.PlayerCapturedPieceList.remove(getIndexFromWatingList(presentChessBoard));

        }

        //update the chess
        Chess chess = presentChessBoard.getChess();
        Chess chess2 = clickBoard.getChess();
        chess.setCoor(clickBoard);//update chess
        chess.setStep(chess.getStep() + 1);
        Icon icon = presentChessBoard.getIcon();
        presentChessBoard.setChess(null);//clean the chess at this current board
        presentChessBoard.setIcon(null);//clean the icon at this current board
        presentChessBoard = clickBoard;//
        presentChessBoard.setChess(chess);//set new chess at current board
        presentChessBoard.setIcon(icon);// set new icon at current board

        isGameOver(chess2);

        checkIsPromoted(presentChessBoard);// check if the chess is promoted

        System.out.println("AICapturedPieceList.size():" + ChessInfo.AICapturedPieceList.size());
        if (ChessInfo.AICapturedPieceList.size() > 0) {
            System.out.println(ChessInfo.AICapturedPieceList.get(0).getCoorX() + ChessInfo.AICapturedPieceList.get(0).getCoorY());
        }

    }

    public static void isGameOver(Chess chess) {
        if (chess == myKing) {
            JOptionPane.showMessageDialog(null, "we win", "infor", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        } else if (chess == enemyKing) {
            JOptionPane.showMessageDialog(null, "we lose", "infor", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);

        }
    }

    public static void turnToMyTrun(boolean isEnable) {
        MainPlayFrame.player1InfoJpanel.setMyTurn(isEnable);
        MainPlayFrame.player2InfoJpanel.setMyTurn(!isEnable);
        ChessBoardPanel.coverPanel.setVisible(!isEnable);
        isPlayerTurn = isEnable;
    }

    public static int getIndexFromWatingList(ChessBoard presentChessBoard) {

        int k = 0;

        if (variantsNumber == 0) {
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


        if (variantsNumber == 1) {
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


        if (variantsNumber == 2) {
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

                for (int i = 7; i > 0; i--) {
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
    public static ImageIcon getChessImage(Chess chess) {

        if (chess.getName() == "Dog") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIDogIcon;
            } else {
                return ChessBoardPanel.myDogIcon;
            }
        }

        if (chess.getName() == "Cat") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AICatIcon;
            } else {
                return ChessBoardPanel.myCatIcon;
            }
        }

        if (chess.getName() == "Lion") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AILionIcon;
            } else {
                return ChessBoardPanel.myLionIcon;
            }
        }

        if (chess.getName() == "Chick") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIChickIcon;
            } else {
                return ChessBoardPanel.myChickIcon;
            }
        }

        if (chess.getName() == "Elephant") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIElephant;
            } else {
                return ChessBoardPanel.myElephant;
            }
        }

        if (chess.getName() == "Giraffe") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIGiraffe;
            } else {
                return ChessBoardPanel.myGiraffe;
            }
        }

        if (chess.getName() == "Boar") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIBoar;
            } else {
                return ChessBoardPanel.myBoar;
            }
        }

        if (chess.getName() == "Rabbit") {
            if (chess.isEnemy()) {
                return ChessBoardPanel.AIRabbit;
            } else {
                return ChessBoardPanel.myRabbit;
            }
        }

        // this is useless return
        return ChessBoardPanel.myLionIcon;

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

    public static void checkIsPromoted(ChessBoard presentChessBoard) {
        //check if it is the chess that have promoted fucntion
        if (presentChessBoard.getChess().getName() == "Chick") {
            //check if this board can lead chess promoted
            if (presentChessBoard.getChess().checkIsPromotedNow()) {
                presentChessBoard.setIcon(null);//clean the icon at this current board
                if (presentChessBoard.getChess().isEnemy()) {
                    presentChessBoard.setIcon(new ImageIcon("images/ChickPromotedUp.png"));// set new icon at current board
                } else {
                    presentChessBoard.setIcon(new ImageIcon("images/ChickPromotedDown.png"));// set new icon at current board
                }
            }
        } else if (presentChessBoard.getChess().getName() == "Cat") {
            if (presentChessBoard.getChess().checkIsPromotedNow()) {
                presentChessBoard.setIcon(null);//clean the icon at this current board
                if (presentChessBoard.getChess().isEnemy()) {
                    presentChessBoard.setIcon(new ImageIcon("images/catPromotedUp.png"));// set new icon at current board
                } else {
                    presentChessBoard.setIcon(new ImageIcon("images/catPromotedDown.png"));// set new icon at current board
                }
            }
        }
    }

    public void initAllChesses(boolean isEnemy, int variantsNumber) {


        myChickIcon = new ImageIcon("images/chickenDown.png");
        myCatIcon = new ImageIcon("images/catDown.png");
        myDogIcon = new ImageIcon("images/dogDown.png");
        myLionIcon = new ImageIcon("images/lionDown.png");
        myChickPromoted = new ImageIcon("images/chickPromotedDown.png");
        myCatPromoted = new ImageIcon("images/catPromotedDown.png");
        myElephant = new ImageIcon("images/elephantDown.png");
        myGiraffe = new ImageIcon("images/giraffeDown.png");
        myBoar = new ImageIcon("images/boarDown.png");
        myRabbit = new ImageIcon("images/rabbitDown.png");

        AIChickIcon = new ImageIcon("images/chickenUp.png");
        AICatIcon = new ImageIcon("images/catUp.png");
        AIDogIcon = new ImageIcon("images/dogUp.png");
        AILionIcon = new ImageIcon("images/lionUp.png");
        AIChickPromoted = new ImageIcon("images/chickPromotedUp.png");
        AICatPromoted = new ImageIcon("images/catPromotedUp.png");
        AIElephant = new ImageIcon("images/elephantUp.png");
        AIGiraffe = new ImageIcon("images/giraffeUp.png");
        AIBoar = new ImageIcon("images/boarUp.png");
        AIRabbit = new ImageIcon("images/rabbitUp.png");


        int chessTypeChecking = 0;
        int countNumberOfPiece = 0;

        PieceCreatingController PieceCreatingController = new PieceCreatingController(isEnemy);
        if (variantsNumber == 0) {
            Lion lion = new Lion(0, 5, !isEnemy);
            chessboard[0][5].setIcon(AILionIcon);
            chessboard[0][5].setChess(lion);
            ChessInfo.AIChessListAdd(lion);

            /////////////////////////////////////////////AI
            for (int i = 0; i < 8; i++) {
                double b;
                b = Math.random() * 10;
                b = b / 2;
                int numberOfCurrentTypeOfPiece = (int) b;
                countNumberOfPiece = PieceCreatingController.setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
                        countNumberOfPiece, variantsNumber);
                chessTypeChecking++;
            }
            ////////////////////////////////////////////player
            chessTypeChecking = 0;
            countNumberOfPiece = 0;

            Lion lion2 = new Lion(5, 5, isEnemy);
            chessboard[5][5].setIcon(myLionIcon);
            chessboard[5][5].setChess(lion2);
            ChessInfo.playerChessList.add(lion2);


            PieceCreatingController.setPlayerChess(variantsNumber);


            if (isEnemy) {
                myKing = lion2;
                enemyKing = lion;
            } else {
                myKing = lion;
                enemyKing = lion2;
            }


        }


        if (variantsNumber == 1) {
            Lion lion = new Lion(0, 7, !isEnemy);
            chessboard[0][7].setIcon(AILionIcon);
            chessboard[0][7].setChess(lion);
            ChessInfo.AIChessListAdd(lion);

            /////////////////////////////////////////////AI
            for (int i = 0; i < 10; i++) {
                double b;
                b = Math.random() * 10;
                b = b / 2;
                int numberOfCurrentTypeOfPiece = (int) b;
                countNumberOfPiece = PieceCreatingController.setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
                        countNumberOfPiece, variantsNumber);
                chessTypeChecking++;
            }
            ////////////////////////////////////////////player
            chessTypeChecking = 0;
            countNumberOfPiece = 0;

            Lion lion2 = new Lion(8, 7, isEnemy);
            chessboard[8][7].setIcon(myLionIcon);
            chessboard[8][7].setChess(lion2);
            ChessInfo.playerChessList.add(lion2);


            PieceCreatingController.setPlayerChess(variantsNumber);


            if (isEnemy) {
                myKing = lion2;
                enemyKing = lion;
            } else {
                myKing = lion;
                enemyKing = lion2;
            }


        }


        if (variantsNumber == 2) {
            Lion lion = new Lion(0, 6, !isEnemy);
            chessboard[0][6].setIcon(AILionIcon);
            chessboard[0][6].setChess(lion);
            ChessInfo.AIChessListAdd(lion);

            /////////////////////////////////////////////AI
            for (int i = 0; i < 13; i++) {
                double b;
                b = Math.random() * 10;
                b = b / 2;
                int numberOfCurrentTypeOfPiece = (int) b;
                countNumberOfPiece = PieceCreatingController.setAIChess(isEnemy, chessTypeChecking, numberOfCurrentTypeOfPiece,
                        countNumberOfPiece, variantsNumber);
                chessTypeChecking++;
            }
            ////////////////////////////////////////////player
            chessTypeChecking = 0;
            countNumberOfPiece = 0;

            Lion lion2 = new Lion(7, 6, isEnemy);
            chessboard[7][6].setIcon(myLionIcon);
            chessboard[7][6].setChess(lion2);
            ChessInfo.playerChessList.add(lion2);

            PieceCreatingController.setPlayerChess(variantsNumber);

            if (isEnemy) {
                myKing = lion2;
                enemyKing = lion;
            } else {
                myKing = lion;
                enemyKing = lion2;
            }


        }


    }

    ;

    public void actionPerformed(ActionEvent e) {

        System.out.println("last current chess board" + presentChessBoard.getCoorY() + "          " + presentChessBoard.getCoorX());


        PieceUpdatingController.updateCapturedChessList(variantsNumber);
        ChessBoard clickBoard = (ChessBoard) e.getSource();//The current clicked position


        System.out.println("current click chess board" + clickBoard.getCoorY() + "          " + clickBoard.getCoorX());


        // checking if it is for down player
        if (MainPlayFrame.player1InfoJpanel.getMyTurn()) {

            //checking the click area
            if (presentChessBoard != null && presentChessBoard.getChess() != null) {
                //checking is the chess at the main play area
                //0 is main play area
                //1 is up players waiting board
                //2 is down players waiting board
                if (presentChessBoard.getIsWaitingBorad() == 0) {
                    //must at the main board
                    if (clickBoard.getIsWaitingBorad() == 0) {
                        if (clickBoard != presentChessBoard) {
                            //Here there is a judgment type, whether it is a piece that has died,
                            // and also to determine whether the piece is really dead on the board first,
                            // because it can not be mixed with the main board,
                            // otherwise it is not easy to judge, so write a more judgment program to judge, can be written here
                            boolean walkable = presentChessBoard.getChess().isWalkable(clickBoard, chessboard);
                            //Click on the location to advance
                            if (walkable) {
                                moveChess(presentChessBoard, clickBoard);
                                PieceUpdatingController.updateCapturedChessList(variantsNumber);
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
                    } else if (clickBoard.getIsWaitingBorad() == 2 && clickBoard.getChess() != null) {
                        presentChessBoard = clickBoard;// update
                        System.out.println("update captured  piece");
                    } else {
                        System.out.println("can not move");
                    }
                }
                // if the current Chess board is at up players waiting chess board
                // and must click at main play area
                else if (presentChessBoard.getIsWaitingBorad() == 2 && clickBoard.getIsWaitingBorad() == 0) {
                    //		System.out.println("544444444444444444444444444444444444");
                    // there need to check more
                    System.out.println("drop captured chess");
                    if (clickBoard.getChess() == null) {
                        moveChess(presentChessBoard, clickBoard);
                        turnToMyTrun(!isPlayerTurn);
                    } else if (clickBoard.getChess() != null && !clickBoard.getChess().isEnemy()) {
                        presentChessBoard = clickBoard;// update
                        System.out.println("update chess from captured  piece to board chess");
                    } else {
                        System.out.println("can not move");
                    }
                } else if (presentChessBoard.getIsWaitingBorad() == 0 && clickBoard.getIsWaitingBorad() == 2 && clickBoard.getChess() != null) {
                    //		System.out.println("544444444444444444444444444444444444");
                    // there need to check more
                    System.out.println("choose the captured chess");
                    presentChessBoard = clickBoard;// update
                } else if (presentChessBoard.getIsWaitingBorad() == 2 && clickBoard.getIsWaitingBorad() == 2) {

                    presentChessBoard = clickBoard;// update
                    System.out.println("update captured  piece");


                }
            } else {// get a new presentChessBoard from the main board area or the option chess area
                if (clickBoard.getChess() != null && (!clickBoard.getChess().isEnemy()) || clickBoard.getIsWaitingBorad() == 2) {
                    System.out.println("update present ChessBoard piece");
                    presentChessBoard = clickBoard;// update
                }
            }
            PieceUpdatingController.updateCapturedChessList(variantsNumber);

            System.out.println("ChessBoardPanel the size of AIChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(ChessInfo.AIChessList.size());

            System.out.println("ChessBoardPanel the size of playerChessList !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(ChessInfo.playerChessList.size());

            return;
        }

    }


}
