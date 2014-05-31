package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Florian Bonniec, Thomas Le Gougaud
 * 
 */

public abstract class BlockSpecial extends Block {

	public BlockSpecial(Texture text) {
		super(text);
	}

	@Override
	public abstract Block getMovableFromComposite();

	@Override
	public abstract Block getGemFromComposite();

	@Override
	public abstract void addBlock(Block b);
}
