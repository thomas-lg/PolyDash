package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Florian Bonniec
 * 
 */

public class Character extends Block {
	private boolean alive;

	public Character(Texture text) {
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

	@Override
	public Block getMovableFromComposite() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Block getGemFromComposite() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addBlock(Block b) {
		throw new UnsupportedOperationException();

	}

}
