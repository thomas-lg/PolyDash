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
	 * @param game
	 */
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

	/**
	 * Permet la mise à jour automatique de l'écran lors d'événement
	 */
	@Override
	public void render(float arg0) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		game.getBatch().begin();
		
		game.getGs().checkGameState();
		printScore(String.valueOf(Var.SCORE), 10, 350);
		printGrid();

		game.getBatch().end();
	}

	/**
	 * Affichage de la grille sur l'écran
	 */
	private void printGrid() {
		Block[][] grid = game.getGs().getGameState();
		float x = 100;
		float y = Var.V_HEIGHT-50;
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				game.getBatch().draw(grid[i][j].getImg(), x, y);
				x = x + 32;
			}
			x = 100;
			y = y-32;

		}
	}

	/**
	 * Affichage du score sur l'écran
	 * 
	 * @param s
	 * @param x
	 * @param y
	 */
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
				game.getBatch().draw(font[c], x + i * 28, y);
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
