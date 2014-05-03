package polytech.polydash.main;

import polytech.polydash.screens.HUD;
import polytech.polydash.screens.TestScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Polydash extends Game{
	
	public static final String TITLE = "Polydash";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 200;
	public static final int SCALE = 2;
	public SpriteBatch batch;
	public BitmapFont font;
	
	public void create() {
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
