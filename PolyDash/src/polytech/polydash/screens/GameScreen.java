package polytech.polydash.screens;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.main.Polydash;
import polytech.polydash.utils.Var;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 
 * @author Thomas Le Gougaud
 * 
 */
public class GameScreen implements Screen {
	final Polydash game;

	/**
	 * Constructeur de l'écran du jeu
	 * 
	 * @param game
	 */
	public GameScreen(Polydash game) {
		this.game = game;
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

	/**
	 * Permet la mise à jour automatique de l'écran lors d'événement
	 */
	@Override
	public void render(float arg0) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		game.getBatch().begin();

		game.getGs().checkGameState();
		printScore(String.valueOf(Var.SCORE));
		printGrid();

		game.getBatch().end();
	}

	/**
	 * Affichage de la grille sur l'écran
	 */
	private void printGrid() {
		Block[][] grid = game.getGs().getGameState();
		int x = 28;
		int y = Var.V_HEIGHT - 75;
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				game.getBatch().draw(grid[i][j].getImg(), x, y);
				x = x + 32;
			}
			x = 28;
			y = y - 32;

		}
	}

	/**
	 * Affichage du score sur l'écran
	 * 
	 * @param s
	 * @param x
	 * @param y
	 */
	private void printScore(String s) {
		Texture score = Polydash.res.getTexture("score");
		Texture texture = Polydash.res.getTexture("chiffres");
		TextureRegion[] font = new TextureRegion[10];
		int x = 28;
		int y = Var.V_HEIGHT - 40;
		game.getBatch().draw(score, x, y);

		for (int i = 0; i < 10; i++) {
			font[i] = new TextureRegion(texture, i * 32, 0, 32, 32);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				c -= '0';
				game.getBatch().draw(font[c], x + 150 + i * 28, y);
			}
		}
	}

}
