/**  
 * Cette classe gére les déplacements aussi bien celle du PJ que des PNJs. 
 * 

 **/

package fr.uvsq.Donjon_RogueLike.evenement;

import java.util.Scanner;


import fr.uvsq.Donjon_RogueLike.composant.Element;
import fr.uvsq.Donjon_RogueLike.composant.Sol;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur;
import fr.uvsq.Donjon_RogueLike.evenement.interaction.Interaction;
import fr.uvsq.Donjon_RogueLike.ecran.Inventaire;
import fr.uvsq.Donjon_RogueLike.fichiers.enregistres.SauvegarderPartie;
import fr.uvsq.Donjon_RogueLike.menu.Menu;
import fr.uvsq.Donjon_RogueLike.piece.Piece;

public class Deplacement
{
	    /**
	     *  Attributs:
	     *  sortie : représente une référence sur la piéce de sortie du jeu.
	     *  input : Scanner, utilisé pour lire l'entrée standard.
	     *  porteSortieX : colonne de la sortie.
	     *  porteSortieY : ligne de la sortie.
	     */
		private static Piece sortie;
		private static Scanner input = new Scanner(System.in);
		private static int[] deplacementPNJ;
		

		/**
		 * Initialise l'attribut sortie.
		 * @param s : piéce de sortie.
		 */
		public static void setPieceSortie(Piece s)
		{
			sortie = s;
		}
	
		/**
		 * Initialise la variable permettant le déplacement des PNJs.
		 * @param dPNJ : variable permettant de controller les déplacements des PNJs.
		 */
		public static void setDeplacementPNJ(int[] dPNJ)
		{
			deplacementPNJ = dPNJ;		
		}
		
		
		
		/*** Cette méthode teste si le joueur se trouve à la sortie 
		 *   
		 * @param PJ : correspond au personnage joueur.
		 * @param piecePJ : correspond à la piéce dans laquelle se trouve le PJ. 
		 * @param touche : correspond à la touche entrée par l'utilisateur.
		 * @return false si on ne se trouve pas à la sortie ou si on décide de ne pas quitter la partie.
		 *  
		 ***/
		public static boolean isPlayerOut(PersonnageJoueur PJ,Piece piecePJ,char touche)
		{
			if(piecePJ == sortie)
			{
				int x = PJ.getX(),y = PJ.getY();
				char symElement;

				Element e = piecePJ.getElement(x+1, y);
				symElement = e.getSymbole();

				if(symElement == '+' && touche == 'd')
					return QuitterPartie.endGame();
				else
					return false;
			}
			else
				return false;
		}
		

	/***
	 * Cette méthode se charge de récuper les entrées clavier.	
	 * @return la touche entrée par l'utilisateur.
	 */
	public static char readClavier()
	{
		   
		   String test;
		   char touche = '\0';

		   while(touche != 'd' && touche != 'g' && touche != 'h' && touche != 'b' && touche != 's' && touche != 'q' && touche != 'i')
		   {
			   test = input.nextLine();
			   
			   if(test.length() == 1)
				   touche = test.charAt(0);
			   
		   }

		   return touche;
	}
	


