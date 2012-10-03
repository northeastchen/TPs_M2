package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import auction.Auction;
import auction.User;
import auction.impl.AccountImpl;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
import auction.impl.MessageImpl;
import auction.impl.ServerImpl;
import auction.impl.UserImpl;

public class AccountImplTest extends TestCase {

	AccountImpl testA;
	Auction mockau1;
	Auction mockau2;
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
		
		mockau1=EasyMock.createMock(AuctionImpl.class);
		List<BidImpl> bids = new java.util.ArrayList<BidImpl>();
		EasyMock.expect(mockau1.getBids()).andReturn(bids).anyTimes();
		
		mockau2=EasyMock.createMock(AuctionImpl.class);
		List<BidImpl> bids2 = new java.util.ArrayList<BidImpl>();
		EasyMock.expect(mockau2.getBids()).andReturn(bids2).anyTimes();

		EasyMock.expect(mockau1.getMaxBid()).andReturn(!bids.isEmpty() ? bids.get(bids.size()-1) : null).anyTimes();
		
		//ServerImpl.instance.getAuctions().put(name,this);
		
		
		EasyMock.replay(mockau1);
		EasyMock.replay(mockau2);
		
		bid1=new BidImpl(u1, mockau1, 20);
		bid2=new BidImpl(u1, mockau2, 10);
		bid3=new BidImpl(u2, mockau2, 40);
		
		 
		
		l_auction=new ArrayList<Auction>();
		
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

	public void testGetFreeCredit1() {
		System.out.println(testA.getFreeCredit());
	}

	public void testGetCredits() {	
		fail("Not yet implemented");
	}

}
