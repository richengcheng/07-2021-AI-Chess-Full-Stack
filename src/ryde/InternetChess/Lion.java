package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Lion extends Chess {

    public Lion(int y,int x,boolean isEnemy){
        super(y,x,"Lion",1000,isEnemy);
    }

    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // The target location is empty or an enemy
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// The coordinate difference between the position of the chessboard to be advanced and the current position
            betweenX = this.getCoorX() - click.getCoorX();
            betweenY = this.getCoorY() - click.getCoorY();
            switch (Math.abs(betweenX)) {
                case 0:// ↑↓↖↗↙↘
                {
                  //  System.out.println("99999999999999999999999999999999999999999999999");
                    if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0)
                        return true;
                    break;
                }
                case 1:// ←→↖↗↙↘
                {
               //     System.out.println("888888888888888888888888888888888888888888888");
                    if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0)
                        return true;
                    break;
                }
            }
        }
        return false;
    }


}


