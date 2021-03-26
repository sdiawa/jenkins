/**
 * Classe Diawara est le nom  d'un personnage joueur.

 
 */

package fr.uvsq.Donjon_RogueLike.composant.personnage.joueur;

import fr.uvsq.Donjon_RogueLike.composant.personnage.equipement.arme.Epee;

public class Diawara extends PersonnageJoueur 
{

	/**
	 * Equipement de Diawara, repesente type particulier de PJ.
	 */
	private Epee e; 
	//private Couteau c; 
	
	/**
	 * Constructeur de la classe Diawara.
	 * @param x : colonne dans laquelle se trouve le personnage.
	 * @param y : ligne dans laquelle se trouve le personnage.
	 */
	public Diawara(int x, int y) 
	{
		super(x, y, '&');
		
		typeElement = "Diawara";
		e = new Epee();
		//c = new Couteau();
	}
	public String toString()
	{
		return "\n\t\t PJ : " +typeElement + "\n\t\t Arme : " + e.getTypeEquipement() + "\n\t\t Point Vie: " + super.getPointVie() + "\n\t\t Point Magie: " + super.getPointMagie() + "\n\t\t Monnaie: " + super.getMonnaie() + "\n\n";
		
	}
	
	
	/**
	 * Affiche les armes du PJ.
	 */
	public void showArmes()
	{
		System.out.println("\t\t e: Utiliser l'epee \n\n");
	}

}

	