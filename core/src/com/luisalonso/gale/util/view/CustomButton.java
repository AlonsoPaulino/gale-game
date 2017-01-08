package com.luisalonso.gale.util.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.FloatAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class CustomButton extends GUIResource {
	
	private ClickListener mListener;
	public void executeAction(){};
	
	public CustomButton(Texture texture, float x, float y) {
		super(texture,x,y);
		initButton();
	}
	
	public CustomButton(Texture texture, float x, float y, boolean visibility) {
		super(texture,x,y, visibility);
		initButton(); 
	}
	
	public CustomButton(Texture texture, float width, float height, float x, float y){
		super(texture, width, height, x, y);
		initButton();
	}
	
	public CustomButton(Texture texture, float width, float height, float x, float y, boolean visibility){
		super(texture, width, height, x, y, visibility);
		initButton();
	}

	public void initButton(){
		mListener = new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				CustomButton.this.addAction(new ScaleToAction(){
					@Override
					protected void begin() {
						super.begin();
						setScale(1.1f);
						setDuration(0.1f);						
					}
				});
				return super.touchDown(event, x, y, pointer, button);
			}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				CustomButton.this.addAction(
					new SequenceAction(
							new ScaleToAction(){
								@Override
								protected void begin() {
									super.begin();
									setScale(1f);
									setDuration(0.1f);		
								}
							},
							new FloatAction(){
								@Override
								protected void begin() {
									super.begin();
									setDuration(0.05f);		
								}
								
								@Override
								protected void end() {
									executeAction();
								}
							})
				);			
				super.touchUp(event, x, y, pointer, button);
			}
		};
		this.addListener(mListener);
	}
	
	public ClickListener getClickListener() {
		return mListener;
	}
}
