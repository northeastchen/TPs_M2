// This is mutant program.
// Author : ysma

package palindrome;


public class palindrome
{

    public static boolean isPalindrome( java.lang.String s )
    {
        int l = s.length();
        for (int i = 0; i < l++ / 2; i++) {
            if (s.charAt( i ) != s.charAt( l - i - 1 )) {
                return false;
            }
        }
        return true;
    }

}
