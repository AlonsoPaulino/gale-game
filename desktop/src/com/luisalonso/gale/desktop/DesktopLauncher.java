package com.luisalonso.gale.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.luisalonso.gale.GaleGame;
import com.luisalonso.gale.util.AppConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = AppConstants.VIEWPORT_WIDTH * 3 / 4;
		config.height = AppConstants.VIEWPORT_HEIGHT * 3 / 4;
		new LwjglApplication(new GaleGame(), config);
	}
}
