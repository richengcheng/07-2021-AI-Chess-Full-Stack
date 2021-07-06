package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Cat extends Chess {

    private int firstPlace;
    private boolean IsPromoted=false;

    public Cat(int y,int x,boolean isEnemy){
        super(y,x,"Cat",400,isEnemy);
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
    public boolean isWalkable(ChessBoard b, ChessBoard[][] bs) {
        //
        if (b.getChess() == null || b.getChess().isEnemy()!=isEnemy()) {
            int betweenX, betweenY;//
            betweenX = this.getCoorX() - b.getCoorX();
            betweenY = this.getCoorY() - b.getCoorY();

            //if the cat is not promoted yet
            if(!IsPromoted) {
                switch (Math.abs(betweenX)) {
                    case 0:// ↑↓
                    {
                        if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0) {

                            //up cat can not move ↑
                            if (isEnemy() == true && ((this.getCoorY() - b.getCoorY()) > 0)) {
                                return false;
                            }

                            //down cat can not move  ↓
                            if (isEnemy() == false && ((this.getCoorY() - b.getCoorY()) < 0)) {
                                return false;
                            }

                            return true;
                        }
                        break;
                    }
                    case 1:// ↖↗↙↘
                    {
                        //down cat can not move  ←→
                        if (Math.abs(betweenY) == 0) {
                            return false;
                        }
                        if (Math.abs(betweenY) == 1) {
                            return true;
                        }
                        break;
                    }
                }
            }else { // if the cat is promoted so the walk way like a dog
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

            }

        }
        return false;
    }


}

