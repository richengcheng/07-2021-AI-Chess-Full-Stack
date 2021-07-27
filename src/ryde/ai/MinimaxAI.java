package ryde.ai;


import ryde.InternetChess.Chess;
import ryde.battle.ChessInfo;
import ryde.gui.ChessBoard;
import ryde.gui.ChessBoardPanel;


import javax.swing.*;
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

    /**
     * Find all the possible footholds of the board,
     * and add the selected result to the corresponding list
     */
    public void allSearch() {

        //if there is piece that AI captured
        if(ChessInfo.AICapturedPieceList.size()!=0){

            for (int i = 0; i < 5; i++) {
                for (int j = 3; j < 8; j++) {

                    if (ChessBoardPanel.chessboard[i][j].getChess() == null) {
                        allAICapturedChessWalkWayList.add(i * 10 + j);
                        allAICapturedChessWalkWayMap.put(i * 10 + j, ChessBoardPanel.chessboard[i][j].getCoorY() * 10 +
                                ChessBoardPanel.chessboard[i][j].getCoorX());
                    }

                }
            }
        }


        for (int i = 0; i < ChessInfo.AIChessList.size(); i++) {
//			System.out.println("AI方"+ChessInfo.AIChessList.get(i).getName()+"可移动方位数 :"+ChessInfo.AIChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard,allAIChesswalkWayMap));
            allAIChessWalkWayList.add(ChessInfo.AIChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard, allAIChesswalkWayMap));
        }

        for (int i = 0; i < ChessInfo.playerChessList.size(); i++) {
//			System.out.println("我方"+ChessInfo.playerChessList.get(i).getName()+"可移动方位数 :"+ChessInfo.playerChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard,allPlayerChesswalkWayMap));
            allPlayerChessWalkWayList.add(ChessInfo.playerChessList.get(i).searchWalkableWay(ChessBoardPanel.chessboard, allPlayerChesswalkWayMap));
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

    public int countValue(List<Chess> AIChessList,List<Chess> AICapturedChessList) {
        int highScore = 0;
        //I-th chess piece
        for (int i = 0; i < AIChessList.size(); i++) {

            if(AIChessList.get(i).getName()=="Lion") {
                highScore = 10000000;
            }

            switch(AIChessList.get(i).getCoorY()) {
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
                    break;
            }

        }

        for (int i = 0; i < AICapturedChessList.size(); i++) {
            highScore=highScore+300;
        }

        return highScore;
    }


    public int minimax( int depth, boolean maximizingplayer, ChessBoard[][] currentChessBoard,List<Chess> AICaputerdPieceList,
                       List<Chess> PlayerCaputerdPieceList, List<Chess> AIPieceList,List<Chess> PlayerPieceList    ){

        if (depth ==0){

        }
        if(maximizingplayer){
            int maxEval = -10000000;

            //each AI piece
            for(int j=0;j<AIPieceList.size();j++) {

                List<Integer> allCurrentChessWalkWayList = new ArrayList<>();
                //get walk way list of current piece
                allCurrentChessWalkWayList = (AIPieceList.get(j).searchWalkableWay(currentChessBoard));

                for (int i = 0; i < allCurrentChessWalkWayList.size(); i++) {
                    // for each  child of chess  position


                    // move chess
                    {
                        int Y = allCurrentChessWalkWayList.get(i) % 10;
                        int X = allCurrentChessWalkWayList.get(i) / 10;

                        // if current board contain a chess and this board is main working board
                        if (currentChessBoard[Y][X].getChess() != null && AIPieceList.get(j).isEnemy() != currentChessBoard[Y][X].getChess().isEnemy()) {//

                            Chess chessExange = currentChessBoard[Y][X].getChess();

                            //change the chess enemy state
                            chessExange.setEnemy(!chessExange.isEnemy());
                            //	ChessInfo.AIChessList.remove(chessExange2);
                            //set the chess to be no promoted because it is the chess dead
                            chessExange.setIsPromoted(false);

                            if ( AIPieceList.get(j).isEnemy()) {
                                PlayerPieceList.remove(currentChessBoard[Y][X].getChess());
                                AICaputerdPieceList.add(chessExange);
                            } else {

                                AIPieceList.remove(currentChessBoard[Y][X].getChess());
                                PlayerCaputerdPieceList.add(chessExange);

                            }
                            System.out.println("chess moved by moveChess function ");

                        }

                        currentChessBoard[Y][X].setChess(null);
                        currentChessBoard[Y][X].setChess(AIPieceList.get(j));

                        //update
                        AIPieceList.get(j).setCoor(currentChessBoard[Y][X]);

                    }
                  //  chess.setCoorX(allCurrentChessWalkWayList.get(i) % 10);
                  //  chess.setCoorY(allCurrentChessWalkWayList.get(i) / 10);


                    int valueOfChid = minimax( depth - 1, maximizingplayer, currentChessBoard, AICaputerdPieceList,
                            PlayerCaputerdPieceList, AIPieceList, PlayerPieceList);

                    if (maxEval <= valueOfChid) {
                        maxEval = valueOfChid;
                    }
                }
            }

            return maxEval;


        }else{
            int minEval = 10000000;
            List<Integer> allCurrentChessWalkWayList = new ArrayList<>();
            allCurrentChessWalkWayList=(PlayerPieceList.get(1).searchWalkableWay(ChessBoardPanel.chessboard));
            for(int i=0;i<allCurrentChessWalkWayList.size();i++) {
                // for each  child of chess  position
               // chess.setCoorX(allCurrentChessWalkWayList.get(i)%10);
              //  chess.setCoorY(allCurrentChessWalkWayList.get(i)/10);
                minimax( depth-1,!maximizingplayer,currentChessBoard,AICaputerdPieceList,
                        PlayerCaputerdPieceList,  AIPieceList,PlayerPieceList  );
            }
            return minEval;
        }

    }



    //for minimax
    public void moveChessMinimax(ChessBoard [][]  chessboard, int X,int Y,Chess chess,List<Chess>  AICaputerdPieceList,
                                 List<Chess> PlayerCaputerdPieceList , List<Chess> AIPieceList,List<Chess> PlayerPieceList ) {

        // if current board contain a chess and this board is main working board
        if (chessboard[Y][X].getChess()!=null&& chess.isEnemy()!=chessboard[Y][X].getChess().isEnemy()) {//

            Chess chessExange = chessboard[Y][X].getChess();

           //change the chess enemy state
            chessExange.setEnemy(!chessExange.isEnemy());
            //	ChessInfo.AIChessList.remove(chessExange2);
            //set the chess to be no promoted because it is the chess dead
            chessExange.setIsPromoted(false);

            if (chess.isEnemy()) {
                PlayerPieceList.remove(chessboard[Y][X].getChess());
                AICaputerdPieceList.add(chessExange);
            }else {

                AIPieceList.remove(chessboard[Y][X].getChess());
                PlayerCaputerdPieceList.add(chessExange);

            }
            System.out.println("chess moved by moveChess function ");

        }

        chessboard[Y][X].setChess(null);
        chessboard[Y][X].setChess(chess);

        chess.setCoor(chessboard[Y][X]);

    }

    public void run() {
        try {
            while (true) {
                if (!ChessBoardPanel.isPlayerTurn()) {
                    ChessBoardPanel.setPlayerTurn(true);
                    ChessBoardPanel.turnToMyTrun(true);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
