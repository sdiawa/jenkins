package Exception;

public class EntreNonValide extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntreNonValide(){
		System.out.println("ERREUR : La valeur entree est non valide !!");
	}
}