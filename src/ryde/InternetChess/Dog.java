package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Dog extends Chess {
    private int firstPlace;

    public Dog(int y,int x,boolean isEnemy){
        super(y,x,"Dog",600,isEnemy);
        firstPlace=y;
    }


    @Override
    public boolean isWalkable(ChessBoard b, ChessBoard[][] bs) {
        // The target location is empty or an enemy
        if (b.getChess() == null || b.getChess().isEnemy()!=isEnemy()) {
            int betweenX, betweenY;// The coordinate difference between the position of the chessboard to be advanced and the current position
            betweenX = this.getCoorX() - b.getCoorX();
            betweenY = this.getCoorY() - b.getCoorY();


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
                        if(isEnemy()==true&&((this.getCoorY()-b.getCoorY())>0)){
                            return false;
                        }
                        //down dog can not move  ↙↘
                        if(isEnemy()==false&&((this.getCoorY()-b.getCoorY())<0)){
                            return false;
                        }
                        return true;
                    }
                    break;
                }
            }
            /**
            switch (betweenY) {
                case 1:// ↑
                    if (firstPlace == 3)
                        return true;
                    break;
                case -1:// ↓
                    if (firstPlace == 2)
                        return true;
                    break;
            }
            */

            /**
            if (Math.abs(betweenX) == Math.abs(betweenY)) {// ↖↗↙↘
                int j=1;
                for (int i = 1; i < Math.abs(getCoorY() - b.getCoorY());) {
                    if (getCoorY() > b.getCoorY())
                        i = -i;
                    if (getCoorX() > b.getCoorX())
                        j=-j;
                    //if there is a chess, can not move
                    if (bs[getCoorY() + i][getCoorX()+j].getChess() != null)
                        return false;
                    i = Math.abs(i) + 1;
                    j=Math.abs(j) + 1;
                }
                return true;
            }*/
        }
        return false;
    }


}