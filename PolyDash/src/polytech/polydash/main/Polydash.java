package polytech.polydash.main;

import java.io.File;
import java.io.IOException;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.gameStateManager.GameState;
import polytech.polydash.handlers.Content;
import polytech.polydash.handlers.PInputProcessor;
import polytech.polydash.labyrinthfiles.Reader;
import polytech.polydash.screens.GameScreen;
import polytech.polydash.utils.Var;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Thomas Le Gougaud
 * 
 */
public class Polydash extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	public static Content res;
	private GameState gs;

	/**
	 * Init de tous les fichiers de ressources, de la gestion des inputs et du damier
	 */
	public void create() {
		res = new Content();
		
		
		res.loadTexture("res" + File.separator + "fix_bloc.png");
		res.loadTexture("res" + File.separator + "empty.png");
		res.loadTexture("res" + File.separator + "mobile_bloc.png");
		res.loadTexture("res" + File.separator + "ruby.png");
		res.loadTexture("res" + File.separator + "miner.png");
		res.loadTexture("res" + File.separator + "miner_move.png");

		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();

		this.setScreen(new GameScreen(this));

		Reader r = new Reader("level" + File.separator + Var.LEVEL);
		Block[][] dammier = new Block[Var.NBROW][Var.NBROW];
		try {
			dammier = r.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs = new GameState(dammier);
	//	printDammier(gs.getGameState());
//		gs.leftRotation();
//		printDammier(gs.getGameState());
//		gs.checkGameState();
//		gs.rightRotation();
//		gs.checkGameState();
//		printDammier(gs.getGameState());
		Gdx.input.setInputProcessor(new PInputProcessor(gs));
	}

	@Override
	public void dispose() {
		super.dispose();
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

	public static void printDammier(Block[][] dammier) {
		System.out.println("Debut Dammier");
		try {
			for (int i = 0; i < Var.NBROW; i++) {
				for (int j = 0; j < Var.NBROW; j++) {
					System.out.print(dammier[i][j].toString());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin Dammier");

	}

	/**
	 * 
	 * @return batch
	 */
	public SpriteBatch getBatch() {
		return batch;
	}

	/**
	 * 
	 * @return font
	 */
	public BitmapFont getFont() {
		return font;
	}

	/**
	 * 
	 * @return gs
	 */
	public GameState getGs() {
		return gs;
	}
	
	public void setGs(GameState gs) {
		this.gs = gs;
	}
}
