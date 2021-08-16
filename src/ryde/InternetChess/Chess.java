package ryde.InternetChess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import ryde.gui.ChessBoard;

public class Chess implements Serializable,Cloneable{
	private boolean isUnderAttack=false;
	private int step=0;//
	private int value=10;//
	private int coorX;
	private int coorY;
	private String name;
	private boolean isEnemy;
	private boolean hasSpecialWalkWay;
	private boolean IsPromoted=false;

	public Chess() {

	}

	public Chess( Chess chess) {

		this.coorX = chess.getCoorX();
		this.coorY = chess.getCoorY();
		this.name = chess.getName();
		this.isEnemy = chess.isEnemy();
		this.value=chess.getValue();
		hasSpecialWalkWay = false;
		IsPromoted=false;

	}

	public Chess(int coorY, int coorX, String name,int value, boolean isEnemy) {
		this.coorX = coorX;
		this.coorY = coorY;
		this.name = name;
		this.isEnemy = isEnemy;
		this.value=value;
		hasSpecialWalkWay = false;
		IsPromoted=false;
	}

	/**
	 * 
	 * @param click  The currently clicked board position
	 * @param bs	Whole chessboard
	 * @return 	Whether the selected position can be moved forward
	 */
	public boolean isWalkable(ChessBoard click, ChessBoard[][] bs) {
		return false;
	}
	
	/**
	 * Return the foothold where the piece can move forward, and set the opponent piece at the foothold as underAttaacked; and save the attack point of the piece into the hash table
	 * 
	 * @param bs Whole chessboard
	 * @return   List with two-digit numbers as coordinates
	 */

	public ArrayList<Integer> searchWalkableWay(ChessBoard[][] bs,Map<Integer, Integer> walkWayMap,int variantsNumber){
		ArrayList<Integer> walkWayList=new ArrayList<Integer>();
		if(variantsNumber==0) {
			for (int i = 0; i < 6; i++) {
				for (int j = 3; j < 8; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);
						//build a map reflection
						walkWayMap.put(i * 100 + j, getCoorY() * 100 + getCoorX());

					}
				}
			}
		}


		if(variantsNumber==1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 3; j < 12; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);
						//build a map reflection
						walkWayMap.put(i * 100 + j, getCoorY() * 100 + getCoorX());

					}
				}
			}
		}

		if(variantsNumber==2) {
			for (int i = 0; i < 8; i++) {
				for (int j = 3; j < 10; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);
						//build a map reflection
						walkWayMap.put(i * 100 + j, getCoorY() * 100 + getCoorX());

					}
				}
			}
		}

		return walkWayList;
	}

	//for minimax
	public ArrayList<Integer> searchWalkableWay(ChessBoard[][] bs,int variantsNumber){
		ArrayList<Integer> walkWayList=new ArrayList<Integer>();
		if(variantsNumber==0) {
			for (int i = 0; i < 6; i++) {
				for (int j = 3; j < 8; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);

					}
				}
			}
		}


		if(variantsNumber==1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 3; j < 12; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);

					}
				}
			}
		}

		if(variantsNumber==2) {
			for (int i = 0; i < 8; i++) {
				for (int j = 3; j < 10; j++) {
					if (isWalkable(bs[i][j], bs)) {
						//the current board of chess is not null and also the chess will be marked as underattacked
						if (bs[i][j].getChess() != null && bs[i][j].getChess().isEnemy() != this.isEnemy()) {
							bs[i][j].getChess().setUnderAttack(true);
						}
						//input the walk way list
						walkWayList.add(i * 100 + j);

					}
				}
			}
		}

		return walkWayList;
	}





	public boolean checkIsPromotedNow(){
		return false;
	}
	
	/**
	 * The special moves of the chess pieces,
	 * @param presentChessBoard 
	 * Currently selected location
	 * @param click	
	 * Click location
	 * @param bs
	 * Whole chessboard
	 */
	public void specialWalkWay(ChessBoard presentChessBoard,ChessBoard click,ChessBoard[][] bs) {

	}

	@Override
	public Object clone(){
		Chess chess=null;
		try {
			chess=(Chess) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chess;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setIsPromoted(boolean value) {
		this.IsPromoted = value;
	}

	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}

	public boolean isUnderAttack() {
		return isUnderAttack;
	}

	public void setUnderAttack(boolean isUnderAttack) {
		this.isUnderAttack = isUnderAttack;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getCoorX() {
		return coorX;
	}

	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}

	public int getCoorY() {
		return coorY;
	}

	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}

	public void setCoor(ChessBoard b) {
		this.coorX = b.getCoorX();
		this.coorY = b.getCoorY();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasSpecialWalkWay() {
		return hasSpecialWalkWay;
	}

	public void setSpecialWalkWay(boolean hasSpecialWalkWay) {
		this.hasSpecialWalkWay = hasSpecialWalkWay;
	}

}
