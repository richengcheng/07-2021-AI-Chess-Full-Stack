package ryde.InternetChess;
/**
public class PromotablePiece extends Piece {

    private int promoteCheck =0; //checking

    public PromotablePiece (Player owner, Square  square){
     super(owner,square);
    }

    public boolean getIsPromoted(){
        return true;
    }



    public void promote(){
       this.promoteCheck=1;
    }

    public int getPromote(){
        return  this.promoteCheck;
    }
*/
    /**override*/

  /**  public void move(Square toSquare){
        /**if there is no piece in next Square*/
 /**       if(toSquare.getPiece() == null) {
           super.getSquare().cleanPiece();
            super.SetSquare(toSquare);
            toSquare.cleanPiece();
            toSquare.placePiece(this);
        }else{*/
            /**clean the relationship between the square and piece*/
      /**      toSquare.getPiece().beCaptured(super.getOwner());
            super.getSquare().cleanPiece();
            super.SetSquare(toSquare);
            toSquare.cleanPiece();
            toSquare.placePiece(this);
        }

        Checkingpromote(toSquare);
    }

    public void Checkingpromote(Square toSquare){
         if( toSquare.getPromotesPlayer()==null)
             this.promoteCheck=0;
        else if(super.getOwner()!=toSquare.getPromotesPlayer())
             this.promoteCheck=1;

    }

}
*/