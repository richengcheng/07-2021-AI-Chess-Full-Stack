package ryde.battle;


import java.util.ArrayList;
import java.util.List;

import ryde.InternetChess.Chess;

public class ChessInfo {
	public static List<Chess> AIChessList=new ArrayList<Chess>();
	public static List<Chess> playerChessList=new ArrayList<Chess>();
	public static List<Chess> AICapturedPieceList=new ArrayList<Chess>();
	public static List<Chess> PlayerCapturedPieceList=new ArrayList<Chess>();
	
	public ChessInfo(){
		for (int i = 0; i < 8; i++) {
		}
	}

	public static boolean AIChessListRemove(Chess chess){
		return AIChessList.remove(chess);
	}
	public static boolean playerChessListRemove(Chess chess){
		return playerChessList.remove(chess);
	}
	public static boolean AIChessListAdd(Chess chess){
		return AIChessList.add(chess);
	}
	public static boolean playerChessListAdd(Chess chess){
		return playerChessList.add(chess);
	}
	
}