	/**
	 * Cette méthode gére le déplacement du PJ.
	 * @param nbPieces : nombre de piéces du terrain.
	 * @param ligneCouloir: correspond au nombre de lignes d'une instance du type Couloir.
	 * @param direction: correspond à la touche entrée par l'utilisateur.
	 * @param pieces: correspond aux piéces du terrain.
	 * @param piecePJ: correspond à l'identifiant de la piéce dans laquelle se trouve le PJ
	 * @param PJ: personnage joueur
	 */
	public static void deplacementPJ(int nbPieces,int ligneCouloir,char direction,Piece[] pieces,int piecePJ,fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur PJ)
	{
		int x = PJ.getX(),y = PJ.getY();
		int nbColonne = pieces[piecePJ].getNbColonne(), nbLigne = pieces[piecePJ].getNbLigne();

		switch(direction)
		{
			case 'i':
				Menu.effaceEcran();
				Inventaire.afficherInventaire(PJ);
				break;
			case 'q':
				Menu.effaceEcran();
				QuitterPartie.quitPartie(pieces, nbPieces);
				break;
			case 's':
				Menu.effaceEcran();
				SauvegarderPartie.savePartie(pieces,nbPieces);
				Menu.effaceEcran();
				break;
			case 'd':
					if(x + 1 < nbColonne)
					{
						Element e = pieces[piecePJ].getElement(x+1, y);

						if(e.getTypeElement().equals("Sol"))
						{
							e.setPosition(x, y);
							PJ.setPosition(x+1, y);
							pieces[piecePJ].setCase(e);
							pieces[piecePJ].setCase(PJ);
						}
						else if(e.getTypeElement().equals("Mur")) 
						{ System.out.println("\n\n\t\t\t\t ----> Vous avez heurté un mur : # \n\n");}
						else if(e.getTypeElement().equals("Porte"))
						{
							if(pieces[piecePJ] == sortie) {}
							else
							{
								if(pieces[piecePJ + 1].getNbLigne() == ligneCouloir)
									PJ.setPosition(1,1);
								else
									PJ.setPosition(1,5);
								pieces[piecePJ + 1].setCase(PJ);
								
								Sol s = new Sol(x,y);
								pieces[piecePJ].setCase(s);
								pieces[piecePJ + 1].setCase(PJ);
								PJ.setnPiece(piecePJ + 1);
							}
						}
						else if(e.getTypeElement().equals("Magie"))
						{
							if(PJ.getPointMagie() + 10 <= 100)
							{
								PJ.setPointMagie(PJ.getPointMagie() + 10 );
								Sol s = new Sol(x+1,y);
								pieces[piecePJ].setCase(s);
							}
							else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts magie \n\n");}
						}
						else if(e.getTypeElement().equals("Vie"))
						{
							if(PJ.getPointVie() + 10 <= 100)
							{
								PJ.setPointVie(PJ.getPointVie() + 10 );
								Sol s = new Sol(x+1,y);
								pieces[piecePJ].setCase(s);
							}
							else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts vie \n\n");}
						}
						else if(e.getTypeElement().equals("PNJ"))
						{
							Menu.effaceEcran();
							Interaction I = new Interaction();
							I.Duel(PJ, e);
							Sol s = new Sol(x+1,y);
							pieces[piecePJ].setCase(s);
							Menu.effaceEcran();
						}

					}
			break;
			case 'g':
				if(x - 1 > - 1)
				{
					Element e = pieces[piecePJ].getElement(x-1, y);

					if(e.getTypeElement().equals("Sol"))
					{
						e.setPosition(x, y);
						PJ.setPosition(x-1, y);
						pieces[piecePJ].setCase(e);
						pieces[piecePJ].setCase(PJ);
					}
					else if(e.getTypeElement().equals("Mur"))
					{System.out.println("\n\n\t\t\t\t ----> Vous avez heurté un mur : # \n\n");}
					else if(e.getTypeElement().equals("Porte"))
					{
						if(pieces[piecePJ - 1].getNbLigne() == ligneCouloir)
							PJ.setPosition(nbColonne - 2,1);
						else
							PJ.setPosition(nbColonne - 2,5);

						PJ.setnPiece(piecePJ - 1);
						Sol s = new Sol(x,y);
						pieces[piecePJ].setCase(s);
						pieces[piecePJ - 1].setCase(PJ);
						PJ.setnPiece(piecePJ - 1);
					}
					else if(e.getTypeElement().equals("Magie"))
					{
						if(PJ.getPointMagie() + 10 <= 100)
						{
							PJ.setPointMagie(PJ.getPointMagie() + 10 );
							Sol s = new Sol(x-1,y);
							pieces[piecePJ].setCase(s);
						}
						else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts magie \n\n");}
					}
					else if(e.getTypeElement().equals("Vie"))
					{
						if(PJ.getPointVie() + 10 <= 100)
						{
							PJ.setPointVie(PJ.getPointVie() + 10 );
							Sol s = new Sol(x-1,y);
							pieces[piecePJ].setCase(s);
						}
						else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts vie \n\n");}
					}
					else if(e.getTypeElement().equals("PNJ"))
					{
						Menu.effaceEcran();
						Interaction I = new Interaction();
						I.Duel(PJ, e);
						Sol s = new Sol(x-1,y);
						pieces[piecePJ].setCase(s);
						Menu.effaceEcran();
					}


				}
		  break;
		  case 'b':
			   if(y + 1 < nbLigne - 1)
				{
					Element e = pieces[piecePJ].getElement(x, y+1);

					if(e.getTypeElement().equals("Sol"))
					{
						e.setPosition(x, y);
						PJ.setPosition(x, y+1);
						pieces[piecePJ].setCase(e);
						pieces[piecePJ].setCase(PJ);
					}
					else if(e.getTypeElement().equals("Mur")) {}
					else if(e.getTypeElement().equals("Magie"))
					{
						if(PJ.getPointMagie() + 10 <= 100)
						{
							PJ.setPointMagie(PJ.getPointMagie() + 10 );
							Sol s = new Sol(x,y+1);
							pieces[piecePJ].setCase(s);
						}
						else{System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts magie \n\n");}
					}
					else if(e.getTypeElement().equals("Vie"))
					{
						if(PJ.getPointVie() + 10 <= 100)
						{
							PJ.setPointVie(PJ.getPointVie() + 10 );
							Sol s = new Sol(x,y+1);
							pieces[piecePJ].setCase(s);
						}
						else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts vie \n\n");}
					}
					else if(e.getTypeElement().equals("PNJ"))
					{
						Menu.effaceEcran();
						Interaction I = new Interaction();
						I.Duel(PJ, e);
						Sol s = new Sol(x,y+1);
						pieces[piecePJ].setCase(s);
						Menu.effaceEcran();
					}

				}
			   else {System.out.println("\n\n\t\t\t\t ----> Vous avez heurté un mur : # \n\n");}
		break;
		case 'h':
			if(y - 1 > -1 )
			{
				Element e = pieces[piecePJ].getElement(x, y-1);

				if(e.getTypeElement().equals("Sol"))
				{
					e.setPosition(x, y);
					PJ.setPosition(x, y-1);
					pieces[piecePJ].setCase(e);
					pieces[piecePJ].setCase(PJ);
				}
				else if(e.getTypeElement().equals("Mur")) 
				{System.out.println("\n\n\t\t\t\t ----> Vous avez heurté un mur : # \n\n");}
				else if(e.getTypeElement().equals("Magie"))
				{
					if(PJ.getPointMagie() + 10 <= 100)
					{
						PJ.setPointMagie(PJ.getPointMagie() + 10 );
						Sol s = new Sol(x,y-1);
						pieces[piecePJ].setCase(s);
					}
					else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts magie \n\n");}
				}
				else if(e.getTypeElement().equals("Vie"))
				{
					if(PJ.getPointVie() + 10 <= 100)
					{
						PJ.setPointVie(PJ.getPointVie() + 10 );
						Sol s = new Sol(x,y-1);
						pieces[piecePJ].setCase(s);
					}
					else {System.out.println("\n\n\t\t\t\t ----> Vous avez déjà 100 pts vie \n\n");}
				}
				else if(e.getTypeElement().equals("PNJ"))
				{
					Menu.effaceEcran();
					Interaction I = new Interaction();
					I.Duel(PJ, e);
					Sol s = new Sol(x,y-1);
					pieces[piecePJ].setCase(s);
					Menu.effaceEcran();
				}
				
			}
			else {System.out.println("\n\n\t\t\t\t ----> Vous avez heurté un mur : # \n\n");}
		break;
		default:
			break;


		}
		

	}

	/** Cette méthode gére le déplacement des PNJs.
	 * 
	 * @param nbPieces: nombre de piéces du terrain.
	 * @param pieces: correspond aux piéces du terrain.
	 * @param PJ: personnage joueur.
	 */
	
	public static void deplacementPNJ(int nbPieces,Piece[] pieces,PersonnageJoueur PJ)
	{
		for(int i=0; i<nbPieces; i++)
		{
			for(int j=0; j<pieces[i].getNbLigne(); j++)
			{
				for(int k=0; k< pieces[i].getNbColonne(); k++)
				{
					Element elt = pieces[i].getElement(k,j);
					if(elt.getTypeElement().equals("PNJ"))
					{
						int x = elt.getX(), y = elt.getY();
						
						if(y-1 > 0 && deplacementPNJ[i] == 0)
						{
							Element e = pieces[i].getElement(x, y-1);
								
							if(e.getTypeElement().equals("Sol"))
							{
								e.setPosition(x, y);
								elt.setPosition(x, y-1);
								pieces[i].setCase(e);
								pieces[i].setCase(elt);
							}
							else if(e.getTypeElement().equals("Siriki") || e.getTypeElement().equals("Mouwafak") || e.getTypeElement().equals("Diawara")) {}
							else
								deplacementPNJ[i] = 1;
						}
						else if(y-1 <= 0 && deplacementPNJ[i] == 0)
							deplacementPNJ[i] = 1;
						else if(x+1 < pieces[i].getNbColonne() - 1 && deplacementPNJ[i] == 1) 
						{
							Element e = pieces[i].getElement(x+1, y);
							
							if(e.getTypeElement().equals("Sol"))
							{
								e.setPosition(x, y);
								elt.setPosition(x+1, y);
								pieces[i].setCase(e);
								pieces[i].setCase(elt);
							}
							else if(e.getTypeElement().equals("Siriki") || e.getTypeElement().equals("Mouwafak") || e.getTypeElement().equals("Diawara")) {}
							else
								deplacementPNJ[i] = 2;
					    }
						else if(x+1 >= pieces[i].getNbColonne() - 1 && deplacementPNJ[i] == 1)
							deplacementPNJ[i] = 2;
						else if(x-1 > 0 && deplacementPNJ[i] == 2) 
						{
							Element e = pieces[i].getElement(x-1, y);
							
							if(e.getTypeElement().equals("Sol"))
							{
								e.setPosition(x, y);
								elt.setPosition(x-1, y);
								pieces[i].setCase(e);
								pieces[i].setCase(elt);
							}
							else if(e.getTypeElement().equals("Siriki") || e.getTypeElement().equals("Diawara") || e.getTypeElement().equals("Mouwfak")) {}
							else
								deplacementPNJ[i] = 3;
					    }
						else if(x-1 <= 0 && deplacementPNJ[i] == 2)
							deplacementPNJ[i] = 3;
						else if(y+1 < pieces[i].getNbLigne() - 1 && deplacementPNJ[i] == 3)
						{	
							Element e = pieces[i].getElement(x, y+1);
							
							if(e.getTypeElement().equals("Sol"))
							{
								e.setPosition(x, y);
								elt.setPosition(x, y+1);
								pieces[i].setCase(e);
								pieces[i].setCase(elt);
							}
							else if(e.getTypeElement().equals("Siriki") || e.getTypeElement().equals("Diawara") || e.getTypeElement().equals("Mouwafak")) {}								
							else
								deplacementPNJ[i] = 0;
						}

						
						else
							deplacementPNJ[i] = 0;
						
					}
				}
			}
		}

	}

}