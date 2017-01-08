package com.luisalonso.gale.actors;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.listeners.PieceListener;
import com.luisalonso.gale.util.AppConstants;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GameBoard extends Group {
	
	private Piece [][] mPieces;
	private int mSize;
	
	public GameBoard() {
		mSize = AppConstants.N * AppConstants.PIECE_SIZE;
		GameBoard.this.setSize(mSize, mSize);
		mPieces = new Piece[AppConstants.N][AppConstants.N];
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; ++j) {
				mPieces[i][j] = new Piece();
				PieceConfiguration conf = new PieceConfiguration();
				conf.boardXPosition = i;
				conf.boardYPosition = j;
				mPieces[i][j].setConfiguration(conf);
			}
		}
 	}
	
	public void setupAsActor() {
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; ++j) {
				mPieces[i][j].setPosition(i * AppConstants.PIECE_SIZE, j * AppConstants.PIECE_SIZE);
				mPieces[i][j].setPieceListener(new PieceListener() {
					@Override
					public void onPieceSelected(int x, int y) {
						Gale.game.play(x, y);
					}
				});
				mPieces[i][j].setupAsActor();
				addActor(mPieces[i][j]);
			}
		}
	}
	
	public void setBoardConfiguration(Piece [][] conf) {
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; ++j) {
				mPieces[i][j].setConfiguration(conf[i][j].getConfiguration());
			}
		}
	}
	
	public Piece[][] getBoardConfiguration() {
		return mPieces;
	}
	
	public Piece getPiece(int i, int j) {
		return (mPieces != null) ? mPieces[i][j] : null;
	}
	
	public int getSize() {
		return mSize;
	}
	
	public void log () {
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; ++j) {
				System.out.print((mPieces[i][j].isEnable())? "1" : "0");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public void update(int x, int y) {
		for (int i = 0; i <= x; ++i) {
			for (int j = 0; j <= y; ++j) {
				mPieces[i][j].flip();
			}
		}
	}
}

