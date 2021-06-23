

public class Square {

    private Game Game;
    private  int Row;
    private   int Col;
    private  Player PromotesPlayer=null;
    private  Piece piece=null;

    public Square(Game game, int row, int col){
        this.Game=game;
        this.Row=row;
        this.Col=col;

    }

    public Square(Game game, int row, int col, Player promotesPlayer){
        this.Game=game;
        this.Row=row;
        this.Col=col;
        this.PromotesPlayer=promotesPlayer;
    }

    /**creating picece*/
    public void PieceInitialize(Player player){

        //create Chick
        if(this.getRow()==2&&this.getCol()==1)
            this.piece = new  Chick(player,this);
        if(this.getRow()==2&&this.getCol()==2)
            this.piece = new  Chick(player,this);
        if(this.getRow()==2&&this.getCol()==3)
            this.piece = new  Chick(player,this);
        if(this.getRow()==3&&this.getCol()==1)
            this.piece = new  Chick(player,this);
        if(this.getRow()==3&&this.getCol()==2)
            this.piece = new  Chick(player,this);
        if(this.getRow()==3&&this.getCol()==3)
            this.piece = new  Chick(player,this);

        //create cat
        if(this.getRow()==0&&this.getCol()==0)
            this.piece = new  Cat(player,this);
        if(this.getRow()==0&&this.getCol()==4)
            this.piece = new  Cat(player,this);
        if(this.getRow()==5&&this.getCol()==0)
            this.piece = new  Cat(player,this);
        if(this.getRow()==5&&this.getCol()==4)
            this.piece = new  Cat(player,this);

        //create dog
        if(this.getRow()==0&&this.getCol()==1)
            this.piece = new  Dog(player,this);
        if(this.getRow()==0&&this.getCol()==3)
            this.piece = new  Dog(player,this);
        if(this.getRow()==5&&this.getCol()==1)
            this.piece = new  Dog(player,this);
        if(this.getRow()==5&&this.getCol()==3)
            this.piece = new  Dog(player,this);

        //create lion
        if(this.getRow()==0&&this.getCol()==2)
            this.piece = new  Lion(player,this);
        if(this.getRow()==5&&this.getCol()==2)
            this.piece = new  Lion(player,this);

    }


     public void cleanPiece(){
        this.piece=null;
     }


    public void placePiece(Piece piece){
        if(this.piece!=null){
            throw new IllegalArgumentException("the last line should have thrown an exception");
        }else {
            this.piece = piece;
        }
    }

    public void removePiece(){
       this.piece=null;
    }

    public boolean isPromotionZone(Player player){
         if(this.PromotesPlayer==player) {
             return true;
         }
         return  false;
    }

    public  Game getGame(){
         return this.Game;
    }

    public Piece getPiece(){
       return this.piece;
    }

    public int getRow(){
       return this.Row;
    }

    public int getCol(){
       return this.Col;
    }

    public Player getPromotesPlayer(){
        return this.PromotesPlayer;
    }

}
