package Exception;

public class AbscenceOperande extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbscenceOperande(){
		System.out.println("ERREUR : Entrer au moins deux operandes !!");
	}
}
