package polytech.polydash.vues;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import polytech.polydash.draughtboardmanagement.Character;


public class HUD {
	private Character player;
	private TextureRegion[] font;
	
	public HUD(Character player) {
		this.player = player;
		Texture texture = new Texture(Gdx.files.internal("Ressources/chiffres.png"));
		font = new TextureRegion[8];
		for(int i = 0; i < 8; i++) {
			font[i] = new TextureRegion(texture, i * 32, 0, 32, 32);
		}
	}
	
	public void render(SpriteBatch sb) {
		
		sb.begin();
		
		// draw crystal amount
		printHUD(sb, String.valueOf(player.getMoves()), 10, 350);
		
		sb.end();
		
	}
	
	private void printHUD(SpriteBatch sb, String s, int x, int y) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c>='0' && c<'8'){
			c -='0'; 
			sb.draw(font[c], x + i *28, y);
			}
		}
	}
	
}

