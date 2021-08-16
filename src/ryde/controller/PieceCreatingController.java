package ryde.controller;

import ryde.InternetChess.*;
import ryde.battle.ChessInfo;
import ryde.gui.ChessBoardPanel;


import javax.swing.*;

public class PieceCreatingController {

   private boolean isEnemy;
   public  PieceCreatingController(boolean isEnemy){
       this.isEnemy=isEnemy;
    }

    public int  setAIChess (boolean isEnemy,int chessTypeChecking,int numberOfCurrentTypeOfPiece,
                            int countNumberOfPiece,int variantsNumber){




        int X=0,Y=0;




        if(variantsNumber==0) {

            for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

                Y = countNumberOfPiece / 3;
                X = countNumberOfPiece % 3 + 3;

                if (countNumberOfPiece == 2) {
                    countNumberOfPiece++;//because lion is already set
                    break;
                }

                if(chessTypeChecking==0) {

                    Cat cat1 = new Cat(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(cat1);
                    ChessBoardPanel.chessboard[Y][X].setIcon(  ChessBoardPanel.AICatIcon);
                    ChessBoardPanel.chessboard[Y][X].setChess(cat1);
                  //
                   // System.out.println("cat11!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+chessboard[Y][X].getChess().isEnemy());
                    countNumberOfPiece++;

                    if(X!=5){
                        int BetweenX = Math.abs(5 - X);
                        int newX=5+BetweenX;

                        Cat cat2 = new Cat(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(cat2);
                     //   ChessList.add(cat2);
                        ChessBoardPanel. chessboard[Y][newX].setIcon(ChessBoardPanel.AICatIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(cat2);

                    //    System.out.println("cat2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+chessboard[Y][newX].getChess().isEnemy());
                    }

                }

                if(chessTypeChecking==1) {
                    Dog dog =new Dog(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(dog);
                  //  ChessList.add(dog);
                    ChessBoardPanel.  chessboard[Y][X].setIcon(ChessBoardPanel.AIDogIcon);
                    ChessBoardPanel.   chessboard[Y][X].setChess(dog);
                    countNumberOfPiece++;

                    if(X!=5){
                        int BetweenX = Math.abs(5 - X);
                        int newX=5+BetweenX;

                        Dog dog2 =new Dog(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(dog2);
                      //  ChessList.add(dog2);
                        ChessBoardPanel.     chessboard[Y][newX].setIcon(ChessBoardPanel.AIDogIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(dog2);
                    }


                }

                if(chessTypeChecking>1&&countNumberOfPiece<7) {
                    Chick chick3 = new Chick(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(chick3);
                  //  ChessList.add(chick3);
                    ChessBoardPanel.   chessboard[Y][X].setIcon(ChessBoardPanel.AIChickIcon);
                    ChessBoardPanel.   chessboard[Y][X].setChess(chick3);
                    countNumberOfPiece++;

                    if(X!=5){
                        int BetweenX = Math.abs(5 - X);
                        int newX=5+BetweenX;

                        Chick chick4 = new Chick(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(chick4);
                     //   ChessList.add(chick4);
                        ChessBoardPanel.  chessboard[Y][newX].setIcon(ChessBoardPanel.AIChickIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(chick4);
                    }

                }


            }


        }



        if(variantsNumber==1) {

            for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

                Y = countNumberOfPiece / 5;
                X = countNumberOfPiece % 5 + 3;

                if(countNumberOfPiece==4){
                    countNumberOfPiece++;//because lion is already set
                    break;
                }

                if(chessTypeChecking==0) {

                    Cat cat1 = new Cat(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(cat1);
                    ChessBoardPanel.   chessboard[Y][X].setIcon(ChessBoardPanel.AICatIcon);
                    ChessBoardPanel.   chessboard[Y][X].setChess(cat1);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Cat cat2 = new Cat(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(cat2);
                        ChessBoardPanel.  chessboard[Y][newX].setIcon(ChessBoardPanel.AICatIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(cat2);
                    }

                }

                if(chessTypeChecking==1) {
                    Dog dog =new Dog(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(dog);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AIDogIcon);
                    ChessBoardPanel.  chessboard[Y][X].setChess(dog);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Dog dog2 =new Dog(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(dog2);
                        ChessBoardPanel. chessboard[Y][newX].setIcon(ChessBoardPanel.AIDogIcon);
                        ChessBoardPanel.   chessboard[Y][newX].setChess(dog2);
                    }

                }

                if(chessTypeChecking==2) {
                    Elephant elephant = new Elephant(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(elephant);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AIElephant);
                    ChessBoardPanel. chessboard[Y][X].setChess(elephant);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Elephant elephant2 = new Elephant(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(elephant2);
                        ChessBoardPanel.chessboard[Y][newX].setIcon(ChessBoardPanel.AIElephant);
                        ChessBoardPanel.chessboard[Y][newX].setChess(elephant2);
                    }

                }

                if(chessTypeChecking==3) {
                    Giraffe giraffe = new Giraffe(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(giraffe);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AIGiraffe);
                    ChessBoardPanel.chessboard[Y][X].setChess(giraffe);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Giraffe giraffe2 = new Giraffe(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(giraffe2);
                        ChessBoardPanel.chessboard[Y][newX].setIcon(ChessBoardPanel.AIGiraffe);
                        ChessBoardPanel.chessboard[Y][newX].setChess(giraffe2);
                    }

                }

                if(chessTypeChecking==4) {
                    Boar boar =new Boar(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(boar);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AIBoar);
                    ChessBoardPanel.chessboard[Y][X].setChess(boar);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Boar boar2 =new Boar(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(boar2);
                        ChessBoardPanel. chessboard[Y][newX].setIcon(ChessBoardPanel.AIBoar);
                        ChessBoardPanel. chessboard[Y][newX].setChess(boar2);
                    }

                }



                if(chessTypeChecking==5) {

                    Rabbit rabbit =new Rabbit(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(rabbit);
                    ChessBoardPanel. chessboard[Y][X].setIcon(ChessBoardPanel.AIRabbit);
                    ChessBoardPanel. chessboard[Y][X].setChess(rabbit);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Rabbit rabbit2 =new Rabbit(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(rabbit2);
                        ChessBoardPanel. chessboard[Y][newX].setIcon(ChessBoardPanel.AIRabbit);
                        ChessBoardPanel. chessboard[Y][newX].setChess(rabbit2);
                    }


                }

                if(chessTypeChecking>5&&countNumberOfPiece<10) {
                    Chick chick3 = new Chick(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(chick3);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AIChickIcon);
                    ChessBoardPanel. chessboard[Y][X].setChess(chick3);
                    countNumberOfPiece++;

                    if(X!=7){
                        int BetweenX = Math.abs(7 - X);
                        int newX=7+BetweenX;

                        Chick chick4 = new Chick(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(chick4);
                        ChessBoardPanel.  chessboard[Y][newX].setIcon(ChessBoardPanel.AIChickIcon);
                        ChessBoardPanel.   chessboard[Y][newX].setChess(chick4);

                    }


                }


            }


        }




        if(variantsNumber==2) {

            for (int i = 0; i < numberOfCurrentTypeOfPiece; i++) {

                Y = countNumberOfPiece / 4;
                X = countNumberOfPiece % 4 + 3;

                if(countNumberOfPiece==3){
                    countNumberOfPiece++;//because lion is already set
                    break;
                }

                if(chessTypeChecking==0) {

                    Cat cat1 = new Cat(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(cat1);
                    ChessBoardPanel.chessboard[Y][X].setIcon(ChessBoardPanel.AICatIcon);
                    ChessBoardPanel.   chessboard[Y][X].setChess(cat1);
                    countNumberOfPiece++;

                    if(X!=6){
                        int BetweenX = Math.abs(6 - X);
                        int newX=6+BetweenX;

                        Cat cat2 = new Cat(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(cat2);
                        ChessBoardPanel.chessboard[Y][newX].setIcon(ChessBoardPanel.AICatIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(cat2);
                    }


                }

                if(chessTypeChecking==1) {
                    Dog dog =new Dog(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(dog);
                    ChessBoardPanel.    chessboard[Y][X].setIcon(ChessBoardPanel.AIDogIcon);
                    ChessBoardPanel.   chessboard[Y][X].setChess(dog);
                    countNumberOfPiece++;

                    if(X!=6){
                        int BetweenX = Math.abs(6 - X);
                        int newX=6+BetweenX;

                        Dog dog2 =new Dog(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(dog2);
                        ChessBoardPanel. chessboard[Y][newX].setIcon(ChessBoardPanel.AIDogIcon);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(dog2);
                    }

                }


                if(chessTypeChecking==2) {
                    Boar boar =new Boar(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(boar);
                    ChessBoardPanel. chessboard[Y][X].setIcon(ChessBoardPanel.AIBoar);
                    ChessBoardPanel.    chessboard[Y][X].setChess(boar);
                    countNumberOfPiece++;

                    if(X!=6){
                        int BetweenX = Math.abs(6 - X);
                        int newX=6+BetweenX;

                        Boar boar2 =new Boar(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(boar2);
                        ChessBoardPanel.  chessboard[Y][newX].setIcon(ChessBoardPanel.AIBoar);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(boar2);
                    }

                }



                if(chessTypeChecking==3) {

                    Rabbit rabbit =new Rabbit(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(rabbit);
                    ChessBoardPanel. chessboard[Y][X].setIcon(ChessBoardPanel.AIRabbit);
                    ChessBoardPanel.   chessboard[Y][X].setChess(rabbit);
                    countNumberOfPiece++;

                    if(X!=6){
                        int BetweenX = Math.abs(6 - X);
                        int newX=6+BetweenX;

                        Rabbit rabbit2 =new Rabbit(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(rabbit2);
                        ChessBoardPanel.chessboard[Y][newX].setIcon(ChessBoardPanel.AIRabbit);
                        ChessBoardPanel.  chessboard[Y][newX].setChess(rabbit2);
                    }

                }

                if(chessTypeChecking>3&&countNumberOfPiece<8) {
                    Chick chick3 = new Chick(Y, X, !isEnemy);
                    ChessInfo.AIChessListAdd(chick3);
                    ChessBoardPanel. chessboard[Y][X].setIcon(ChessBoardPanel.AIChickIcon);
                    ChessBoardPanel.chessboard[Y][X].setChess(chick3);
                    countNumberOfPiece++;

                    if(X!=6){
                        int BetweenX = Math.abs(6 - X);
                        int newX=6+BetweenX;

                        Chick chick4 = new Chick(Y, newX, !isEnemy);
                        ChessInfo.AIChessListAdd(chick4);
                        ChessBoardPanel.chessboard[Y][newX].setIcon(ChessBoardPanel.AIChickIcon);
                        ChessBoardPanel. chessboard[Y][newX].setChess(chick4);
                    }

                }


            }


        }



        return countNumberOfPiece;
    }


    public void setPlayerChess(int variantsNumber ){

        int X=0,Y=0;
/*
		for (int i = 0; i < 6; i++) {
			for (int j = 3; j < 8; j++) {
				if(chessboard[i][j].getChess()!=null)
					System.out.println(		chessboard[i][j].getChess().isEnemy());
			}
		}
*/
        if(variantsNumber==0) {
            for(int i=0; i<ChessInfo.AIChessList.size();i++) {
                Chess chess1 = ChessInfo.AIChessList.get(i);


                if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
                    continue;
                }

                int newY=0;

                if(chess1.getCoorY()==0) {
                    newY =5;
                }

                if(chess1.getCoorY()==1) {
                    newY =4;
                }

                if(chess1.getCoorY()==2) {
                    newY =3;
                }

                // chess2.setEnemy(isEnemy);
                Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
                ChessBoardPanel.chessboard[newY][chess1.getCoorX()].setChess(chess3);
                ChessBoardPanel.chessboard[newY][chess1.getCoorX()].setIcon( ChessBoardPanel.getChessImage(chess3));
                ChessInfo.playerChessList.add(chess3);
            }

        }


        if(variantsNumber==1) {

            for(int i=0; i<ChessInfo.AIChessList.size();i++) {
                Chess chess1 = ChessInfo.AIChessList.get(i);


                if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
                    continue;
                }

                int newY=0;

                if(chess1.getCoorY()==0) {
                    newY =8;
                }

                if(chess1.getCoorY()==1) {
                    newY =7;
                }

                if(chess1.getCoorY()==2) {
                    newY =6;
                }

                if(chess1.getCoorY()==3) {
                    newY =5;
                }

                if(chess1.getCoorY()==4) {
                    newY =4;
                }


                // chess2.setEnemy(isEnemy);
                Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
                ChessBoardPanel. chessboard[newY][chess1.getCoorX()].setChess(chess3);
                ChessBoardPanel. chessboard[newY][chess1.getCoorX()].setIcon(ChessBoardPanel.getChessImage(chess3));
                ChessInfo.playerChessList.add(chess3);
            }


        }

        if(variantsNumber==2) {

            for(int i=0; i<ChessInfo.AIChessList.size();i++) {
                Chess chess1 = ChessInfo.AIChessList.get(i);


                if(ChessInfo.AIChessList.get(i).getName()=="Lion"){
                    continue;
                }

                int newY=0;

                if(chess1.getCoorY()==0) {
                    newY =7;
                }

                if(chess1.getCoorY()==1) {
                    newY =6;
                }

                if(chess1.getCoorY()==2) {
                    newY =5;
                }

                if(chess1.getCoorY()==3) {
                    newY =4;
                }

                // chess2.setEnemy(isEnemy);
                Chess chess3=SetNewPiece(chess1,newY,chess1.getCoorX());
                ChessBoardPanel.chessboard[newY][chess1.getCoorX()].setChess(chess3);
                ChessBoardPanel.chessboard[newY][chess1.getCoorX()].setIcon(ChessBoardPanel.getChessImage(chess3));
                ChessInfo.playerChessList.add(chess3);
            }



        }

    }



    public Chess  SetNewPiece (Chess chess,int Y,int X ){

        if(chess.getName()=="Dog"){

            Dog dog = new Dog(Y, X,  isEnemy);
            return dog;

        }

        if(chess.getName()=="Cat"){

            Cat cat = new Cat(Y, X, isEnemy);
            return cat;
        }

        if(chess.getName()=="Lion"){
            Lion Lion = new Lion(Y, X, isEnemy);
            return Lion;
        }

        if(chess.getName()=="Chick"){
            Chick Chick = new Chick(Y, X, isEnemy);
            return Chick;
        }

        if(chess.getName()=="Elephant"){
            Elephant Elephant = new Elephant(Y, X, isEnemy);
            return Elephant;
        }

        if(chess.getName()=="Giraffe"){
            Giraffe Giraffe = new Giraffe(Y, X, isEnemy);
            return Giraffe;
        }

        if(chess.getName()=="Boar"){
            Boar Boar = new Boar(Y, X, isEnemy);
            return Boar;
        }

        if(chess.getName()=="Rabbit"){
            Rabbit Rabbit = new Rabbit(Y, X, isEnemy);
            return Rabbit;
        }

        // this is useless return
        Rabbit Rabbit = new Rabbit(Y, X, isEnemy);
        return Rabbit;

    }




}
