package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class BlockEmpty extends Block {

	public BlockEmpty(Texture text) {
		super(text);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "_";
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
