package polytech.polydash.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Polydash.TITLE;
		cfg.width = Polydash.V_WIDTH * Polydash.SCALE;
		cfg.height = Polydash.V_HEIGHT * Polydash.SCALE;
		cfg.useGL20 = false;
		new LwjglApplication(new Polydash(), cfg);
	}

}
