package polytech.polydash.labyrinthfiles;

import polytech.polydash.draughtboardmanagement.*;
import polytech.polydash.draughtboardmanagement.Character;

public class BlockFactory {
	
	/**
	 * Constructeur de BlockFactory
	 */
	public BlockFactory() {
		super();
	}

	/**
	 * Méthode permettant de transcrire un caractère de l'alphabet choisi en un Block
	 * @param c représentant le caractère à transcrire
	 * @return un Block
	 * @throws UndefineCharBlockException 
	 */
	/*public Block getInstanceBlock(char c) throws UndefineCharBlockException {
		switch (c)
		{
		  case '_': return new BlockEmpty();
		  case '#': return new BlockFix();
		  case 'O': return new BlockMovable();
		  case 'G': return new BlockGem();
		  case 'P': return new Character();
		  default : throw new UndefineCharBlockException();
		}
	}*/
}
