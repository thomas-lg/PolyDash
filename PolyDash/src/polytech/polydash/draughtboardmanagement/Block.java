package polytech.polydash.draughtboardmanagement;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Block {
	
	private Image img;
	
	public Block(String file){
		setImg(file);
	}

	public Image getImg() {
		return img;
	}

	public void setImg(String file) {
		ImageIcon img = new ImageIcon(file);
		this.img = img.getImage();
	}
	

}
