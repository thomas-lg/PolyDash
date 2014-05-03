package polytech.polydash.screens;

import polytech.polydash.main.Polydash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HUD implements Screen {
	  final Polydash game;
	private TextureRegion[] font;

	public HUD(Polydash game) {
		this.game = game;
		setGrid();
		Texture texture = new Texture(
				Gdx.files.internal("res/chiffres.png"));
		font = new TextureRegion[8];
		for (int i = 0; i < 8; i++) {
			font[i] = new TextureRegion(texture, i * 32, 0, 32, 32);
		}
	}

	private void setGrid() {
		// TODO (Thomas -> Je check ça demain on aura tout le grid si je suis chaud <3)
	}

	private void printHUD(String s, int x, int y) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c < '8') {
				c -= '0';
				game.batch.draw(font[c], x + i * 28, y);
			}
		}
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
		
		game.batch.begin();

		// draw crystal amount
		printHUD(String.valueOf(500), 10, 350);

		game.batch.end();

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
