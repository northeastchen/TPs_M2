package test_sans_mocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.BulletinBoard;
import auction.Moderator;
import auction.User;
import auction.impl.AuctionImpl;
import auction.impl.BidImpl;
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
	private List<BidImpl> bids;
	private UserImpl ui;
	private UserImpl ui2;

	protected void setUp() throws Exception {
		super.setUp();
		seller = new UserImpl("Jean", "Test", "email", "password", "address");
		sellerTest = new UserImpl("name", "Test", "email", "password",
				"address");
		moderatorTest = new ModeratorImpl("mode", "rator", "mail", "pass",
				"here");
		au = new AuctionImpl(seller, "Auction 1", "Description de l'auction",
				15, 30, 2);
		bids = new java.util.ArrayList<BidImpl>();
		ui = new UserImpl("User", "Impl", "email", "password", "address");
		ui2 = new UserImpl("User2", "Impl2", "email2", "password2", "address2");
	}

	public void testAuctionImpl() {
		auTest = new AuctionImpl(sellerTest, "Auction test",
				"Description de l'auction de test", 15, 30, 2);
		assertEquals(sellerTest, auTest.getSeller());
		assertEquals("Auction test", auTest.getName());
		assertEquals("Description de l'auction de test",
				auTest.getDescription());
		assertEquals(15, auTest.getStartDate());
		assertEquals(30, auTest.getEndDate());
		assertEquals(2, auTest.getMinimumBid());
		assertEquals(auTest,
				ServerImpl.instance.getAuctions().get(auTest.getName()));
	}

	/*
	 * Test de CancelAuction
	 */

	/*
	 * Test de (person instanceof Moderator)
	 */
	public void testCancelAuctionPending1() {
		au.setState(Pending.instance);
		assertEquals("OK", au.cancelAuction(moderatorTest));
		assertEquals(Cancelled.instance, au.getState());
	}

	/*
	 * Test de personn==auction.getSeller()
	 */
	public void testCancelAuctionPending2() {
		au.setState(Pending.instance);
		assertEquals("OK", au.cancelAuction(seller));
	}

	public void testCancelAuctionPending3() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot cancel this auction",
				au.cancelAuction(sellerTest));
	}

	public void testCancelAuctionCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction already cancelled",
				au.cancelAuction(sellerTest));

	}

	public void testCancelAuctionOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auction open", au.cancelAuction(sellerTest));

	}

	public void testCancelAuctionClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.cancelAuction(sellerTest));
	}

	/*
	 * Test de Close
	 */
	public void testClosePending() {
		au.setState(Pending.instance);
		try {
			au.close();

		} catch (Error e) {
			assertEquals(e.getMessage(), "Cannot close a pending auction.");
		}
	}

	public void testCloseCancelled() throws Throwable {
		au.setState(Cancelled.instance);
		try {
			au.close();

		} catch (Error e) {
			assertEquals(e.getMessage(), "Cannot close a cancelled auction.");
		}
	}

	public void testCloseOpen1() {
		au.setState(Open.instance);
		Bid b1 = new BidImpl(ui, au, 15);
		au.join(ui2);
		au.close();
		assertEquals(Closed.instance, au.getState());
	}
	
	public void testCloseOpen2() {
		au.setState(Open.instance);
		au.join(ui2);
		au.close();
		assertEquals(Closed.instance, au.getState());
	}


	public void testCloseOpen3() {
		au.setState(Open.instance);
		au.close();
		assertEquals(Closed.instance, au.getState());
	}

	public void testCloseClosed() {
		au.setState(Closed.instance);
		try {
			au.close();

		} catch (Error e) {
			assertEquals(e.getMessage(), "Cannot close a closed auction.");
		}
	}

	public void testGetBidHistory1() {
		Bid b1 = new BidImpl(ui, au, 15);
		Bid b2 = new BidImpl(ui, au, 25);
		assertEquals(au.getBidHistory(), System.getProperty("line.separator"));
	}

	public void testGetBidHistory2() {
		assertEquals(au.getBidHistory(), "");
	}

	/*
	 * test getBids() avec bids vide
	 */
	public void testGetBidsEmpty() {
		assertEquals(bids, au.getBids());
	}

	/*
	 * test getBids() avec bids non vide
	 */
	public void testGetBidsNotEmpty() {
		BidImpl b = new BidImpl(ui, au, 50);
		bids.add(b);
		assertEquals(bids, au.getBids());
	}

	public void testGetBulletinBoard() {
		assertTrue(au.getBulletinBoard() instanceof BulletinBoard);
	}

	/*
	 * Test de GetCurrentBid
	 */

	public void testGetCurrentBidPending() {
		au.setState(Pending.instance);
		assertEquals(au.getCurrentBid(), "ERROR: auction pending");
	}

	public void testGetCurrentBidCancelled() {
		au.setState(Cancelled.instance);
		assertEquals(au.getCurrentBid(), "ERROR: auction cancelled");
	}

	/*
	 * Test avec 2 éléments
	 */
	public void testGetCurrentBidOpen1() {
		au.setState(Open.instance);
		Bid b1 = new BidImpl(ui, au, 15);
		Bid b2 = new BidImpl(ui, au, 20);
		assertEquals("email 20", au.getCurrentBid());
	}

	/*
	 * Test avec 0 éléments
	 */
	public void testGetCurrentBidOpen2() {
		au.setState(Open.instance);
		assertEquals("ERROR: no current bid", au.getCurrentBid());
	}

	/*
	 * Test avec 2 éléments
	 */
	public void testGetCurrentBidClosed1() {
		au.setState(Closed.instance);
		Bid b1 = new BidImpl(ui, au, 15);
		Bid b2 = new BidImpl(ui, au, 20);
		assertEquals("email 20", au.getCurrentBid());
	}

	/*
	 * Test avec 0 éléments Test qui a permis de corriger une erreur dans la
	 * fonction getCurrentBid de Closed (ajout d'un contrôle de null)
	 */
	public void testGetCurrentBidClosed2() {
		au.setState(Closed.instance);
		assertEquals("ERROR: no current bid", au.getCurrentBid());
	}

	public void testGetDescription() {
		assertEquals("Description de l'auction", au.getDescription());
	}

	public void testGetEndD() {
		assertEquals("30", au.getEndD());
	}

	public void testGetEndDate() {
		assertEquals(30, au.getEndDate());
	}

	/*
	 * Test avec Pending
	 */
	public void testGetJoinedUsersPending() {
		au.setState(Pending.instance);
		au.join(ui);
		Collection<User> col = new ArrayList<User>();
		assertEquals(col, au.getJoinedUsers());
	}

	/*
	 * Test avec Cancelled
	 */
	public void testGetJoinedUsersCancelled() {
		au.setState(Cancelled.instance);
		au.join(ui);
		Collection<User> col = new ArrayList<User>();
		assertEquals(col, au.getJoinedUsers());
	}

	/*
	 * Test avec Open
	 */
	public void testGetJoinedUsersOpen() {
		au.setState(Open.instance);
		au.join(ui);
		Collection<User> col = new ArrayList<User>();
		col.add(ui);
		assertEquals(col, au.getJoinedUsers());
	}

	/*
	 * Test avec Closed
	 */
	public void testGetJoinedUsersClosed() {
		au.setState(Closed.instance);
		au.join(ui);
		Collection<User> col = new ArrayList<User>();
		assertEquals(col, au.getJoinedUsers());
	}

	public void testGetMaxBidNotEmpty() {
		Bid b1 = new BidImpl(ui, au, 15);
		assertEquals(b1, au.getMaxBid());
	}

	public void testGetMaxBidEmpty() {
		assertEquals(null, au.getMaxBid());
	}

	public void testGetMinBid() {
		assertEquals("2", au.getMinBid());
	}

	public void testGetMinimumBid() {
		assertEquals(2, au.getMinimumBid());
	}

	public void testGetName() {
		assertEquals("Auction 1", au.getName());
	}

	public void testGetSeller() {
		assertTrue(au.getSeller() instanceof User);
		assertEquals(seller, au.getSeller());
	}

	public void testGetStartD() {
		assertEquals("15", au.getStartD());
	}

	public void testGetStartDate() {
		assertEquals(15, au.getStartDate());
	}

	public void testGetState() {
		assertTrue(au.getState() instanceof AuctionState);
	}

	/*
	 * Test de join avec le stage pending
	 */
	public void testJoinPending() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction pending", au.join(ui));
	}

	/*
	 * Test de join avec le state Cancelled
	 */
	public void testJoinCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.join(ui));
	}

	/*
	 * Test de join avec le state Open
	 */
	public void testJoinOpen1() {
		au.setState(Open.instance);
		assertEquals("OK", au.join(ui));
		assertTrue(au.getJoinedUsers().contains(ui));
		assertTrue(ui.getJoinedAuctions().contains(au));
	}

	/*
	 * Test de join avec le state Open
	 */
	public void testJoinOpen2() {
		au.setState(Open.instance);
		au.join(ui);
		assertEquals("ERROR: auction already joined", au.join(ui));
	}

	/*
	 * Test de join avec le state Closed
	 */
	public void testJoinClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.join(ui));
	}

	/*
	 * Test de leave avec le state Pending
	 */
	public void testLeavePending() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction pending", au.leave(ui));
	}

	/*
	 * Test de leave avec le state Cancelled
	 */
	public void testLeaveCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.leave(ui));
	}

	/*
	 * Test de leave avec le state Open condition :
	 * (!auction.getJoinedUsers().contains(user))
	 */
	public void testLeaveOpen1() {
		au.setState(Open.instance);
		assertEquals("ERROR: auction not joined", au.leave(ui));
	}

	/*
	 * Test de leave avec le state Open condition : (b!=null &&
	 * b.getUser()==user)
	 */
	public void testLeaveOpen2() {
		au.setState(Open.instance);
		au.join(ui);
		Bid b = new BidImpl(ui, au, 50);
		assertEquals(
				"ERROR: you cannot leave an auction when you have the best bid",
				au.leave(ui));
	}

	/*
	 * Test de leave avec le state Open condition : ne rentre dans aucun if
	 */
	public void testLeaveOpen3() {
		au.setState(Open.instance);
		au.join(ui);
		Collection<User> colUsers = new ArrayList<User>();
		Collection<User> colAuctions = new ArrayList<User>();
		assertEquals("OK", au.leave(ui));
		assertEquals(colUsers, au.getJoinedUsers());
		assertEquals(colAuctions, ui.getJoinedAuctions());
	}

	public void testLeaveOpen4() {
		au.setState(Open.instance);
		au.join(ui2);
		au.join(ui);
		Bid b = new BidImpl(ui, au, 50);
		assertEquals("OK", au.leave(ui2));
	}

	/*
	 * Test de leave avec le state Closed
	 */
	public void testLeaveClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.leave(ui));
	}

	/*
	 * Test avec liste Bids vide
	 */
	public void testMinimumAmountBidsEmpty() {
		assertEquals(au.getMinimumBid(), au.minimumAmount());
	}

	/*
	 * Test avec liste Bids non vide
	 */
	public void testMinimumAmountBidsNotEmpty() {
		Bid b = new BidImpl(ui, au, 50);
		assertEquals(50 * 11 / 10, au.minimumAmount());
	}

	/*
	 * Test de Open
	 */

	public void testOpenPending() {
		au.setState(Pending.instance);
		au.open();
		assertEquals(Open.instance, au.getState());
	}

	public void testOpenCancelled() {
		au.setState(Cancelled.instance);
		try {
			au.open();
		} catch (Error e) {
			assertEquals("Cannot open a cancelled auction.", e.getMessage());
		}
	}

	public void testOpenOpen() {
		au.setState(Open.instance);
		try {
			au.open();
		} catch (Error e) {
			assertEquals("Cannot open an open auction", e.getMessage());
		}
	}

	public void testOpenClosed() {
		au.setState(Closed.instance);
		try {
			au.open();
		} catch (Error e) {
			assertEquals("Cannot close a closed auction.", e.getMessage());
		}
	}

	public void testPlaceBidPending() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction pending", au.placeBid(ui, 50));
	}

	public void testPlaceBidCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.placeBid(ui, 50));
	}

	public void testPlaceBidOpen1() {
		au.setState(Open.instance);
		assertEquals("ERROR: insufficient amount", au.placeBid(ui, 0));
	}

	public void testPlaceBidOpen2() {
		au.setState(Open.instance);
		assertEquals("ERROR: insufficient free credit", au.placeBid(ui, 50));
	}

	public void testPlaceBidOpen3() {
		au.setState(Open.instance);
		Bid b = new BidImpl(ui, au, 50);
		au.join(ui);
		assertEquals("OK", au.placeBid(ui, 80));
	}

	public void testPlaceBidClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.placeBid(ui, 50));
	}

	/*
	 * Test de postMessage pour le state Pending
	 */
	public void testPostMessagePending() {
		au.setState(Pending.instance);
		assertEquals("ERROR: auction pending",
				au.postMessage(seller, "newMess"));
	}

	/*
	 * Test de postMessage pour le state Cancelled
	 */
	public void testPostMessageCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled",
				au.postMessage(seller, "newMess"));
	}

	/*
	 * Test de postMessage pour le state Open condition :
	 * (auction.getSeller()!=person && !(person instanceof Moderator) &&
	 * !auction.getJoinedUsers().contains(person))
	 */
	public void testPostMessageOpen1() {
		au.setState(Open.instance);
		assertEquals("ERROR: you cannot post on this bulletin board",
				au.postMessage(sellerTest, "newMess"));
	}

	/*
	 * Test de postMessage pour le state Open condition : Ne rentre pas dans le
	 * if
	 */
	public void testPostMessageOpen2() {
		au.setState(Open.instance);
		au.join(ui);
		assertEquals("OK", au.postMessage(seller, "newMess"));
	}

	/*
	 * Test de postMessage pour le state Closed
	 */
	public void testPostMessageClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.postMessage(seller, "newMess"));
	}

	public void testPostMessageOpen3() {
		au.setState(Open.instance);
		assertEquals("OK", au.postMessage(moderatorTest, "newMess"));
	}

