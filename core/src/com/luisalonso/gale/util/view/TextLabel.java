package com.luisalonso.gale.util.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class TextLabel extends Label{
	
	private LabelStyle style;
	
	public TextLabel(String text, LabelStyle style, float x, float y) {
		this (text, style, x, y, 1f, 1f);
	}
	
	public TextLabel(String text, LabelStyle style, float x, float y, float fontScale) {
		this (text, style, x, y, fontScale, fontScale);
	}
	
	public TextLabel(String text, LabelStyle style, float x, float y, float fontScaleX, float fontScaleY) {
		super (text, style);
		this.style = style;
		setPosition(x, y);
		setFontScale(fontScaleX, fontScaleY);
	}
	
	public void setFontColor(Color color) {	
		style.fontColor = color;		
	}
	
	public void setFont(BitmapFont font) {	
		style.font = font;		
	}
}
