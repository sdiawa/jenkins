########################################################################
###############					 
###############      ROGUELIKE 	mini projet	  		
###############					 	
########################################################################


# Auteurs: 
	
	* DIAWARA Sekou Abdoul Kader 	* HOUSSEIN Mouwafak Hamed.      * MEITE Siriki


#Presentation generale:
le jeu Roguelike ci-contre est un jeu qui fait �voluer un joueur dans environnement.
A l'initialisation du jeu, le joueur � une certaine dur�e de vie exprim�e en nombre de points.

Ce nombre de points peut augmenter ou diminuer tout au long du jeu et d�termine ainsi l'existence
du joueur dans une partie de jeu.

Pour faire une partie du jeu, l'utilisateur doit choisir un personnage joueur.

Le choix du personnage peut �tre d�terministe ou al�atoire.

#Principe g�n�ral du jeu:
Les instructions seront affich�es � l'�cran � l'utilisateur. celui-ci devra les saisir au clavier
suivies de la touche "ENTREE"

#Pr�requis
		*pache Maven (version utilis�e pour le projet : 3.6.0)
		*JDK (version utilis�e pour le projet :11.0.1)

#Le d�roulement d'une partie de jeu:
Une partie de jeu est compos�e de deux sous partie:
La premi�re sous partie est un environnement o� �volue le personnage "joueur" � repr�sent� par @ � 
avec d'autres personnages "non joueur" � repr�sent� par A � et un ensemble d'�l�ments sous 
forme de bonus (provisions, point de vie).


# Exemple de d�roulement d�un partie compl�te de Roguelike

Pour jouer une partie du jeu Roguelike, l�utilisateur doit :

 
-	Se placer dans le r�pertoire � target � du projet ;
-	Taper la commande java  -jar Donjon_RogueLike-0.0.1-SNAPSHOT.jar

Le jeu est lanc� et l�utilisateur faire une saisie suivie de la touche � ENTREE �

1.	Permet de lancer une nouvelle partie
2.	Permet de charger une partie existante et sauvegard�e par l�utilisateur.
 L�utilisateur a la possibilit� de sauvegarder une partie et le rejouer � tout moment.
3.	Permet simplement de quitter le jeu.

Si l�utilisateur a choisi 1 ou 2, alors on lui propose une liste d�options afin de personnaliser 
la partie, en particulier le personnage � joueur � avec qui il souhaite faire la partie.  
Sinon, il choisit un personnage de fa�on al�atoire.

Lorsque la partie commence, l�utilisateur doit faire �voluer (d�placer) le personnage � joueur � 
� l�aide des touches :
		g puis � ENTREE � pour aller � gauche ;
		d puis � ENTREE � pour aller � droite ;
		b puis � ENTREE � pour aller en bas ;
		h puis � ENTREE � pour aller en haut.

On peut ramasser des points de vies, de magie et augmenter ainsi dur�e de vie dans le jeu.

Lorsque le personnage � joueur � parvient � trouver la porte (repr�sent� par un seul � + �), 
alors il a gagn� la partie et doit charger une nouvelle partie.

Si pendant son parcours, le personnage � joueur � rencontre le personnage � non joueur �, 
un duel se d�clenche automatiquement � la fin duquel un des personnages meurt.

Chaque personnage a une arme sp�cifique qu�il peut utiliser. Par exemple, le personnage � Siriki �
utilise les armes fl�che � f � et �p�e � e �.

Chaque coup d�une arme bien choisie, entraine une diminution des points de vie du Personnage � non joueur � 
sachant qu�une mauvaise utilisation d�une arme (par exemple non poss�d� par le personnage) entraine une 
diminution drastique des points de vie du personnage � joueur � 

Si c�est le personnage � non joueur � qui meurt, le personnage � joueur � continue la partie.

Dans le cas contraire, la partie est perdue et termin�e, il faut lancer une nouvelle partie












