package test;

import auction.Person;
import auction.commands.GetMessages;
import auction.impl.BulletinBoardImpl;
import auction.impl.MessageImpl;
import auction.impl.ModeratorImpl;
import auction.impl.UserImpl;
import junit.framework.TestCase;

public class BulletinBoardImplTest extends TestCase {

	Person m;
	Person u;
	BulletinBoardImpl b;
	MessageImpl m1;
	MessageImpl m2;
	MessageImpl m3;

	protected void setUp() throws Exception {
		super.setUp();
		b = new BulletinBoardImpl();
		m = new ModeratorImpl("firstname", "lastName", "email", "password",
				"address");
		u = new UserImpl("firstname", "lastName", "email", "password",
				"address");

		// Ajout de 3 messages dans le bulletinBoard
		m1 = new MessageImpl(b, m, "Message 1");
		m2 = new MessageImpl(b, m, "Message 2");
		m3 = new MessageImpl(b, u, "Message 3");
	}

	public void testDelMessage() {
		// 1er if
		assertEquals("ERROR: only moderators can delete a message",
				b.delMessage(u, 1));
		// 2nd if
		assertEquals("ERROR: this message does not exist", b.delMessage(m, 0));
		assertEquals("ERROR: this message does not exist", b.delMessage(m, 4));

		// remove
		assertEquals("OK", b.delMessage(m, 1));
		assertEquals(2, b.getMessages().size());
		assertFalse(b.getMessages().contains(m1));
		assertTrue(b.getMessages().contains(m2));
		assertTrue(b.getMessages().contains(m3));
	}

	/*
	 * Test de getMess() avec 3 messages dans la liste
	 */
	public void testGetMess1() {
		assertEquals(
				"1 " + m1.toString() + System.getProperty("line.separator")
						+ "2 " + m2.toString()
						+ System.getProperty("line.separator") + "3 "
						+ m3.toString(),
				b.getMess());
	}
	
	/*
	 * Test de getMess() avec 1 message dans la liste
	 */
	public void testGetMess2() {
		b.delMessage(m, 3);
		b.delMessage(m, 2);
		assertEquals(
				"1 " + m1.toString(),
				b.getMess());
	}
	
	/*
	 * Test de getMess() avec aucun message dans la liste
	 */
	public void testGetMess3() {
		b.delMessage(m, 1);
		b.delMessage(m, 1);
		b.delMessage(m, 1);
		assertEquals(
				"",
				b.getMess());
	}

	public void testGetMessages() {
		assertEquals(b.getMessages().size(), 3);
	}

}
