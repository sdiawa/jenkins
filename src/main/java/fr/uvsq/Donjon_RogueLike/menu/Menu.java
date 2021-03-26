/**
 * Cette classe gère  le Menu principal

 */

package fr.uvsq.Donjon_RogueLike.menu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
	/**
	 * Attributs de la classe Menu.
	 */
	private int choix = 0; 	

	/**
	 * Affiche l'entete du Menu. 	
	 */
	private void enteteMenu() {
		System.out.println("\n\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█  ########    ######   #      #            #   ######   #      #   █");
		System.out.println("\t\t█  #       #  #      #  # #    #            #  #      #  # #    #   █");
		System.out.println("\t\t█  #       #  #      #  #  #   #            #  #      #  #  #   #   █");
		System.out.println("\t\t█  #       #  #      #  #   #  #    #       #  #      #  #   #  #   █");
		System.out.println("\t\t█  #       #  #      #  #    # #    #       #  #      #  #    # #   █");
		System.out.println("\t\t█  #       #  #      #  #      #    #       #  #      #  #      #   █");
		System.out.println("\t\t█  ########    ######   #      #     #######    ######   #      #   █");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\n\t\t                                                                    ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                   █ ");
		System.out.println("\t\t█                         1- Nouvelle Partie                        █ ");
		System.out.println("\t\t█                                                                   █ ");
		System.out.println("\t\t█                         2- Charger une partie                     █  ");
		System.out.println("\t\t█                                                                   █ ");
		System.out.println("\t\t█                         3- Quitter                                █   ");
		System.out.println("\t\t█                                                                   █   ");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	/**
	 * cette méthode gère le menu.
	 */
	public void gestionMenu() {
		colorEcran("70");
		Scanner input = new Scanner(System.in);

		try {
			while (choix != 1 && choix != 2 && choix != 3) {
				this.enteteMenu();
				System.out.println("\n\n\t\t                         Veuillez saisir votre choix \n\n\n");
				choix = input.nextInt();
				effaceEcran();

			}
		} catch (InputMismatchException e) {
			System.out
					.println("\n\t\t   Votre saisie est incorrecte !!! \n \t\t   Merci de relancer l'application \n\n");

		} finally {
			switch (choix) {
			case 1:
				NouvellePartieMenu n = new NouvellePartieMenu();
				n.gestionMenu();
				break;
			case 2:
				ChargerPartieMenu c = new ChargerPartieMenu();
				c.gestionMenu();
			default:
				System.exit(1);
				break;

			}
			input.close();

		}

	}

	/**
	 * Cette méthode met à jour le terminal , en effaçant l'affichage précédent.
	 */
	public static void effaceEcran() {

		try {

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		} catch (Exception e) {
			System.exit(1);
		}

	}

	/**
	 * Cette méthode change la couleur du terminal
	 * 
	 * @param codeCouleur : code couleur.
	 */
	public static void colorEcran(String codeCouleur) {
		try {

			new ProcessBuilder("cmd", "/c", "COLOR " + codeCouleur).inheritIO().start().waitFor();

		} catch (Exception e) {
			System.exit(1);
		}
	}

}
