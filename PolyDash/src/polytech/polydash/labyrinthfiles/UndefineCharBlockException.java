package polytech.polydash.labyrinthfiles;

public class UndefineCharBlockException extends Exception{
	
	public UndefineCharBlockException(){
		super();
	}

	@Override
	public String getMessage() {
		return "Le caractere ne correspond pas a un Block dans le langage pdash";
	}

}
