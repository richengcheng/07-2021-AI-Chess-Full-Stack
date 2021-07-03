package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Chick extends Chess {

    private int firstPlace;

    public Chick(int y, int x, boolean isEnemy) {
        super(y, x, "Chick", 100, isEnemy);
         firstPlace=y;
    }

    @Override
    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // 目标位置为空或者是敌人
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// 要前进的棋盘位置和当前位置的坐标差
            betweenX = getCoorX() - click.getCoorX();
            betweenY = getCoorY() - click.getCoorY();
            if(betweenX==0) {
                switch (betweenY) {
                    case 1:// ↓
                        if (!this.isEnemy())
                            return true;
                        break;
                    case -1:// ↑
                        if (this.isEnemy())
                            return true;
                        break;
                }
            }

        }
        return false;
    }
}
