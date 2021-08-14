package ryde.battle;



import java.util.ArrayList;
import java.util.List;

import ryde.InternetChess.Chess;
import ryde.gui.ChessBoard;

public class ChessInfoMinMax {
    public List<Chess> AIPieceList=new ArrayList<Chess>();
    public List<Chess> playerPieceList=new ArrayList<Chess>();
    public List<Chess> AICapturedPieceList=new ArrayList<Chess>();
    public List<Chess> PlayerCapturedPieceList=new ArrayList<Chess>();
    public ChessBoard[][] currentChessBoard ;//= new ChessBoard[][];

    public ChessInfoMinMax(ChessBoard[][] currentChessBoard, List<Chess> AICapturedPieceList,
                           List<Chess> PlayerCapturedPieceList, List<Chess> AIPieceList, List<Chess> PlayerPieceList  ){
         this.currentChessBoard=currentChessBoard;
         this.AICapturedPieceList=AICapturedPieceList;
         this.PlayerCapturedPieceList=PlayerCapturedPieceList;
         this.AIPieceList=AIPieceList;
         this.playerPieceList=PlayerPieceList;

    }

    public ChessInfoMinMax( ){


    }

    public  void AIChessListRemove(Chess chess){this.AIPieceList.remove(chess);}

    public  void playerChessListRemove(Chess chess){
        this.playerPieceList.remove(chess);
    }

    public  void AIChessListAdd(Chess chess){
        this.AIPieceList.add(chess);
    }

    public  void playerChessListAdd(Chess chess){
        this.playerPieceList.add(chess);
    }

}


