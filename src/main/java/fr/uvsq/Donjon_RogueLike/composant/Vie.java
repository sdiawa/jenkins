/**
 * Cette classe représente un élement dans le terrain, plus spécifiquement la vie. 

 
 */

package fr.uvsq.Donjon_RogueLike.composant;

public class Vie extends Element
{
	/**
	 * Constructeur de la classe Vie.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Vie(int x, int y)
	{
		super(x, y, '*');
		typeElement = "Vie";
	}
}