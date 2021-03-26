/**
 * * Classe Siriki est le nom  d'un personnage joueur..


 */

package fr.uvsq.Donjon_RogueLike.composant.personnage.joueur;

import fr.uvsq.Donjon_RogueLike.composant.personnage.equipement.arme.*;

public class Siriki extends PersonnageJoueur
{
	
	
	private Fleche f;
	private Epee e;
	/**
	 * Constructeur de la classe Siriki.
	 * @param x : colonne dans laquelle se trouve le personnage.
	 * @param y : ligne dans laquelle se trouve le personnage.
	 */
	public Siriki(int x, int y) 
	{
		super(x, y, '@');
		
		typeElement = "Siriki";
		f = new Fleche();
		e = new Epee();
		
	}
	
	public String toString()
	{
		return "\n\t\t PJ : " +typeElement + "\n\t\t Arme 1: " + f.getTypeEquipement() + "\n\t\t Arme 2: " + e.getTypeEquipement() + "\n\t\t Point vie: " + super.getPointVie() + "\n\t\t Point Magie: " + super.getPointMagie() + "\n\t\t Monnaie: " + super.getMonnaie() + "\n\n";
	}
	
	
	public void showArmes()
	{
		System.out.println("\t\t f: Utiliser la fleche");
		System.out.println("\t\t e: Utiliser l'epee\n\n");
	}

}
