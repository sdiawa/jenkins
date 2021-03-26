package sofrone;



import java.util.Scanner;

import Exception.AbscenceOperande;
import Exception.DenominateurNull;
import Exception.EntreNonValide;
import Exception.ValeurHorsDomaine;
import sofrone.MoteurRpn;

public class saissieRpn {
	public MoteurRpn moteurRpn;
    private Scanner sc;
    private double max=500;
    private double min=0;
    
	public saissieRpn(){
		moteurRpn = new MoteurRpn();
		sc = new Scanner(System.in);
		

	}
	public boolean start() throws AbscenceOperande, EntreNonValide, DenominateurNull, ValeurHorsDomaine {
		
		String s = sc.next();
		return saissieUtilisateur(s);

			
	}
	
	public boolean saissieUtilisateur(String s) throws  EntreNonValide, ValeurHorsDomaine, AbscenceOperande, DenominateurNull{
	 
		if(s.equals("+")) 
			s = "PLUS";		
		if(s.equals("-"))
			s = "MINUS";
		if(s.equals("*"))
			s = "MULT";
		if(s.equals("/"))
			s = "DIVIDE";
		if(s.equals("PLUS") || s.equals("MINUS") || s.equals("MULT") || s.equals("DIVIDE")){
			moteurRpn.enregistre(s);
			moteurRpn.afficherPile();
				return true;
			}
			else 
				if(s.equals("exit")) {
				
				return false;
			}
			else{ 
				double operande;
				try{
				 operande = Double.parseDouble(s);
				}catch(Exception e){
					throw new EntreNonValide();
				}
				 
				moteurRpn.empiler(operande);
				moteurRpn.afficherPile();
				return true;
			
				 
		
		}
	}
	
}
