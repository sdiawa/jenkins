package Exception;

public class DenominateurNull extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DenominateurNull(){
		System.out.println("ERREUR : IMPOSSIBLE DE DIVISER PAR 0 !!!");
	}
}