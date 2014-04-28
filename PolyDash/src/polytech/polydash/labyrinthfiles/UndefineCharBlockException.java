package polytech.polydash.labyrinthfiles;

public class UndefineCharBlockException extends Exception{
	
	/**
	 * @author Antoine Pasquier
	 */
	private static final long serialVersionUID = 1L;

	public UndefineCharBlockException(){
		super();
	}

	@Override
	public String getMessage() {
		return "Le caractere ne correspond pas a un Block dans le langage pdash";
	}

}
