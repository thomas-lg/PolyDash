package polytech.polydash.gameStateManager;

import polytech.polydash.draughtboardmanagement.Block;

public class GameState {
	
	private Block[][] gameState;

	public GameState(Block[][] gameState) {
		super();
		this.setGameState(gameState);
	}
	
	public void rightRotation(){
		Block[][] newGameState = new Block[this.gameState.length][this.gameState.length];
        for (int i = 0; i < this.gameState.length; i++)
            for (int j = 0; j < this.gameState.length; j++)
            	newGameState[j][i] = this.gameState[i][j];
        this.setGameState(newGameState);
	}
	
	public Block[][] leftRotation(){
		return null;
	}
	
	public Block[][] getGameState() {
		return gameState;
	}

	public void setGameState(Block[][] gameState) {
		this.gameState = gameState;
	}
	
	
	
	

}
