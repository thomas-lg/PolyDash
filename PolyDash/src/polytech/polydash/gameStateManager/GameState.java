package polytech.polydash.gameStateManager;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.draughtboardmanagement.BlockComposite;
import polytech.polydash.draughtboardmanagement.BlockEmpty;
import polytech.polydash.draughtboardmanagement.BlockGem;
import polytech.polydash.draughtboardmanagement.BlockMovable;
import polytech.polydash.draughtboardmanagement.BlockSpecial;
import polytech.polydash.main.Polydash;

public class GameState {

	private Block[][] gameState;

	public GameState(Block[][] gameState) {
		super();
		this.setGameState(gameState);
	}

	public void leftRotation(){
		Block[][] newGameState = new Block[this.gameState.length][this.gameState.length];
		for (int i = 0; i < this.gameState.length; i++){
			for (int j = 0; j < this.gameState.length; j++){
				newGameState[(this.gameState.length-1)-j][i] = this.gameState[i][j];
			}
		}
		this.setGameState(newGameState);
	}

	public void rightRotation(){
		Block[][] newGameState = new Block[this.gameState.length][this.gameState.length];
		for (int i = 0; i < this.gameState.length; i++){
			for (int j = 0; j < this.gameState.length; j++){
				newGameState[j][(this.gameState.length-1)-i] = this.gameState[i][j];
			}
		}
		this.setGameState(newGameState);
	}

	public void checkGameState(){
		System.out.println("check");
		for(int i = this.gameState.length-1; i >= 0; i--){
			for(int j = this.gameState.length-1; j >= 0; j--){
					if(this.gameState[i][j] instanceof BlockMovable){
						for(int cpt = 1; i+cpt<this.gameState.length-1;cpt++){
						if(this.gameState[i+cpt][j] instanceof BlockEmpty){
							Block tmp = this.gameState[i+cpt][j];
							this.gameState[i+cpt][j] = this.gameState[i][j];
							this.gameState[i][j] = tmp;
						}else if(this.gameState[i+cpt][j] instanceof BlockGem){
							BlockComposite tmp = new BlockComposite(Polydash.res.getTexture("mobile_bloc")); // TODO image a modifier
							tmp.addBlock((BlockSpecial)this.gameState[i+cpt][j]);
							tmp.addBlock((BlockSpecial)this.gameState[i+cpt-1][j]);
							this.gameState[i+cpt][j] = tmp;
							this.gameState[i+cpt-1][j] = new BlockEmpty(Polydash.res.getTexture("empty"));// TODO image a modifier
						}
					}
				}
			}
		}
	}

	public Block[][] getGameState() {
		return gameState;
	}

	public void setGameState(Block[][] gameState) {
		this.gameState = gameState;
	}





}
