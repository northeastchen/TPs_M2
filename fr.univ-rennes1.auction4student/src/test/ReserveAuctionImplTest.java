package test;

import junit.framework.TestCase;
import auction.impl.ReserveAuctionImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;
import auction.states.Cancelled;
import auction.states.Closed;
import auction.states.Open;
import auction.states.Pending;

public class ReserveAuctionImplTest extends TestCase {

	private ReserveAuctionImpl au;
	private ReserveAuctionImpl auTest;
	private UserImpl seller;
	private UserImpl seller2;
	
	protected void setUp() throws Exception {
		super.setUp();
		seller = new UserImpl("Jean", "Test", "email", "password", "address");
		seller2 = new UserImpl("Jean", "Test2", "email", "password", "address");
		au= new ReserveAuctionImpl(seller, "ReserveAuction test",
				"Description de l'auction de test", 15, 30, 2, 5);
	}

	public void testReserveAuctionImpl() {
		auTest = new ReserveAuctionImpl(seller, "ReserveAuction test",
				"Description de l'auction de test", 15, 30, 2, 5);
		assertEquals(seller, auTest.getSeller());
		assertEquals("ReserveAuction test", auTest.getName());
		assertEquals("Description de l'auction de test",
				auTest.getDescription());
		assertEquals(15, auTest.getStartDate());
		assertEquals(30, auTest.getEndDate());
		assertEquals(2, auTest.getMinimumBid());
		assertEquals(auTest,
				ServerImpl.instance.getAuctions().get(auTest.getName()));
		assertEquals(5, auTest.getReservePrice());
	}

	public void testGetReservePrice() {
		assertEquals(5, au.getReservePrice());
	}

	public void testSetReservePrice() {
		au.setReservePrice(50);
		assertEquals(50, au.getReservePrice());
	}

	public void testSetResPricePending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction", au.setResPrice(seller2, 50));
	}

	public void testSetResPricePending2() {
		au.setState(Pending.instance);
		assertEquals("ERROR: the reserve price must be greater than the minimum bid", au.setResPrice(seller, 0));
	}

	public void testSetResPricePending3() {
		au.setState(Pending.instance);
		assertEquals("OK", au.setResPrice(seller, 50));
		assertEquals(50, au.getReservePrice());
	}
	
	public void testSetResPriceCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setResPrice(seller, 50));
	}
	
	public void testSetResPriceOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auctions is open", au.setResPrice(seller, 50));
	}
	
	public void testSetResPriceClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setResPrice(seller, 50));
	}

}
