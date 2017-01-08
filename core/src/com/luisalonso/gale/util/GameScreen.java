package com.luisalonso.gale.util;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * @author Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */

public class GameScreen implements Screen{

	private final String TAG = GameScreen.this.getClass().getSimpleName();
	protected Stage mStage;
	
	public GameScreen() {
		mStage = new Stage(new FitViewport(AppConstants.VIEWPORT_WIDTH, AppConstants.VIEWPORT_HEIGHT));
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mStage.act();
		mStage.draw();
	}
	
	public Stage getStage() {
		return mStage;
	}
	
	@Override
	public void resize(int width, int height) {
		mStage.getViewport().update(width, height, true);
	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "on show screen");
	}
	
	@Override
	public void hide() {
		Gdx.app.log(TAG, "on hide screen");
	}
	
	@Override
	public void pause() {
		Gdx.app.log(TAG, "on pause screen");
	}
	
	@Override
	public void resume() {
		Gdx.app.log(TAG, "on resume screen");
	}
	
	@Override
	public void dispose() {
		Gdx.app.log(TAG, "on dispose screen");
	}
}
