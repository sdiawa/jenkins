package teste;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Exception.AbscenceOperande;
import Exception.DenominateurNull;
import Exception.EntreNonValide;
import Exception.ValeurHorsDomaine;
import sofrone.saissieRpn;

public class saissierpntest {
	saissieRpn s;
	@Before
	public void setUp() throws Exception {
		s = new saissieRpn();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaisiPLUS() throws AbscenceOperande, EntreNonValide, ValeurHorsDomaine, DenominateurNull {
		s.saissieUtilisateur("1");
		s.saissieUtilisateur("2");
		s.saissieUtilisateur("+");
		assertEquals(3, s.moteurRpn.getStack().get(0),1);
	}
	@Test
	public void testSaisiMULT() throws AbscenceOperande, EntreNonValide, ValeurHorsDomaine, DenominateurNull {
		s.saissieUtilisateur("4");
		s.saissieUtilisateur("2");
		s.saissieUtilisateur("*");
		assertEquals(8, s.moteurRpn.getStack().get(0),1);
	}
	
	@Test
	public void testSaisiMINUS() throws AbscenceOperande, EntreNonValide, ValeurHorsDomaine, DenominateurNull {
		s.saissieUtilisateur("7");
		s.saissieUtilisateur("3");
		s.saissieUtilisateur("-");
		assertEquals(4, s.moteurRpn.getStack().get(0),1);
	}
	
	@Test
	public void testSaisiDIVIDE() throws AbscenceOperande, EntreNonValide, ValeurHorsDomaine, DenominateurNull {
		s.saissieUtilisateur("5");
		s.saissieUtilisateur("2");
		s.saissieUtilisateur("/");
		assertEquals(5/2, s.moteurRpn.getStack().get(0),1);
	}

}
