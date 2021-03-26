/**
 * Cette classe représente la map du Jeu.

 * @author mouwafak diawara siriki
 */

package fr.uvsq.Donjon_RogueLike.terrain;

import java.util.ArrayList;
import java.util.Random;

import fr.uvsq.Donjon_RogueLike.composant.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.nonJoueur.*;
import fr.uvsq.Donjon_RogueLike.evenement.interaction.Interaction;
import fr.uvsq.Donjon_RogueLike.ecran.InfoJeu;
import fr.uvsq.Donjon_RogueLike.evenement.Deplacement;
import fr.uvsq.Donjon_RogueLike.menu.Menu;
import fr.uvsq.Donjon_RogueLike.piece.*;

public class Terrain extends InfoJeu
{
	/**
	 * Attributs de la classe Terrain.
	 */
	private Piece[] pieces;

	private Porte[] portes;
	private PersonnageJoueur PJ;
	private ArrayList<PersonnageNonJoueur> A;
	private ArrayList<Magie> M;
	private ArrayList<Vie> V;

	private int NB_MAX_PIECES = 4;
	private int nbPieces;
	private int nbLignesPiece;
	private int nbColonnesPiece;
	private int nbLignesCouloir = 4;

	
	/**
	 * Constructeur de la classe Terrain.
	 * @param nbPieces : nombre de piéces du terrain.
	 * @param lignes : nombre de ligne des piéces du terrain.
	 * @param colonnes : nombre de colonne des piéces du terrain.
	 * @param PJ : personnage joueur choisit par l'utilisateur.
	 */
	public Terrain(int nbPieces,int lignes, int colonnes, PersonnageJoueur PJ)
	{

		if(nbPieces < NB_MAX_PIECES)
		  {
		     portes = new Porte[Porte.getNbPortes(nbPieces)];

 		     this.nbPieces = nbPieces + (nbPieces - 1);
		  }
		else
		    {
			this.nbPieces = NB_MAX_PIECES + (NB_MAX_PIECES - 1);
			portes = new Porte[Porte.getNbPortes(NB_MAX_PIECES)];
		    }

		nbLignesPiece = lignes;
		nbColonnesPiece = colonnes;
		pieces = new Piece[this.nbPieces];
		this.PJ = PJ;

		initElements(nbPieces);
		setTerrain();
		
		Deplacement.setPieceSortie(pieces[this.nbPieces - 1]);
		Deplacement.setDeplacementPNJ(new int[this.nbPieces]);
		fillTerrain();

	}

	/**
	 * Constructeur de la classe Terrain.
	 * @param nbPieces : nombre de piéces du terrain.
	 * @param lignes : nombre de ligne des piéces du terrain.
	 * @param colonnes : nombre de colonne des piéces du terrain.
	 */
	public Terrain(int nbPieces,int lignes, int colonnes )
	{
			portes = new Porte[Porte.getNbPortes(nbPieces)];
			this.nbPieces = nbPieces;
			
			nbLignesPiece = lignes;
			nbColonnesPiece = colonnes;
			pieces = new Piece[this.nbPieces];
			setTerrain();
			
			Deplacement.setPieceSortie(pieces[this.nbPieces - 1]);
			Deplacement.setDeplacementPNJ(new int[this.nbPieces]);		
	}
	
	
	/**
	 * @return : une instance de la classe Terrain.
	 */
	public Piece[] getTerrain()
	{
		return pieces;
	}

	/**
	 * Initialise le Terrain.
	 */
	private void setTerrain()
	{
		for(int i=0; i<nbPieces; i++)
		{

			if(nbPieces % 2 == 0)
			  {
				if(i % 2 == 0)
					pieces[i] = new Piece(nbLignesPiece,nbColonnesPiece);
				else
					pieces[i] = new Couloir(nbLignesCouloir, nbColonnesPiece);
			  }
			else
			  {
				if(i % 2 == 0)
					pieces[i] = new Piece(nbLignesPiece,nbColonnesPiece);
				else
					pieces[i] = new Couloir(nbLignesCouloir, nbColonnesPiece);

			  }
			pieces[i].InitPiece(i);

		}

	}

