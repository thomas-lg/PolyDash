package polytech.polydash.handlers;

import java.io.File;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * HashMap des ressources
 * 
 * @author Thomas Le Gougaud
 */
public class Content {

	private HashMap<String, Texture> textures;

	/**
	 * Init des différentes HashMap
	 */
	public Content() {
		textures = new HashMap<String, Texture>();
	}

	/**
	 * Chargement d'une texture en mémoire
	 * 
	 * @param path
	 */
	public void loadTexture(String path) {
		int slashIndex = path.lastIndexOf(File.separator);
		String key;
		if (slashIndex == -1) {
			key = path.substring(0, path.lastIndexOf('.'));
		} else {
			key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
		}
		loadTexture(path, key);
	}

	private void loadTexture(String path, String key) {
		Texture tex = new Texture(Gdx.files.internal(path));
		textures.put(key, tex);
	}

	/**
	 * Get de HashMap
	 * 
	 * @param key
	 * @return Une texture
	 */
	public Texture getTexture(String key) {
		return textures.get(key);
	}

	/**
	 * Supprime une texture
	 * 
	 * @param key
	 */
	public void removeTexture(String key) {
		Texture tex = textures.get(key);
		if (tex != null) {
			textures.remove(key);
			tex.dispose();
		}
	}
}
