package polytech.polydash.gameStateManager;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.draughtboardmanagement.BlockComposite;
import polytech.polydash.draughtboardmanagement.BlockEmpty;
import polytech.polydash.draughtboardmanagement.BlockGem;
import polytech.polydash.draughtboardmanagement.BlockMovable;
import polytech.polydash.draughtboardmanagement.Character;
import polytech.polydash.main.Polydash;
import polytech.polydash.utils.Var;
import polytech.polydash.utils.Var.Move;

public class GameState {

	private Block[][] gameState;
	private int xCharacter;
	private int yCharacter;

	public GameState(Block[][] gameState) {
		super();
		this.setGameState(gameState);
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				if (this.gameState[i][j] instanceof Character) {
					xCharacter = i;
					yCharacter = j;
				}
			}
		}
	}

	public void leftRotationGameState() {
		System.out.println("Rotation gauche");
		Block[][] newGameState = new Block[Var.NBROW][Var.NBROW];
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				newGameState[(Var.NBROW - 1) - j][i] = this.gameState[i][j];
			}
		}
		this.setCharacterPosLeft();
		this.setGameState(newGameState);
	}
	public void rightRotation() {
		rightRotationGameState();
		checkGameState();
	}
	public void leftRotation(){
		leftRotationGameState();
		checkGameState();
	}
	public void rightRotationGameState() {
		System.out.println("Rotation droite");
		Block[][] newGameState = new Block[Var.NBROW][Var.NBROW];
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				newGameState[j][(Var.NBROW - 1) - i] = this.gameState[i][j];
			}
		}
		this.setCharacterPosRight();
		this.setGameState(newGameState);
	}

	public void checkGameState() {
		System.out.println("check");
		for (int i = Var.NBROW - 1; i >= 0; i--) {
			for (int j = Var.NBROW - 1; j >= 0; j--) {
				if (this.gameState[i][j] instanceof BlockMovable) {
					movableBlockTraitement(i, j);
				}
				/*if (this.gameState[i][j] instanceof BlockComposite) {
					Block gemme = this.gameState[i][j].getGemFromComposite();
					Block movable = this.gameState[i][j]
							.getMovableFromComposite();
					this.gameState[i][j] = movable;
					movableBlockTraitement(i, j);
					this.gameState[i][j] = gemme;
				}*/
			}
		}
	}

	/**
	 * Temporaire Rajouter enum de l'état de l'écran 0,90,180,270 et faire les
	 * modifs de l'emplacement du perso xCharater et tout voir la maj de l'écran
	 * 
	 * @param m
	 */
	public void move(Move m) {
		int x = xCharacter, y = yCharacter;
		Block charac;
		if (m == Var.Move.RIGHT) {
			if(gameState[xCharacter][yCharacter+1]instanceof BlockEmpty && yCharacter+1<20  && yCharacter+1>=0){
			y = yCharacter + 1;
			}
		}
		if (m == Var.Move.LEFT) {
			if(gameState[xCharacter][yCharacter-1]instanceof BlockEmpty && yCharacter-1<20  && yCharacter-1>=0){
			y = yCharacter - 1;
			}
		}
		if (m == Var.Move.DOWN) {
			if(gameState[xCharacter+1][yCharacter]instanceof BlockEmpty && xCharacter+1<20  && xCharacter+1>=0){
			x = xCharacter + 1;
			}
		}
		if (m == Var.Move.UP) {
			if((gameState[xCharacter-1][yCharacter]instanceof BlockEmpty) && xCharacter-1<20  && xCharacter-1>=0 ){
			x = xCharacter - 1;
			}
		}
		charac = gameState[xCharacter][yCharacter];
		gameState[xCharacter][yCharacter] = gameState[x][y];
		gameState[x][y] = charac;
		//gameState[xCharacter][yCharacter].setImg(gameState[x][y].getImg());
		//gameState[x][y].setImg(charac.getImg());
		xCharacter = x;
		yCharacter = y;
		System.out.println("x : " + xCharacter + " y : " + yCharacter);
	}

	private void movableBlockTraitement(int i, int j) {
		Block tmp = this.gameState[i][j];
		Block replaceBy = this.gameState[i][j];
		int cpt = 1;
		for (cpt = 1; i + cpt < Var.NBROW - 1; cpt++) {
			if (this.gameState[i + cpt][j] instanceof BlockEmpty) {
				tmp = this.gameState[i][j];
				replaceBy = this.gameState[i][j];
			} else if (this.gameState[i + cpt][j] instanceof BlockGem) {
				replaceBy = new BlockComposite(
						Polydash.res.getTexture("mobile_bloc")); // TODO image a
																	// //
																	// modifier
				replaceBy.addBlock(this.gameState[i][j]);
				replaceBy.addBlock(this.gameState[i + cpt][j]);
				this.gameState[i + cpt][j] = replaceBy;
				tmp = new BlockEmpty(Polydash.res.getTexture("empty"));// TODO
																		// image
																		// a
																		// modifier
				break;
			} else if (this.gameState[i + cpt][j] instanceof Character) {
				Character player = (Character) this.gameState[i + cpt][j];
				player.setAlive(false);
				tmp = new BlockEmpty(Polydash.res.getTexture("empty"));// TODO
																		// image
																		// a
																		// modifier
				replaceBy = this.gameState[i][j];
				break;
			} else {
				replaceBy = this.gameState[i + cpt][j];
				tmp = this.gameState[i + cpt - 1][j];
				break;
			}
		}
		this.gameState[i + cpt][j] = replaceBy;
		this.gameState[i][j] = tmp;
	}

	public Block[][] getGameState() {
		return gameState;
	}

	private void setCharacterPosRight() {
		int tmp = xCharacter;
		if (xCharacter <= (Var.NBROW / 2) && yCharacter <= (Var.NBROW / 2)) {
			xCharacter = yCharacter;
			yCharacter = Var.NBROW - tmp;
		}
		if (xCharacter > (Var.NBROW / 2) && yCharacter > (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - yCharacter;
			yCharacter = Var.NBROW - tmp;
		}
		if (xCharacter > (Var.NBROW / 2) && yCharacter <= (Var.NBROW / 2)) {
			xCharacter = yCharacter;
			yCharacter = Var.NBROW - yCharacter;
		}
		if (xCharacter <= (Var.NBROW / 2) && yCharacter > (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - xCharacter;
			yCharacter = xCharacter;
		}
	}

	private void setCharacterPosLeft() {
		int tmp = xCharacter;
		if (xCharacter <= (Var.NBROW / 2) && yCharacter <= (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - yCharacter;
			yCharacter = xCharacter;
		}
		if (xCharacter > (Var.NBROW / 2) && yCharacter > (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - yCharacter;
			yCharacter = Var.NBROW - tmp;
		}
		if (xCharacter > (Var.NBROW / 2) && yCharacter <= (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - yCharacter;
			yCharacter = tmp;
		}
		if (xCharacter <= (Var.NBROW / 2) && yCharacter > (Var.NBROW / 2)) {
			xCharacter = Var.NBROW - yCharacter;
			yCharacter = Var.NBROW - tmp;
		}
	}

	public void setGameState(Block[][] gameState) {
		this.gameState = gameState;
	}

	public int getxCharacter() {
		return xCharacter;
	}

	public int getyCharacter() {
		return yCharacter;
	}

	public void setxCharacter(int xCharacter) {
		this.xCharacter = xCharacter;
	}

	public void setyCharacter(int yCharacter) {
		this.yCharacter = yCharacter;
	}

}
