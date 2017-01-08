package com.luisalonso.gale.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class ResourceManager {
	
	private AssetManager mAssetManager;
	
	public ResourceManager(AssetManager assetManager) {
		mAssetManager = assetManager;
	}
	
	public void loadTexture(String path) {
		TextureParameter parameter = new TextureParameter();
		parameter.minFilter = TextureFilter.Linear;
		parameter.magFilter = TextureFilter.Linear;
		mAssetManager.load(AppConstants.TEXTURES_PATH + path, Texture.class, parameter);
	}
	
	public void loadBitMap(String path){
		BitmapFontParameter parameter = new BitmapFontParameter();
		parameter.minFilter = TextureFilter.Linear;
		parameter.magFilter = TextureFilter.Linear;
		mAssetManager.load(AppConstants.FONTS_PATH + path, BitmapFont.class, parameter);
	}
	
	public BitmapFont getFont(String path){
		return mAssetManager.get(AppConstants.FONTS_PATH + path, BitmapFont.class);
	}
	
	public TextureAtlas getTextureAtlas(String path){
		return mAssetManager.get(AppConstants.FONTS_PATH + path, TextureAtlas.class);
	}
	
	public Texture getTexture(String path) {
		return mAssetManager.get(AppConstants.TEXTURES_PATH + path, Texture.class);
	}
	
	public boolean update() {
		return mAssetManager.update();
	}
}
