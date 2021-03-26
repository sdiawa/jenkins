/**
 * Cette classe represente le personnage joueur.

 * 
 */

package fr.uvsq.Donjon_RogueLike.composant.personnage.joueur;

import fr.uvsq.Donjon_RogueLike.composant.personnage.Personnage;


public class PersonnageJoueur extends Personnage 
{

	/**
	 * Attributs de la classe PersonnageJoueur.
	 */
	private int ptMagie = 0;
	private int jetons = 0;
	
	
	/**
	 * Constructeur de la classe PersonnageJoueur.
	 * @param x : colonne dans laquelle se trouve le personnage.
	 * @param y : ligne dans laquelle se trouve le personnage.
	 * @param symbole : symbole du personnage.
	 */
	public PersonnageJoueur(int x, int y, char symbole) 
	{
		super(x,y,symbole);
		typeElement = "PJ";
	}

	/**
	 * Met � jour les points de magie du personnage.
	 * @param ptMagie : point magie
	 */
	public void setPointMagie(int ptMagie)
        {
	     if(ptMagie >= 0 && ptMagie <= 100)
		this.ptMagie = ptMagie;
        }

	/**
	 * @return ptMagie : point magie du personnage.
	 */
	public int getPointMagie()
        {
	     return ptMagie;
        }

	/**
	 * Met � jour les jetons du PJ.
	 * @param jetons : monnaie du PJ
	 */
	public void setMonnaie(int jetons)
	{
		if(jetons > -1)
			this.jetons = jetons;
	}
	
	/**
	 * @return : les jetons que possede le PJ.
	 */
	public int getMonnaie()
	{
		return jetons;
	}
	
	
	/**
	 * Affiche les armes du PJ.
	 */
	public void showArmes()
	{
	}
	
	
	public String toString()
	{
		return typeElement;
	}
}
