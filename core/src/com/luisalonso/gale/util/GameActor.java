package com.luisalonso.gale.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GameActor extends Actor{
	
	protected TextureRegion mTextureRegion;
	
	public GameActor() {
		// TODO Auto-generated constructor stub
	}
	
	public GameActor(Texture texture){
		setTexture(texture);
	}
	
	public GameActor(Texture texture, int width, int height) {
		setTexture(texture, width, height);
	}
	
	public void setTexture(Texture texture) {
		mTextureRegion = new TextureRegion(texture);
		setSize(texture.getWidth(), texture.getHeight());
	}
	
	public void setTexture(Texture texture, int width, int height) {
		mTextureRegion = new TextureRegion(texture);
		setSize(width, height);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(mTextureRegion, getX(), getY(), getOriginX(), getOriginY(),
				   getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		super.draw(batch, parentAlpha);
	}
}
