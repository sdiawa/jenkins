/**  
 * Cette classe permet de quitter une partie en cours. 

 * 
 
 **/

package fr.uvsq.Donjon_RogueLike.evenement;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.uvsq.Donjon_RogueLike.fichiers.enregistres.SauvegarderPartie;
import fr.uvsq.Donjon_RogueLike.menu.Menu;
import fr.uvsq.Donjon_RogueLike.menu.NouvellePartieMenu;
import fr.uvsq.Donjon_RogueLike.piece.Piece;

public class QuitterPartie extends SauvegarderPartie
{
	/****
	 * Cette méthode permet de quitter la partie en cours , à la demande de l'utilisateur. 
	 * @param pieces: correspond aux piéces du terrain.
	 * @param nbPieces: nombre de piéce du terrain.
	 */
	public static void quitPartie(Piece pieces[],int nbPieces)
	{
		System.out.println("\n\n\t Voulez-vous quitter la partie ? o/n");
		String quit = SauvegarderPartie.readClavier();
		
		Menu.effaceEcran();
		if(quit.equals("o"))
		{
			SauvegarderPartie.savePartie(pieces,nbPieces);
			Menu.effaceEcran();
			Menu menu = new Menu();
			menu.gestionMenu();
		}		
		
	}
	
	/***
	 * Cette méthode permet de quitter la partie , lorsque le joueur atteint la porte de sortie.
	 * @return false, si le joueur choisit de rester. 
	 */
	public static boolean endGame()
	{
		int choix = 0;
		System.out.println("\n\n\t Vous vous trouvez � la porte de sortie");
		System.out.println("\t Voulez-vous :\n");
		System.out.println("\n\t 1- Continuer d'explorer le donjon ");
		System.out.println("\t 2- Lancer une nouvelle partie");
		System.out.println("\t 3- Quitter ");
		
		 Scanner input = new Scanner(System.in);
 		   
		   try
		    {
			    while(choix != 1 && choix != 2 && choix != 3)
			     {
			    	System.out.println("\n\n\t\t   Veuillez saisir votre choix \n\n\n");
			    	choix = input.nextInt();
			    	Menu.effaceEcran(); 
			    	
			     }			   
		    }
		   catch(InputMismatchException e)
		    {
			   System.out.println("\n\t\t   Votre saisie est incorrecte !!!");
			   Menu.effaceEcran();
		    }
		   finally
		   {
			switch(choix)
			     {
			        case 1:
			        break;
			        case 2:
			        	NouvellePartieMenu n = new NouvellePartieMenu();
			        	n.gestionMenu();

			        default:
			        	input.close();
			        	System.exit(1);
			        break;	
			   
			     }
			   
		   }
		   return false;
		   
	}
}
