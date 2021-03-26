/**
 * Cette classe affiche les informations relatives au Jeu, tel que les touches utiles pour le déplacement du PJ et d'autres renseignements sur les élements du terrain.
 * 
 * @author siriki
 */

package fr.uvsq.Donjon_RogueLike.ecran;

public abstract class InfoJeu {
	/**
	 * Affiche l'en-tete d'informations.
	 */
	private void entete() {
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
		System.out.println("\n\n\t\t ***************************** Informations ********************");
		
		
	}

	/**
	 * Affiche les informations.
	 * 
	 * @param symbolePJ : symbole du personnage joueur.
	 */
	public void afficheInfoJeu(char symbolePJ) {
		this.entete();

		System.out.println("\t\t\t+ : Porte			        g: Gauche");
		System.out.println("\t\t\t" + symbolePJ + " : Personnage Joueur			d: Droite");
		System.out.println("\t\t\t☻ : Personnage Non Joueur		b: Descendre");
		System.out.println("\t\t\t� : Magie			        h: Monter");
		System.out.println("\t\t\t* : Vie");
		System.out.println("\n\n");
		System.out.println("\n\n\t\t ***************************** Jeu info ********************");
		System.out.println("\t\t\t\t\t s: Sauvegarder la partie");
		System.out.println("\t\t\t\t\t q: Quitter la partie");
		System.out.println("\t\t\t\t\t i: Afficher l'inventaire du PJ \n\n");

	}

}
