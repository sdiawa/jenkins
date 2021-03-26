/**
 *La classe Personnage represente (PJ ou PNJs).

  */

package fr.uvsq.Donjon_RogueLike.composant.personnage;

import fr.uvsq.Donjon_RogueLike.composant.Element;

public class Personnage  extends Element 
{
	
	/**
	 * Attributs de la classe Personnage.
	 * ptVie : point de vie du personnage.
	 */
	private int ptVie = 50;
	
	
	/**
	 * Constructeur de la classe Personnage.
	 * @param x : colonne à laquelle se trouve le personnage.
	 * @param y : ligne à laquelle se trouve le personnage.
	 * @param symbole : symbole du personnage.
	 */
	public Personnage(int x, int y, char symbole) 
	{
		super(x, y, symbole);
	}

	/**
	 * Met à jour les points de vie du personnage
	 * @param ptVie : point de vie.
	 */
	public void setPointVie(int ptVie)
    {
	     if(ptVie >= 0 && ptVie <= 100)
	    	 this.ptVie = ptVie;
	     else if(ptVie < 0)
	     {
	    	 this.ptVie = 0;
	     }
    }

	/**
	 * @return ptVie: point de vie du personnage.
	 */
	public int getPointVie()
    {
	    return ptVie;
    }

}
