package polytech.polydash.gameStateManager;


import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.draughtboardmanagement.BlockComposite;
import polytech.polydash.draughtboardmanagement.BlockEmpty;
import polytech.polydash.draughtboardmanagement.BlockFix;
import polytech.polydash.draughtboardmanagement.BlockGem;
import polytech.polydash.draughtboardmanagement.BlockMovable;
import polytech.polydash.draughtboardmanagement.Character;
import polytech.polydash.main.Polydash;
import polytech.polydash.utils.Var;
import polytech.polydash.utils.Var.Move;

/**
 * 
 * @author Florian Bonniec, Thomas Le Gougaud
 * 
 */
public class GameState {

	private Block[][] gameState;
	private int xCharacter;
	private int yCharacter;
	private int nbGem;
	// private boolean alive;
	private boolean move;

	/**
	 * Constructeur du plateau
	 * 
	 * @param gameState
	 */
	public GameState(Block[][] gameState) {
		super();
		move = false;
		// alive = true;
		nbGem = 0;
		this.setGameState(gameState);
		for (int i = 0; i < Var.NBROW; i++) {
			for (int j = 0; j < Var.NBROW; j++) {
				if (this.gameState[i][j] instanceof Character) {
					xCharacter = i;
					yCharacter = j;
				}
				if (this.gameState[i][j] instanceof BlockGem) {
					nbGem++;
				}
			}
		}
	}

