package ryde.InternetChess;

import ryde.gui.ChessBoard;

public class Boar extends Chess {

    private int firstPlace;

    public Boar(int y, int x, boolean isEnemy) {
        super(y, x, "Boar", 600, isEnemy);
        firstPlace = y;
    }

    @Override
    /**
     * Determine if the clicked position can be advanced
     * @param click Target location of the click
     * @param bs All boards
     * @return
     */

    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // Target location is empty or enemy
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// The difference between the coordinates of the board position to be advanced and the current position
            betweenX = Math.abs(this.getCoorX() - click.getCoorX());
            betweenY = Math.abs(this.getCoorY() - click.getCoorY());

            if (betweenX == 0) {// ↑↓

                if (isEnemy() == true) {

                    if((this.getCoorY() - click.getCoorY())<0) {
                        for (int i = 1; i < Math.abs(getCoorY() - click.getCoorY()); ) {
                            if (getCoorY() > click.getCoorY())
                                i = -i;
                            if (bs[getCoorY() + i][getCoorX()].getChess() != null)
                                return false;
                            i = Math.abs(i) + 1;
                        }
                        return true;
                    }else {
                        return false;
                    }

                } else {

                    if((this.getCoorY() - click.getCoorY())>0) {

                        for (int i = 1; i < Math.abs(getCoorY() - click.getCoorY()); ) {
                            if (getCoorY() > click.getCoorY())
                                i = -i;
                            if (bs[getCoorY() + i][getCoorX()].getChess() != null)
                                return false;
                            i = Math.abs(i) + 1;
                        }
                        return true;
                    }else {

                        return false;

                    }

                }

            }
            return false;

        }
        return false;
    }

}
