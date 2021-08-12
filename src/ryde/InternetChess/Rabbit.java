package ryde.InternetChess;

import ryde.gui.ChessBoard;

public class Rabbit extends Chess {

    private int firstPlace;

    public Rabbit(int y, int x, boolean isEnemy){
        super(y,x,"Rabbit",600,isEnemy);
        firstPlace=y;
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
        if (click.getChess() == null || click.getChess().isEnemy()!=isEnemy()) {
            int betweenX, betweenY;// The difference between the coordinates of the board position to be advanced and the current position
            betweenX = Math.abs(this.getCoorX() - click.getCoorX());
            betweenY = Math.abs(this.getCoorY() - click.getCoorY());

           if (Math.abs(betweenX)==1&&Math.abs(betweenY) == 2) {


                        if(isEnemy()==true){

                            if(this.getCoorY()-click.getCoorY()==-2)
                                return true;
                            else
                                return false;
                        }else {

                            //down rabbit can not move  ↙↘
                            if (this.getCoorY() - click.getCoorY()==2)
                                return true;
                            else
                                return false;
                        }


            }
        }
        return false;
    }
}



