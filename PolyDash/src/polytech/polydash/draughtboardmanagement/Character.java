package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class Character extends Block {
	private boolean alive;
	private int moves=567;
	
	public Character(Texture text){
		super(text);
		this.setAlive(true);
	}
	@Override
	public String toString() {
		return "P";
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getMoves() 
	{
		return moves;
	}
	

}
