package polytech.polydash.draughtboardmanagement;

import com.badlogic.gdx.graphics.Texture;

public abstract class Block {
	
	private Texture texture;
	
	public Block(Texture text){
		this.texture = text;
	}

	public Texture getImg() {
		return texture;
	}
	
	public abstract Block getMovableFromComposite();
		
	
	public abstract Block getGemFromComposite();
		
	
	public abstract void addBlock(Block b) ;
    	
    
	public void setImg(Texture text) {
		this.texture = text;
	}
	

}