//	public void testPostMessageOpen4() {
//		au.setState(Open.instance);
//		assertEquals("OK", au.postMessage(sellerTest, "newMess"));
//	}
	
	/*
	 * Test de setDesc pour le state Pending condition :
	 * (auction.getSeller()!=person && !(person instanceof Moderator))
	 */
	public void testSetDescPending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction",
				au.setDesc(sellerTest, "newDesc"));
	}

	/*
	 * Test de setDesc pour le state Pending condition : Ne rentre pas dans le
	 * if
	 */
	public void testSetDescPending2() {
		au.setState(Pending.instance);
		assertEquals("OK", au.setDesc(seller, "newDesc"));
		assertEquals("newDesc", au.getDescription());
	}

	/*
	 * Test de setDesc pour le state Cancelled
	 */
	public void testSetDescCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setDesc(seller, "newDesc"));
	}

	/*
	 * Test de setDesc pour le state Open
	 */
	public void testSetDescOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auctions is open", au.setDesc(seller, "newDesc"));
	}

	/*
	 * Test de setDesc pour le state Closed
	 */
	public void testSetDescClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setDesc(seller, "newDesc"));
	}

	public void testSetDescription() {
		au.setDescription("Modification description");
		assertEquals("Modification description", au.getDescription());
	}

	/*
	 * Test de setEndD pour le state Pending condition :
	 * (auction.getSeller()!=person && !(person instanceof Moderator))
	 */
	public void testSetEndDPending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction",
				au.setEndD(sellerTest, 10));
	}

	/*
	 * Test de setEndD pour le state Pending condition :
	 * (value<=auction.getStartDate())
	 */
	public void testSetEndDPending2() {
		au.setState(Pending.instance);
		assertEquals("ERROR: the end date must be greater than the start date",
				au.setEndD(seller, au.getStartDate() - 1));
	}

	/*
	 * Test de setEndD pour le state Pending condition : Ne rentre dans aucun if
	 */
	public void testSetEndDPending3() {
		au.setState(Pending.instance);
		int sd = au.getStartDate();
		assertEquals("OK", au.setEndD(seller, au.getStartDate() + 1));
		assertEquals(sd + 1, au.getEndDate());
	}

	/*
	 * Test de setEndD pour le state Cancelled
	 */
	public void testSetEndDCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setEndD(seller, 10));
	}

	/*
	 * Test de setEndD pour le state Open
	 */
	public void testSetEndDOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auctions is open", au.setEndD(seller, 10));
	}

	/*
	 * Test de setEndD pour le state Closed
	 */
	public void testSetEndDClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setEndD(seller, 10));
	}

	public void testSetEndDate() {
		au.setEndDate(50);
		assertEquals(50, au.getEndDate());
	}

	/*
	 * Test de setMinBid pour le state Pending condition :
	 * (auction.getSeller()!=person && !(person instanceof Moderator))
	 */
	public void testSetMinBidPending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction",
				au.setMinBid(sellerTest, 10));
	}

	/*
	 * Test de setMinBid pour le state Pending condition : (value<=0)
	 */
	public void testSetMinBidPending2() {
		au.setState(Pending.instance);
		assertEquals("ERROR: the minimum bid must be greater than 0",
				au.setMinBid(seller, -5));
	}

	/*
	 * Test de setMinBid pour le state Pending condition : Ne rentre dans aucun
	 * if
	 */
	public void testSetMinBidPending3() {
		au.setState(Pending.instance);
		assertEquals("OK", au.setMinBid(seller, 10));
		assertEquals(10, au.getMinimumBid());
	}

	/*
	 * Test de setMinBid pour le state Cancelled
	 */
	public void testSetMinBidCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setMinBid(seller, 10));
	}

	/*
	 * Test de setMinBid pour le state Open
	 */
	public void testSetMinBidOpen() {
		au.setState(Open.instance);
		assertEquals("ERROR: auctions is open", au.setMinBid(seller, 10));
	}

	/*
	 * Test de setMinBid pour le state Closed
	 */
	public void testSetMinBidClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setMinBid(seller, 10));
	}

	public void testSetMinimumBid() {
		au.setMinimumBid(4);
		assertEquals(4, au.getMinimumBid());
	}

	/*
	 * test avec Pending.setStartDate 1ère condition :
	 * auction.getSeller()!=person && !(person instanceof Moderator)
	 */
	public void testSetStartDPending1() {
		au.setState(Pending.instance);
		assertEquals("ERROR: you cannot modify this auction",
				au.setStartD(sellerTest, 10));
	}

	/*
	 * test avec Pending.setStartDate 2nde condition :
	 * value<=ServerImpl.instance.getTick()
	 */
	public void testSetStartDPending2() {
		au.setState(Pending.instance);
		assertEquals(
				"ERROR: the start date must be greater than the current time",
				au.setStartD(seller, 0));
	}

	/*
	 * test avec Pending.setStartDate 3ème condition :
	 * value>=auction.getEndDate()
	 */
	public void testSetStartDPending3() {
		au.setState(Pending.instance);
		assertEquals("ERROR: the start date must be less than the end date",
				au.setStartD(seller, au.getEndDate() + 1));
	}

	/*
	 * test avec Pending.setStartDate aucune des condition
	 */
	public void testSetStartDPending4() {
		au.setState(Pending.instance);
		assertEquals("OK", au.setStartD(seller, 12));
		assertEquals(12, au.getStartDate());
	}

	/*
	 * test avec Cancelled.setStartDate
	 */
	public void testSetStartDCancelled() {
		au.setState(Cancelled.instance);
		assertEquals("ERROR: auction cancelled", au.setStartD(seller, 10));
	}

	/*
	 * test avec Closed.setStartDate
	 */
	public void testSetStartDClosed() {
		au.setState(Closed.instance);
		assertEquals("ERROR: auction closed", au.setStartD(seller, 10));
	}

	/*
	 * test avec Open.setStartDate
	 */
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
		assertEquals("Auction 1" + " " + "Description de l'auction" + " "
				+ "PENDING" + " " + 30, au.toString());
	}

}
