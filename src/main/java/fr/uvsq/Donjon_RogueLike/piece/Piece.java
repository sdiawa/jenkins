/**  
 * Cette classe représente une piéce du Terrain. 

 * 
 * @author siriki
 **/

package fr.uvsq.Donjon_RogueLike.piece;

import java.util.Random;


import fr.uvsq.Donjon_RogueLike.composant.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.*;

public class Piece 
{

	/***
	 * Attributs de la classe:
	 *  -piece : matrice d'éléments.
	 *  -ligne: nombre de ligne de la matrice.
	 *  -colonne : nombre de colonne de la matrice.
	 */
	protected Element piece[][];
	protected int ligne;
	protected int colonne;
	private int rand = 0;
	
	/***
	 * Constructeur de la classe Piece.
	 * @param ligne : nombre de ligne de la matrice. 
	 * @param colonne : nombre de colonne de la matrice.
	 */
	public Piece(int ligne,int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		
		piece = new Element[this.ligne][this.colonne];
	}


	/**
	 * retourne le nombre de ligne de la matrice.
	 * @return ligne.
	 */
	public int getNbLigne()
    {
		return ligne;
	}

	/**
	 * retourne le nombre de colonne de la matrice.
	 * @return colonne.
	 */
	public int getNbColonne()
    {
		return colonne;
	}
	
	/**
	 * Initialise l'instance de la classe. 
	 * @param nPiece : numéro de la pi�ce.
	 */
	public void InitPiece(int nPiece)
	{
		for(int i=0; i<piece.length; i++) 
			for(int j=0; j<piece[i].length; j++) {
				if(i == 0 || i == piece.length - 1)
				{
					  piece[i][j] = new Mur(i,j);
					  piece[i][j].setnPiece(nPiece);
				}
				else if(j == 0 || j == piece[i].length - 1)
				{
					piece[i][j] = new Mur(i,j);
					piece[i][j].setnPiece(nPiece);
				}
				else
				{
					piece[i][j] = new Sol(i,j);
					piece[i][j].setnPiece(nPiece);
				}
			}
		
		if(ligne/2 != 5)
		{
			Random random = new Random();
			rand = random.nextInt(3);
			
			if(rand == 0)
			{
				int i = 1;
				for(; i< (colonne/2) + 1; i++)
				{
					piece[(ligne/2)][i] = new Mur((ligne/2),i);
					piece[(ligne/2)][i].setnPiece(nPiece);
				}
				if(ligne > 10)
				{
					for(i=(ligne/2) + 1; i<(ligne/2) + (ligne/4); i++)
					{
						piece[i][(colonne/2)] = new Mur(i,(colonne/2));
						piece[i][(colonne/2)].setnPiece(nPiece);
					}
					for(i=1; i< (colonne/2) - 1; i++)
					{
						piece[(ligne/2) + (ligne/4) - 1][i] = new Mur((ligne/2) + (ligne/4) - 1,i);
						piece[(ligne/2) + (ligne/4) - 1][i].setnPiece(nPiece);
					}
				}

				
			}
			else if(rand == 1)
			{
				int i=colonne - 2;
				for(; i > (colonne/2); i--)
				{
					piece[(ligne/2)][i] = new Mur((ligne/2),i);
					piece[(ligne/2)][i].setnPiece(nPiece);
				}
				if(ligne > 10)
				{
					for(i=(ligne/2) + 1; i<(ligne/2) + (ligne/4); i++)
					{
						piece[i][(colonne/2)+1] = new Mur(i,(colonne/2)+1);
						piece[i][(colonne/2)+1].setnPiece(nPiece);
					}
					for(i=colonne - 2; i > (colonne/2)+2; i--)
					{
						piece[(ligne/2) + (ligne/4) - 1][i] = new Mur((ligne/2) + (ligne/4) - 1,i);
						piece[(ligne/2) + (ligne/4) - 1][i].setnPiece(nPiece);
					}
				}

			}
		}

						
	}

	/**
	 * Met la piéce à jour.
	 * @param PJ : personnage joueur.
	 * @param P : personnage non joueur.
	 */
	public void updatePiece(PersonnageJoueur PJ, Personnage P)
	{
		InitPiece(0);
		setCase(P);
		setCase(PJ);
	}

	/**
	 * Affiche la piéce.
	 */
	public void showPiece()
	{
		for(int i=0; i<ligne; i++)
		{
			System.out.print("\t\t\t" );
			drawLine(i);
			System.out.print("\n" );
		}

	}
	
	
	/**
	 * Affiche une ligne de la piéce.
	 * @param ligne : ligne de la piéce à dessiner.
	 */
	public void drawLine(int ligne)
  	{
	    if(ligne > -1 && ligne < this.ligne)
		for(int i=0; i< colonne; i++)
		    System.out.print(piece[ligne][i].getSymbole());

	}
	
	
	/**
	 * Stocke l'élement passé en argument dans la pièce.
	 * @param e : élement à insérer dans la pièce.
	 */
	public void setCase(Element e)
	{
	    int x = e.getX();
	    int y = e.getY();
	    piece[y][x] = e;	
	}

	/**
	 * retourne le symbole de l'élement se trouvant aux coordonnées x et y
	 * @param x : colonne dans laquelle se trouve l'élement.
	 * @param y	: ligne dans laquelle se trouve l'élment.
	 * @return symbole de l'élement correspondant.
	 */
	public char getCaseElement(int x , int y)
	{
	   if((x > -1 && x < colonne) && (y > -1 && y < ligne))
	      return piece[y][x].getSymbole();
	   else
	      return '\0';
	}


	/**
	 * retourne l'élément de coordonnées x,y.
	 * @param x : colonne dans laquelle se trouve l'élement.
	 * @param y : ligne dans laquelle se trouve l'élment.
	 * @return Element : l'élement correspondant.
	 */
	public Element getElement(int x, int y)
	{
		if((x > -1 && x <colonne) && (y > -1 && y < ligne))
		  return piece[y][x];
		else
			return null;
	}

 
}
