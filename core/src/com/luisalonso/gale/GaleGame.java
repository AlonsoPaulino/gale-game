package com.luisalonso.gale;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.luisalonso.gale.scenes.GameOverScene;
import com.luisalonso.gale.scenes.MainScene;
import com.luisalonso.gale.scenes.MenuScene;
import com.luisalonso.gale.scenes.SelectPlayerScene;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.PreferencesManager;
import com.luisalonso.gale.util.Resources;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GaleGame extends Game {

	public Resources mResources;
	public PreferencesManager mPreferencesManager;

	private MenuScene mMenuScene;
	private MainScene mGameScene;
	private GameOverScene mGameOverScene;
	private SelectPlayerScene mSelectScene;

	@Override
	public void create() {
		GaleGame.this.setUpAppController();
		mMenuScene = new MenuScene();
		GaleGame.this.setScreen(mMenuScene);
		Gdx.input.setInputProcessor(mMenuScene.getStage());
		Gdx.app.log("ON CREATE -> ", AppConstants.PLUS_INF + "");
		Gdx.app.log("ON CREATE -> ", AppConstants.MINUS_INF + "");
	}

	public void changeToMenuScene() {
		mMenuScene = new MenuScene();
		setScreen(mMenuScene);
		Gdx.input.setInputProcessor(mMenuScene.getStage());
	}
	
	public void changeToGameScene() {
		mGameScene = new MainScene();
		setScreen(mGameScene);
		Gdx.input.setInputProcessor(mGameScene.getStage());
	}

	public void changeToGameOverScene() {
		mGameOverScene = new GameOverScene();
		setScreen(mGameOverScene);
		Gdx.input.setInputProcessor(mGameOverScene.getStage());
	}

	public void changeToSelectScene() {
		mSelectScene = new SelectPlayerScene();
		setScreen(mSelectScene);
		Gdx.input.setInputProcessor(mSelectScene.getStage());
	}
	
	public void setUpAppController() {
		mResources = new Resources();
		mPreferencesManager = new PreferencesManager();
		Gale.game = GaleGame.this;
		Gale.preferencesManager = mPreferencesManager;
		Gale.resources = mResources;
		Gale.player = AppConstants.PLAYER_1;
	}

	public void play(int x, int y) {
		if (Gale.board.getPiece(x, y).isEnable()) {
			if (Gale.player == AppConstants.PLAYER_1 || Gale.player == AppConstants.PLAYER_2) {
				updateBoard(x, y);
			}
		}
	}

	public void updateBoard(int x, int y) {
		if (Gale.board != null) {
			Gale.board.update(x, y);
			setNextPlayer();
		}

		if (gameOver()) {
			changeToGameOverScene();
		}
	}
	
	private void setNextPlayer() {
		if (Gale.mode == AppConstants.HUMAN_HUMAN_MODE) {
			Gale.player = (Gale.player == AppConstants.PLAYER_1) ? 
					AppConstants.PLAYER_2 : AppConstants.PLAYER_1; 
		} else if (Gale.mode == AppConstants.HUMAN_MACHINE_MODE) {
			Gale.player = (Gale.player == AppConstants.PLAYER_1) ?
					AppConstants.MACHINE_PLAYER : AppConstants.PLAYER_1;
		}
	}

	public boolean gameOver() {
		for (int i = 0; i < AppConstants.N; ++i) {
			for (int j = 0; j < AppConstants.N; j++) {
				if (Gale.board.getPiece(i, j).isEnable())
					return false;
			}
		}
		return true;
	}
	
	public void share() {
		
	}
}
