package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public class BlockComposite extends BlockSpecial{
	private BlockSpecial[] blockComposite;
	private int nbComposite = 0;

	public BlockComposite(Texture text) {
		super(text);
		this.blockComposite = new BlockSpecial[2];
	}
	
	
	@Override
	public String toString() {
		return "c";
	}

	
	public Block getMovableFromComposite(){
		Block movable = null; //TODO a revoir
			if(blockComposite[0] instanceof BlockMovable){
				movable = blockComposite[0];
			}
			else if(blockComposite[1] instanceof BlockMovable){
				movable = blockComposite[1];
			}
		System.out.println(movable);
		return movable;
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

	@Override
	public void addBlock(Block b) {
		if(nbComposite<2){
			blockComposite[nbComposite] = (BlockSpecial) b;
			//System.out.println("<"+b.toString()+">");
			nbComposite++;
		}
		
	}


	@Override
	public Block getGemFromComposite() {
		Block gemme = null; //TODO a revoir
			if(blockComposite[0] instanceof BlockGem){
				gemme = blockComposite[0];
			}
			else if(blockComposite[1] instanceof BlockGem){
				gemme = blockComposite[1];
			}
		System.out.println(gemme);
		return gemme;
	}

}
