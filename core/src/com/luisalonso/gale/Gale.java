package com.luisalonso.gale;

import com.luisalonso.gale.actors.GameBoard;
import com.luisalonso.gale.util.AppConstants;
import com.luisalonso.gale.util.PreferencesManager;
import com.luisalonso.gale.util.Resources;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class Gale {
	
	public static GaleGame game;
	public static GameBoard board;
	public static Resources resources;
	public static PreferencesManager preferencesManager;
	public static float machineDelay;
	public static int player;
	public static int mode;
	public static int level;
	
	public static void setDelay() {
		if (level == AppConstants.LEVEL_1) {
			machineDelay = 1f;
		} else if (level == AppConstants.LEVEL_2) {
			machineDelay = 1f;
		} else if (level == AppConstants.LEVEL_3) {
			machineDelay = 2f;
		}
	}
	
	public static void resetConf() {
		player = AppConstants.PLAYER_1;
	}
	
}
