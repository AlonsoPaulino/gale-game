package com.luisalonso.gale.ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.badlogic.gdx.Gdx;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.actors.Piece;
import com.luisalonso.gale.util.AppConstants;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class IA {

	public static GameTree mGameTree;
	public static boolean playing;
	
	public static void start() {
		Node root = new Node(null, AppConstants.PLAYER_1);
		root.setNewConfiguration(Gale.board.getBoardConfiguration());
		mGameTree = new GameTree(root);
		playing = true;
		
		switch (Gale.level) {
			case AppConstants.LEVEL_1:
				play(level1());
			break;
			
			case AppConstants.LEVEL_2:
				play(level2());
			break;
			
			case AppConstants.LEVEL_3:
				play(level3());
			break;
		}
	}
	
	public static int heuristic (Node node) {
		Piece[][] conf = node.getGameBoard().getBoardConfiguration();
		int piecesEnabled = 0;
		int pieceEnabledVertical = 0;
		int pieceEnabledHoritzontal = 0;
		
		int n = AppConstants.N;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (conf[i][j].isEnable()) {
					piecesEnabled++;
					if (i == n - 1) pieceEnabledHoritzontal++;
					if (j == n - 1) pieceEnabledVertical++;
				}
			}
		}
		
		boolean aux = (pieceEnabledHoritzontal == pieceEnabledVertical) && 
				!conf[n-2][n-2].isEnable() && piecesEnabled > 0;
		
		if (node.getPlayer() == AppConstants.PLAYER_1) {
			piecesEnabled *= -1;
		}
		
		if (piecesEnabled == 1 || piecesEnabled == -1 || aux) {
			if (node.getPlayer() == AppConstants.PLAYER_1) {
				piecesEnabled = AppConstants.MINUS_INF;
			} else if (node.getPlayer() == AppConstants.MACHINE_PLAYER) {
				piecesEnabled = AppConstants.PLUS_INF;
			}
		}
		
		if (piecesEnabled == 0) {
			if (node.getPlayer() == AppConstants.PLAYER_1) {
				piecesEnabled = AppConstants.PLUS_INF;
			} else if (node.getPlayer() == AppConstants.MACHINE_PLAYER) {
				piecesEnabled = AppConstants.MINUS_INF;
			}
		}
		
		return piecesEnabled;
	}
	
	private static void play(Node nodeSelected) {
		if (nodeSelected != null) {
			IA.playing = false;
			Gale.game.updateBoard(nodeSelected.getX(), nodeSelected.getY());
		} else {
			Gdx.app.log("IA", "no posibilites");
		}
	}
	
	/* JUGADA ALEATORIA */
	private static Node level1() {
		ArrayList<Node> nodes = mGameTree.getRoot().getChilds();
		if (nodes != null) {
			if (nodes.size() > 1) {
				int selected = 0 + (int)(Math.random()*(nodes.size() - 1));
				Node node = nodes.get(selected);
				while (node.getX() == AppConstants.N - 1 && node.getY() == AppConstants.N - 1) {
					selected = 0 + (int)(Math.random()*(nodes.size() - 1));
					node = nodes.get(selected);
				}
				return nodes.get(selected);
			} else {
				return nodes.get(0);
			}
			
		} else {
			return null;
		}
	}
	
	/* PRIMERO EL MEJOR */
	private static Node level2() {
		ArrayList<Node> nodes = mGameTree.getRoot().getChilds();
		Collections.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				return node2.getUtility() - node1.getUtility();
			}
		});
		int utility = nodes.get(0).getUtility();
		ArrayList<Node> posibilities = new ArrayList<Node>();
		posibilities.add(nodes.get(0));
		for (int i = 1; i < nodes.size(); ++i) {
			if (utility == nodes.get(i).getUtility()) {
				posibilities.add(nodes.get(i));
			}
		}
		
		if (posibilities.size() > 1) {
			int selected = 0 + (int)(Math.random()*(posibilities.size() - 1));
			Node node = posibilities.get(selected);
			while (node.getX() == AppConstants.N - 1 && node.getY() == AppConstants.N - 1) {
				selected = 0 + (int)(Math.random()*(posibilities.size() - 1));
				node = posibilities.get(selected);
			}
			return posibilities.get(selected);
		} else {
			return nodes.get(0);
		}
	}

	/* MINIMAX */
	private static Node level3() {
		ArrayList<Node> maxNodes = mGameTree.getRoot().getChilds();
		for (int i = 0; i < maxNodes. size(); ++i) {
			ArrayList<Node> minNodes = maxNodes.get(i).getChilds();
			if (minNodes != null) {
				int aux = minNodes.get(0).getUtility();
				for (int j = 1; j < minNodes.size(); ++j) {
					if (minNodes.get(j).getUtility() < aux) {
						aux = minNodes.get(j).getUtility();
					}
				}
				maxNodes.get(i).setUtility(aux);
			}
		}
		
		int ans = maxNodes.get(0).getUtility();
		int idx = 0;
		
		for (int i = 1; i < maxNodes.size(); ++i) {
			if (maxNodes.get(i).getUtility() > ans) {
				ans = maxNodes.get(i).getUtility();
				idx = i;
			}
		}
		
		return maxNodes.get(idx);
	}
}
