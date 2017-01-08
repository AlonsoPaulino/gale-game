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

public class MenuScene extends GameScreen{
	
	private static final int MENU_MODE = 0;
	private static final int MENU_LEVEL = 1;
	
	private static final float BUTTON_MENU_X = AppConstants.VIEWPORT_WIDTH/2 - Gale.resources.mButtonBlue.getWidth()/2;
	private static final float BUTTON_HUMAN_MODE_Y = 230f;
	private static final float BUTTON_MACHINE_MODE_Y = 330f;
	
	private static final float BUTTON_LEVEL_1_Y = 550f;
	private static final float BUTTON_LEVEL_2_Y = 450f;
	private static final float BUTTON_LEVEL_3_Y = 350f;
	private static final float BUTTON_BACK_Y = 100f;
	
	private CustomLabel mLogo;
	private Background mBackground;
	private CustomButton mHumanMode;
	private TextLabel mHumanModeText;
	private CustomButton mMachineMode;
	private TextLabel mMachineModeText;
	private CustomButton mLevel1;
	private TextLabel mLevel1Text;
	private CustomButton mLevel2;
	private TextLabel mLevel2Text;
	private CustomButton mLevel3;
	private TextLabel mLevel3Text;
	private CustomButton mBack;
	private TextLabel mBackText;
	
	public MenuScene() {
		LabelStyle style = new LabelStyle(Gale.resources.mLettersStyle, Color.WHITE);
		mBackground = new Background(Gale.resources.mBackground);
		mBackground.setSize(AppConstants.BACKGROUND_WIDTH, AppConstants.VIEWPORT_HEIGHT);
		
		mLogo = new CustomLabel(Gale.resources.mLogo, 450f, 220f, BUTTON_MENU_X, 550f);
		
		mHumanModeText = new TextLabel("2  Players", style, BUTTON_MENU_X, BUTTON_HUMAN_MODE_Y + 20, 0.5f);
		mHumanModeText.setX(AppConstants.VIEWPORT_WIDTH/2 - mHumanModeText.getWidth()/4);
		mMachineModeText = new TextLabel("1  Player", style, BUTTON_MENU_X, BUTTON_MACHINE_MODE_Y + 20, 0.5f);
		mMachineModeText.setX(AppConstants.VIEWPORT_WIDTH/2 - mMachineModeText.getWidth()/4);		
		mLevel1Text = new TextLabel("Principiante", style, BUTTON_MENU_X, BUTTON_LEVEL_1_Y + 20, 0.5f);
		mLevel1Text.setX(AppConstants.VIEWPORT_WIDTH/2 - mLevel1Text.getWidth()/4);
		mLevel2Text = new TextLabel("Intermedio", style, BUTTON_MENU_X, BUTTON_LEVEL_2_Y + 20, 0.5f);
		mLevel2Text.setX(AppConstants.VIEWPORT_WIDTH/2 - mLevel2Text.getWidth()/4);
		mLevel3Text = new TextLabel("Diíficil", style, BUTTON_MENU_X, BUTTON_LEVEL_3_Y + 20, 0.5f);
		mLevel3Text.setX(AppConstants.VIEWPORT_WIDTH/2 - mLevel3Text.getWidth()/4);
		mBackText = new TextLabel("Atras", style, BUTTON_MENU_X, BUTTON_BACK_Y + 20, 0.5f);
		mBackText.setX(AppConstants.VIEWPORT_WIDTH/2 - mBackText.getWidth()/4);
		
		mHumanMode = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X , BUTTON_HUMAN_MODE_Y) {
			@Override
			public void executeAction() {
				Gale.mode = AppConstants.HUMAN_HUMAN_MODE;
				Gale.game.changeToGameScene();
				super.executeAction();
			}
		};
		
		mHumanModeText.addListener(mHumanMode.getClickListener());
		
		mMachineMode = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_MACHINE_MODE_Y) {
			@Override
			public void executeAction() {
				showOptions(MENU_LEVEL);
				super.executeAction();
			}
		};
		mMachineModeText.addListener(mMachineMode.getClickListener());
		
		mLevel1 = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_LEVEL_1_Y) {
			@Override
			public void executeAction() {
				Gale.mode = AppConstants.HUMAN_MACHINE_MODE;
				Gale.level = AppConstants.LEVEL_1;
				Gale.game.changeToSelectScene();
				Gale.setDelay();
				super.executeAction();
			}
		};
		mLevel1Text.addListener(mLevel1.getClickListener());
		
		mLevel2 = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_LEVEL_2_Y) {
			@Override
			public void executeAction() {
				Gale.mode = AppConstants.HUMAN_MACHINE_MODE;
				Gale.level = AppConstants.LEVEL_2;
				Gale.game.changeToSelectScene();
				Gale.setDelay();
				super.executeAction();
			}
		};
		mLevel2Text.addListener(mLevel2.getClickListener());
		
		mLevel3 = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_LEVEL_3_Y) {
			@Override
			public void executeAction() {
				Gale.mode = AppConstants.HUMAN_MACHINE_MODE;
				Gale.level = AppConstants.LEVEL_3;
				Gale.game.changeToSelectScene();
				Gale.setDelay();
				super.executeAction();
			}
		};
		mLevel3Text.addListener(mLevel3.getClickListener());
		
		mBack = new CustomButton(Gale.resources.mButtonBlue, BUTTON_MENU_X, BUTTON_BACK_Y) {
			@Override
			public void executeAction() {
				showOptions(MENU_MODE);
				super.executeAction();
			}
		};
		mBackText.addListener(mBack.getClickListener());
		
		showOptions(MENU_MODE);
		mStage.addActor(mBackground);
		mStage.addActor(mLogo);
		mStage.addActor(mHumanMode);
		mStage.addActor(mMachineMode);
		mStage.addActor(mHumanModeText);
		mStage.addActor(mMachineModeText);
		mStage.addActor(mLevel1);
		mStage.addActor(mLevel1Text);
		mStage.addActor(mLevel2);
		mStage.addActor(mLevel2Text);
		mStage.addActor(mLevel3);
		mStage.addActor(mLevel3Text);
		mStage.addActor(mBack);
		mStage.addActor(mBackText);
	}
	
	public void showOptions(int mode) {
		mLogo.setVisible(mode == MENU_MODE);
		mHumanMode.setVisible(mode == MENU_MODE);
		mHumanModeText.setVisible(mode == MENU_MODE);
		mMachineMode.setVisible(mode == MENU_MODE);
		mMachineModeText.setVisible(mode == MENU_MODE);
		mLevel1.setVisible(mode == MENU_LEVEL);
		mLevel1Text.setVisible(mode == MENU_LEVEL);
		mLevel2.setVisible(mode == MENU_LEVEL);
		mLevel2Text.setVisible(mode == MENU_LEVEL);
		mLevel3.setVisible(mode == MENU_LEVEL);
		mLevel3Text.setVisible(mode == MENU_LEVEL);
		mBack.setVisible(mode == MENU_LEVEL);
		mBackText.setVisible(mode == MENU_LEVEL);
	}
}
