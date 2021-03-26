package teste;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Exception.AbscenceOperande;
import Exception.DenominateurNull;
import sofrone.MoteurRpn;

public class MoteurRpntest {
	MoteurRpn moteurrpn;
	@Before
	public void setUp() throws Exception {
		moteurrpn = new MoteurRpn();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpiler() {
		moteurrpn.empiler(3);
		
		assertEquals(1, moteurrpn.getStack().size(),1);
	}

	@Test
	public void testDepiler() {
		moteurrpn.empiler(3);
		moteurrpn.depiler();
		assertEquals(0, moteurrpn.getStack().size(),1);
	}

	@Test
	public void testenregistre() throws AbscenceOperande, DenominateurNull {
		moteurrpn.empiler(3);
		moteurrpn.empiler(4);
		moteurrpn.enregistre("PLUS");
		assertEquals(7, moteurrpn.getStack().get(0),1);
	}

}
