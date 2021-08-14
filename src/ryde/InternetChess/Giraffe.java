package ryde.InternetChess;

import ryde.gui.ChessBoard;

public class Giraffe extends Chess {

    private int firstPlace;

    public Giraffe(int y, int x, boolean isEnemy){
        super(y,x,"Giraffe",800,isEnemy);
        firstPlace=y;
    }

    @Override
    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {

        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;
            betweenX = this.getCoorX() - click.getCoorX();
            betweenY = this.getCoorY() - click.getCoorY();
            if (betweenX == 0) { // ↑↓
                for (int i = 1; i < Math.abs(getCoorY() - click.getCoorY());) {
                    if (getCoorY() > click.getCoorY())
                        i = -i;
                    if (bs[getCoorY() + i][getCoorX()].getChess() != null)
                        return false;
                    i = Math.abs(i) + 1;
                }
                return true;
            } else if (betweenY == 0) {// ←→
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
