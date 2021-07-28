package ryde.InternetChess;

import ryde.gui.ChessBoard;

public class Elephant extends Chess {

    private int firstPlace;

    public Elephant(int y, int x, boolean isEnemy){
        super(y,x,"Elephant",600,isEnemy);
        firstPlace=y;
    }


    @Override
    public boolean isWalkable(ChessBoard b, ChessBoard[][] bs) {
        // The target location is empty or an enemy
        if (b.getChess() == null || b.getChess().isEnemy()!=isEnemy()) {
            int betweenX, betweenY;// The coordinate difference between the position of the chessboard to be advanced and the current position
            betweenX = this.getCoorX() - b.getCoorX();
            betweenY = this.getCoorY() - b.getCoorY();

            if (Math.abs(betweenX) == Math.abs(betweenY)) {// ↖↗↙↘
                int j = 1;
                for (int i = 1; i < Math.abs(getCoorY() - b.getCoorY());) {
                    if (getCoorY() > b.getCoorY())
                        i = -i;
                    if (getCoorX() > b.getCoorX())
                        j = -j;
                    if (bs[getCoorY() + i][getCoorX() + j].getChess() != null)
                        return false;
                    i = Math.abs(i) + 1;
                    j = Math.abs(j) + 1;
                }
                return true;
            }

        }

        return false;
    }


}
