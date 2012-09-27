package test;

import auction.Person;
import auction.impl.BulletinBoardImpl;
import auction.impl.ModeratorImpl;
import auction.impl.UserImpl;
import junit.framework.TestCase;

public class BulletinBoardImplTest extends TestCase {

	Person p;
	Person u;
	BulletinBoardImpl b;
	
	protected void setUp() throws Exception {
		super.setUp();
		b=new BulletinBoardImpl();
	    p=new ModeratorImpl("firstname","lastName", "email", "password", "address");
	    u=new UserImpl("firstname","lastName", "email", "password", "address");
	}

	public void testDelMessage() {
		assertEquals("ERROR: this message does not exist",b.delMessage(p,1));
		assertEquals("ERROR: only moderators can delete a message",b.delMessage(u,1));
	}

	public void testGetMess() {
		fail("Not yet implemented");
	}

	public void testGetMessages() {
		fail("Not yet implemented");
	}

}
