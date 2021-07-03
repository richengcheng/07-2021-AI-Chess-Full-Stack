package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Lion extends Chess {

    public Lion(int y,int x,boolean isEnemy){
        super(y,x,"Lion",1000,isEnemy);
    }

    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // 目标位置为空或者是敌人
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// 要前进的棋盘位置和当前位置的坐标差
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


