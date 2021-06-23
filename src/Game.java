
import java.util.ArrayList;


public class Game {

    private int HEIGHT = 6;
    private int WIDTH = 5;

    private Player player1;
    private Player player2;
    private ArrayList<Square> SquareList = new ArrayList<Square>();

    public Game(Player p, Player p1) {
        this.player1 = p;
        this.player2 = p1;
        /** setting direction for checking position of user in the chess ground*/
        this.player1.setPosition("up");
        this.player2.setPosition("down");
        Initialize_Chess(p,p1);
    }

    /**creating whole environment with 30 square*/
    private void Initialize_Chess(Player player2, Player player1){

        //row 1
        Square Cat1Square_Player2 = new Square(this, 0, 0, this.player1);
        Cat1Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Cat1Square_Player2);

        Square Dog1Square_Player2 = new Square(this, 0, 1, this.player1);
        Dog1Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Dog1Square_Player2);

        Square LiOnSquare_Player2 = new Square(this, 0, 2, this.player1);
        LiOnSquare_Player2.PieceInitialize(player2);
        this.SquareList.add(LiOnSquare_Player2);

        Square Dog2Square_Player2 = new Square(this, 0, 3, this.player1);
        Dog2Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Dog2Square_Player2);

        Square Cat2Square_Player2 = new Square(this, 0, 4, this.player1);
        Cat2Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Cat2Square_Player2);

        // row2
        this.SquareList.add(new Square(this, 1, 0, this.player1));
        this.SquareList.add(new Square(this, 1, 1, this.player1));
        this.SquareList.add(new Square(this, 1, 2, this.player1));
        this.SquareList.add(new Square(this, 1, 3, this.player1));
        this.SquareList.add(new Square(this, 1, 4, this.player1));

        // row3
        this.SquareList.add(new Square(this, 2, 0));

        Square Chick1Square_Player2 = new Square(this, 2, 1);
        Chick1Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Chick1Square_Player2);

        Square Chick2Square_Player2 = new Square(this, 2, 2);
        Chick2Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Chick2Square_Player2);

        Square Chick3Square_Player2 = new Square(this, 2, 3);
        Chick3Square_Player2.PieceInitialize(player2);
        this.SquareList.add(Chick3Square_Player2);

        this.SquareList.add(new Square(this, 2, 4));

        // row4
        this.SquareList.add(new Square(this, 3, 0));
        Square Chick1Square_Player1 = new Square(this, 3, 1);
        Chick1Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Chick1Square_Player1);

        Square Chick2Square_Player1 = new Square(this, 3, 2);
        Chick2Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Chick2Square_Player1);

        Square Chick3Square_Player1 = new Square(this, 3, 3);
        Chick3Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Chick3Square_Player1);

        this.SquareList.add(new Square(this, 3, 4));
        // row5
        this.SquareList.add(new Square(this, 4, 0, this.player2));
        this.SquareList.add(new Square(this, 4, 1, this.player2));
        this.SquareList.add(new Square(this, 4, 2, this.player2));
        this.SquareList.add(new Square(this, 4, 3, this.player2));
        this.SquareList.add(new Square(this, 4, 4, this.player2));

        // row6
        Square Cat1Square_Player1 = new Square(this, 5, 0, this.player2);
        Cat1Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Cat1Square_Player1);

        Square Dog1Square_Player1 = new Square(this, 5, 1, this.player2);
        Dog1Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Dog1Square_Player1);

        Square LiOnSquare_Player1 = new Square(this, 5, 2, this.player2);
        LiOnSquare_Player1.PieceInitialize(player1);
        this.SquareList.add(LiOnSquare_Player1);

        Square Dog2Square_Player1 = new Square(this, 5, 3, this.player2);
        Dog2Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Dog2Square_Player1);

        Square Cat2Square_Player1 = new Square(this, 5, 4, this.player2);
        Cat2Square_Player1.PieceInitialize(player1);
        this.SquareList.add(Cat2Square_Player1);

    }


    public Player getPlayer(int playerNumber) {



            if (this.player1.getPlayerNumber() == playerNumber) {
                return this.player1;
            } else if (this.player2.getPlayerNumber() == playerNumber) {
                return this.player2;
            }else {
                throw new IllegalArgumentException("the last line was supposed to throw an IllegalArgumentException");
            }

    }


    public Player getWinner() {
        if (this.player1.hasWon()) {
            return this.player1;
        } else if(this.player2.hasWon()){
            return this.player2;
        }
        return null;
    }


    public Square getSquare(int row, int col) {
        Square square1 = null;
        for (int i = 0; i < this.SquareList.size(); i++) {
            Square square = this.SquareList.get(i);
            if (square.getRow() == row && square.getCol() == col) {
                square1= square;
            }
        }
        return square1;
    }


}

