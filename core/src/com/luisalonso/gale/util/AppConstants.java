package com.luisalonso.gale.util;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class AppConstants {

	/* GENERAL */
	public static final String GAME_PREFERENCES_NAME = "Gale Preferences";
	public static final int HUMAN_HUMAN_MODE = 0;
	public static final int HUMAN_MACHINE_MODE = 1;
	public static final int LEVEL_1 = 0;
	public static final int LEVEL_2 = 1;
	public static final int LEVEL_3 = 2;
	
	/* PLAYERS */
	public static final int PLAYER_1 = 1;
	public static final int PLAYER_2 = 2;
	public static final int MACHINE_PLAYER = 3;
	
	public static final String PLAYER_1_NAME = "Mortal";
	public static final String PLAYER_2_NAME = "Avenger";
	public static final String MACHINE_NAME = "Skynet";
	
	/* VIEWPORT */
	public static final int VIEWPORT_WIDTH = 540;
	public static final int VIEWPORT_HEIGHT = 960;
	public static final int BACKGROUND_WIDTH = VIEWPORT_WIDTH * 2;
	
	/* PATHS */
	public static final String TEXTURES_PATH = "resources/";
	public static final String FONTS_PATH = "fonts/";
	public static final String BUTTON_BLUE = "button_blue.png";
	public static final String HOME_BUTTON = "home_button.png";
	public static final String SHARE_BUTTON = "share_button.png";
	public static final String GREEN_PIECE_NAME = "green_piece.png";
	public static final String RED_PIECE_NAME = "red_piece.png";
	public static final String BACKGROUND_NAME = "background.png";
	public static final String REPLAY_BUTTON_NAME = "replay_button.png";
	public static final String GAME_OVER_NAME = "game_over.png";
	public static final String SECTION_WHITE = "section_white.png";
	public static final String LETTERS_STYLE = "letters.fnt";
	public static final String NUMBERS_STYLE = "numbers.fnt";
	public static final String LOGO = "logo.png";
	
	/* PIECES */
	public static final int GREEN = 0;
	public static final int RED = 1;
	public static final int LOCKED = 0;
	public static final int ENABLE = 1;
	public static final int PIECE_SIZE = 60;
	
	/* GAME BOARD */
	public static final int N = 7;
	
	/* IA */
	public static final int PLUS_INF = 2 << 20;
	public static final int MINUS_INF = - (2 << 20);
}
