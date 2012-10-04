package test_sans_mocks;

import java.util.List;

import junit.framework.TestCase;
import auction.Auction;
import auction.Bid;
import auction.impl.AccountImpl;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.UserImpl;

public class AccountImplTest extends TestCase {

	AccountImpl testA;
	List<Auction> l_auction;
	
	BidImpl bid1;
	BidImpl bid2;
	BidImpl bid3;
	
	UserImpl u1;
	UserImpl u2;
	
	protected void setUp() throws Exception {
		super.setUp();
		u1 = new UserImpl("firstname", "lastname", "email", "password", "address");
		u2=new UserImpl("firstname2","lastname2","email2","password2","address2");
		
		testA = new AccountImpl(u1);
		 	
	}
	
	public void testAccountImpl() {
		assertNotNull(testA);
	}

	public void testGetCredit() {
		assertEquals(0, testA.getCredit());
	}

	public void testIncCredit() {
		assertEquals("OK", testA.incCredit(50));
		assertEquals(50, testA.getCredit());
	}

	public void testDecCredit() {
		assertEquals("OK", testA.decCredit(50));
		assertEquals(-50, testA.getCredit());
	}

	/*
	 * Test de getMaxBid
	 */
	
	/*
	 * Test condition a.getMaxBid()!=null && a.getMaxBid().getUser()==owner
	 */
	public void testGetFreeCredit1() {
		Auction au =new AuctionImpl(u1, "Auction1","Description auc1", 12,20,5);
		Auction au2 =new AuctionImpl(u1, "Auction2","Description auc2", 15,22,18);
		
		Bid bid1=new BidImpl(u1,au, 20);
		Bid bid2=new BidImpl(u1,au, 25);
		
		assertEquals(25,testA.getFreeCredit());	
	}
	
	public void testGetFreeCredit2() {
		Auction au =new AuctionImpl(u1, "Auction1","Description auc1", 12,20,5);
		Auction au2 =new AuctionImpl(u1, "Auction2","Description auc2", 15,22,18);
		assertEquals(testA.getCredit(),testA.getFreeCredit());
	}
	
	public void testGetFreeCredit3() {
		Auction au =new AuctionImpl(u1, "Auction1","Description auc1", 12,20,5);
		Auction au2 =new AuctionImpl(u1, "Auction2","Description auc2", 15,22,18);
		
		Bid bid1=new BidImpl(u2,au, 20);
		Bid bid2=new BidImpl(u2,au, 25);
		assertEquals(testA.getCredit(),testA.getFreeCredit());
	}
	
	

	public void testGetCredits() {	
		testA.incCredit(12);
		assertEquals("12 12",testA.getCredits());
	}

}
