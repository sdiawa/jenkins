########################################################################
###############					 
###############      ROGUELIKE 	mini projet	  		
###############					 	
########################################################################


# Auteurs: 
	
	* DIAWARA Sekou Abdoul Kader 	* HOUSSEIN Mouwafak Hamed.      * MEITE Siriki


#Presentation generale:
le jeu Roguelike ci-contre est un jeu qui fait évoluer un joueur dans environnement.
A l'initialisation du jeu, le joueur à une certaine durée de vie exprimée en nombre de points.

Ce nombre de points peut augmenter ou diminuer tout au long du jeu et détermine ainsi l'existence
du joueur dans une partie de jeu.

Pour faire une partie du jeu, l'utilisateur doit choisir un personnage joueur.

Le choix du personnage peut être déterministe ou aléatoire.

#Principe général du jeu:
Les instructions seront affichées à l'écran à l'utilisateur. celui-ci devra les saisir au clavier
suivies de la touche "ENTREE"

#Prérequis
		*pache Maven (version utilisée pour le projet : 3.6.0)
		*JDK (version utilisée pour le projet :11.0.1)

#Le déroulement d'une partie de jeu:
Une partie de jeu est composée de deux sous partie:
La première sous partie est un environnement où évolue le personnage "joueur" « représenté par @ » 
avec d'autres personnages "non joueur" « représenté par A » et un ensemble d'éléments sous 
forme de bonus (provisions, point de vie).


# Exemple de déroulement d’un partie complète de Roguelike

Pour jouer une partie du jeu Roguelike, l’utilisateur doit :

 
-	Se placer dans le répertoire « target » du projet ;
-	Taper la commande java  -jar Donjon_RogueLike-0.0.1-SNAPSHOT.jar

Le jeu est lancé et l’utilisateur faire une saisie suivie de la touche « ENTREE »

1.	Permet de lancer une nouvelle partie
2.	Permet de charger une partie existante et sauvegardée par l’utilisateur.
 L’utilisateur a la possibilité de sauvegarder une partie et le rejouer à tout moment.
3.	Permet simplement de quitter le jeu.

Si l’utilisateur a choisi 1 ou 2, alors on lui propose une liste d’options afin de personnaliser 
la partie, en particulier le personnage « joueur » avec qui il souhaite faire la partie.  
Sinon, il choisit un personnage de façon aléatoire.

Lorsque la partie commence, l’utilisateur doit faire évoluer (déplacer) le personnage « joueur » 
à l’aide des touches :
		g puis « ENTREE » pour aller à gauche ;
		d puis « ENTREE » pour aller à droite ;
		b puis « ENTREE » pour aller en bas ;
		h puis « ENTREE » pour aller en haut.

On peut ramasser des points de vies, de magie et augmenter ainsi durée de vie dans le jeu.

Lorsque le personnage « joueur » parvient à trouver la porte (représenté par un seul « + »), 
alors il a gagné la partie et doit charger une nouvelle partie.

Si pendant son parcours, le personnage « joueur » rencontre le personnage « non joueur », 
un duel se déclenche automatiquement à la fin duquel un des personnages meurt.

Chaque personnage a une arme spécifique qu’il peut utiliser. Par exemple, le personnage « Siriki »
utilise les armes flèche « f » et épée « e ».

Chaque coup d’une arme bien choisie, entraine une diminution des points de vie du Personnage « non joueur » 
sachant qu’une mauvaise utilisation d’une arme (par exemple non possédé par le personnage) entraine une 
diminution drastique des points de vie du personnage « joueur » 

Si c’est le personnage « non joueur » qui meurt, le personnage « joueur » continue la partie.

Dans le cas contraire, la partie est perdue et terminée, il faut lancer une nouvelle partie












