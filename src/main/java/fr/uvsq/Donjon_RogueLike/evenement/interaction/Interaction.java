/**
 * Cette classe gére les interactions entre PJ et PNJ.
 
 */

package fr.uvsq.Donjon_RogueLike.evenement.interaction;


import java.util.Scanner;

import fr.uvsq.Donjon_RogueLike.composant.Element;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur;
import fr.uvsq.Donjon_RogueLike.composant.personnage.nonJoueur.PersonnageNonJoueur;
import fr.uvsq.Donjon_RogueLike.menu.Menu;
import fr.uvsq.Donjon_RogueLike.menu.NouvellePartieMenu;
import fr.uvsq.Donjon_RogueLike.piece.*;

public class Interaction 
{
	/**
	 * Attribut de la classe Interaction.
	 */
	private static int state = 0;

	/**
	 * Met à jour l'attribut state.
	 * @param s : valeur de l'attribut state.
	 */
	public static void setState(int s)
	{
		state = s;
	}
	
	/**
	 * @return state : Attribut de la classe.
	 */
	public static int getState()
	{
		return state;
	}
	
	
	/**
	 * Affiche l'entete.
	 */
	private void entete()
	{
		System.out.println("\n\t\t***********************************************");
		System.out.println("\t\t|                    Duel                     |");
	    System.out.println("\t\t|                                             |");
	    System.out.println("\t\t***********************************************\n\n");
	    
	    
	}
	
