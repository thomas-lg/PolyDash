package polytech.polydash.labyrinthfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import polytech.polydash.draughtboardmanagement.Block;
import polytech.polydash.draughtboardmanagement.BlockEmpty;
import polytech.polydash.draughtboardmanagement.BlockFix;
import polytech.polydash.draughtboardmanagement.BlockGem;
import polytech.polydash.draughtboardmanagement.BlockMovable;
import polytech.polydash.draughtboardmanagement.Character;
import polytech.polydash.main.Polydash;
import polytech.polydash.utils.Var;

/**
 * 
 * @author Florian Bonniec,Antoine Pasquier
 *
 */
public class Reader {
	private File level;
	public Reader(String Filepath){
		this.level = new File(Filepath);
	}

/**
 * Permet de transcrire un fichier correctement formaté en un dammier de 20*20 ( le plateau de jeu)
 * Retourne un message d'erreur si le fichier n'est pas au bon format.
 * @return le plateau de jeu matrice de 20*20
 * @throws IOException
 */
	public Block[][] readFile() throws IOException {
		String line;
		int index=0;
		Block[][] dammier = new Block[Var.NBROW][Var.NBROW];
		BufferedReader readwithBuffer = openFile(this.level);
		while ((line = readwithBuffer.readLine()) != null && index<Var.NBROW) {
			try {
				line = line.replaceAll(" ", ""); // A revoir 
				for(int i=0;i<Var.NBROW;i++){
					dammier[index][i]= getInstanceBlock(line.charAt(i));
				}
				index++;
			} catch (UndefineCharBlockException error) { //end try
				JOptionPane.showMessageDialog(null, "Is not the right format for" +this.level.getAbsolutePath());
				readwithBuffer.close();
				System.out.println(error.getMessage());
				return null;
			}
		}
		readwithBuffer.close();
		return dammier;
	}
/**
 * Permet d'ouvrir un fichier, retourne un message à l'utilisateur si le fichier est introuvable
 * 
 * @param f correspond au fichier à ouvrir  
 * @return BufferedReader qui permet de lire le fichier ligne par ligne
 */
	private BufferedReader openFile(File f){
		try {
			return new BufferedReader(new FileReader(this.level));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found in .../PolyDash/level/");
			e.printStackTrace();
			return null; 
		}
	}
	
	/**
	 * 
	 * @param caractere identifiant le block demandé
	 * @return le block souhaité
	 * @throws UndefineCharBlockException (caractére inconnue)
	 */

	private  Block getInstanceBlock(char c) throws UndefineCharBlockException {
		switch (c)
		{
		case '_': return new BlockEmpty(Polydash.res.getTexture("empty"));
		case '#': return new BlockFix(Polydash.res.getTexture("fix_bloc"));
		case 'O': return new BlockMovable(Polydash.res.getTexture("mobile_bloc"));
		case 'G': return new BlockGem(Polydash.res.getTexture("ruby"));
		case 'P': return new Character(Polydash.res.getTexture("miner"));
		default : throw new UndefineCharBlockException();
		}
	}


}
