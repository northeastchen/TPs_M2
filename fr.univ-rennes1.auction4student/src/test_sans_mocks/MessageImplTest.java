package test_sans_mocks;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;

import junit.framework.TestCase;
import auction.Person;
import auction.impl.BulletinBoardImpl;
import auction.impl.MessageImpl;
import auction.impl.ModeratorImpl;
import auction.impl.UserImpl;

public class MessageImplTest extends TestCase {
	Person m;
	Person u;
	BulletinBoardImpl bb;
	MessageImpl mess;
	MessageImpl mess2;
	
	protected void setUp() throws Exception {
		super.setUp();
		m=new UserImpl("firstname","lastname","email","password","address");
		u=new ModeratorImpl("firstname","lastname","email","password","address");
		
		bb = new BulletinBoardImpl();
		
		mess=new MessageImpl(bb,m ,"Message de test");
		
		mess2=new MessageImpl(bb,u,"Message de test 2");
	}

	public void testMessageImpl() {
		assertNotNull(mess);
		assertNotNull(mess2);
	}

	public void testGetAuthor() {
		assertEquals(m,mess.getAuthor());
		assertEquals(u,mess2.getAuthor());
	}

	public void testGetBulletinBoard() {
		assertEquals(bb, mess.getBulletinBoard());
		assertEquals(bb, mess2.getBulletinBoard());
	}

	public void testGetMessage() {
		assertEquals("Message de test",mess.getMessage());
		assertEquals("Message de test 2",mess2.getMessage());
	}

	public void testToString() {
		assertEquals("email Message de test",mess.toString());
		assertEquals("email Message de test 2",mess2.toString());
	}

}
