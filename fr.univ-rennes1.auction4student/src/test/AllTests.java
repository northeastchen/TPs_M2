package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AccountImplTest.class);
		suite.addTestSuite(AuctionFactoryTest.class);
		suite.addTestSuite(AuctionImplTest.class);
		suite.addTestSuite(BidImplTest.class);
		suite.addTestSuite(BulletinBoardImplTest.class);
		suite.addTestSuite(MessageImplTest.class);
		suite.addTestSuite(ModeratorImplTest.class);
		suite.addTestSuite(ReserveAuctionImplTest.class);
		suite.addTestSuite(UserImplTest.class);
		//$JUnit-END$
		return suite;
	}

}
