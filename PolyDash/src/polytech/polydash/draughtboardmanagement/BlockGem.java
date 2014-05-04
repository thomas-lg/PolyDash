package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class BlockGem extends BlockSpecial {

	public BlockGem(Texture text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "G";
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
