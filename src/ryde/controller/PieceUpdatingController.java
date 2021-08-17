package ryde.controller;

import ryde.battle.ChessInfo;
import ryde.gui.ChessBoardPanel;
import ryde.InternetChess.Chess;


public class PieceUpdatingController {

    private int variantsNumber;

    public PieceUpdatingController(int variantsNumber)
    {
        this.variantsNumber=variantsNumber;
    }
    public static void AIgetpiece(Chess chessExange2, Chess chessExange){
        ChessInfo.playerChessList.remove(chessExange2);
        ChessInfo.AICapturedPieceList.add(chessExange);
    }
    public static void Playergetpiece(Chess chessExange2, Chess chessExange){
        ChessInfo.AIChessList.remove(chessExange2);
        ChessInfo.PlayerCapturedPieceList.add(chessExange);
    }
    public  static  void updateCapturedChessList(int variantsNumber){
        //clear waiting board

        if(variantsNumber==0) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {

                    ChessBoardPanel. chessboard[i][j].setChess(null);
                    ChessBoardPanel.    chessboard[i][j].setIcon(null);
                }
            }

            for (int i = 5; i > 0; i--) {
                for (int j = 10; j > 7; j--) {
                    ChessBoardPanel. chessboard[i][j].setChess(null);
                    ChessBoardPanel.  chessboard[i][j].setIcon(null);

                }
            }


            //set chess
            int k = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
                        ChessBoardPanel. chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
                        ChessBoardPanel.  chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.AICapturedPieceList.get(k)));
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
                        ChessBoardPanel. chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
                        ChessBoardPanel.  chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
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

                    ChessBoardPanel.chessboard[i][j].setChess(null);
                    ChessBoardPanel.  chessboard[i][j].setIcon(null);
                }
            }

            for (int i = 8; i > 0; i--) {
                for (int j = 14; j > 11; j--) {
                    ChessBoardPanel.  chessboard[i][j].setChess(null);
                    ChessBoardPanel.  chessboard[i][j].setIcon(null);

                }
            }

            //set chess
            int k = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
                        ChessBoardPanel. chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
                        ChessBoardPanel. chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.AICapturedPieceList.get(k)));
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
                        ChessBoardPanel. chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
                        ChessBoardPanel.  chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
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

                    ChessBoardPanel.   chessboard[i][j].setChess(null);
                    ChessBoardPanel.     chessboard[i][j].setIcon(null);
                }
            }

            for (int i = 7; i > 0; i--) {
                for (int j = 12; j > 9; j--) {
                    ChessBoardPanel.  chessboard[i][j].setChess(null);
                    ChessBoardPanel.  chessboard[i][j].setIcon(null);

                }
            }


            //set chess
            int k = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 3; j++) {
                    if (k < ChessInfo.AICapturedPieceList.size() && ChessInfo.AICapturedPieceList.get(k) != null) {
                        ChessBoardPanel. chessboard[i][j].setChess(ChessInfo.AICapturedPieceList.get(k));
                        ChessBoardPanel. chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.AICapturedPieceList.get(k)));
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
                        ChessBoardPanel.  chessboard[i][j].setChess(ChessInfo.PlayerCapturedPieceList.get(k));
                        ChessBoardPanel. chessboard[i][j].setIcon(ChessBoardPanel.getChessImage(ChessInfo.PlayerCapturedPieceList.get(k)));
                        //updateChess infor
                        ChessInfo.PlayerCapturedPieceList.get(k).setCoorX(j);
                        ChessInfo.PlayerCapturedPieceList.get(k).setCoorY(i);
                        k++;
                    }

                }
            }
        }


    };


}
