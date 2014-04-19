package polytech.polydash.labyrinthfiles;

import java.io.IOException;

import polytech.polydash.draughtboardmanagement.Block;

public class MainTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r = new Reader("C:\\Users\\Florian\\Desktop\\level.txt");
		Block[][] dammier = new Block[20][20];
		dammier = r.readFile();
		System.out.println("Debut Dammier");
		for(int i =0;i<20;i++){
			for(int j =0;j<20;j++){
				System.out.print(dammier[i][j].toString());
			}
			System.out.println();
		}
		System.out.println("Fin Dammier");
	}

}
