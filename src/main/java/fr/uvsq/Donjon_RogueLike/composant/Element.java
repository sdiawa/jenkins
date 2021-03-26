/**
la classe Element  représente la composante du jeu. 

 
 */

package fr.uvsq.Donjon_RogueLike.composant;

public class Element
{
	/**
	 * Attributs de la classe Element.
	 * nPiece : identifiant de la piéce dans laquelle se trouve l'élement.
	 * positionX : colonne à laquelle se trouve l'élement.
	 * positionY : ligne à laquelle se trouve l'élement.
	 * symbole	 : symbole représentant l'élement dans le terrain.
	 * typeElement : désigne le type d'élement que représente l'objet : Porte,Mur,...
	 */
	private int nPiece; 
	private int positionX;
	private int positionY;
	private char symbole;
	protected String typeElement = "default";

	/**
	 * Constructeur de la Classe Element.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 * @param c : symbole représentant l'élement dans le terrain.
	 */
	public Element(int x, int y, char c)
	{
		positionX = x;
		positionY = y;
		symbole = c;
	}
	
	/**
	 * met à jour la position de l'élement dans le terrain.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public void setPosition(int x, int y)
	{
		positionX = x;
		positionY = y;
	}

	/**
	 * @return symbole : symbole représentant l'élement dans le terrain.
	 */
	public char getSymbole()
	{
		return symbole;
	}
	
	
	/**
	 * @return positionX : colonne à laquelle se trouve l'élement.
	 */
	public int getX()
	{
		return positionX;
	}
	
	/**
	 * @return positionY : ligne à laquelle se trouve l'élement.
	 */
	public int getY()
	{
		return positionY;
	}
	
	/**
	 * @return typeElement : type d'élement correspondant.
	 */
	public String getTypeElement()
	{
		return typeElement;
	}
	
	/**
	 * Met à jour la piéce dans laquelle se trouve l'élement.
	 * @param piece : piéce dans laquelle se trouve l'élement.
	 */
	public void setnPiece(int piece)
	{
		if(piece >= 0)
			nPiece = piece;
	}
	
	/**
	 * @return nPiece : identifiant de la piéce dans laquelle se trouve l'élement.
	 */
	public int getnPiece()
	{
		return nPiece;
	}

}

