package com.luisalonso.gale.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.actors.GameBoard;
import com.luisalonso.gale.ia.IA;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.GameScreen;
import com.luisalonso.gale.util.view.Background;
import com.luisalonso.gale.util.view.TextLabel;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class MainScene extends GameScreen{

	private static final float LABEL_TURN_Y = 750f;
	
	private Background mBackground;
	private TextLabel mTurn;
	private LabelStyle mStyle;
	private String mText; 
	
	private float mCurrentTime = 0;
	
	public MainScene() {
		Gale.board = new GameBoard();
		mStyle = new LabelStyle(Gale.resources.mLettersStyle, Color.WHITE);
		mBackground = new Background(Gale.resources.mBackground);
		mBackground.setSize(AppConstants.BACKGROUND_WIDTH, AppConstants.VIEWPORT_HEIGHT);
		
		Gale.board.setPosition((AppConstants.VIEWPORT_WIDTH - Gale.board.getWidth())/2, 
				(AppConstants.VIEWPORT_HEIGHT - Gale.board.getHeight())/2);
		Gale.board.setupAsActor();
		if (Gale.player == AppConstants.PLAYER_1) {
			mTurn = new TextLabel(AppConstants.PLAYER_1_NAME, mStyle, 0, LABEL_TURN_Y);
		} else if (Gale.player == AppConstants.PLAYER_2) {
			mTurn = new TextLabel(AppConstants.PLAYER_2_NAME, mStyle, 0, LABEL_TURN_Y);
		} else {
			mTurn = new TextLabel(AppConstants.MACHINE_NAME, mStyle, 0, LABEL_TURN_Y);
		}
		mTurn.setX(AppConstants.VIEWPORT_WIDTH/2 - mTurn.getWidth()/2);
		
		mStage.addActor(mBackground);
		mStage.addActor(Gale.board);
		mStage.addActor(mTurn);
	}
	
	public void updateText() {
		mTurn.remove();
		if (Gale.player == AppConstants.PLAYER_1) {
			mText =  AppConstants.PLAYER_1_NAME;
			mTurn = new TextLabel(mText, mStyle, 0, LABEL_TURN_Y);
			mTurn.setX(AppConstants.VIEWPORT_WIDTH/2 - mTurn.getWidth()/2);
		} else if (Gale.player == AppConstants.PLAYER_2) {
			mText =  AppConstants.PLAYER_2_NAME;
			mTurn = new TextLabel(mText, mStyle, 0, LABEL_TURN_Y);
			mTurn.setX(AppConstants.VIEWPORT_WIDTH/2 - mTurn.getWidth()/2);
		} else if (Gale.player == AppConstants.MACHINE_PLAYER) {
			mText =  AppConstants.MACHINE_NAME;
			mTurn = new TextLabel(mText, mStyle, 0, LABEL_TURN_Y);
			mTurn.setX(AppConstants.VIEWPORT_WIDTH/2 - mTurn.getWidth()/2);
		}
		mStage.addActor(mTurn);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		updateText();
		if (Gale.mode == AppConstants.HUMAN_MACHINE_MODE) {
			if (Gale.player == AppConstants.MACHINE_PLAYER && !IA.playing) {
				mCurrentTime += delta;
				if (mCurrentTime > Gale.machineDelay) {
					IA.start();
					mCurrentTime = 0;
				}
			}
		}
	}
}
