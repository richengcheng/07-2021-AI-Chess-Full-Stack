package ryde.InternetChess;

import ryde.gui.ChessBoard;

import java.util.ArrayList;

public class Cat extends Chess {

    private int firstPlace;

    public Cat(int y,int x,boolean isEnemy){
        super(y,x,"Cat",400,isEnemy);
        firstPlace=y;
    }


    @Override
    public boolean isWalkable(ChessBoard b, ChessBoard[][] bs) {
        // 目标位置为空或者是敌人
        if (b.getChess() == null || b.getChess().isEnemy()!=isEnemy()) {
            int betweenX, betweenY;// 要前进的棋盘位置和当前位置的坐标差
            betweenX = this.getCoorX() - b.getCoorX();
            betweenY = this.getCoorY() - b.getCoorY();


            switch (Math.abs(betweenX)) {
                case 0:// ↑↓
                {
                    if (Math.abs(betweenY) == 1 || Math.abs(betweenY) == 0) {

                        //up cat can not move ↑
                        if(firstPlace==0&&((this.getCoorY()-b.getCoorY())>0)){
                            return false;
                        }

                        //down cat can not move  ↓
                        if(firstPlace==5&&((this.getCoorY()-b.getCoorY())<0)){
                            return false;
                        }

                        return true;
                    }
                    break;
                }
                case 1:// ↖↗↙↘
                {
                    //down cat can not move  ←→
                    if(Math.abs(betweenY) == 0){
                        return false;
                    }
                    if (Math.abs(betweenY) == 1) {
                        return true;
                    }
                    break;
                }
            }

        }
        return false;
    }


}

