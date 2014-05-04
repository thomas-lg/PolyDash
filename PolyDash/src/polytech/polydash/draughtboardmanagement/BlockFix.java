package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class BlockFix extends Block {

	public BlockFix(Texture text) {
		super(text);
		// TODO Auto-generated constructor stub
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
