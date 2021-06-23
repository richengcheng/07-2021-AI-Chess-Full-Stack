

import java.util.ArrayList;

public class Cat extends PromotablePiece {

    private int beCapturedCheck=0; //capture check

    public  Cat (Player owner, Square  square){
            super(owner,square);
        }

    public boolean getIsPromoted(){

        if(beCapturedCheck==1){
            return false;
        }
        else if(super.getPromote()==1){
            return true;
        }
        return false;
    }


    public void beCaptured(Player capture){

        if(getIsPromoted()==true){
            this.beCapturedCheck=1;
        }
        capture.addPieceToHand(this);
        /** clean the square*/
        super.SetNullSquare();
        /**change the owner */
        super.SetOwner(capture);

    }



    public ArrayList<Square> getLegalMoves(){

        ArrayList<Square> LegalSquarelist = new ArrayList<Square>();


       if(super.getPromote()==0) {

           /**   no  Promote,Lower half of the board */
           if (super.getOwner().getPosition() == "down") {

               //check left top Square
               if (super.getSquare().getRow() - 1 >= 0 && super.getSquare().getCol() - 1 >= 0) {
                   //get the left top Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() - 1, super.getSquare().getCol() - 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check  mid top Square
               if (super.getSquare().getRow() - 1 >= 0) {
                   //get left mid Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() - 1, super.getSquare().getCol());
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }

               //check right top Square
               if (super.getSquare().getRow() - 1 >= 0 && super.getSquare().getCol() + 1 <= 4) {
                   //get right top Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() - 1, super.getSquare().getCol() + 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check left bottom Square
               if (super.getSquare().getRow() + 1 <= 5 && super.getSquare().getCol() - 1 >= 0) {
                   //get left bottom Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() + 1, super.getSquare().getCol() - 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check  right bottom Square
               if (super.getSquare().getRow() + 1 <= 5 && super.getSquare().getCol() + 1 <= 4) {
                   //get right bottom Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() + 1, super.getSquare().getCol() + 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }
           }
           /**  no  Promote, upper half of the board */
           else {


               //check left top Square
               if (super.getSquare().getRow() - 1 >= 0 && super.getSquare().getCol() - 1 >= 0) {
                   //get the left top Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() - 1, super.getSquare().getCol() - 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check right top Square
               if (super.getSquare().getRow() - 1 >= 0 && super.getSquare().getCol() + 1 <= 4) {
                   //get right top Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() - 1, super.getSquare().getCol() + 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check left bottom Square
               if (super.getSquare().getRow() + 1 <= 5 && super.getSquare().getCol() - 1 >= 0) {
                   //get left bottom Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() + 1, super.getSquare().getCol() - 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }

               //check  mid bottom Square
               if (super.getSquare().getRow() + 1 <= 5) {
                   //get mid bottom Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() + 1, super.getSquare().getCol());
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }


               //check  right bottom Square
               if (super.getSquare().getRow() + 1 <= 5 && super.getSquare().getCol() + 1 <= 4) {
                   //get right bottom Square
                   Square square1 = super.getSquare().getGame().getSquare(super.getSquare().getRow() + 1, super.getSquare().getCol() + 1);
                   if (square1.getPiece() == null) {
                       LegalSquarelist.add(square1);
                   } else {
                       //if it is same owner
                       if (square1.getPiece().getOwner() == super.getOwner()) {

                       } else {
                           LegalSquarelist.add(square1);
                       }

                   }

               }

           }
       }else {



           /**  Promote,Lower half of the board */
           if (super.getOwner().getPosition() == "down") {
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


           }else {


               /** Promote, Upper half of the board */
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

       }

        return  LegalSquarelist;
    }


    public int getBeCapturedCheck(){
        return this.beCapturedCheck;
    }

}

