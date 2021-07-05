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
        // The target location is empty or an enemy
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// The coordinate difference between the position of the chessboard to be advanced and the current position
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
