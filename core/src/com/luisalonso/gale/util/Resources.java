package com.luisalonso.gale.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class Resources {
	
	private ResourceManager mResourceManager;
	
	public BitmapFont mLettersStyle;
	public BitmapFont mNumbersStyle;
	
	public Texture mGreenPiece;
	public Texture mRedPiece;
	public Texture mBackground;
	public Texture mButtonBlue;
	public Texture mReplayButton;
	public Texture mHomeButton;
	public Texture mShareButton;
	public Texture mGameOver;
	public Texture mSectionWhite;
	public Texture mLogo;
	
	public Resources() {
		mResourceManager = new ResourceManager(new AssetManager());
		mResourceManager.loadTexture(AppConstants.GREEN_PIECE_NAME);
		mResourceManager.loadTexture(AppConstants.BUTTON_BLUE);
		mResourceManager.loadTexture(AppConstants.HOME_BUTTON);
		mResourceManager.loadTexture(AppConstants.SHARE_BUTTON);
		mResourceManager.loadTexture(AppConstants.RED_PIECE_NAME);
		mResourceManager.loadTexture(AppConstants.BACKGROUND_NAME);
		mResourceManager.loadTexture(AppConstants.REPLAY_BUTTON_NAME);
		mResourceManager.loadTexture(AppConstants.GAME_OVER_NAME);
		mResourceManager.loadTexture(AppConstants.SECTION_WHITE);
		mResourceManager.loadBitMap(AppConstants.LETTERS_STYLE);
		mResourceManager.loadBitMap(AppConstants.NUMBERS_STYLE);
		mResourceManager.loadTexture(AppConstants.LOGO);
		
		while (!mResourceManager.update());
		
		mGreenPiece = mResourceManager.getTexture(AppConstants.GREEN_PIECE_NAME);
		mButtonBlue = mResourceManager.getTexture(AppConstants.BUTTON_BLUE);
		mRedPiece = mResourceManager.getTexture(AppConstants.RED_PIECE_NAME);
		mBackground = mResourceManager.getTexture(AppConstants.BACKGROUND_NAME);
		mReplayButton = mResourceManager.getTexture(AppConstants.REPLAY_BUTTON_NAME);
		mHomeButton = mResourceManager.getTexture(AppConstants.HOME_BUTTON);
		mShareButton = mResourceManager.getTexture(AppConstants.SHARE_BUTTON);
		mGameOver = mResourceManager.getTexture(AppConstants.GAME_OVER_NAME);
		mSectionWhite = mResourceManager.getTexture(AppConstants.SECTION_WHITE);
		mLettersStyle = mResourceManager.getFont(AppConstants.LETTERS_STYLE);
		mNumbersStyle = mResourceManager.getFont(AppConstants.NUMBERS_STYLE);
		mLogo = mResourceManager.getTexture(AppConstants.LOGO);
	}
}
