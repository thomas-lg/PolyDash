package polytech.polydash.screens;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.main.Polydash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {
	final Polydash game;
	private int testNb = 500;

	public GameScreen(Polydash game) {
		this.game = game;
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
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		game.getSpriteBatch().begin();
		// draw crystal amount
		printScore(String.valueOf(testNb), 10, 350);
		printGrid();

		game.getSpriteBatch().end();
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			testNb++;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			testNb--;
		}
	}

	private void printGrid() {
		Block[][] grid = game.getGameState().getGameState();
		float x = 100;
		float y = 10;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				game.getSpriteBatch().draw(grid[i][j].getImg(), x, y);
				y = y + 32;
			}
			x = x + 32;
			y = 10;

		}
	}

	private void printScore(String s, int x, int y) {
		Texture texture = new Texture(Gdx.files.internal("res/chiffres.png"));
		TextureRegion[] font = new TextureRegion[8];
		for (int i = 0; i < 8; i++) {
			font[i] = new TextureRegion(texture, i * 32, 0, 32, 32);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c < '8') {
				c -= '0';
				game.getSpriteBatch().draw(font[c], x + i * 28, y);
			}
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