	/**
	 * Met à jour l'attribut PJ de la classe Terrain.
	 * @param pj : référence vers un objet de type PersonnageJoueur.
	 */
	public void setPJ(PersonnageJoueur pj)
	{
		if(pj != null)
			PJ = pj;
	}
	
	/**
	 * Met à jour l'attribut V de la classe Terrain.
	 * @param v : référence vers un objet de type ArrayList Vie
	 */
	public void setVie(ArrayList<Vie> v)
	{
		if(v != null)
			V = v;
	}
	
	/**
	 * Met à jour l'attribut M de la classe Terrain.
	 * @param m : référence vers un objet de type ArrayList Magie
	 */
	public void setMagie(ArrayList<Magie> m)
	{
		if(m != null)
			M = m;
	}
	
	
	/**
	 * Met à jour l'attribut A de la classe Terrain.
	 * @param pa : référence vers un objet de type ArrayList PersonnageNonJoueur
	 */
	public void setPNJ(ArrayList<PersonnageNonJoueur> pa)
	{
		if(pa != null)
			A = pa;
	}
	
	/**
	 * Initialise les élements du terrain.
	 * @param nbPieces : nombre de piéces du terrain.
	 */
	private void initElements(int nbPieces)
	{
		A =  new ArrayList<PersonnageNonJoueur> (nbPieces);
		M = new ArrayList<Magie>(nbPieces);
		V = new ArrayList<Vie>(nbPieces) ;
	}

	/**
	 * Place aléatoirement l'élement e dans une des piéces.
	 * @param nbPieces : nombre de pièces du terrain.
	 * @param e : élement à placer dans le terrain.
	 */
	private void setElementCase(int nbPieces,Element e)
    {

	     int piece = 0,x,y;
	     Random rand = new Random();

	     piece = rand.nextInt(nbPieces);

	     do
	       {
	     	 if(pieces[piece].getNbLigne() == nbLignesPiece)
	     		 y = rand.nextInt((nbLignesPiece -2 ) - 1) + 1;
	         else
	        	 y = rand.nextInt(1 ) + 1;

	     	 x = rand.nextInt((nbColonnesPiece -2 ) - 1) + 1;

	       }while(pieces[piece].getCaseElement(x,y) != '.');

	     e.setPosition(x, y);
	     pieces[piece].setCase(e);
	     e.setnPiece(piece);

        }

	/**
	 * Place les portes dans le terrain.
	 */
	private void setPortes()
        {
			int tmp = portes.length;

			for(int i=0; i<nbPieces && tmp >= 0; i++)
			{
                  if(pieces[i].getNbLigne() == nbLignesPiece)
                  {
                	  if(i == 0)
                	  {
                		  tmp -= 1;
                		  portes[tmp] = new Porte(nbColonnesPiece - 1,nbLignesCouloir + 1);
                		  pieces[i].setCase(portes[tmp]);
                		  portes[tmp].setnPiece(i);
                	  }

                	  else
                	  {
                		  tmp -= 1;

                		  if(tmp > -1 && tmp < portes.length)
                		  {
                			  portes[tmp] = new Porte(0,nbLignesCouloir + 1);
                			  pieces[i].setCase(portes[tmp]);
                			  portes[tmp].setnPiece(i);
                		  }
                		  tmp -= 1;

                		  if(tmp > -1 && tmp < portes.length)
                		  {
                			  portes[tmp] = new Porte(nbColonnesPiece - 1,nbLignesCouloir + 1);
                			  pieces[i].setCase(portes[tmp]);
                			  portes[tmp].setnPiece(i);
                		  }

                	  }
                  }
                  else
                  {
                	  tmp -= 1;

                	  if(tmp > -1 && tmp < portes.length)
                	  {
                		  portes[tmp] = new Porte(0,1);
                		  pieces[i].setCase(portes[tmp]);
                		  portes[tmp].setnPiece(i);
                	  }
                	  tmp -= 1;

                	  if(tmp > -1 && tmp < portes.length)
                	  {
                		  portes[tmp] = new Porte(nbColonnesPiece - 1,1);
                		  pieces[i].setCase(portes[tmp]);
                		  portes[tmp].setnPiece(i);
                	  }

                  }

			}

        }

	
	/**
	 * remplit le terrain.
	 */
	private void fillTerrain()
    {
		this.setPortes();
		this.setElementCase(this.nbPieces,PJ);

		for(int i=0; i<nbPieces; i++)
		{
			 A.add(new PersonnageNonJoueur(0,0));
			 this.setElementCase(nbPieces,A.get(i));
			 
			 M.add(new Magie(0,0));
			 this.setElementCase(nbPieces,M.get(i));
			 
			 V.add(new Vie(0,0));
			 this.setElementCase(nbPieces,V.get(i));
		}

	}

