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
	
	public void setImg(Texture text) {
		this.texture = text;
	}
	

}
