package test;

import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;
import auction.states.Cancelled;
import auction.states.Closed;
import auction.states.Open;
import auction.states.Pending;
import junit.framework.TestCase;

public class AuctionImplTest extends TestCase {

	private User seller;
	private User sellerTest;
	private Auction au;
	private Auction auTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		seller=new UserImpl("Jean","Test","email","password", "address");
		sellerTest=new UserImpl("name","Test","email","password", "address");
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
		fail("Not yet implemented");
	}

	public void testClose() {
		fail("Not yet implemented");
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

	public void testSetStartD() {
		fail("Not yet implemented");
	}

	public void testSetStartDate() {
		fail("Not yet implemented");
	}

	public void testSetState() {
		Cancelled c=new Cancelled();
		Closed cl=new Closed();
		Open o=new Open();
		Pending p=new Pending();
		
		au.setState(c);
		assertEquals(c, au.getState());
		au.setState(cl);
		assertEquals(cl, au.getState());
		au.setState(o);
		assertEquals(o, au.getState());
		au.setState(p);
		assertEquals(p, au.getState());
		
	}

	public void testToString() {
		fail("Not yet implemented");
	}

}
