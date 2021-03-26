/**

 * Cette classe sert à lancer une nouvelle partie.
 * 
 */

package fr.uvsq.Donjon_RogueLike.menu;

import java.util.InputMismatchException;

import java.util.Scanner;

import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.Siriki;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.Diawara;

import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.Mouwafak;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur;

import fr.uvsq.Donjon_RogueLike.terrain.Terrain;

import java.util.Random;

public class NouvellePartieMenu extends Menu {
	/**
	 * Attributs de la classe NouvellePartieMenu
	 */
	private int choix = 0;

	/**
	 * Affiche l'entete.
	 */
	private void enteteNouvellePartieMenu() {
		System.out.println("\n\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                       Nouvelle Partie                           █ ");
		System.out.println("\t\t█                                                                 █");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\n\t\t                                                                   ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     1- Choisir votre personnage                 █ ");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     2- Choix aleatoire                          █  ");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     3- Revenir au Menu principale               █   ");
		System.out.println("\t\t█                                                                 █   ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"   );
		

	}
	/**
	 * cette méthode est appelé lorsque l'utilisateur opte pour le choix aléatoire
	 * du personnage.
	 * 
	 */
	private void choixAleatoirePersonnage() {
		int nbPiece = 0, nbLignesPiece = 0, nbColonnesPiece = 0;
		PersonnageJoueur PJ = null;
		Random rand = new Random();
		choix = rand.nextInt(2) + 1;

		switch (choix) {
		case 1:
			PJ = new Siriki(0, 0);
			break;
		case 2:
			PJ = new Diawara(0, 0);

			break;
		case 3:
			PJ = new Mouwafak(0, 0);

			break;
		}

		nbPiece = rand.nextInt(4) + 1;
		nbLignesPiece = rand.nextInt(12) + 8;
		nbColonnesPiece = rand.nextInt(15) + 15;

		Terrain T = new Terrain(nbPiece, nbLignesPiece, nbColonnesPiece, PJ);
		T.showTerrain();

	}

	/**
	 * Affiche les types de PJ disponible.
	 */
	private void affichePersonnage() {
		System.out.println("\n\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                       Choix du personnage                       █ ");
		System.out.println("\t\t█                                                                 █");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\n\t\t                                                                   ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     1- @  ---> Siriki                           █ ");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     2- &  ---> Diawara                          █  ");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                     3- $  ---> Mouwafak                         █   ");
		System.out.println("\t\t█                                                                 █   ");
		System.out.println("\t\t█                     4- Retour au Menu principal                 █   ");
		System.out.println("\t\t█                                                                 █   ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"   );
		
	}

	/**
	 * Cette méthode gére le choix du personnage.
	 */
	private void choisirPersonnage() {
		int nbPiece = 0, nbLignesPiece = 0, nbColonnesPiece = 0;
		PersonnageJoueur PJ = null;
		Scanner input = new Scanner(System.in);
		choix = 0;
		try {
			while (choix != 1 && choix != 2 && choix != 3 && choix != 4) {
				this.affichePersonnage();
		    	System.out.println("\n\n\t\t                        Veuillez saisir votre choix \n\n\n");
				choix = input.nextInt();
				super.effaceEcran();

			}
		} catch (InputMismatchException e) {
			super.effaceEcran();
			System.out
					.println("\n\t\t   Votre saisie est incorrecte !!! \n \t\t   Merci de relancer l'application \n\n");
			input.close();
			System.exit(1);
		} finally {
			switch (choix) {
			case 1:
				PJ = new Siriki(0, 0);
				break;
			case 2:
				PJ = new Diawara(0, 0);
				break;

			case 3:
				PJ = new Mouwafak(0, 0);
			default:
				super.gestionMenu();
				break;
			 }

		 }
		   
		   Random rand = new Random();

		   nbPiece = rand.nextInt(4) + 1;
	 	   nbLignesPiece = rand.nextInt(12) + 8;
	       nbColonnesPiece = rand.nextInt(15) + 15;

	 	   Terrain T = new Terrain(nbPiece,nbLignesPiece,nbColonnesPiece,PJ);
	 	   T.showTerrain();
	 	   input.close();
  }


/**
* Cette méthode gère le menu.
*/
public void gestionMenu()
  {

	   Scanner input = new Scanner(System.in);

	   try
	    {
		    while(choix != 1 && choix != 2 && choix != 3)
		     {
		    	this.enteteNouvellePartieMenu();
		    	System.out.println("\n\n\t\t                        Veuillez saisir votre choix \n\n\n");
		    	choix = input.nextInt();
		    	super.effaceEcran();

		     }
	    }
	   catch(InputMismatchException e)
	    {
		   System.out.println("\n\t\t  Saisie incorrecte !!! \n");
		   System.out.println("\n\t\t  Retour au Menu principal \n");
		   super.effaceEcran();
		   super.gestionMenu();
	    }
	   finally
	   {
		   switch(choix)
		     {
		        case 1:
		        	this.choisirPersonnage();
		        break;
		        case 2:
		        	this.choixAleatoirePersonnage();
		        break;
		        case 3:
		        	super.gestionMenu();
		        break;
		        default:
		        	System.out.println("\n\t\t  Saisie incorrecte !!! \n");
		        	System.out.println("\n\t\t  Retour au Menu principal \n");
		        	super.effaceEcran();
		        	super.gestionMenu();
		        break;
	           }

		   input.close();
       }

}

}