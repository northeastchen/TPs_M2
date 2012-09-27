package test;

import auction.impl.UserImpl;
import junit.framework.TestCase;

public class UserImplTest extends TestCase {

	private UserImpl u;
	
	protected void setUp() throws Exception {
		super.setUp();
		u = new UserImpl("firstname", "lastname", "email", "password", "address");
	}
	
	public void testUserImpl() {
		assertNotNull(u);
	}

	public void testGetAdress() {
		assertEquals("Test de getAdress()", "address", u.getAdress());
	}

	public void testGetEmail() {
		assertEquals("Test de getEmail()", "email", u.getEmail());
	}

	public void testGetFirstName() {
		assertEquals("Test de getFirstName()", "firstname", u.getFirstName());
	}

	public void testGetLastName() {
		assertEquals("Test de getLastName()", "lastname", u.getLastName());
	}

	public void testGetPassword() {
		assertEquals("Test de getPassword()", "password", u.getPassword());
	}

}
