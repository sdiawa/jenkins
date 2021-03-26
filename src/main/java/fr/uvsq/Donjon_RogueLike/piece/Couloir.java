/**  
 * Cette classe représente une pièce du Terrain, plus précisement un couloir. 

 * 
 * 
 **/

package fr.uvsq.Donjon_RogueLike.piece;

import fr.uvsq.Donjon_RogueLike.composant.Mur;
import fr.uvsq.Donjon_RogueLike.composant.Sol;

public class Couloir extends Piece
{
	/**
	 * Constructeur de la classe Couloir
	 * @param lignes : nombre de lignes du couloir.
	 * @param colonnes : nombre de colonnes du couloir.
	 */
	public Couloir(int lignes,int colonnes) {
		super(lignes,colonnes);
	}
	
	/**
	 * Initialise l'instance de la classe. 
	 * @param nPiece : numéro de la pièce.
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
						
	}

}
