package test;

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
	BulletinBoardImpl mockb;
	MessageImpl mess;
	
	protected void setUp() throws Exception {
		super.setUp();
		m=new UserImpl("firstname","lastname","email","password","address");
		u=new ModeratorImpl("firstname","lastname","email","password","address");
		
		mockb=EasyMock.createMock(BulletinBoardImpl.class);
		List<MessageImpl> messages=new ArrayList<MessageImpl>();
		EasyMock.expect(mockb.getMessages()).andReturn(messages); 
		
		EasyMock.replay(mockb);
		
		mess=new MessageImpl(mockb,m ,"Message de test");
	}

	public void testMessageImpl() {
		assertNotNull(mess);
	}

	public void testGetAuthor() {
		assertEquals(m,mess.getAuthor());
	}

	public void testGetBulletinBoard() {
		assertEquals(mockb, mess.getBulletinBoard());
	}

	public void testGetMessage() {
		assertEquals("Message de test",mess.getMessage());
	}

	public void testToString() {
		assertEquals("email Message de test",mess.toString());
	}

}
