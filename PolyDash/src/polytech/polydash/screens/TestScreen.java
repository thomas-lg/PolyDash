package polytech.polydash.screens;

import polytech.polydash.main.Polydash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class TestScreen implements Screen {
	  final Polydash game;

		OrthographicCamera camera;

		
	public TestScreen(final Polydash gam) {
		game = gam;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.getSpriteBatch().setProjectionMatrix(camera.combined);

		game.getSpriteBatch().begin();
		game.getBitmapFont().draw(game.getSpriteBatch(), "Welcome to Polydash!!! ", 100, 150);
		game.getBitmapFont().draw(game.getSpriteBatch(), "Tap anywhere to begin!", 100, 100);
		game.getSpriteBatch().end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
