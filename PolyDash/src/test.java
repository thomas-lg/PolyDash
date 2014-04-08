import polytech.polydash.labyrinthfiles.*;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hi you");
		
		BlockFactory blockFactory = new BlockFactory();
		try {
			System.out.println(blockFactory.getInstanceBlock('#'));
			System.out.println(blockFactory.getInstanceBlock('a'));
		} catch (UndefineCharBlockException e) {
			System.out.println(e.getMessage());
		}
	}
}
