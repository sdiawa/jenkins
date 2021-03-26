package fr.uvsq.Donjon_RogueLike;
import fr.uvsq.Donjon_RogueLike.menu.Menu;

/**
 * Classe principale à partir de laquelle on accéde au Jeu.
 
 */
public class Main {
	 
	 public static void main(String[] args)
	 {
		 
		 Menu M = new Menu();
		 Menu.effaceEcran();
		 M.gestionMenu();
		 
		 		 
	 }
}