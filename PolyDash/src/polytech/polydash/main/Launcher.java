package polytech.polydash.main;

import polytech.polydash.utils.Var;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * 
 * @author Thomas Le Gougaud
 * 
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Var.TITLE;
		cfg.width = Var.V_WIDTH * Var.SCALE;
		cfg.height = Var.V_HEIGHT * Var.SCALE;
		cfg.useGL20 = false;
		if (args.length == 1) {
			Var.LEVEL = args[0];
		}
		new LwjglApplication(new Polydash(), cfg);
	}
}
