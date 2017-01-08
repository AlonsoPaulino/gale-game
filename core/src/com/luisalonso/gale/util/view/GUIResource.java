package com.luisalonso.gale.util.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public abstract class GUIResource extends Actor{
	
	protected TextureRegion mTextureRegion;
	private Animation mAnimation;
	private float mStateTime = 0;

	public GUIResource(Texture texture, float x, float y) {
		mTextureRegion = new TextureRegion(texture);
		setHeight(texture.getHeight());
		setWidth(texture.getWidth());
		setX(x); this.setY(y);
		setOrigin(texture.getWidth()/2, texture.getHeight()/2);
	}
	
	public GUIResource(Texture texture, float x, float y, boolean visibility) {
		mTextureRegion = new TextureRegion(texture);
		setHeight(texture.getHeight());
		setWidth(texture.getWidth());
		setX(x); this.setY(y);
		setOrigin(texture.getWidth()/2, texture.getHeight()/2);
		setVisible(visibility);
	}
	
	public GUIResource(Texture texture, float width, float height, float x, float y){
		mTextureRegion = new TextureRegion(texture);
		setHeight(height);
		setWidth(width);
		setOrigin(width/2, height/2);
		setPosition(x, y);
	}
	
	public GUIResource(Texture texture, float width, float height, float x, float y, boolean visibility){
		mTextureRegion = new TextureRegion(texture);
		setHeight(height);
		setWidth(width);
		setOrigin(width/2, height/2);
		setPosition(x, y);
		setVisible(visibility);
	}
	
	public GUIResource(TextureRegion[] texture_region, float time, float x, float y){
		mTextureRegion = texture_region[0];
		setWidth(mTextureRegion.getRegionWidth());
		setHeight(mTextureRegion.getRegionHeight());
		setOrigin(getWidth()/2, getHeight()/2);
		setPosition(x, y);
		mAnimation = new Animation(time, texture_region);
	}
	
	public void setAnimation(TextureRegion[] texture_region, float time){
		mTextureRegion = texture_region[0];
		mAnimation = new Animation(time, texture_region);
	}
	
	@Override
	public void act(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		mStateTime += Gdx.graphics.getDeltaTime();
		if(mAnimation != null){
			if(mAnimation.isAnimationFinished(mStateTime)) mStateTime = 0;
			mTextureRegion = mAnimation.getKeyFrame(mStateTime);
		}
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(mTextureRegion, getX(), getY(), getOriginX(), getOriginY(),
				   getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		super.draw(batch, parentAlpha);
	}

	public TextureRegion getTextureRegion(){
		return mTextureRegion;
	}
	
	public Texture getTexture(){
		return mTextureRegion.getTexture();
	}
	
	public void setTexture(Texture texture){
		mTextureRegion = new TextureRegion(texture);
	}	
}
