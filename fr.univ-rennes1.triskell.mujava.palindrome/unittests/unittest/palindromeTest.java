/**
 * 
 */
package unittest;

import palindrome.palindrome;
import junit.framework.TestCase;

/**
 * @author ben
 *
 */
public class palindromeTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome1() {
		boolean result = false;
		result = palindrome.isPalindrome("toto");
		assertFalse(result);
	}

	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome2() {
		boolean result = false;
		result = palindrome.isPalindrome("tt");
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome3() {
		boolean result = false;
		result = palindrome.isPalindrome("tot");
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome4() {
		boolean result = false;
		result = palindrome.isPalindrome("kayak");
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome5() {
		boolean result = false;
		result = palindrome.isPalindrome("kayybk");
		assertFalse(result);
	}
	
	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome6() {
		boolean result = false;
		result = palindrome.isPalindrome("rayyak");
		assertFalse(result);
	}
	
	/**
	 * Test method for {@link palindrome.palindrome#isPalindrome(java.lang.String)}.
	 */
	public void testIsPalindrome7() {
		boolean result = false;
		result = palindrome.isPalindrome("to");
		assertFalse(result);
	}
	
	
}
