package com.luisalonso.gale.util.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class CustomLabel extends GUIResource{
	
	public CustomLabel(Texture texture, float x, float y) {
		super(texture,x,y);
	}
	
	public CustomLabel(Texture texture, float x, float y, boolean visibility) {
		super(texture,x,y, visibility);
	}
	
	public CustomLabel(Texture texture, float width, float height, float x, float y){
		super(texture, width, height, x, y);
	}
	
	public CustomLabel(Texture texture, float width, float height, float x, float y, boolean visibility){
		super(texture, width, height, x, y, visibility);
	}
	
	public CustomLabel(TextureRegion texture[], float time, float x, float y){
		super(texture,time,x,y);
	}
}
