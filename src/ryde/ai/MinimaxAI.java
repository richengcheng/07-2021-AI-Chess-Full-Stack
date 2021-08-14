package ryde.ai;


import ryde.InternetChess.Chess;
import ryde.battle.ChessInfo;
import ryde.gui.ChessBoard;
import ryde.gui.ChessBoardPanel;
import ryde.battle.ChessInfoMinMax;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimaxAI  implements Runnable  {

    private List<List<Integer>> allAIChessWalkWayList = new ArrayList<List<Integer>>();
    private List<Integer> allAICapturedChessWalkWayList = new ArrayList<Integer>();

    private List<List<Integer>> allAIWalkWayValueList = new ArrayList<List<Integer>>();
    private List<List<Integer>> allAICapturedChessWalkWayValueList = new ArrayList<List<Integer>>();

    private List<List<Integer>> allPlayerChessWalkWayList = new ArrayList<List<Integer>>();


    public static HashMap<Integer, Integer> allPlayerChesswalkWayMap = new HashMap<Integer, Integer>();

    public HashMap<Integer, Integer> allAIChesswalkWayMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> allAICapturedChessWalkWayMap = new HashMap<Integer, Integer>();

    private boolean  checkingIsCapturedList= false;

    private int  variantsNumber;



    private static int PieceY=0,PieceX=0,numberOfWalkWay=0;
    public MinimaxAI(int variantsNumber){
        this.variantsNumber=variantsNumber;
        int X=0,Y=0;
/*
        if(variantsNumber==0){
            Y=6;X=11;
        }else if(variantsNumber==1){
            Y=9;X=15;
        }else {
            Y=8;X=13;
        }

       currentChessBoard = new ChessBoard[Y][X] ;
*/

    }


    /**
     * Find all the possible footholds of the board,
     * and add the selected result to the corresponding list
     */
    public void allSearch() {

        //if there is piece that AI captured
        if(variantsNumber==0) {
            if (ChessInfo.AICapturedPieceList.size() != 0) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 3; j < 8; j++) {

                        if (ChessBoardPanel.chessboard[i][j].getChess() == null) {
                            allAICapturedChessWalkWayList.add(i * 100 + j);
                            allAICapturedChessWalkWayMap.put(i * 100 + j, ChessBoardPanel.chessboard[i][j].getCoorY() * 100 +
                                    ChessBoardPanel.chessboard[i][j].getCoorX());
                        }

                    }
                }
            }
        }

        if(variantsNumber==1) {
            if (ChessInfo.AICapturedPieceList.size() != 0) {

                for (int i = 0; i < 7; i++) {
                    for (int j = 3; j < 12; j++) {

                        if (ChessBoardPanel.chessboard[i][j].getChess() == null) {
                            allAICapturedChessWalkWayList.add(i * 100 + j);
                            allAICapturedChessWalkWayMap.put(i * 100 + j, ChessBoardPanel.chessboard[i][j].getCoorY() * 100 +
                                    ChessBoardPanel.chessboard[i][j].getCoorX());
                        }

                    }
                }
            }
        }

        if(variantsNumber==2) {
            if (ChessInfo.AICapturedPieceList.size() != 0) {

                for (int i = 0; i < 6; i++) {
                    for (int j = 3; j <10; j++) {

                        if (ChessBoardPanel.chessboard[i][j].getChess() == null) {
                            allAICapturedChessWalkWayList.add(i * 100 + j);
                            allAICapturedChessWalkWayMap.put(i * 100 + j, ChessBoardPanel.chessboard[i][j].getCoorY() * 100 +
                                    ChessBoardPanel.chessboard[i][j].getCoorX());
                        }

                    }
                }
            }
        }


        for (int i = 0; i < ChessInfo.AIChessList.size(); i++) {
      allAIChessWalkWayList.add(ChessInfo.AIChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard, allAIChesswalkWayMap,variantsNumber));
        }

        for (int i = 0; i < ChessInfo.playerChessList.size(); i++) {
      allPlayerChessWalkWayList.add(ChessInfo.playerChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard, allPlayerChesswalkWayMap,variantsNumber));
        }
    }

    /**
     * Calculate the score for each move
     * 0 for first rank
     * 200 for second rank
     * 400 for third and fourth ranks
     * 600 for fourth and fourth ranks
     * 800 for fifth and fourth ranks
     * 800 for sixth and fourth ranks
     * 300 for the AI’s hand (ready to drop anywhere)
     */

    public int countValue(ChessInfoMinMax ChessInfoMinMax) {
        int highScore = 0;
        //I-th chess piece
        for (int i = 0; i < ChessInfoMinMax.AIPieceList.size(); i++) {

            //count  each piece value
            highScore =highScore+ ChessInfoMinMax.AIPieceList.get(i).getValue();


            switch(ChessInfoMinMax.AIPieceList.get(i).getCoorY()) {
                case 0:
                    break;
                case 1:
                    highScore=highScore+200; break;
                case 2:
                    highScore=highScore+400; break;
                case 3:
                    highScore=highScore+600; break;
                case 4:
                    highScore=highScore+800; break;
                case 5:
                    highScore=highScore+800; break;
                case 6:
                    highScore=highScore+800; break;
                case 7:
                    highScore=highScore+800; break;
                case 8:
                    highScore=highScore+800; break;
                case 9:
                    highScore=highScore+800; break;
            }

        }
         //count each value of AI Captured Piece
        for (int i = 0; i < ChessInfoMinMax.AICapturedPieceList.size(); i++) {
            highScore=highScore+300;
        }

        //count each value of player Captured Piece
        for (int i = 0; i < ChessInfoMinMax.playerPieceList.size(); i++) {
            highScore = highScore - ChessInfoMinMax.AIPieceList.get(i).getValue();
        }

        //count each value of player Captured Piece
        for (int i = 0; i < ChessInfoMinMax.PlayerCapturedPieceList.size(); i++) {
            highScore=highScore-300;
        }

        return highScore;
    }



    public int minimax( int depth, boolean maximizingplayer,ChessInfoMinMax preChessInfoMinMax, ChessBoard[][] currentChessBoard,List<Chess> AICapturedPieceList,
                       List<Chess> PlayerCapturedPieceList, List<Chess> AIPieceList, List<Chess> playerPieceList    ) {

        System.out.println("AIPieceList size "+ AIPieceList.size());
        System.out.println("current depth "+ depth);



        if (depth == 5) {
            System.out.println("!!current depth "+ depth+"value of best move                                        "+ countValue(preChessInfoMinMax));
            return countValue(preChessInfoMinMax);
        }






        if (maximizingplayer) {
            int BestMove = -10000000;
            //each AI piece
            List<Chess>  AIPieceListStore =new ArrayList<Chess>(AIPieceList);

            for (int j = 0; j < AIPieceListStore.size(); j++) {


            //    if(depth==0) {
                    for (int k = 0; k < AIPieceListStore.size(); k++) {
                        System.out.println("!!current depth       "+ depth+"                  !! get AIPieceList position " + AIPieceList.get(k).getCoorY() + "       " + AIPieceList.get(k).getCoorX());
                    }
            //    }

                List<Integer> allCurrentChessWalkWayList = new ArrayList<Integer>();
                //get walk way list of current piece
                allCurrentChessWalkWayList = AIPieceList.get(j).searchWalkableWay(currentChessBoard, variantsNumber);

                //check  each  walkable way  of current piece
                for (int i = 0; i < allCurrentChessWalkWayList.size(); i++) {

                    System.out.println("current depth "+ depth+"allCurrentChessWalkWayList size"+allCurrentChessWalkWayList.size());

                    {
                        int X1=0,Y1=0;

                        if(variantsNumber==0){
                            Y1=6;X1=11;
                        }else if(variantsNumber==1){
                            Y1=9;X1=15;
                        }else {
                            Y1=8;X1=13;
                        }

                        AIPieceList=new ArrayList<Chess>(AIPieceList);
                        playerPieceList=new ArrayList<Chess>(playerPieceList);
                        PlayerCapturedPieceList=new ArrayList<Chess>(PlayerCapturedPieceList);
                        AICapturedPieceList=new ArrayList<Chess>(AICapturedPieceList);
                        ChessBoard[][] currentChessBoardStore=new ChessBoard[Y1][X1];
                        currentChessBoardStore=currentChessBoard;

                        //set a new ChessInfor board which can store the current step infor
                        ChessInfoMinMax ChessInfoMinMax = new ChessInfoMinMax(currentChessBoardStore, AICapturedPieceList,
                                PlayerCapturedPieceList, AIPieceList, playerPieceList);

                        int Y = allCurrentChessWalkWayList.get(i) / 100;
                        int X = allCurrentChessWalkWayList.get(i) % 100;

                        //store the current piece information
                        Chess currentPiece = AIPieceList.get(j);


                        // if current board does not contain a piece which is enemy piece and this board is main working board
                        if (currentChessBoard[Y][X].getChess() == null && currentChessBoard[Y][X].getIsWaitingBorad() == 0) {

                            //remove the current piece from AI piece list
                            ChessInfoMinMax.AIPieceList.remove(j);

                            //update piece
                            currentPiece.setCoor(currentChessBoard[Y][X]);

                            // updated  chess board
                            ChessInfoMinMax.currentChessBoard[Y][X].setChess(null);

                            // updated  chess board
                            ChessInfoMinMax.currentChessBoard[Y][X].setChess(currentPiece);

                            //add the updated piece back
                            ChessInfoMinMax.AIPieceList.add(currentPiece);

                        }
                        // if current board does not contain a piece which is enemy piece and this board is main working board
                        else if (currentChessBoard[Y][X].getChess() != null && currentChessBoard[Y][X].getIsWaitingBorad() == 0) {

                            //remove the current piece from AI piece list
                            ChessInfoMinMax.AIPieceList.remove(j);

                            //get the players chess
                            Chess currentPlayerPiece = currentChessBoard[Y][X].getChess();

                            //update players piece list
                            ChessInfoMinMax.playerPieceList.remove(currentPlayerPiece);

                            //update AI piece location
                            currentPiece.setCoor(currentChessBoard[Y][X]);

                            // updated  chess board
                            ChessInfoMinMax.currentChessBoard[Y][X].setChess(null);

                            // updated  chess board
                            ChessInfoMinMax.currentChessBoard[Y][X].setChess(currentPiece);

                            //add the updated piece back
                            ChessInfoMinMax.AIPieceList.add(currentPiece);

                        }

                        int k=0;
                        System.out.println();

                        BestMove= maxValue(BestMove, minimax(depth + 1, maximizingplayer, ChessInfoMinMax, ChessInfoMinMax.currentChessBoard, ChessInfoMinMax.AICapturedPieceList,
                                ChessInfoMinMax.PlayerCapturedPieceList, ChessInfoMinMax.AIPieceList, ChessInfoMinMax.playerPieceList),depth,AIPieceList.get(j).getCoorY(),
                                AIPieceList.get(j).getCoorX(),allCurrentChessWalkWayList.get(i));
                       // System.out.println("current depth "+ depth+"current piece name is "+ AIPieceList.get(j).getName());



                    }

                }
            }
         System.out.println("current depth "+ depth+"value of best move                                        "+ BestMove);
            return BestMove;

        }
        return 0;
    }

    public int maxValue(int a,int b,int depth,int pieceY,int pieceX, int i){

        if(a<b){
            a=b;
            //record the destination at the root
            if(depth==0){
                PieceY=pieceY;
                PieceX=pieceX;
                numberOfWalkWay=i;
            }
        }

        return a;
    }


    public void moveToBestWay(ChessBoard[][] currentChessBoard,List<Chess> AICapturedPieceList,
                              List<Chess> PlayerCapturedPieceList, List<Chess> AIPieceList, List<Chess> playerPieceList) {
        PieceY=0;
        PieceX=0;
        numberOfWalkWay=0;
        int k=0;
        int X=0,Y=0;


        if(variantsNumber==0){
            Y=6;X=11;
        }else if(variantsNumber==1){
            Y=9;X=15;
        }else {
            Y=8;X=13;
        }

        ChessInfoMinMax preChessInfoMinMax= new ChessInfoMinMax();

        AIPieceList=new ArrayList<Chess>(AIPieceList);
        playerPieceList=new ArrayList<Chess>(playerPieceList);
        PlayerCapturedPieceList=new ArrayList<Chess>(PlayerCapturedPieceList);
        AICapturedPieceList=new ArrayList<Chess>(AICapturedPieceList);
        ChessBoard[][] currentChessBoardStore=new ChessBoard[Y][X];
        currentChessBoardStore=currentChessBoard;

        k= minimax(0, true, preChessInfoMinMax,
                currentChessBoardStore, AICapturedPieceList,
                PlayerCapturedPieceList, AIPieceList,  playerPieceList);


        System.out.println("k is "+k);
/*
        System.out.println("6666666666666666666666666666666666666666666666 "+ChessInfo.AIChessList.
                get(numberOfChess).getName());
        System.out.println("6666666666666666666666666666666666666666666666 "+ChessInfo.AIChessList.
                get(numberOfChess).getCoorX());
        System.out.println("6666666666666666666666666666666666666666666666 "+ChessInfo.AIChessList.
                get(numberOfChess).getCoorY());
        System.out.println("6666666666666666666666666666666666666666666666 "+ChessBoardPanel.chessboard[ChessInfo.AIChessList.
                get(numberOfChess).getCoorY()][ChessInfo.AIChessList.
                get(numberOfChess).getCoorX()].getCoorX());
        System.out.println("6666666666666666666666666666666666666666666666 "+ChessBoardPanel.chessboard[ChessInfo.AIChessList.
                get(numberOfChess).getCoorY()][ChessInfo.AIChessList.
                get(numberOfChess).getCoorX()].getCoorY());
        */
/*
        ChessBoardPanel.moveChess(ChessBoardPanel.chessboard[ChessInfo.AIChessList.
                get(numberOfChess).getCoorY()][ChessInfo.AIChessList.
                get(numberOfChess).getCoorX()],ChessBoardPanel.chessboard[numberOfWalkWay / 100][numberOfWalkWay % 100]);
        */

    }

    public void clearStatus() {

        allPlayerChessWalkWayList.clear();
        allAIChessWalkWayList.clear();

        allAICapturedChessWalkWayList.clear();

        allAIWalkWayValueList.clear();
        allAICapturedChessWalkWayValueList.clear();

        allPlayerChesswalkWayMap.clear();

        allAIChesswalkWayMap.clear();
        allAICapturedChessWalkWayMap.clear();

        checkingIsCapturedList=false;

        for (int i = 0; i < ChessInfo.AIChessList.size(); i++) {
            ChessInfo.AIChessList.get(i).setUnderAttack(false);
        }
        for (int i = 0; i < ChessInfo.playerChessList.size(); i++) {
            ChessInfo.playerChessList.get(i).setUnderAttack(false);
        }
    }


    public void run() {
        try {
            while (true) {
                if (!ChessBoardPanel.isPlayerTurn()) {
                    ChessBoardPanel.setPlayerTurn(true);
                    moveToBestWay(ChessBoardPanel.chessboard,ChessInfo.AICapturedPieceList,
                            ChessInfo.PlayerCapturedPieceList, ChessInfo.AIChessList,  ChessInfo.playerChessList);
                    System.out.println("111111111111111111111111111111111111111111111111111111111111 the destination "+PieceY+"     "+PieceX+"     "+numberOfWalkWay);
                    clearStatus();
                    ChessBoardPanel.turnToMyTrun(true);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
