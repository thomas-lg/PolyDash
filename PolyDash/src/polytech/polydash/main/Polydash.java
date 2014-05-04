package polytech.polydash.main;

import java.io.File;
import java.io.IOException;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.gameStateManager.GameState;
import polytech.polydash.handlers.Content;
import polytech.polydash.labyrinthfiles.Reader;
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
		Reader r = new Reader(".."+File.separator+"PolyDash"+File.separator+"level"+File.separator+"level2.txt");
		Block[][] dammier = new Block[20][20];
			try {
				dammier = r.readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameState gs = new GameState(dammier);
			printDammier(gs.getGameState());
			//gs.leftRotation();
			//printDammier(gs.getGameState());
			gs.checkGameState();
			printDammier(gs.getGameState());
		
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
	
	public void test(){
	try {
	Reader r = new Reader(".."+File.separator+"PolyDash"+File.separator+"level"+File.separator+"level2.txt");
	Block[][] dammier = new Block[20][20];
		dammier = r.readFile();
		GameState gs = new GameState(dammier);
		printDammier(gs.getGameState());
		//gs.leftRotation();
		//printDammier(gs.getGameState());
		gs.checkGameState();
		printDammier(gs.getGameState());
		//gs.rightRotation();
		//printDammier(gs.getGameState());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void printDammier(Block[][] dammier){
	System.out.println("Debut Dammier");
	try{
	for(int i =0;i<20;i++){
		for(int j =0;j<20;j++){
			System.out.print(dammier[i][j].toString());
		}
		System.out.println();
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.println("Fin Dammier");
	
}

}
