package polytech.polydash.draughtboardmanagement;

public class Character extends Block {
	private boolean alive;
	private int moves=0;
	
	public Character(String file){
		super(file);
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
