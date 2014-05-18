package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Florian Bonniec, Thomas Le Gougaud
 * 
 */

public class BlockMovable extends BlockSpecial {

	public BlockMovable(Texture text) {
		super(text);
	}

	@Override
	public String toString() {
		return "O";
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
