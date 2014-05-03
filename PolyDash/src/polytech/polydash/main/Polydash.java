package polytech.polydash.main;

import polytech.polydash.handlers.Content;
import polytech.polydash.screens.TestScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Polydash extends Game {

	public static final String TITLE = "Polydash";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 200;
	public static final int SCALE = 2;
	public SpriteBatch batch;
	public BitmapFont font;
	public static Content res;

	public void create() {
		res = new Content();
		
		res.loadTexture("res/fix_block.png");
		res.loadTexture("res/empty.png");
		res.loadTexture("res/mobile_bloc.png");
		res.loadTexture("res/ruby.png");
		res.loadTexture("res/miner.png");
		res.loadTexture("res/miner_move.png");

		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new TestScreen(this));
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
