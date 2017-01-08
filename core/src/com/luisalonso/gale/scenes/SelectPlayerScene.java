package com.luisalonso.gale.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.luisalonso.gale.Gale;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.GameScreen;
import com.luisalonso.gale.util.view.Background;
import com.luisalonso.gale.util.view.CustomButton;
import com.luisalonso.gale.util.view.TextLabel;

public class SelectPlayerScene extends GameScreen{

	private static final float BUTTON_MENU_X = AppConstants.VIEWPORT_WIDTH/2 - Gale.resources.mButtonBlue.getWidth()/2;
	private static final float BUTTON_PLAYER_Y = 200f;
	private static final float BUTTON_MACHINE_Y = 300f;
	
	private Background mBackground;
	private CustomButton mPlayer;
	private CustomButton mMachine;
	private TextLabel mPlayerText;
	private TextLabel mMachineText;
	private TextLabel mText;
	
	public SelectPlayerScene() {
		LabelStyle style = new LabelStyle(Gale.resources.mLettersStyle, Color.WHITE);
		mBackground = new Background(Gale.resources.mBackground);
		mBackground.setSize(AppConstants.BACKGROUND_WIDTH, AppConstants.VIEWPORT_HEIGHT);
		
		mText = new TextLabel("FIRST PLAYER", style, BUTTON_MENU_X, 700f);
		mPlayerText = new TextLabel("HUMANO", style, BUTTON_MENU_X, BUTTON_PLAYER_Y + 20, 0.5f);
		mPlayerText.setX(AppConstants.VIEWPORT_WIDTH/2 - mPlayerText.getWidth()/4);
		mMachineText = new TextLabel("MAQUINA", style, BUTTON_MENU_X, BUTTON_MACHINE_Y + 20, 0.5f);
		mMachineText.setX(AppConstants.VIEWPORT_WIDTH/2 - mMachineText.getWidth()/4);
		
		mPlayer = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_PLAYER_Y) {
			@Override
			public void executeAction() {
				Gale.player = AppConstants.PLAYER_1;
				Gale.game.changeToGameScene();
				super.executeAction();
			}
		};
		mPlayerText.addListener(mPlayer.getClickListener());
		
		mMachine = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_MACHINE_Y) {
			@Override
			public void executeAction() {
				Gale.player = AppConstants.MACHINE_PLAYER;
				Gale.game.changeToGameScene();
				super.executeAction();
			}
		};
		mMachineText.addListener(mMachine.getClickListener());
		
		mStage.addActor(mBackground);
		mStage.addActor(mText);
		mStage.addActor(mPlayer);
		mStage.addActor(mMachine);
		mStage.addActor(mPlayerText);
		mStage.addActor(mMachineText);
	}	
}
