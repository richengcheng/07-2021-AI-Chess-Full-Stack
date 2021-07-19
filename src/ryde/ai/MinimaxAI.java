package ryde.ai;


import ryde.InternetChess.Chess;
import ryde.battle.ChessInfo;
import ryde.gui.ChessBoardPanel;


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

    public void countValue() {
        int highScore = 0;
        //I-th chess piece
        for (int i = 0; i < allAIChessWalkWayList.size(); i++) {
            List<Integer> walkWayList = allAIChessWalkWayList.get(i);
            List<Integer> eachWayValueList = new ArrayList<Integer>();
            //The score of the j-th move of the i-th piece
            for (int j = 0; j < walkWayList.size(); j++) {
                //if the this  board  at current walk way is empty
                if (ChessBoardPanel.chessboard[walkWayList.get(j) / 10][walkWayList.get(j) % 10].getChess() == null) {
                    //Go forward and get a point
                    highScore++;
                } else {// if there is a enemy piece at this current walk way board
                    Chess chess = ChessBoardPanel.chessboard[walkWayList.get(j) / 10][walkWayList.get(j) % 10].getChess();
                    //AI gets the chess piece and scores the chess piece
                    highScore++;
                    highScore += chess.getValue();
                    // here we are assuming that board has no  piece
                    ChessBoardPanel.chessboard[walkWayList.get(j) / 10][walkWayList.get(j) % 10].setChess(null);
                    //Pieces eaten by AI are under the protection of the player, and points are reduced (except for the king)
                    //IF the that piece is not lion and also that board is under attack by Human beings, so that value of the
                    //piece min loose score

                    for (int k = 0; k < ChessInfo.playerChessList.size(); k++) {
                        if (/**!chess.getName().equals("king") &&*/ ChessInfo.playerChessList.get(k).isWalkable(ChessBoardPanel.
                                chessboard[walkWayList.get(j) / 10][walkWayList.get(j) % 10], ChessBoardPanel.chessboard)) {
                            highScore -= ChessInfo.AIChessList.get(i).getValue();
                        }
                    }

                    //set the piece back
                    ChessBoardPanel.chessboard[walkWayList.get(j) / 10][walkWayList.get(j) % 10].setChess(chess);

                }

                //The current maximum value of all AI chess pieces threatened
                int maxValue = 0;
                //AI chess pieces are threatened and unprotected
                for (int j2 = 0; j2 < ChessInfo.AIChessList.size(); j2++) {
                    //Firstly the AI chess is under attack now
                    //Secondly the underattacked piece has no protection from other AI piece
                    //also, need to check that the AI piece is checking other AI piece's walkway
                    if (ChessInfo.AIChessList.get(j2).isUnderAttack() && !allAIChesswalkWayMap.containsKey(walkWayList.get(j)) && j2 != i) {

                        if (ChessInfo.AIChessList.get(j2).getValue() > maxValue) {
                            maxValue = ChessInfo.AIChessList.get(j2).getValue();
                        }

                    }
                }

                //Deduct the maximum threat value points
                highScore -= maxValue;
                //	if the player can also reach that walk way board, which means if AI go there, next around the AI piece will be token
                // so totally it means this way is really really dangerous

                if (allPlayerChesswalkWayMap.containsKey(walkWayList.get(j))) {
                    //lose the score of the chess that will be token if go this way
                    highScore -= ChessInfo.AIChessList.get(i).getValue();
                }


                //The score of each move of the piece is saved into the list
                eachWayValueList.add(highScore);
                highScore = 0;
            }

            //The score list of each piece is saved into the total list
            allAIWalkWayValueList.add(eachWayValueList);
        }


        //test
        //	System.out.println("allAIWalkWayValueList: " + allAIWalkWayValueList);
    }


    public void countCapturedPieceWalkWayValue(){
        int highScore = 0;
        //I-th chess piece
        for (int i = 0; i < ChessInfo.AICapturedPieceList.size(); i++) {
            //List<Integer> walkWayList = allAIChessWalkWayList.get(i);
            List<Integer> eachWayValueList = new ArrayList<Integer>();
            //The score of the j-th move of the i-th piece
            for (int j = 0; j < allAICapturedChessWalkWayList.size(); j++) {
                //if the this  board  at current walk way is empty
                if (ChessBoardPanel.chessboard[allAICapturedChessWalkWayList.get(j) / 10][allAICapturedChessWalkWayList.get(j) % 10].getChess() == null) {
                    //Go forward and get a point
                    highScore++;
                    highScore++;
                    highScore=highScore+400;
                } else {// if there is a enemy piece at this current walk way board
                    Chess chess = ChessBoardPanel.chessboard[allAICapturedChessWalkWayList.get(j) / 10][allAICapturedChessWalkWayList.get(j) % 10].getChess();
                    //AI gets the chess piece and scores the chess piece
                    highScore++;
                    highScore++;
                    highScore += chess.getValue();
                    // here we are assuming that board has no  piece
                    ChessBoardPanel.chessboard[allAICapturedChessWalkWayList.get(j) / 10][allAICapturedChessWalkWayList.get(j) % 10].setChess(null);
                    //Pieces eaten by AI are under the protection of the player, and points are reduced (except for the king)
                    //IF the that piece is not lion and also that board is under attack by Human beings, so that value of the
                    //piece min loose score
                    for (int k = 0; k < ChessInfo.playerChessList.size(); k++) {
                        if (!chess.getName().equals("king") && ChessInfo.playerChessList.get(k).isWalkable(ChessBoardPanel.
                                chessboard[allAICapturedChessWalkWayList.get(j) / 10][allAICapturedChessWalkWayList.get(j) % 10], ChessBoardPanel.chessboard)) {
                            highScore -= chess.getValue();
                        }
                    }
                    //set the piece back
                    ChessBoardPanel.chessboard[allAICapturedChessWalkWayList.get(j) / 10][allAICapturedChessWalkWayList.get(j) % 10].setChess(chess);

                }


                //	if the player can also reach that walk way board, which means if AI go there, next around the AI piece will be token
                // so totally it means this way is really really dangerous
/**
 if (allPlayerChesswalkWayMap.containsKey(allAICapturedChessWalkWayList.get(j))) {
 //lose the score of the chess that will be token if go this way
 highScore -= ChessInfo.AIChessList.get(i).getValue();
 }
 */

                //The score of each move of the piece is saved into the list
                eachWayValueList.add(highScore);
                highScore = 0;
            }

            //The score list of each piece is saved into the total list
            allAICapturedChessWalkWayValueList.add(eachWayValueList);
        }

    }


    public void minimax(Chess chess,int depth,boolean maximizingplayer){

        if (depth ==0){

        }
        if(!maximizingplayer){
            int maxEval = -10000000;
            List<List<Integer>> allCurrentChessWalkWayList = new ArrayList<List<Integer>>();
            allCurrentChessWalkWayList.add(chess.searchWalkableWay(ChessBoardPanel.chessboard));
            for(int i=0;i<allCurrentChessWalkWayList.size();i++) {
                minimax(chess, depth - 1, maximizingplayer);
            }

        }else{
            int minEval = 10000000;
            minimax( chess,depth-1,!maximizingplayer);
        }

    }


    /**
     * According to the analysis of allWalkWayValueList, find out the move with the highest score
     *
     * @return Returns an integer, where the first two digits and
     * the last two digits are used as the two subscripts of allChessWalkWayList respectively
     */

    public int findBestWay() {
        int firstIndex = 0;
        int secondIndex = 0;
        int bestValue = -9999;
        int maxValueOfChessUnderAttacked = 0;
        int mostWalkWayOfNotUnderAttcked = -1;
        boolean hasChessUnderAttacked = false;
        // Find the value with the largest move value in the main board
        for (int i = 0; i < allAIWalkWayValueList.size(); i++) {
            for (int j = 0; j < allAIWalkWayValueList.get(i).size(); j++) {
                if (allAIWalkWayValueList.get(i).get(j) > bestValue) {
                    firstIndex = i;
                    secondIndex = j;
                    bestValue = allAIWalkWayValueList.get(i).get(j);
                }
                // test
                //	System.out.println(ChessInfo.AIChessList.get(i).getName() + " walkvalue :" + allAIWalkWayValueList.get(i).get(j));
            }
        }

        System.out.println("bestValue1 is "+bestValue);

        // Find the best value with the largest move value in waiting board chess
        for (int i = 0; i < ChessInfo.AICapturedPieceList.size(); i++) {
            for (int j = 0; j < allAICapturedChessWalkWayList.size(); j++) {
                if (allAICapturedChessWalkWayValueList.get(i).get(j) > bestValue) {
                    checkingIsCapturedList=true;
                    firstIndex = i;
                    secondIndex = j;
                    bestValue = allAICapturedChessWalkWayValueList.get(i).get(j);
                }
                // test
                //	System.out.println(		ChessInfo.AIChessList.get(i).getName() + " walkvalue :" + allAICapturedChessWalkWayValueList.get(i).get(j));
            }
        }

        System.out.println("bestValue2 is "+bestValue);

        // Filter the same maximum number of moves.
        // If the ones are threatened, choose the one with the greatest value.
        // If they are not threatened, choose the one with the most moves.
        for (int i = 0; i < allAIWalkWayValueList.size(); i++) {
            for (int j = 0; j < allAIWalkWayValueList.get(i).size(); j++) {

                if (allAIWalkWayValueList.get(i).get(j) == bestValue) {
                    //chess borad should be only at the main board firstly
                    //		System.out.println("the size of AI Chess list");
                    //		System.out.println(ChessInfo.AIChessList.size());
                    //		System.out.println("AI chess list X and Y ");
                    //		System.out.println(ChessInfo.AIChessList.get(i).getCoorX());
                    //		System.out.println(ChessInfo.AIChessList.get(i).getCoorY());

                    //check if the AI piece is underattacked
                    if (ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i).getCoorY()][ChessInfo.AIChessList.get(i)
                            .getCoorX()].getChess().isUnderAttack()) {
                        hasChessUnderAttacked = true;
                    }

                    // Whether there is a chess piece under threat
                    if (hasChessUnderAttacked) {
                        //Yes, choose the coordinates of the most valuable piece
                        if (ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i).getCoorY()][ChessInfo.AIChessList
                                .get(i).getCoorX()].getChess().isUnderAttack()
                                && ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i)
                                .getCoorY()][ChessInfo.AIChessList.get(i).getCoorX()].getChess()
                                .getValue() > maxValueOfChessUnderAttacked) {
                            firstIndex = i;
                            secondIndex = j;
                            maxValueOfChessUnderAttacked = ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i)
                                    .getCoorY()][ChessInfo.AIChessList.get(i).getCoorX()].getChess().getValue();
                            //	System.out.println(ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i)*	.getCoorY()][ChessInfo.AIChessList.get(i).getCoorX()].getChess().getName() + "AI Piece is under attacked");
                        }
                    } else {
                        //None, choose the coordinates of the pieces with the most moves
                        if (allAIWalkWayValueList.get(i).size() > mostWalkWayOfNotUnderAttcked
                                && ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(i).getCoorY()][ChessInfo.AIChessList.
                                get(i).getCoorX()].getChess().getValue() < 1108) {
                            firstIndex = i;
                            secondIndex = j;
                            mostWalkWayOfNotUnderAttcked = allAIWalkWayValueList.get(i).size();
                        }
                    }

                }
            }

        }
        return firstIndex * 100 + secondIndex;
    }

    /**
     * go ahead
     */
    public void moveToBestWay() {
        allSearch(); // first step
        countValue();// second step
        countCapturedPieceWalkWayValue();//third step
        int index1 = findBestWay();
        for (int x=0;x<ChessInfo.AIChessList.size();x++){
            System.out.println(ChessInfo.AIChessList.get(x).getName());
        }
        System.out.println("allAIChessWalkWayList"+allAIChessWalkWayList);
        System.out.println(findBestWay());


        //if the best way piece is at waiting board
        if(checkingIsCapturedList) {
            System.out.println("878787878787878787878787887878787878787878787878787878787887878787878787878787878787878787887878787878787878787878787878787878787878");
            System.out.println(ChessInfo.AICapturedPieceList.get(index1 / 100).getCoorY());
            System.out.println(ChessInfo.AICapturedPieceList.get(index1 / 100).getCoorX());
            int index3 = allAICapturedChessWalkWayList.get(index1 %100);

            ChessBoardPanel.moveChess(
                    ChessBoardPanel.chessboard[ChessInfo.AICapturedPieceList.
                            get(index1 / 100).getCoorY()][ChessInfo.AICapturedPieceList.get(index1 / 100).getCoorX()],
                    ChessBoardPanel.chessboard[index3 / 10][index3 % 10]);
        }else {

            int index2 = allAIChessWalkWayList.get(index1 / 100).get(index1 % 100);
            ChessBoardPanel.moveChess(
                    ChessBoardPanel.chessboard[ChessInfo.AIChessList.get(index1 / 100).
                            getCoorY()][ChessInfo.AIChessList.get(index1 / 100).getCoorX()],
                    ChessBoardPanel.chessboard[index2 / 10][index2 % 10]);
        }
    }

    /**
     * Clear
     */
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
                    moveToBestWay();
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
