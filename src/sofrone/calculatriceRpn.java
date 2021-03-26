package sofrone;



import Exception.AbscenceOperande;

import Exception.DenominateurNull;
import Exception.EntreNonValide;
import Exception.ValeurHorsDomaine;
import sofrone.saissieRpn;

//les énumérations héritent de la classe java.lang.Enum

public enum calculatriceRpn {


	calculatriceRpn;
	
	
	public static void main(String[] args) throws Exception{
		
				saissieRpn s = new saissieRpn();
				System.out.println("Saissie :");
				try {
					while(s.start()){
						
					}
				} catch (DenominateurNull | ValeurHorsDomaine | AbscenceOperande | EntreNonValide e) {
					
					
				}
	}
}
