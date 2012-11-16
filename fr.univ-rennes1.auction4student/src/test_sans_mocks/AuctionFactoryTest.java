package test_sans_mocks;

import junit.framework.TestCase;
import auction.Auction;
import auction.impl.AuctionFactory;
import auction.impl.AuctionImpl;
import auction.impl.ReserveAuctionImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;

public class AuctionFactoryTest extends TestCase {

	private Auction au;
	private Auction rau;
	private UserImpl seller;
	private UserImpl seller2;
	
	private Auction auTest;
	
	protected void setUp() throws Exception {
		seller = new UserImpl("Jean", "Test", "email", "password", "address");
		seller2 = new UserImpl("Jean", "Test2", "email", "password", "address");
		au = new AuctionImpl(seller, "Auction 1", "Description de l'auction",
				15, 30, 2);
		rau= new ReserveAuctionImpl(seller, "ReserveAuction test",
				"Description de l'auction de test", 15, 30, 2, 5);
		
	}

	public void testCreateAuction() {
		auTest = AuctionFactory.getEInstance().createAuction(seller, "Auction 1", "Description de l'auction",
				15, 30, 2);
		assertEquals(seller, auTest.getSeller());
		assertEquals("Auction 1", auTest.getName());
		assertEquals("Description de l'auction",
				auTest.getDescription());
		assertEquals(15, auTest.getStartDate());
		assertEquals(30, auTest.getEndDate());
		assertEquals(2, auTest.getMinimumBid());
		assertEquals(auTest,
				ServerImpl.instance.getAuctions().get(auTest.getName()));
	}

	public void testCreateReservedAuction() {
		auTest = AuctionFactory.getEInstance().createReservedAuction(seller, "ReserveAuction test",
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
		assertEquals(5, ((ReserveAuctionImpl)auTest).getReservePrice());
	}
}
