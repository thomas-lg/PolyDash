package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class BlockFix extends Block {

	/**
	 * 
	 * @author Florian Bonniec, Thomas Le Gougaud
	 * 
	 */

	public BlockFix(Texture text) {
		super(text);
	}

	@Override
	public String toString() {
		return "#";
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
