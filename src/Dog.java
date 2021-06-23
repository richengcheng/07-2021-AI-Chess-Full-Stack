

import java.util.ArrayList;

public class Dog extends Piece {

    public Dog (Player owner, Square  square){
        super(owner,square);
    }

    public ArrayList<Square> getLegalMoves(){

        ArrayList<Square> LegalSquarelist = new ArrayList<Square>();


        /**  Lower half of the board */

        if(super.getOwner().getPosition()=="down") {

            //check left top Square
            if(super.getSquare().getRow()-1>=0&&super.getSquare().getCol()-1>=0){
                //get the left top Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()-1 ,  super.getSquare().getCol()-1 );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


            //check left mid Square
            if(super.getSquare().getRow()-1>=0){
                //get left mid Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()-1 ,  super.getSquare().getCol() );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }

            //check right top Square
            if(super.getSquare().getRow()-1>=0&&super.getSquare().getCol()+1<=4){
                //get right top Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()-1 ,  super.getSquare().getCol()+1 );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


            //check mid left  Square
            if(super.getSquare().getCol()-1>=0){
                //get mid left  Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow() ,  super.getSquare().getCol()-1);
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }

            //check mid right Square
            if(super.getSquare().getCol()+1<=4){
                //get mid left  Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow() ,  super.getSquare().getCol()+1);
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


            //check  mid bottom Square
            if(super.getSquare().getRow()+1<=5){
                //get mid bottom Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()+1 ,  super.getSquare().getCol() );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }

        }
        else{

            /**  Upper half of the board */


            //check left mid Square
            if(super.getSquare().getRow()-1>=0){
                //get left mid Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()-1 ,  super.getSquare().getCol() );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


            //check mid left  Square
            if(super.getSquare().getCol()-1>=0){
                //get mid left  Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow() ,  super.getSquare().getCol()-1);
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }

            //check mid right Square
            if(super.getSquare().getCol()+1<=4){
                //get mid left  Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow() ,  super.getSquare().getCol()+1);
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }



            //check left bottom Square
            if(super.getSquare().getRow()+1<=5&&super.getSquare().getCol()-1>=0){
                //get left bottom Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()+1 ,  super.getSquare().getCol()-1 );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }

            //check  mid bottom Square
            if(super.getSquare().getRow()+1<=5){
                //get mid bottom Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()+1 ,  super.getSquare().getCol() );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


            //check  right bottom Square
            if(super.getSquare().getRow()+1<=5&&super.getSquare().getCol()+1<=4){
                //get right bottom Square
                Square  square1=  super.getSquare().getGame().getSquare (super.getSquare().getRow()+1 ,  super.getSquare().getCol()+1 );
                if(square1.getPiece()==null){
                    LegalSquarelist.add(square1);
                }else {
                    //if it is same owner
                    if(square1.getPiece().getOwner()==super.getOwner()){

                    }else {
                        LegalSquarelist.add(square1);
                    }

                }

            }


        }




        return  LegalSquarelist;
    }
}