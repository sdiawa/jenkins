
package fr.uvsq.Donjon_RogueLike.composant;

public class Porte extends Element
{

	/**
	 * Constructeur de la classe Porte.
	 * @param x : colonne à laquelle se trouve l'élement.
	 * @param y : ligne à laquelle se trouve l'élement.
	 */
	public Porte(int x, int y)
	{
		super(x, y, '+');
		typeElement = "Porte";
	}

	/**
	 * retourne le nombre de portes du terrain en fonction du nombre de piéce.
	 * @param nbPieces : nombre de piéce du terrain.
	 * @return nombre de portes.
	 */
	public static int getNbPortes(int nbPieces)
        {
	 	   switch(nbPieces)
		    {
		      case 1:
		         return 1;
		      case 2:
		         return 5;
		      case 3:
		         return 9;
		      case 4:
		         return 13;
		      case 5 :
		    	  return 17;
		      default:
		         return 21;

		    }

      }
}