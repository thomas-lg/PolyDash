package polytech.polydash.gameStateManager;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.draughtboardmanagement.BlockEmpty;
import polytech.polydash.draughtboardmanagement.BlockFix;
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
				if (newGameState[(Var.NBROW - 1) - j][i] instanceof Character) {
					xCharacter = (Var.NBROW - 1) - j;
					yCharacter = i;
				}
			}
		}
		this.setGameState(newGameState);
	}

	public void rightRotationGameState() {
		System.out.println("Rotation droite");
		Block[][] newGameState = new Block[Var.NBROW][Var.NBROW];
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				newGameState[j][(Var.NBROW - 1) - i] = this.gameState[i][j];
				if (newGameState[j][(Var.NBROW - 1) - i] instanceof Character) {
					xCharacter = j;
					yCharacter = (Var.NBROW - 1) - i;
				}
			}
		}
		this.setGameState(newGameState);
	}

	public void rightRotation() {
		rightRotationGameState();
		this.checkGameState();
	}

	public void leftRotation() {
		leftRotationGameState();
		this.checkGameState();
	}

	public void checkGameState() {
		System.out.println("check");
		for (int i = Var.NBROW - 1; i >= 0; i--) {
			for (int j = Var.NBROW - 1; j >= 0; j--) {
				if (this.gameState[i][j] instanceof BlockMovable) {
					System.out.println(i + " " + j);
					movableBlockTraitement(i, j);
				}
				/*
				 * if (this.gameState[i][j] instanceof BlockComposite) { Block
				 * gemme = this.gameState[i][j].getGemFromComposite(); Block
				 * movable = this.gameState[i][j] .getMovableFromComposite();
				 * this.gameState[i][j] = movable; movableBlockTraitement(i, j);
				 * this.gameState[i][j] = gemme; }
				 */
			}
		}
	}

	/**
	 * Gestion du mouvement du personnage à l'écran, lors de déplacement type :
	 * Gauche, Droite, Haut, Bas
	 * 
	 * @param m
	 */
	public void move(Move m) {
		boolean move = false;
		int x = xCharacter, y = yCharacter;
		Block charac;
		if (m == Var.Move.RIGHT) {
			if (yCharacter + 1 < 20 && yCharacter + 1 >= 0) {
				if (gameState[xCharacter][yCharacter + 1] instanceof BlockEmpty) {
					y = yCharacter + 1;
					Var.SCORE++;
					move = true;
				} else if (yCharacter + 2 < 20
						&& yCharacter + 2 >= 0
						&& gameState[xCharacter][yCharacter + 1] instanceof BlockMovable
						&& gameState[xCharacter][yCharacter + 2] instanceof BlockEmpty) {
					gameState[x][y + 2] = gameState[x][y + 1];
					y = yCharacter + 1;
					Var.SCORE++;
					move = true;
				}
			}
		}
		if (m == Var.Move.LEFT) {
			if (yCharacter - 1 < 20
					&& yCharacter - 1 >= 0
					&& gameState[xCharacter][yCharacter - 1] instanceof BlockEmpty) {
				y = yCharacter - 1;
				Var.SCORE++;
				move = true;
			} else if (yCharacter - 2 < 20
					&& yCharacter - 2 >= 0
					&& gameState[xCharacter][yCharacter - 1] instanceof BlockMovable
					&& gameState[xCharacter][yCharacter - 2] instanceof BlockEmpty) {
				gameState[x][y - 2] = gameState[x][y - 1];
				y = yCharacter - 1;
				Var.SCORE++;
				move = true;
			}
		}
		if (m == Var.Move.DOWN) {
			if (xCharacter + 1 < 20
					&& xCharacter + 1 >= 0
					&& gameState[xCharacter + 1][yCharacter] instanceof BlockEmpty) {
				x = xCharacter + 1;
				Var.SCORE++;
				move = true;
			} else if (xCharacter + 1 < 20
					&& xCharacter + 1 >= 0
					&& gameState[xCharacter + 1][yCharacter] instanceof BlockMovable
					&& gameState[xCharacter + 2][yCharacter] instanceof BlockEmpty) {
				gameState[xCharacter + 2][y] = gameState[x + 1][y];
				x = xCharacter + 1;
				Var.SCORE++;
				move = true;
			}
		}
		if (m == Var.Move.UP) {
			if ((xCharacter - 1 < 20 && xCharacter - 1 >= 0 && gameState[xCharacter - 1][yCharacter] instanceof BlockEmpty)) {
				x = xCharacter - 1;
				Var.SCORE++;
				move = true;
			} else if (xCharacter - 1 < 20
					&& xCharacter - 1 >= 0
					&& gameState[xCharacter - 1][yCharacter] instanceof BlockMovable
					&& gameState[xCharacter - 2][yCharacter] instanceof BlockEmpty) {
				gameState[xCharacter - 2][y] = gameState[x - 1][y];
				x = xCharacter - 1;
				Var.SCORE++;
				move = true;
			}
		}

		if (move) {
			charac = gameState[xCharacter][yCharacter];
			gameState[x][y] = charac;
			gameState[xCharacter][yCharacter] = new BlockEmpty(
					Polydash.res.getTexture("empty"));

			// gameState[xCharacter][yCharacter].setImg(gameState[x][y].getImg());
			// gameState[x][y].setImg(charac.getImg());
			xCharacter = x;
			yCharacter = y;
			this.checkGameState();
			System.out.println("x : " + xCharacter + " y : " + yCharacter);
		}
		System.out.println("x : " + xCharacter + " y : " + yCharacter);
	}

	private void movableBlockTraitement(int i, int j) {
		Block blockdeplace = this.gameState[i][j];
		Block blockremplace = this.gameState[i][j];
		int cpt = 1;
		for (cpt = 1; i + cpt < Var.NBROW; cpt++) {
			if (this.gameState[i + cpt][j] instanceof BlockEmpty) {
				blockremplace = this.gameState[i + cpt][j];
			} else if (this.gameState[i + cpt][j] instanceof BlockGem) {
				blockremplace = this.gameState[i + cpt][j];
				// blockremplace = new BlockComposite(
				// Polydash.res.getTexture("mobile_bloc")); // TODO image a
				// //
				// modifier
				// blockremplace.addBlock(this.gameState[i][j]);
				// blockremplace.addBlock(this.gameState[i + cpt][j]);
				// this.gameState[i + cpt][j] = blockremplace;
				// blockdeplace = new
				// BlockEmpty(Polydash.res.getTexture("empty"));// TODO
				// image
				// a
				// modifier
				// break;
			} else if (this.gameState[i + cpt][j] instanceof Character) {
				Character player = (Character) this.gameState[i + cpt][j];
				player.setAlive(false);
				// blockdeplace = new
				// BlockEmpty(Polydash.res.getTexture("empty"));// TODO
				// image
				// a
				// modifier
				blockremplace = new BlockEmpty(Polydash.res.getTexture("empty"));
			} else if (this.gameState[i + cpt][j] instanceof BlockFix) {
				cpt--;
				break;
			} else {
				blockremplace = this.gameState[i + cpt][j];
				blockdeplace = this.gameState[i + cpt - 1][j];
				break;
			}
		}
		this.gameState[i][j] = blockremplace;
		this.gameState[i + cpt][j] = blockdeplace;
	}

	public Block[][] getGameState() {
		return gameState;
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
