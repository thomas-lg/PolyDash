package polytech.polydash.main;

import java.io.File;

import polytech.polydash.draughtboardmanagement.Character;
import polytech.polydash.labyrinthfiles.Reader;
import polytech.polydash.vues.HUD;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener{
	
	public static final String TITLE = "Polydash";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 200;
	public static final int SCALE = 2;
	
	
	private SpriteBatch sb;
	
	@Override
	public void create() {
		Character c = new Character(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"Miner.png");
		HUD hud = new HUD(c);
		sb = new SpriteBatch();
		hud.render(sb);
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
