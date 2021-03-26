/**  
 * Cette classe permet de charger une partie sauvegardée 

 * 

 **/

package fr.uvsq.Donjon_RogueLike.menu;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.uvsq.Donjon_RogueLike.composant.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.nonJoueur.*;
import fr.uvsq.Donjon_RogueLike.terrain.Terrain;


public class ChargerPartieMenu extends Menu
{
	/**
	 * Attributs de la classe ChargerPartieMenu.
	 */
	private int choix = 0;
	
	/**
	 *  Affiche l'entete.
	 */
	private void enteteChargerPartieMenu()
	 {
		System.out.println("\n\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t█                                                                 █ ");
		System.out.println("\t\t█                       Charger une partie                        █ ");
		System.out.println("\t\t█                                                                 █");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
				
	 }
	
	/**
	 * cette méthode gère le menu.
	 */
	public void gestionMenu()
	  {
		   boolean isFichier = false;
		   int i = 1;
		   Scanner input = new Scanner(System.in);
		   File repertoire;
		   File[] fichiers = null;
		   
		   repertoire = new File("C:\\savedFiles");
		   
		   try
		    {	
			    
			    while(choix == 0)
			     {
			    	i = 1;
			    	this.enteteChargerPartieMenu();
			    	  
					if(repertoire.isDirectory() && repertoire.canRead())
					    {
							fichiers = repertoire.listFiles();
							isFichier = true;
						    
				            for (File fichier : fichiers) 
				            {
				            	if(fichier.isFile())
				            	{
					            	System.out.println("\n\t\t        " + i + "- " + fichier.getName());
					            	i += 1;
				            	}

				             }
				            System.out.println("\n\t\t       " + i + "- Revenir au Menu principal  \n");
					    }
					 else
					    {
						 	System.out.println("\n\n\t\t Rien à afficher !!! \n\n\n");
						 	System.out.println("\n\t\t " + i + "- Revenir au Menu principal  \n");
					    }
					
					System.out.println("\t\t                       Veuillez saisir votre choix \n\n\n");
					choix = input.nextInt();
					
					if(choix < 1 || choix > i)
						choix = 0;
					super.effaceEcran();
			     }
			    
		    }
		   catch(InputMismatchException e)
		    {
			  
			   System.out.println("\n\t\t                                    Saisie incorrecte !!! \n");
	           System.out.println("\n\t\t                                 Retour au Menu principal \n");
	           super.effaceEcran();
	           super.gestionMenu();
		    }
		   finally
		   {
			   if(choix == i)
				   super.gestionMenu();
			   else
			   {
				   if(isFichier)
				   {
					   try 
					   {
						
						   chargerPartie(fichiers[choix - 1]);
					   } 
					   catch (IOException e) 
					   {
						e.printStackTrace();
					   }
				   }
					   
			   }
			   input.close();
	        }
		  
			  
		   
		   
	   }
	
	
	/**
	 * Cette méthode analyse et récupère les informations de la partie sauvegardée dans le fichier choisi. 
	 * @param file : le fichier dans lequel on récupère les informations du jeu.
	 * @throws IOException : Exception lancée lorsqu'une erreur survient lors de l'accès au fichier.
	 * @throws FileNotFoundException : Exception lancée lorsque le fichier spécipfié en paramètre n'existe pas.
	 */
	private void chargerPartie(File file) throws IOException,FileNotFoundException
	{

		 int nbPieces = 0,nbLignes = 0,nbColonnes = 0,nPiece = 0;
		 int x = 0,y = 0;
		 String line = "void";
		 Terrain T;
		 PersonnageJoueur PJ = null;
		 int countMagie = 0 ,countPNJ = 0,countVie = 0;
		 ArrayList<PersonnageNonJoueur> PA = new ArrayList<PersonnageNonJoueur>();
		 ArrayList<Magie> m = new ArrayList<Magie>();
		 ArrayList<Vie> v = new ArrayList<Vie>();
		 
		 if(file.isFile() && file.canRead())
       {
           try( FileInputStream fs = new FileInputStream (file))
              {
                   Scanner scanner = new Scanner(fs,"UTF-8");
                   
                   while(!line.contains("Type"))
                   {
                  	 line = scanner.next();

                       if(line.equals("nbPieces:"))           
                           nbPieces = scanner.nextInt();                                          
                       else if(line.equals("nbLignes:"))
                      	 nbLignes = scanner.nextInt();
                       else if(line.equals("nbColonnes:"))
                      	 nbColonnes = scanner.nextInt();
                       
                       scanner.nextLine();
                   }
                   
                   T = new Terrain(nbPieces,nbLignes,nbColonnes);
                   
                   while((scanner.hasNextLine()))
                   {
                       line = scanner.next();

                       if(line.equals("Mur"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                           Mur mur = new Mur(x,y);
                           mur.setnPiece(nPiece);
                           T.getTerrain()[nPiece].setCase(mur);
                           scanner.nextLine();
                       }
                       else if(line.equals("Sol"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                           Sol s = new Sol(x,y);
                           s.setnPiece(nPiece);
                           T.getTerrain()[nPiece].setCase(s);
                           scanner.nextLine();
                       }
                       else if(line.equals("Porte"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                           Porte p = new Porte(x,y);
                           p.setnPiece(nPiece);
                           T.getTerrain()[nPiece].setCase(p);
                           scanner.nextLine();
                       }
                       else if(line.equals("Magie"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                           
                           if(countMagie < nbPieces)
                           {
                        	   m.add(new Magie(x,y));
                        	   m.get(countMagie).setnPiece(nPiece);
                        	   T.getTerrain()[nPiece].setCase(m.get(countMagie));
                           }
                                                   
                           ++countMagie;
                           scanner.nextLine();
                       }
                       else if(line.equals("Vie"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                      	 if(countVie < nbPieces)
                      	 {
                             v.add(new Vie(x,y));
                             v.get(countVie).setnPiece(nPiece);
                             T.getTerrain()[nPiece].setCase(v.get(countVie));
                      	 }

                      	 ++countVie;
                         scanner.nextLine();
                       }
                       else if(line.equals("PNJ"))
                       {
                      	 x = scanner.nextInt();
                      	 y = scanner.nextInt();
                      	 nPiece = scanner.nextInt();
                      	 
                      	 if(countPNJ < nbPieces)
                           {
                      		 PA.add(new PersonnageNonJoueur(x,y));
                      		 PA.get(countPNJ).setnPiece(nPiece);
                      		 T.getTerrain()[nPiece].setCase(PA.get(countPNJ));
                           }
                           
                           ++countPNJ;
                           scanner.nextLine();
                       }
                       else if(line.equals("Siriki"))
                       {
                        	 
                          	 x = scanner.nextInt();
                          	 y = scanner.nextInt();
                          	 nPiece = scanner.nextInt();
                          	 
                          	PJ = new Siriki(x,y);
                            PJ.setnPiece(nPiece);
                            T.getTerrain()[nPiece].setCase(PJ);
                            T.setPJ(PJ);
                            scanner.nextLine();
                       }
                       else if(line.equals("Diawara"))
                       {
                      	 	x = scanner.nextInt();
                      	 	y = scanner.nextInt();
                      	 	nPiece = scanner.nextInt();
                      	 
                      	 	PJ = new Diawara(x,y);
                      	 	PJ.setnPiece(nPiece);
                      	 	T.getTerrain()[nPiece].setCase(PJ);
                      	 	T.setPJ(PJ);
                      	 	scanner.nextLine();
                       }
                      
                       else if(line.equals("Mouwafak"))
                       {
                    	 	x = scanner.nextInt();
                    	 	y = scanner.nextInt();
                    	 	nPiece = scanner.nextInt();
                    	 
                    	 	PJ = new Mouwafak(x,y);
                    	 	PJ.setnPiece(nPiece);
                    	 	T.getTerrain()[nPiece].setCase(PJ);
                    	 	T.setPJ(PJ);
                    	 	scanner.nextLine();
                       }
                     
                      	 
                   }
                   
                   T.setMagie(m);
                   T.setVie(v); 
                   T.setPNJ(PA);
                   T.showTerrain();
                   scanner.close();
               }
       }
       else
          throw new FileNotFoundException("\n\n\t\t\t  Le fichier n'existe pas !!!");
   
	}
	
	
}
