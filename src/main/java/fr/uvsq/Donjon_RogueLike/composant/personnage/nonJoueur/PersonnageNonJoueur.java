package fr.uvsq.Donjon_RogueLike.composant.personnage.nonJoueur;

import fr.uvsq.Donjon_RogueLike.composant.personnage.Personnage;

public class PersonnageNonJoueur extends Personnage  
{

	/**
	 * Constructeur de la Classe Personnage Ami.
	 * 
	 * @param x : colonne à laquelle se trouve le personnage.
	 * @param y : ligne à laquelle se trouve le personnage.
	 */
	public PersonnageNonJoueur(int x, int y) 
	{
		super(x,y,'☻');
		typeElement = "PNJ";
	}

}