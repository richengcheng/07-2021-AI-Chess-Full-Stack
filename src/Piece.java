
import java.util.ArrayList;

public class Piece {

    private Player player;
    private Square square;



    public Piece(Player owner, Square square){
       this.player=owner;
       this.square=square;
       this.square.placePiece(this);
    }


    public ArrayList<Square> getLegalMoves(){
        ArrayList<Square> LegalSquarelist = new ArrayList<Square>();
        return LegalSquarelist;
    }


    public void move(Square toSquare){
        /**if there is no piece in next Square*/
        if(toSquare.getPiece() == null) {
            this.square.cleanPiece();
            this.square = toSquare;
            toSquare.cleanPiece();
            toSquare.placePiece(this);
        }else{

            /**clean the relationship between the square and piece*/
            toSquare.getPiece().beCaptured(this.player);
            this.square.cleanPiece();
            this.square=toSquare;
            toSquare.cleanPiece();
            toSquare.placePiece(this);
        }
    }

    public void beCaptured(Player capturer){
        /**send to the user*/
        capturer.addPieceToHand(this);
        /** clean the square*/
        this.square.cleanPiece();
        this.player=capturer;
    }

    public void SetSquare(Square square){
        this.square=square;
    }

    public void SetOwner(Player capturer){
        this.player=capturer;
    }


    public Square getSquare(){
        return this.square;
    }

    public void SetNullSquare(){
         this.square=null;
    }


    public Player getOwner(){
       return this.player;
    }


}
