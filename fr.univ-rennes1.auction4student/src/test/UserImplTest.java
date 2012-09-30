package test;

import junit.framework.TestCase;
import auction.Account;
import auction.impl.UserImpl;

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
	
	public void testGetAccount(){
		assertTrue("Test de getAccount()", u.getAccount() instanceof Account);
	}
	
	
	//A revoir 
	public void testGetJoinedAuctions(){
		assertEquals("Test de getAccount()", u.getJoinedAuctions().size(),0 );
	}
	
	public void testGetBids(){
		assertEquals("Test de getAccount()", u.getBids().size(),0 );
	}
	
	

}
