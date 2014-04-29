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

/**
 * 
 * @author Florian Bonniec
 * @worker Florian Bonniec, Antoine Pasquier
 *
 */
public class Reader {
	private final int damierSize = 20;
	private File level;
	public Reader(String Filepath){
		this.level = new File(Filepath);
	}


	public Block[][] readFile() throws IOException {
		String line;
		int index=0;
		Block[][] dammier = new Block[damierSize][damierSize];
		BufferedReader readwithBuffer = openFile(this.level);
		while ((line = readwithBuffer.readLine()) != null && index<damierSize) {
			try {
				line = line.replaceAll(" ", ""); // A revoir 
				for(int i=0;i<damierSize;i++){
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

	private BufferedReader openFile(File f){
		try {
			return new BufferedReader(new FileReader(this.level));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found in .../PolyDash/level/");
			e.printStackTrace();
			return null; 
		}
	}

	private Block getInstanceBlock(char c) throws UndefineCharBlockException {
		switch (c)
		{
		case '_': return new BlockEmpty(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"Block_Vide.png");
		case '#': return new BlockFix(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"block.png");
		case 'O': return new BlockMovable(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"BlockMobile.png");
		case 'G': return new BlockGem(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"ruby.png");
		case 'P': return new Character(".."+File.separator+"PolyDash"+File.separator+"Ressources"+File.separator+"Miner.png");
		default : throw new UndefineCharBlockException();
		}
	}


}
