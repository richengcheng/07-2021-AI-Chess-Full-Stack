package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Chick extends Chess {

    private int firstPlace;

    private boolean IsPromoted=false;


    public Chick(int y, int x, boolean isEnemy) {
        super(y, x, "Chick", 100, isEnemy);
         firstPlace=y;
         IsPromoted=false;
    }

    @Override
    //testing if the chess board can let chess promoted
    public boolean checkIsPromotedNow(){

        if(IsPromoted){
            return true;
        }
        // check if it is human being's chess
        if(!this.isEnemy()){
               if(getCoorY()<2){
                   IsPromoted=true;
                   return true;
               }else {
                   return false;
               }
        }else {
            if(getCoorY()>3){
                IsPromoted=true;
                return true;
            }else {
                return false;
            }

        }

    }

    @Override
    public void setIsPromoted(boolean value) {
        this.IsPromoted = value;
    }

    @Override
    public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
        // The target location is empty or an enemy
        if (click.getChess() == null || click.getChess().isEnemy() != isEnemy()) {
            int betweenX, betweenY;// The coordinate difference between the position of the chessboard to be advanced and the current position
            betweenX = getCoorX() - click.getCoorX();
            betweenY = getCoorY() - click.getCoorY();
            // if the cat has not promoted yet
            if(!IsPromoted) {
                if (betweenX == 0) {
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
            }else { // the cat has promoted now
                switch (Math.abs(betweenX)) {
                    case 0:// ↑↓
                    {
                        //   System.out.println("7878787878787878787878778787");
                        if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0)
                            return true;
                        break;
                    }
                    case 1:// ←→↖↗↙↘
                    {
                        //    System.out.println("5656565565656565656565656565656565");
                        if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0) {
                            //up dog can not move  ↖↗
                            if(isEnemy()==true&&((this.getCoorY()-click.getCoorY())>0)){
                                return false;
                            }
                            //down dog can not move  ↙↘
                            if(isEnemy()==false&&((this.getCoorY()-click.getCoorY())<0)){
                                return false;
                            }
                            return true;
                        }
                        break;
                    }
                }

            }

        }
        return false;
    }
}
