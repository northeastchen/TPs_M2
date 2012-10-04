package auction.states;

import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.Person;
import auction.ReserveAuction;
import auction.User;
import auction.impl.UserImpl;

public class Closed implements AuctionState {

	public static final Closed instance = new Closed();

	 
	public String cancelAuction(Auction auction, Person person) {
		return "ERROR: auction closed";
	}

	 
	public void close(Auction auction) {
		throw new Error("Cannot close a closed auction.");
	}

	/*
	 * Modification du code : ajout d'un contr�le sur getMaxBid() au cas o� retourne null
	 * @see auction.AuctionState#getCurrentBid(auction.Auction)
	 */
	public String getCurrentBid(Auction auction) {
//		Bid b = auction.getMaxBid();
//		return b.toString();
		
		Bid b = auction.getMaxBid();
		if (b!=null)
			return b.toString();
		else
			return "ERROR: no current bid";
	}

	 
	public String getName() {
		return "CLOSED";
	}

	 
	public String join(Auction auction, User user) {
		return "ERROR: auction closed";
	}

	 
	public String leave(Auction auction, User user) {
		return "ERROR: auction closed";
	}

	 
	public void open(Auction auction) {
		throw new Error("Cannot close a closed auction.");
	}

	 
	public String placeBid(Auction auction, UserImpl user, int amount) {
		return "ERROR: auction closed";
	}

	 
	public String postMessage(Auction auction, Person person, String message){
		return "ERROR: auction closed";
	}

	 
	public String setDesc(Auction auction, Person person, String value) {
		return "ERROR: auction closed";
	}

	 
	public String setEndDate(Auction auction, Person person, int value) {
		return "ERROR: auction closed";
	}

	 
	public String setMinBid(Auction auction, Person person, int value) {
		return "ERROR: auction closed";
	}

	 
	public String setResPrice(ReserveAuction auction, Person person, int value) {
		return "ERROR: auction closed";
	}

	 
	public String setStartDate(Auction auction, Person person, int value) {
		return "ERROR: auction closed";
	}

}
