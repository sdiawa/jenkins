package fr.uvsq;


import static org.junit.Assert.*;

import org.junit.Test;


import fr.uvsq.Donjon_RogueLike.composant.*;
import fr.uvsq.Donjon_RogueLike.composant.personnage.Personnage;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.PersonnageJoueur;
import fr.uvsq.Donjon_RogueLike.composant.personnage.joueur.*;


public class TestRoguelike {
	
	@Test
	public void TestPointdeVieInit() {
		
		Personnage pj1 = new Personnage(0,0,'@');
		
		assertEquals(50, pj1.getPointVie());
	}
		
		@Test
		public void TestPtMagie() {
				
			PersonnageJoueur pj2 = new PersonnageJoueur(0,0,'@');
			
			assertEquals(0, pj2.getPointMagie());	
			
		}
		
		
		@Test
		public void TestPtMonnaie() {
		
			PersonnageJoueur pj3 = new PersonnageJoueur(0,0,'@');
	
			assertEquals(0, pj3.getMonnaie());	
	
	}
		
		
		@Test
		public void TestPersonnageSiriki() {
			
			Siriki s = new Siriki(0, 0);
			
	
			assertEquals("Siriki", s.getTypeElement());	
	
	}
		
		
		@Test
		public void TestPersonnageSirikiSymbole() {
			
			Siriki s = new Siriki(0, 0);
	
			assertEquals('@', s.getSymbole());	
	
	}
		
		@Test
		public void TestPersonnageSirikiPointMagie() {
			
			Siriki s = new Siriki(0, 0);
	
			assertEquals(0, s.getPointMagie());	
	
	}
		
		
		@Test
		public void TestPersonnageDiawara() {
			
			Diawara s = new Diawara(0, 0);
			
	
			assertEquals("Diawara", s.getTypeElement());	
	
	}
		
		
		@Test
		public void TestPersonnageDiawaraSymbole() {
			
			Diawara s = new Diawara(0, 0);
	
			assertEquals('&', s.getSymbole());	
	
	}
		
		@Test
		public void TestPersonnageDiawaraPointMagie() {
			
			Diawara s = new Diawara(0, 0);
	
			assertEquals(0, s.getPointMagie());	
	
	}
		
		
		
		@Test
		public void TestPersonnageMouwafak() {
			
			Mouwafak s = new Mouwafak(0, 0);
			
	
			assertEquals("Mouwafak", s.getTypeElement());	
	
	}
		
		
		@Test
		public void TestPersonnageMouwafakSymbole() {
			
			Mouwafak s = new Mouwafak(0, 0);
	
			assertEquals('$', s.getSymbole());	
	
	}
		
		@Test
		public void TestPersonnageMouwafakPointMagie() {
			
			Mouwafak s = new Mouwafak(0, 0);
	
			assertEquals(0, s.getPointMagie());	
	
	}
		
		
		@Test
		public void TestMur() {
			
			Mur m = new Mur(0, 0);
	
			assertEquals('#', m.getSymbole());	
			//m.equals("#");
	
	}
		
		@Test
		public void TestSol() {
			
			Sol s = new Sol(0, 0);
	
			assertEquals('.', s.getSymbole());	
			//m.equals("#");
	
	}
		
		
		@Test
		public void TestPorte() {
			
			Porte p = new Porte(0, 0);
	
			assertEquals('+', p.getSymbole());	
	
	}
		
		
		@Test
		public void TestMagie() {
			
			Magie mag = new Magie(0, 0);
	
			assertEquals('�', mag.getSymbole());	
	
	}
		
		
	
}
