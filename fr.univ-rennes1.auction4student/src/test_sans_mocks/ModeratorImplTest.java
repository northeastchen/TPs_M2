package test_sans_mocks;

import auction.impl.ModeratorImpl;
import junit.framework.TestCase;

public class ModeratorImplTest extends TestCase {

	private ModeratorImpl m;
	
	protected void setUp() throws Exception {
		super.setUp();
		m = new ModeratorImpl("firstname", "lastname", "email", "password", "address");
	}

	public void testGetAdress() {
		assertEquals("Test de getAdress()", "address", m.getAdress());
	}

	public void testGetEmail() {
		assertEquals("Test de getAdress()", "email", m.getEmail());
	}

	public void testGetFirstName() {
		assertEquals("Test de getAdress()", "firstname", m.getFirstName());
	}

	public void testGetLastName() {
		assertEquals("Test de getAdress()", "lastname", m.getLastName());
	}

	public void testGetPassword() {
		assertEquals("Test de getAdress()", "password", m.getPassword());
	}

}