	/**
	 * Affiche le duel.
	 * @param P2  : personnage joueur.
	 * @param P : personnage non joueur.
	 */
	public void Duel(Element P2 , Element P)
	{
		state = 1;
		PersonnageNonJoueur PNJ = (PersonnageNonJoueur) P;
		PersonnageJoueur PJ = (PersonnageJoueur )P2;
	    
	    Couloir p = new Couloir(20,40);
	    p.updatePiece(PJ, PNJ);
	    
	    Scanner sc = new Scanner(System.in);
	    String input = "null";
	    
	    while(PJ.getPointVie() > 0 && PNJ.getPointVie() > 0)
	    {
			entete();
		    System.out.println("\t\t\t" + PJ.getTypeElement() + "   <-- vs -->  " + PNJ.getTypeElement() +"\n");
		    System.out.println("\t\t********************Informations*********************\n");
		    PJ.showArmes();
	    	System.out.println("\t\t" + PJ.getTypeElement() + ": " + PJ.getPointVie() + "  Point vie     "+ PJ.getPointMagie() + "  Point Magie");
	    	System.out.println("\t\t" + PNJ.getTypeElement() + ": " + PNJ.getPointVie() + "  Point vie \n\n");
	    	
	    	showDiscussion(PJ.getTypeElement(),input);
	    	p.showPiece();
	    	
	    	System.out.println("\n\t\t Attention : si vous entrez une mauvaise touche , l'adversaire risque de vous infliger de lourd dégats !!!");
	    	System.out.println("\n\t\t Veuillez saisir la touche correspondant à l'arme que vous voulez utiliser ");
	    	input = sc.nextLine();

	    	if(PJ.getTypeElement().equals("Siriki"))
	    	{
	    		if(!input.equals("f") && !input.equals("e"))
					PJ.setPointVie(PJ.getPointVie() - 15);
	    		else
				{
	    			PNJ.setPointVie(PNJ.getPointVie() - 10);
	    			PJ.setPointVie(PJ.getPointVie() - 5);
				}
					
	    	}
	    	else if(PJ.getTypeElement().equals("Diawara"))
	    	{
	    		if(!input.equals("e"))
	    			PJ.setPointVie(PJ.getPointVie() - 15);
	    		else
	    		{
	    			PNJ.setPointVie(PNJ.getPointVie() - 10);
				    PJ.setPointVie(PJ.getPointVie() - 5);
	    		}

	    	}
	    	else if(PJ.getTypeElement().equals("Mouwafak"))
	    	{
	    		if(!input.equals("g"))
	    			PJ.setPointVie(PJ.getPointVie() - 15);
	    		else
	    		{
	    			PNJ.setPointVie(PNJ.getPointVie() - 10);
					PJ.setPointVie(PJ.getPointVie() - 5);
	    		}

	    	}
	    	
	    /*	else
	    	{
	    		if(!input.equals("m"))
	    			PJ.setPointVie(PJ.getPointVie() - 15);
	    		else
	    			{
	    			   PNJ.setPointVie(PNJ.getPointVie() - 10);
	    			   PJ.setPointMagie(PJ.getPointMagie() - 10);
	    			   PJ.setPointVie(PJ.getPointVie() - 5);
	    			}
	    	}*/
	    		    	
	    	Menu.effaceEcran();
	    }
	    
	    Menu.effaceEcran();
	    if(PJ.getPointVie() == 0)
	    {
	    	System.out.println("\t\t\t PARTIE PERDUE !!! \n\n Le monstre vous a battu \n\n\n");
	    	
	    	while(!input.equals("n"))
	    	{
	    		System.out.println("\n\t\t Appuyez sur 'n' pour faire une nouvelle partie");
	    		input = sc.nextLine();
	    	}
	    	
	    	NouvellePartieMenu n = new NouvellePartieMenu();
			n.gestionMenu();
	    	
	    	//System.exit(0);
	    	
	    	//PJ.getPointVie() = 50;
	    }
	    else
	    {
	    	System.out.println("\t\t\t FELICITATIONS !!! \n\n Vous avez gagné le duel contre le monstre \n\n\n");
	    	
	    	while(!input.equals("r"))
	    	{
	    		System.out.println("\n\t\t Appuyez sur 'r' pour revenir à la partie");
	    		input = sc.nextLine();
	    	}
	    }
	}
	
	
	/**
	 * Affiche le fil de discussion.
	 * @param PJ : type de PJ.
	 * @param input : saisie de l'utilisateur.
	 */
	private void showDiscussion(String PJ, String input)
	{
		if(!input.equals("null"))
		{
			if(PJ.equals("Siriki"))
			{
				if(input.equals("f"))
				{
					System.out.println("\t\t Vous avez attaqué l'adversaire avec une flèche !!\n\n");
					System.out.println("\t\t L'adversaire vous attaque a son tour !\n\n");
				}
				else if(input.equals("ep"))
				{
					System.out.println("\t\t Vous avez attaqu� l'adversaire à l'épée !!\n\n");
					System.out.println("\t\t L'adversaire riposte a son tour !\n\n");
				}
				else
					System.out.println("\t\t Vous avez raté votre attaque ! L'ennemi en profite pour vous infliger une bon coup !\n\n");
			}
			else if(PJ.equals("Diawara"))
			{
				if(input.equals("e"))
				{
					System.out.println("\t\t Vous avez attaqué l'adversaire à l'épée !!\n\n");
					System.out.println("\t\t L'adversaire vous attaque et vous infliger un bon coup !\n\n");
				}
				else
					System.out.println("\t\t l'adversaire vous a frappé !!\n\n");
			}
			else if(PJ.equals("Mouwafak"))
			{
				if(input.equals("g"))
				{
					System.out.println("\t\t Vous avez attaqué l'adversaire au goudin !!\n\n");
					System.out.println("\t\t L'adversaire vous lance une attaque !\n\n");
				}
				
			/*	else if(input.equals("s"))
				{
					System.out.println("\t\t Vous avez attaqué l'adversaire au sabre !!\n\n");
					System.out.println("\t\t L'adversaire lance un sort sur votre armure !\n\n");
				}*/
				
				else
					System.out.println("\t\t l'adversaire vous a assommé !!\n\n");
	
			}
			
			/*
			else if(PJ.equals("Gardien"))
			{
				if(input.equals("p"))
				{
					System.out.println("\t\t Vous avez poignard� l'adversaire !!\n\n");
					System.out.println("\t\t L'adversaire vous lance une attaque a son tour !\n\n");
				}
				else
					System.out.println("\t\t l'adversaire vous a jett� un sort !!\n\n");
			}
			
			
			
			else if(PJ.equals("Sorcier"))
			{
				if(input.equals("m"))
				{
					System.out.println("\t\t Vous avez ensorcel� l'adversaire !!\n\n");
					System.out.println("\t\t L'ennemi vous prend par surprise et vous inflige des d�gats !\n\n");
				}
				else
					System.out.println("\t\t l'adversaire vous a carbonis� !!\n\n");
			}
			
			*/
			
		}
		
	}
}
