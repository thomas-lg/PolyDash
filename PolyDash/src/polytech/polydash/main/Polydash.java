package polytech.polydash.main;

import java.io.File;
import java.io.IOException;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.gameStateManager.GameState;
import polytech.polydash.handlers.Content;
import polytech.polydash.handlers.PInputProcessor;
import polytech.polydash.labyrinthfiles.Reader;
import polytech.polydash.screens.TestScreen;
import polytech.polydash.utils.Var;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Thomas
 * 
 */
public class Polydash extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	public static Content res;
	private GameState gs;

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

		this.setScreen(new TestScreen(this));

		Reader r = new Reader("level" + File.separator + "level.txt");
		Block[][] dammier = new Block[Var.NBROW][Var.NBROW];
		try {
			dammier = r.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs = new GameState(dammier);
//		printDammier(gs.getGameState());
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

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	public GameState getGs() {
		return gs;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public void setGs(GameState gs) {
		this.gs = gs;
	}
}
