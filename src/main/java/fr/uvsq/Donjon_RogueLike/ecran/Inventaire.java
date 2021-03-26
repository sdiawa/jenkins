/**
 * Cette classe gére et affiche l'inventaire du personnage joueur.

 * @author diawara 
 */

package fr.uvsq.Donjon_RogueLike.ecran;

import java.util.Scanner;


import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur;
import fr.uvsq.Donjon_RogueLike.menu.Menu;

public class Inventaire 
{
	
	
	/**
	 * Affiche l'inventaire du PJ
	 * @param PJ : personnage joueur.
	 */
	public static void afficherInventaire(PersonnageJoueur PJ)
	{		
		Menu.effaceEcran();
		
		System.out.println("\n\t\t***********************************************");
		System.out.println("\t\t|                Inventaire                   |");
		System.out.println("\t\t|                                             |");
		System.out.println("\t\t***********************************************");
		     
		System.out.println(PJ);
		     
		Scanner sc = new Scanner(System.in);
		String en = "default";
	
		while(!en.equals("r"))
		 {
		    System.out.println("\n\t\t Appuyer sur 'r' pour revenir à la partie");	
		    en  = sc.nextLine();
		 }
		     
		
		Menu.effaceEcran();
		
	}
}
