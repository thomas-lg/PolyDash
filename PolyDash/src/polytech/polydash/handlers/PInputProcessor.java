package polytech.polydash.handlers;

import polytech.polydash.gameStateManager.GameState;
import polytech.polydash.utils.Var;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Gestion des inputs
 * @author Thomas Le Gougaud
 * 
 */
public class PInputProcessor implements InputProcessor {

	GameState gs;

	/**
	 * Constructeur
	 * @param gs
	 */
	public PInputProcessor(GameState gs) {
		this.gs = gs;
	}
	
	@Override
	public boolean keyDown(int k) {
		if (k == Keys.RIGHT)
			gs.move(Var.Move.RIGHT);
		if (k == Keys.LEFT) {
			gs.move(Var.Move.LEFT);
		}
		if (k == Keys.DOWN) {
			gs.move(Var.Move.DOWN);
		}
		if (k == Keys.UP) {
			gs.move(Var.Move.UP);
		}
		if (k == Keys.SHIFT_RIGHT) {
			gs.rightRotation();
		}
		if (k == Keys.SHIFT_LEFT) {
			gs.leftRotation();
		}
		return true;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
