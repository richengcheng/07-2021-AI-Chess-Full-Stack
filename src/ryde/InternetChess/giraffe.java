package ryde.InternetChess;

import ryde.gui.ChessBoard;

public class giraffe  extends Chess {

    private int firstPlace;

    public giraffe(int y,int x,boolean isEnemy){
        super(y,x,"Giraffe",600,isEnemy);
        firstPlace=y;
    }

    @Override
    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // 目标位置为空或者是敌人
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;
            betweenX = this.getCoorX() - click.getCoorX();
            betweenY = this.getCoorY() - click.getCoorY();
            if (betweenX == 0) {// ←→
                for (int i = 1; i < Math.abs(getCoorY() - click.getCoorY());) {
                    if (getCoorY() > click.getCoorY())
                        i = -i;
                    if (bs[getCoorY() + i][getCoorX()].getChess() != null)
                        return false;
                    i = Math.abs(i) + 1;
                }
                return true;
            } else if (betweenY == 0) {// ↑↓
                for (int i = 1; i < Math.abs(getCoorX() - click.getCoorX());) {
                    if (getCoorX() > click.getCoorX())
                        i = -i;
                    if (bs[getCoorY()][getCoorX() + i].getChess() != null)
                        return false;
                    i = Math.abs(i) + 1;
                }
                return true;
            }
        }
        return false;
    }


}
