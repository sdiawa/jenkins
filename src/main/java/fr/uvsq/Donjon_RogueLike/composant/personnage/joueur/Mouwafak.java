/**
 *Classe Mouwafak est le nom  d'un personnage joueur.

 
 */

package fr.uvsq.Donjon_RogueLike.composant.personnage.joueur;

import fr.uvsq.Donjon_RogueLike.composant.personnage.equipement.arme.Gourdin;

public class Mouwafak extends PersonnageJoueur 
{
	/**
	 * Equipement de Mouwafak.
	 */
	private Gourdin g;
	
	/**
	 * Constructeur de la classe Mouwafak.
	 * @param x : colonne dans laquelle se trouve le personnage.
	 * @param y : ligne dans laquelle se trouve le personnage.
	 */
	public Mouwafak(int x, int y) 
	{
		super(x, y,'$');
		
		typeElement = "Mouwafak";
		g = new Gourdin();
	//	c = new Couteau();
	}
	
	public String toString()
	{
		return  "\n\t\t PJ : " +typeElement + "\n\t\t Arme : " + g.getTypeEquipement() + "\n\t\t Point vie: " + super.getPointVie() + "\n\t\t Point Magie: " + super.getPointMagie() + "\n\t\t Monnaie: " + super.getMonnaie() + "\n\n";
	}
	
	/**
	 * Affiche les armes du PJ. 
	 */
	public void showArmes()
	{
		System.out.println("\t\t g: Utiliser le goudin\n\n");
	}

}
