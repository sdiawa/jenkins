/**
 * Cette classe représente un élement dans le terrain, plus spécifiquement un puit. 
 
 */

package fr.uvsq.Donjon_RogueLike.composant;

public class Puit extends Element 
{

	/**
	 * Constructeur de la classe Puit.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Puit(int x, int y) 
	{
		super(x, y, '~');
	}

}
