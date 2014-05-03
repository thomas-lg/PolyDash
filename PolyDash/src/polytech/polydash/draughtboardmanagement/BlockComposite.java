package polytech.polydash.draughtboardmanagement;

import java.util.Arrays;

public class BlockComposite extends BlockSpecial{
	private BlockSpecial[] blockComposite;
	private final int nbComposite = 2;

	public BlockComposite(String file) {
		super(file);
		this.blockComposite = new BlockSpecial[nbComposite];
	}
	
	public void  addBlock(BlockSpecial block){
		if(blockComposite.length<nbComposite){
			blockComposite[blockComposite.length] = block;
		}
	}
	
	@Override
	public String toString() {
		return "O";
	}

	public void  removeBlock(BlockSpecial block){
		if(blockComposite.length==nbComposite){
			if(blockComposite[0] instanceof BlockMovable){
				blockComposite[0] = null;
			}
			else if(blockComposite[1] instanceof BlockMovable){
				blockComposite[1] = null;
			}
		}
	}

}
