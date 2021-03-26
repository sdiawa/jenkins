/**
 * Cette classe représente au sens large les équipements du joueur.
 * @author mouwafak
 */

package fr.uvsq.Donjon_RogueLike.composant.personnage.equipement;

public class Equipement 
{
	/**
	 * Attributs de la classe Equipement.
	 */
	protected String typeEquipement;

	/**
	 * Constructeur de la Classe Equipement.
	 * @param tE : type d'équipement correspondant.
	 */
	public Equipement(String tE)
	{
		if(tE != null)
			typeEquipement = tE;
		else
			typeEquipement = "Undefined";
	}
	
	/**
	 * Met à jour le type d'équipement de l'objet.
	 * @param tE : type d'équipement correspondant.
	 */
	public void setTypeEquipement(String tE)
	{
		if(tE != null)
			typeEquipement = tE;
	}
	
	
	/**
	 * @return : le type d'équipement que représente l'objet.
	 */
	public String getTypeEquipement()
	{
		return typeEquipement;
	}
	
	
	
}
