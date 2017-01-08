package com.luisalonso.gale.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.listeners.PieceListener;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.GameActor;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class Piece extends GameActor {
	
	private PieceListener mPieceListener;
	private PieceConfiguration mConf;
	
	public Piece() {
		super(Gale.resources.mGreenPiece, AppConstants.PIECE_SIZE, AppConstants.PIECE_SIZE);
		mConf = new PieceConfiguration();
	}
	
	public void setupAsActor() {
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (mPieceListener != null) mPieceListener.onPieceSelected(
						mConf.boardXPosition, mConf.boardYPosition);
				super.clicked(event, x, y);
			}
		});
	}
	
	public void setPieceListener(PieceListener listener) {
		mPieceListener = listener;
	}
	
	public void flip() {
		if (mConf.enable == AppConstants.ENABLE) {
			if (mConf.state == AppConstants.GREEN) {
				updateState(AppConstants.RED);
				mConf.enable = AppConstants.LOCKED;
			} else if (mConf.state == AppConstants.RED) {
				updateState(AppConstants.GREEN);
			}
		}
	}
	
	private void updateState(int newState) {
		if (mConf.state != newState) {
			mConf.state = newState;
			if (mConf.state == AppConstants.RED) {
				setTexture(Gale.resources.mRedPiece);
			} else if (mConf.state == AppConstants.GREEN) {
				setTexture(Gale.resources.mGreenPiece);
			}
		}
	}
	
	public boolean isEnable() {
		return mConf.enable == AppConstants.ENABLE;
	}
	
	public void setConfiguration (PieceConfiguration newConfig) {
		mConf = new PieceConfiguration();
		mConf.boardXPosition = newConfig.boardXPosition;
		mConf.boardYPosition = newConfig.boardYPosition;
		mConf.enable = newConfig.enable;
		mConf.state = newConfig.state;
	}
	
	public PieceConfiguration getConfiguration() {
		return mConf;
	}
	
	@Override
	public void setTexture(Texture texture) {
		super.setTexture(texture, AppConstants.PIECE_SIZE, AppConstants.PIECE_SIZE);
	}
}
