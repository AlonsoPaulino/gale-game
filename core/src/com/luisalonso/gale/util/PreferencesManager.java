package com.luisalonso.gale.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class PreferencesManager {
	
	private Preferences mPreferences;
	
	public PreferencesManager() {
		mPreferences = Gdx.app.getPreferences(AppConstants.GAME_PREFERENCES_NAME);
	}
	
	public void addString(String key, String value){
		mPreferences.putString(key, value);
		mPreferences.flush();
	}
	
	public void addInt(String key, int value) {
		mPreferences.putInteger(key, value);
		mPreferences.flush();
	}
	
	public String getString(String key){
		return mPreferences.getString(key, "");
	}
	
	public int getInt(String key) {
		return mPreferences.getInteger(key, -1);
	}
}
