package com.luisalonso.gale.ia;

import java.util.ArrayList;

import com.luisalonso.gale.actors.GameBoard;
import com.luisalonso.gale.actors.Piece;
import com.luisalonso.gale.util.AppConstants;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GameTree {
	
	private static final int MAX_HEIGHT = 2;
	private Node mRoot;
	
	public GameTree(Node node) {
		if(node.isRoot()) {
			mRoot = node;
			initGameTree();
		}
	}
	
	private void initGameTree() {
		if (mRoot != null) {
			ArrayList<Node> nodes = new ArrayList<Node>(); 
			nodes.add(mRoot);
			int level = 0;
			while (level < MAX_HEIGHT) {
				ArrayList<Node> nodesInNextLevel = new ArrayList<Node>();
				for (int i = 0; i < nodes.size(); ++i) {
					generateChildNodes(nodes.get(i), nodesInNextLevel);
				}
				nodes = nodesInNextLevel;
				level++;
			}
		}
	}
	
	private void generateChildNodes(Node parent, ArrayList<Node> aux) {
		GameBoard board = parent.getGameBoard();
		Piece [][] pieces = board.getBoardConfiguration();
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; ++j) {
				if (pieces[i][j].isEnable()) {
					Node child = new Node(parent, (parent.getPlayer() == AppConstants.PLAYER_1) ? 
							AppConstants.MACHINE_PLAYER : AppConstants.PLAYER_1);
					child.setNewConfiguration(pieces);
					child.setNewBoardState(i, j);
					child.setUtility(IA.heuristic(child));
					parent.addChild(child);
					aux.add(child);
				}
			}
		}
	}
	
	public Node getRoot() {
		return mRoot;
	}
}
