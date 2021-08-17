package ryde.controller;

import ryde.gui.ChessBoard;
import ryde.gui.ChessBoardPanel;

public class boardCreatingController {
    private int variantsNumber;

    public boardCreatingController(int variantsNumber) {
        this.variantsNumber = variantsNumber;
    }


    public void creatingBorad() {

        //if it is 5*6 chess board shoji
        if (variantsNumber == 0) {
            ChessBoardPanel.chessboard = new ChessBoard[6][11];
            //chess board setting
            for (int i = 0; i < 6; i++) {

                //left waiting board setting
                for (int j = 0; j < 3; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 1);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);

                }
                //main chess play board
                for (int j = 3; j < 8; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 0);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }

                //right waiting board
                for (int j = 8; j < 11; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 2);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }
            }

        }


        //if it is 9*9 chess board shoji
        if (variantsNumber == 1) {
            ChessBoardPanel.chessboard = new ChessBoard[9][15];
            //chess board setting
            for (int i = 0; i < 9; i++) {
                //left waiting board setting
                for (int j = 0; j < 3; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 1);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }

                //main chess play board
                for (int j = 3; j < 12; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 0);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }
                //right waiting board
                for (int j = 12; j < 15; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 2);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }
            }

        }


        //if it is 7*8  chess board shoji
        if (variantsNumber == 2) {
            ChessBoardPanel.chessboard = new ChessBoard[8][13];
            //chess board setting
            for (int i = 0; i < 8; i++) {
                //left waiting board setting
                for (int j = 0; j < 3; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 1);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }

                //main chess play board
                for (int j = 3; j < 10; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 0);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }

                //right waiting board
                for (int j = 10; j < 13; j++) {
                    ChessBoardPanel.chessboard[i][j] = new ChessBoard(i, j, 2);
                    ChessBoardPanel.chessboard[i][j].setBounds(j * 55 + 54, i * 56 + 53, 63, 63);
                }
            }


        }


    }

}
