package test;

import junit.framework.TestCase;
import auction.User;
import auction.impl.AccountImpl;
import auction.impl.UserImpl;

public class AccountImplTest extends TestCase {

	AccountImpl testA;
	
	protected void setUp() throws Exception {
		super.setUp();
		User u = new UserImpl("firstname", "lastname", "email", "password", "address");
		testA = new AccountImpl(u);
	}
	
	public void testAccountImpl() {
		assertNotNull(testA);
	}

	public void testGetCredit() {
		assertEquals(0, testA.getCredit());
	}

	public void testIncCredit() {
		assertEquals("OK", testA.incCredit(50));
		assertEquals(50, testA.getCredit());
	}

	public void testDecCredit() {
		assertEquals("OK", testA.decCredit(50));
		assertEquals(-50, testA.getCredit());
	}

	public void testGetFreeCredit() {
		fail("Not yet implemented");
	}

	public void testGetCredits() {
		fail("Not yet implemented");
	}

}
