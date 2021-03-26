/**  
<<<<<<< HEAD
 * Cette classe gére la sauvegarde. 
=======
 * Cette classe gère la sauvegarde. 
>>>>>>> 33334b0a981f7ff00dc2d5ef51a2387d86448381
 * 
 **/

package fr.uvsq.Donjon_RogueLike.fichiers.enregistres;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import fr.uvsq.Donjon_RogueLike.composant.Element;
import fr.uvsq.Donjon_RogueLike.piece.Piece;

public class SauvegarderPartie 
{
	/** Attributs de la classe SauvegarderPartie ***/
	private static BufferedWriter bw;
	
	/***
	 * Cette méthode se charge de récuper les entrées clavier.	
	 * @return entree : la cha�ne entrée par l'utilisateur.
	 */
	protected static String readClavier()
	{
		   Scanner sc = new Scanner(System.in);
		   String entree = sc.nextLine();

		   while(!entree.equals("o") && !entree.equals("n"))
		   {
			  entree = sc.nextLine();
		   }

		   return entree;
	}
	

	/**
	 * Initialise l'attribut BufferedWriter et ouvre le fichier passé en argument.
	 * @param file : fichier à ouvrir.
	 */
	private static void initBW(File file)
	{
		try 
		 {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		 } 
		 catch (IOException e1) 
		 {
			e1.printStackTrace();
		 }
	}
	
	
	/**
	 * Ferme l'attribut BufferedWriter.
	 */
	private static void closeBW()
	{
		if(bw != null)
		{
			try
			 {
				bw.close();
			 } 
			 catch (IOException e) 
			 {
				e.printStackTrace();
			 }
		}
	}
	
	
	/**
	 * Ecrit l'en-tete du fichier.
	 * @param file : fichier dans lequel écrire.
	 * @param nbPieces : nombre de pièces du terrain.
	 * @param nbLignes : nombre de lignes du terrain.
	 * @param nbColonnes : nombre de colonnes du terrain.
	 */
	private static void writeEntete(File file,int nbPieces,int nbLignes, int nbColonnes)
	{

		initBW(file);
		try 
		{
			bw.write("nbPieces: " + nbPieces);
			bw.newLine();
			bw.write("nbLignes: " + nbLignes);
			bw.newLine();
			bw.write("nbColonnes: " + nbColonnes);
			bw.newLine();

			bw.write("Type Element        Position x         Position y          Piece          Symbole");
			bw.newLine();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * Stocke les informations du Terrain dans un fichier.
	 * @param pieces : pièces du Terrain.
	 * @param nbPieces : nombre de pièces du Terrain.
	 */
	public static void savePartie(Piece pieces[],int nbPieces)
	{
		 File directory = new File("C:\\savedFiles");
		 directory.mkdir();
		 
		 File file;
		 Scanner sc = new Scanner(System.in);
		 String fileName;
		 
		 System.out.println("\n\n\t Voulez-vous sauvegarder la partie ? o/n");
		 String value = readClavier();
		 
		 if(value.equals("o"))
		 {
			 System.out.println("\n\n\t Entrez le nom de votre fichier :");
			 
			 fileName = sc.nextLine();
			 
			 file = new File("C:\\savedFiles\\"+fileName.concat(".txt"));
			 
			 if(!file.exists())
			 {
				try
				{
					file.createNewFile();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			 }
			 
			 writeEntete(file,nbPieces,pieces[0].getNbLigne(),pieces[0].getNbColonne());
			 
			 for(int i=0; i<nbPieces; i++)
				{
					for(int j=0; j<pieces[i].getNbLigne(); j++)
					{
						for(int k=0; k< pieces[i].getNbColonne(); k++)
						{
							Element elt = pieces[i].getElement(k,j);
							try 
							{
								bw.write(elt.getTypeElement() + "                  " +k + "                  "+ j + "                  "+ elt.getnPiece() +"                  "+ elt.getSymbole());
								bw.newLine();
							} 
							catch (IOException e)
							{
								e.printStackTrace();
							}
							
						}
					}
				}
			 closeBW();
			 
		 }		 
		 
	}

}