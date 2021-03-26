/**
 * Cette classe représente le dol dans le terrain
 */

package fr.uvsq.Donjon_RogueLike.composant;


public class Sol extends Element {

	/**
	 * Constructeur de la classe Sol.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Sol(int x, int y)
	{
		super(x, y, '.');
		typeElement = "Sol";
	}
}