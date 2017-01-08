package com.luisalonso.gale.ia;

import java.util.ArrayList;

import com.luisalonso.gale.actors.GameBoard;
import com.luisalonso.gale.actors.Piece;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class Node {
	
	private Node mParent;
	private ArrayList<Node> mChilds;
	
	private GameBoard mBoard;
	private int mPlayer;
	private int mUtility;
	private int mX;
	private int mY;
	
	public Node(Node parent, int player) {
		mParent = parent;
		mPlayer = player;
	}
	
	public void setNewBoardState(int x, int y) {
		mBoard.update(x, y);
		mX = x;
		mY = y;
	}
	
	public void setNewConfiguration(Piece[][] conf) {
		mBoard = new GameBoard();
		mBoard.setBoardConfiguration(conf);
	}
	
	public boolean isRoot() {
		return mParent == null;
	}
	
	public Node getParent() {
		return mParent;
	}
	
	public int getPlayer() {
		return mPlayer;
	}
	
	public GameBoard getGameBoard() {
		return mBoard;
	}
			
	public void setUtility(int utility) {
		mUtility = utility;
	}
	
	public int getUtility() {
		return mUtility;
	}
	
	public ArrayList<Node> getChilds() {
		return mChilds;
	}
	
	public void addChild(Node node) {
		if (mChilds == null) {
			mChilds = new ArrayList<Node>();
		}
		mChilds.add(node);
	}
	
	public void setChilds(ArrayList<Node> childs) {
		mChilds = childs;
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
	}
}
