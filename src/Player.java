

import java.util.ArrayList;

public class Player {


    private String Name;
    private int PlayerNumber;
    private boolean CheckWin = false;
    private Piece piece;
    private ArrayList <Piece> Hand = new  ArrayList <Piece>() ;
    private int initialLionRow;
    private String position ;
    public Player (String name, int playerNumber) {
           this.Name=name;
           this.PlayerNumber=playerNumber;
    }


    public String getName(){
        return this.Name;
    }

    public int getPlayerNumber(){
        return this.PlayerNumber;
    }

    public ArrayList <Piece> getHand(){
        return this.Hand;
    }


    public void addPieceToHand(Piece piece){
        this.Hand.add(piece);
    }

    public void dropPiece(Piece piece,Square square){
        this.Hand.remove(piece);
        piece.SetSquare(square);
        square.cleanPiece();
        square.placePiece(piece);
    }

    public void winGame(){
       this.CheckWin=true;
    }

    public boolean hasWon(){
      return this.CheckWin;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition(){
        return this.position;
    }
}