	/**
	 * Affiche le terrain.
	 */
	public void showTerrain()
	{
		char touche = '\0';

		while(!Deplacement.isPlayerOut(PJ, pieces[this.getPJPiece()], touche))
		{
			
			 if(touche == '\0' || touche == 'g' || touche == 'd' || touche == 'b' || touche == 'h')
			 	this.afficheInfoJeu(PJ.getSymbole());
			 Deplacement.deplacementPJ(nbPieces,nbLignesCouloir,touche,pieces,this.getPJPiece(),PJ);
			 Deplacement.deplacementPNJ(nbPieces,pieces,PJ);
			 
			 if(touche == 'i' || touche == 'q' || touche == 's' || Interaction.getState() == 1)
			 {
				   this.afficheInfoJeu(PJ.getSymbole());
				   Interaction.setState(0);
			 }
			 
		     int ligneCouloir = 0,l = 0;
		     boolean isTrue = false;

		     for(int i=0; i<nbLignesPiece; i++)
		     {
		    	 System.out.print("\n");
		    	 for(int j=0; j<nbPieces; j++)
		    	 {

		    		 if(pieces[j].getNbLigne() == nbLignesPiece)
		    			 pieces[j].drawLine(i);
		    		 else
		    		 {
		    			 if(ligneCouloir < nbLignesCouloir)
		    			 {
		    				 for(int k=0; k<nbColonnesPiece; k++)
		    					 System.out.print(" ");
		    			 }
		    			 else if(ligneCouloir >= nbLignesCouloir  && ligneCouloir < nbLignesCouloir + 4)
		    			 {
		    				 if(l < 4)
		    				 {
		    					 isTrue = true;
		    					 pieces[j].drawLine(l);
		    				 }

		    			 }
		    			 else
		    			 {
		    				 for(int k=0; k<nbColonnesPiece; k++)
		    					 System.out.print(" ");
		    			 }


		    		 }
		    	 }

		    	 ligneCouloir += 1;

		    	 if(isTrue )
		    		 l += 1;
		     	}
		     System.out.print("\n\n");

		     touche = Deplacement.readClavier();
		     Menu.effaceEcran();
		}
    }



	/**
	 * @return : la piéce dans laquelle se trouve le PJ.
	 */
	private int getPJPiece()
	{
		int pjPiece = -1;

		for(int i=0; i<nbPieces; i++)
		{
			for(int j=0; j<pieces[i].getNbLigne(); j++)
			{
				for(int k=0; k<nbColonnesPiece; k++)
				{
					if(pieces[i].getElement(k,j).equals(PJ))
					{
						pjPiece = i;
						return pjPiece;
					}
				}
			}
		}
		
		PJ.setnPiece(pjPiece);
		return pjPiece;
	}
	
}