package com.luisalonso.gale.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.GameScreen;
import com.luisalonso.gale.util.view.Background;
import com.luisalonso.gale.util.view.CustomButton;
import com.luisalonso.gale.util.view.CustomLabel;
import com.luisalonso.gale.util.view.TextLabel;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GameOverScene extends GameScreen {
	
	private Background mBackground;
	private CustomLabel mGameOver;
	private TextLabel mText1;
	private TextLabel mText2;
	private CustomLabel mSection;
	private LabelStyle mStyle;
	private CustomButton mReplay;
	private CustomButton mHomeButton;
	private CustomButton mShareButton;
	
	public GameOverScene() {
		mStyle = new LabelStyle(Gale.resources.mLettersStyle, Color.BLACK);
		mBackground = new Background(Gale.resources.mBackground);
		mGameOver = new CustomLabel(Gale.resources.mGameOver, 41.5f, 775);
		mBackground.setSize(AppConstants.BACKGROUND_WIDTH, AppConstants.VIEWPORT_HEIGHT);
		
		mReplay = new CustomButton(Gale.resources.mReplayButton, 0, 249){
			@Override
			public void executeAction() {
				if (Gale.mode == AppConstants.HUMAN_MACHINE_MODE) {
					Gale.game.changeToSelectScene();
				} else {
					Gale.game.changeToGameScene();
				}
				super.executeAction();
			}
		};
		mHomeButton = new CustomButton(Gale.resources.mHomeButton, 150.25f, 133.5f){
			@Override
			public void executeAction() {
				Gale.game.changeToMenuScene();
				super.executeAction();
			}
		};
		mShareButton = new CustomButton(Gale.resources.mShareButton, 297.5f, 133.5f){
			@Override
			public void executeAction() {
				Gale.game.share();
				super.executeAction();
			}
		};
		
		mSection = new CustomLabel(Gale.resources.mSectionWhite, 45f, 460f);
		mText1 = new TextLabel("CONGRATULATIONS!", mStyle , 0, 620, 0.6f);
		mText1.setX(AppConstants.VIEWPORT_WIDTH/2 - mText1.getWidth()/(2 * (1/0.6f)));
		
		String winner = "";
		if (Gale.mode == AppConstants.HUMAN_HUMAN_MODE) {
			if (Gale.player == AppConstants.PLAYER_1) {
				winner = AppConstants.PLAYER_1_NAME;
			} else {
				winner = AppConstants.PLAYER_2_NAME;
			}
		} else {
			if (Gale.player == AppConstants.PLAYER_1) {
				winner = AppConstants.PLAYER_1_NAME;
			} else {
				winner = AppConstants.MACHINE_NAME;
			}
		}
		
		mText2 = new TextLabel(winner, mStyle, 0, 520, 0.8f);
		mText2.setX(AppConstants.VIEWPORT_WIDTH/2 - mText2.getWidth()/(2 * (1/0.8f)));
		mStage.addActor(mBackground);
		mStage.addActor(mGameOver);
		mStage.addActor(mReplay);
		mStage.addActor(mSection);
		mStage.addActor(mText1);
		mStage.addActor(mText2);
		mStage.addActor(mHomeButton);
		mStage.addActor(mShareButton);
		Gale.resetConf();
	}
}
