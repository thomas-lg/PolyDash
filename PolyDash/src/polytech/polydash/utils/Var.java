package polytech.polydash.utils;


/**
 * 
 * @author Thomas Le Gougaud
 * 
 */
public final class Var {

	// Enum
	public static enum Move {
		LEFT, RIGHT, UP, DOWN;
	}

	// Gestion du fenêtrage
	public static final String TITLE = "Polydash";
	public static final int V_WIDTH = 1024;
	public static final int V_HEIGHT = 768;
	public static final int SCALE = 1;

	// Gestion du damier
	public static final int NBROW = 20;

	// Score
	public static int SCORE = 0;

	public static String LEVEL = "level1.pdash";
}
