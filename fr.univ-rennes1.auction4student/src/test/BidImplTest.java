package test;

import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import auction.Auction;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.UserImpl;

public class BidImplTest extends TestCase {

	private UserImpl user;
	private Auction mockAuction;
	
	private BidImpl bid;
	private BidImpl bid2;
	
	protected void setUp() throws Exception {
		super.setUp();
		user = new UserImpl("firstname","lastname","email","password","address");
	
		mockAuction = EasyMock.createMock(AuctionImpl.class);
		
		List<BidImpl> bids = new java.util.ArrayList<BidImpl>();
		EasyMock.expect(mockAuction.getBids()).andReturn(bids);
		EasyMock.expect(mockAuction.getBids()).andReturn(bids);
		EasyMock.replay(mockAuction);
		bid = new BidImpl(user, mockAuction, 12345);
	}
	
	public void testBidImpl() {
		bid2 = new BidImpl(user, mockAuction, 12);
		assertNotNull(bid2);
		assertEquals(12, bid2.getAmount());
		assertEquals(user, bid2.getUser());
		assertEquals(mockAuction, bid2.getAuction());
	}

	public void testGetAmount() {
		assertEquals(12345, bid.getAmount());
	}

	public void testGetAuction() {
		assertEquals(mockAuction, bid.getAuction());
	}

	public void testGetUser() {
		assertEquals(user, bid.getUser());
	}

	public void testToString() {
		assertEquals(user.getEmail() + " " + 12345, bid.toString());
	}

}
