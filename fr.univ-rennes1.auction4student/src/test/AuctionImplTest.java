package test;

import junit.framework.TestCase;
import auction.Auction;
import auction.AuctionState;
import auction.Moderator;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.ModeratorImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;
import auction.states.Cancelled;
import auction.states.Closed;
import auction.states.Open;
import auction.states.Pending;

public class AuctionImplTest extends TestCase {

	private User seller;
	private User sellerTest;
	private Moderator moderatorTest;
	private Auction au;
	private Auction auTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		seller=new UserImpl("Jean","Test","email","password", "address");
		sellerTest=new UserImpl("name","Test","email","password", "address");
		moderatorTest = new ModeratorImpl("mode", "rator", "mail", "pass", "here");
		au=new AuctionImpl(seller,"Auction 1","Description de l'auction",15, 30, 2);
		
	}

	public void testAuctionImpl() {
		auTest=new AuctionImpl(sellerTest,"Auction test","Description de l'auction de test",15, 30, 2);
		assertEquals(sellerTest, auTest.getSeller());
		assertEquals("Auction test", auTest.getName());
		assertEquals("Description de l'auction de test", auTest.getDescription());
		assertEquals(15, auTest.getStartDate());
		assertEquals(30, auTest.getEndDate());
		assertEquals(2, auTest.getMinimumBid());
		assertEquals(auTest, ServerImpl.instance.getAuctions().get(auTest.getName()));
	}

	public void testCancelAuction() {
		// TODO cf State
	}

	public void testClose() {
		// TODO cf State
	}

	public void testGetBidHistory() {
		fail("Not yet implemented");
	}

	public void testGetBids() {
		fail("Not yet implemented");
	}

	public void testGetBulletinBoard() {
		fail("Not yet implemented");
	}

	public void testGetCurrentBid() {
		fail("Not yet implemented");
	}

	public void testGetDescription() {
		assertEquals("Description de l'auction",au.getDescription());
	}

	public void testGetEndD() {
		assertEquals("30",au.getEndD());
	}

	public void testGetEndDate() {
		assertEquals(30,au.getEndDate());
	}

	public void testGetJoinedUsers() {
		fail("Not yet implemented");
	}

	public void testGetMaxBid() {
		fail("Not yet implemented");
	}

	public void testGetMinBid() {
		assertEquals("2",au.getMinBid());
	}

	public void testGetMinimumBid() {
		assertEquals("2",au.getMinimumBid());
	}

	public void testGetName() {
		assertEquals("Auction 1", au.getName());
	}

	public void testGetSeller() {
		assertTrue(au.getSeller() instanceof User);
		assertEquals(seller,au.getSeller());
	}

	public void testGetStartD() {
		assertEquals("15",au.getStartD());
	}

	public void testGetStartDate() {
		assertEquals(15,au.getStartDate());
	}

	public void testGetState() {
		assertTrue(au.getState() instanceof AuctionState);
	}

	public void testJoin() {
		fail("Not yet implemented");
	}

	public void testLeave() {
		fail("Not yet implemented");
	}

	public void testMinimumAmount() {
		fail("Not yet implemented");
	}

	public void testOpen() {
		fail("Not yet implemented");
	}

	public void testPlaceBid() {
		fail("Not yet implemented");
	}

	public void testPostMessage() {
		fail("Not yet implemented");
	}

	public void testSetDesc() {
		fail("Not yet implemented");
	}

	public void testSetDescription() {
		au.setDescription("Modification description");
		assertEquals("Modification description",au.getDescription());
	}

	public void testSetEndD() {
		fail("Not yet implemented");
	}

	public void testSetEndDate() {
		fail("Not yet implemented");
	}

	public void testSetMinBid() {
		fail("Not yet implemented");
	}

	public void testSetMinimumBid() {
		au.setMinimumBid(4);
		assertEquals(4, au.getMinimumBid());
	}

	/*
	 * test 1ère condition : auction.getSeller()!=person && !(person instanceof Moderator)
	 */
	public void testSetStartDPending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction", au.setStartD(sellerTest, 10));
	}
	
	/*
	 * test 2nd value<=0
	 */
	public void testSetStartDPending2() {
		au.setState(Pending.instance);
		assertEquals("ERROR: the minimum bid must be greater than 0", au.setStartD(sellerTest, 0));
		assertEquals("ERROR: the minimum bid must be greater than 0", au.setStartD(moderatorTest, -2));
	}
	
	public void testSetStartDPending3() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction", au.setStartD(seller, 10));
	}
	
	public void testSetStartDPending4() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction cancelled", au.setStartD(seller, 10));
	}
	
	public void testSetStartDPending5() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction cancelled", au.setStartD(seller, 10));
	}
	
	public void testSetStartDPending6() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction cancelled", au.setStartD(seller, 10));
	}
	
	public void testSetStartDCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setStartD(seller, 10));
	}
	
	public void testSetStartDClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setStartD(seller, 10));
	}
	
	public void testSetStartDOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auctions is open", au.setStartD(seller, 10));
	}

	public void testSetStartDate() {
		au.setStartDate(5000);
		assertEquals(5000, au.getStartDate());
	}

	/*
	 * Test de la méthode setState() avec un état Cancelled
	 */
	public void testSetStateCancelled() {
		au.setState(Cancelled.instance);
		assertEquals(Cancelled.instance, au.getState());
	}
	
	/*
	 * Test de la méthode setState() avec un état Pending
	 */
	public void testSetStatePending() {
		au.setState(Pending.instance);
		assertEquals(Pending.instance, au.getState());
	}
	
	/*
	 * Test de la méthode setState() avec un état Open
	 */
	public void testSetStateOpen() {
		au.setState(Open.instance);
		assertEquals(Open.instance, au.getState());
	}
	
	/*
	 * Test de la méthode setState() avec un état Closed
	 */
	public void testSetStateClosed() {
		au.setState(Closed.instance);
		assertEquals(Closed.instance, au.getState());
	}

	public void testToString() {
		assertEquals("Auction 1" + " " + "Description de l'auction" + " " + "PENDING" + " " + 30, 
				au.toString());
	}

}