	/**
	 * Procède a la rotation gauche du tableau de jeu dans le gamestate
	 */
	public void leftRotationGameState() {
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

	/**
	 * Procède a la rotation droite du tableau de jeu dans le gamestate
	 */
	public void rightRotationGameState() {
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

	/**
	 * Initie la rotation droite et vérifie l'état du jeu
	 */
	public void rightRotation() {
		if(gameState[xCharacter][yCharacter] instanceof Character){
			Character c = (Character)gameState[xCharacter][yCharacter];
			if(c.isAlive()){
				rightRotationGameState();
				Var.SCORE++;
			}
		}
		this.checkGameState();
	}

	/**
	 * Initie la rotation gauche et vérifie l'état du jeu
	 */	
	public void leftRotation() {
		if(gameState[xCharacter][yCharacter] instanceof Character){
			Character c = (Character)gameState[xCharacter][yCharacter];
			if(c.isAlive()){
				leftRotationGameState();
				Var.SCORE++;
			}
		}
		this.checkGameState();
	}

	/**
	 * Vérifie entièrement l'état du jeu
	 * Si des blocs doivent tomber si le joueur est vivant/mort, gagnez/perdu
	 */
	public void checkGameState() {
		for (int i = Var.NBROW - 1; i >= 0; i--) {
			for (int j = Var.NBROW - 1; j >= 0; j--) {
				if (this.gameState[i][j] instanceof BlockMovable) {
					movableBlockTraitement(i, j);
				}
				if (this.gameState[i][j] instanceof BlockComposite) {
					if (i + 1 < Var.NBROW
							&& this.gameState[i + 1][j] instanceof BlockEmpty) {
						compositeBlockTraitement(i, j);
					}
				}
			}
		}
		 this.checkWin();
		// this.checkLose();
	}

	/**
	 * Gestion du mouvement du personnage à l'écran, lors de déplacement type :
	 * Gauche, Droite, Haut, Bas
	 * 
	 * @param m
	 */
	public void move(Move m) {
		move = true;
		boolean move = false;
		int x = xCharacter, y = yCharacter;
		if(gameState[xCharacter][yCharacter] instanceof Character){
			Character charac = (Character)gameState[xCharacter][yCharacter];
			if(charac.isAlive()){
		if (m == Var.Move.RIGHT) {
			if (yCharacter + 1 < 20 && yCharacter + 1 >= 0) {
				if (gameState[xCharacter][yCharacter + 1] instanceof BlockEmpty) {
					y = yCharacter + 1;
					//Var.SCORE++;
					move = true;
				} else if (gameState[xCharacter][yCharacter + 1] instanceof BlockGem) {
					y = yCharacter + 1;
					//Var.SCORE++;
					this.nbGem--;
					move = true;
				} else if (yCharacter + 2 < 20
						&& yCharacter + 2 >= 0
						&& gameState[xCharacter][yCharacter + 1] instanceof BlockMovable
						&& gameState[xCharacter][yCharacter + 2] instanceof BlockEmpty) {
					gameState[x][y + 2] = gameState[x][y + 1];
					y = yCharacter + 1;
					//Var.SCORE++;
					move = true;
				} else if (yCharacter + 2 < 20
						&& yCharacter + 2 >= 0
						&& gameState[xCharacter][yCharacter + 1] instanceof BlockComposite
						&& gameState[xCharacter][yCharacter + 2] instanceof BlockEmpty) {
					gameState[x][y + 2] = new BlockMovable(
							Polydash.res.getTexture("mobile_bloc"));
					y = yCharacter + 1;
					//Var.SCORE++;
					nbGem--;
					move = true;
				} else if (yCharacter + 2 < 20
						&& yCharacter + 2 >= 0
						&& gameState[xCharacter][yCharacter + 1] instanceof BlockMovable
						&& gameState[xCharacter][yCharacter + 2] instanceof BlockGem) {
					BlockComposite bc = new BlockComposite(
							Polydash.res.getTexture("mobile_bloc"));
					bc.addBlock(this.gameState[xCharacter][yCharacter + 1]);
					bc.addBlock(this.gameState[xCharacter][yCharacter + 2]);
					gameState[x][y + 2] = bc;
					y = yCharacter + 1;
					//Var.SCORE++;
					move = true;
				}
			}
		} else if (m == Var.Move.LEFT) {
			if (yCharacter - 1 < 20 && yCharacter - 1 >= 0) {
				if (gameState[xCharacter][yCharacter - 1] instanceof BlockEmpty) {
					y = yCharacter - 1;
					//Var.SCORE++;
					move = true;
				} else if (gameState[xCharacter][yCharacter - 1] instanceof BlockGem) {
					y = yCharacter - 1;
					//Var.SCORE++;
					this.nbGem--;
					move = true;
				} else if (yCharacter - 2 < 20
						&& yCharacter - 2 >= 0
						&& gameState[xCharacter][yCharacter - 1] instanceof BlockMovable
						&& gameState[xCharacter][yCharacter - 2] instanceof BlockEmpty) {
					gameState[x][y - 2] = gameState[x][y - 1];
					y = yCharacter - 1;
					//Var.SCORE++;
					move = true;
				} else if (yCharacter - 2 < 20
						&& yCharacter - 2 >= 0
						&& gameState[xCharacter][yCharacter - 1] instanceof BlockComposite
						&& gameState[xCharacter][yCharacter - 2] instanceof BlockEmpty) {
					gameState[x][y - 2] = new BlockMovable(
							Polydash.res.getTexture("mobile_bloc"));
					y = yCharacter - 1;
					//Var.SCORE++;
					nbGem--;
					move = true;
				} else if (yCharacter - 2 < 20
						&& yCharacter - 2 >= 0
						&& gameState[xCharacter][yCharacter - 1] instanceof BlockMovable
						&& gameState[xCharacter][yCharacter - 2] instanceof BlockGem) {
					BlockComposite bc = new BlockComposite(
							Polydash.res.getTexture("mobile_bloc"));
					bc.addBlock(this.gameState[xCharacter][yCharacter - 1]);
					bc.addBlock(this.gameState[xCharacter][yCharacter - 2]);
					gameState[x][y - 2] = bc;
					y = yCharacter - 1;
					//Var.SCORE++;
					move = true;

				}
			}
		} else if (m == Var.Move.DOWN) {
			if (xCharacter + 1 < 20 && xCharacter + 1 >= 0) {
				if (gameState[xCharacter + 1][yCharacter] instanceof BlockEmpty) {
					x = xCharacter + 1;
					//Var.SCORE++;
					move = true;
				} else if (gameState[xCharacter + 1][yCharacter] instanceof BlockGem) {
					x = xCharacter + 1;
					//Var.SCORE++;
					this.nbGem--;
					move = true;
				}
			}
		} else if (m == Var.Move.UP) {
			if (xCharacter - 1 < 20 && xCharacter - 1 >= 0) {
				if (gameState[xCharacter - 1][yCharacter] instanceof BlockEmpty) {
					x = xCharacter - 1;
					//Var.SCORE++;
					move = true;
				} else if (gameState[xCharacter - 1][yCharacter] instanceof BlockGem) {
					x = xCharacter - 1;
					//Var.SCORE++;
					this.nbGem--;
					move = true;
				}
				}
			}
		}
		if (move) {
			Var.SCORE++;
			gameState[x][y] = charac;
			gameState[xCharacter][yCharacter] = new BlockEmpty(
					Polydash.res.getTexture("empty"));
			xCharacter = x;
			yCharacter = y;
			move = false;
			this.checkGameState();
		}
		}
	}

	/**
	 * Gestion des blocs composite (BlockMovable+BlockGem)
	 * @param i
	 * @param j
	 */
	private void compositeBlockTraitement(int i, int j) {
		Block bm = this.gameState[i][j].getMovableFromComposite();
		Block bg = this.gameState[i][j].getGemFromComposite();
		this.gameState[i][j] = bm;
		movableBlockTraitement(i, j);
		this.gameState[i][j] = bg;
	}

	/**
	 * Gestion du déplacement d'un blocs
	 * @param i
	 * @param j
	 */
	private void movableBlockTraitement(int i, int j) {
		Block blockdeplace = this.gameState[i][j];
		Block blockremplace = this.gameState[i][j];
		Character player = null;
		int cpt = i + 1;
		boolean trouve = false;
		while (cpt < Var.NBROW && !trouve) {
			if (this.gameState[cpt][j] instanceof BlockEmpty) {
				cpt++;
				blockremplace = this.gameState[cpt][j];
			} else if (this.gameState[cpt][j] instanceof BlockGem) {
				if (cpt + 1 < Var.NBROW
						&& !(this.gameState[cpt + 1][j] instanceof BlockEmpty)) {
					blockdeplace = new BlockComposite(
							Polydash.res.getTexture("mobile_bloc"));
					blockdeplace.addBlock(this.gameState[i][j]);
					blockdeplace.addBlock(this.gameState[cpt][j]);
					blockremplace = new BlockEmpty(
							Polydash.res.getTexture("empty"));
					trouve = true;

				} else {

					cpt++;
					blockremplace = this.gameState[cpt][j];
				}
			} else if (this.gameState[cpt][j] instanceof Character) {
				player = (Character) this.gameState[cpt][j];
				player.setAlive(false);
				// alive = false;
				cpt++;
			} else if (this.gameState[cpt][j] instanceof BlockFix) {
				cpt--;
				blockremplace = this.gameState[cpt][j];
				trouve = true;
			} else {
				cpt--;
				blockremplace = this.gameState[cpt][j];
				trouve = true;
			}

		}
		if (player != null) {
			if (!player.isAlive()) {
				blockremplace = new BlockEmpty(Polydash.res.getTexture("empty"));
				this.gameState[xCharacter][yCharacter] = new BlockEmpty(Polydash.res.getTexture("empty"));
			}
		}
		this.gameState[i][j] = blockremplace;
		this.gameState[cpt][j] = blockdeplace;
	}

	// /**
	// * Verifie si les condition de victoire sont remplies
	// */
	private void checkWin() {
	if(nbGem==0){
		if(gameState[xCharacter][yCharacter] instanceof Character){
			Character charac = (Character)gameState[xCharacter][yCharacter];
			if(charac.isAlive()){
				charac.setAlive(false);
			}
		}
	}
	}
	
	// private void checkWin() {
	// if (nbGem == 0)
	// for (int i = 0; i < Var.NBROW; i++) {
	// for (int j = 0; j < Var.NBROW; j++) {
	// if (i == 7 && j == 0) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 1) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 11 && j == 2) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 3) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 7 && j == 4) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 5) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 11 && j == 6) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 7) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 7 && j == 8) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 7 && j == 11) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 8 && j == 11) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 11) {
	// gameState[i][j] = new Character(
	// Polydash.res.getTexture("miner"));
	// xCharacter = i;
	// yCharacter = j;
	// } else if (i == 10 && j == 11) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 11 && j == 11) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 7 && j == 14) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 8 && j == 14) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 14) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 10 && j == 14) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 11 && j == 14) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 8 && j == 15) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 16) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 10 && j == 17) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 10 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 7 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 8 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 9 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 10 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else if (i == 11 && j == 18) {
	// gameState[i][j] = new BlockGem(
	// Polydash.res.getTexture("ruby"));
	// } else {
	// gameState[i][j] = new BlockEmpty(
	// Polydash.res.getTexture("empty"));
	// }
	// }
	// }
	// }
	//
	// /**
	// * Verifie si les condition de défaite sont remplies
	// */
	// private void checkLose() {
	// if (!alive) {
	// for (int i = 0; i < Var.NBROW; i++) {
	// for (int j = 0; j < Var.NBROW; j++) {
	// gameState[i][j] = new BlockFix(
	// Polydash.res.getTexture("fix_bloc"));
	// }
	// }
	// }
	// }

	/**
	 * 
	 * @return gameState
	 */
	public Block[][] getGameState() {
		return gameState;
	}

	/**
	 * 
	 * @param gameState
	 */
	public void setGameState(Block[][] gameState) {
		this.gameState = gameState;
	}

	/**
	 * 
	 * @return xCharacter
	 */
	public int getxCharacter() {
		return xCharacter;
	}

	/**
	 * 
	 * @return yCharacter
	 */
	public int getyCharacter() {
		return yCharacter;
	}

	/**
	 * 
	 * @param xCharacter
	 */
	public void setxCharacter(int xCharacter) {
		this.xCharacter = xCharacter;
	}

	/**
	 * 
	 * @param yCharacter
	 */
	public void setyCharacter(int yCharacter) {
		this.yCharacter = yCharacter;
	}

	/**
	 * 
	 * @return nbGem
	 */
	public int getNbGem() {
		return nbGem;
	}

	/**
	 * 
	 * @param nbGem
	 */
	public void setNbGem(int nbGem) {
		this.nbGem = nbGem;
	}

	/**
	 * 
	 * @return move
	 */
	public boolean isMove() {
		return move;
	}

	/**
	 * 
	 * @param move
	 */
	public void setMove(boolean move) {
		this.move = move;
	}
}
