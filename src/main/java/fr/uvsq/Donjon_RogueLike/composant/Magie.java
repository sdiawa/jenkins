/**
 * Cette classe représente un élement dans le terrain, plus spécifiquement la magie. 
 
 */

package fr.uvsq.Donjon_RogueLike.composant;

public class Magie extends Element
{
	/**
	 * Constructeur de la classe Magie.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Magie(int x, int y)
	{
		super(x, y, '�'); 
		typeElement = "Magie";
	}

	
}
