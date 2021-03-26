/**
 * Cette classe représente un mur dans le terrain.
 
 */

package fr.uvsq.Donjon_RogueLike.composant;


public class Mur extends Element {



	/**
	 * Constructeur de la classe Mur.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Mur(int x, int y)
	{
		super(x, y, '#');
		typeElement = "Mur";
	
	}
}