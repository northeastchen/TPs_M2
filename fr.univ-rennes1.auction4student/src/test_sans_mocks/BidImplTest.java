package test_sans_mocks;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import auction.Auction;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.UserImpl;

public class BidImplTest extends TestCase {

	private UserImpl user;
	private Auction au;
	
	private BidImpl bid;
	private BidImpl bid2;
	
	protected void setUp() throws Exception {
		super.setUp();
		user = new UserImpl("firstname","lastname","email","password","address");
	
		au = new AuctionImpl(user, "action", "descaction", 15, 30, 2);
		
		bid = new BidImpl(user, au, 12345);
	}
	
	public void testBidImpl() {
		bid2 = new BidImpl(user, au, 12);
		assertNotNull(bid2);
		assertEquals(12, bid2.getAmount());
		assertEquals(user, bid2.getUser());
		assertEquals(au, bid2.getAuction());
	}

	public void testGetAmount() {
		assertEquals(12345, bid.getAmount());
	}

	public void testGetAuction() {
		assertEquals(au, bid.getAuction());
	}

	public void testGetUser() {
		assertEquals(user, bid.getUser());
	}

	public void testToString() {
		assertEquals(user.getEmail() + " " + 12345, bid.toString());
	}

}
