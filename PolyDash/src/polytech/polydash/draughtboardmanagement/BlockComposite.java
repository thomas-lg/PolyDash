package polytech.polydash.draughtboardmanagement;

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
