package palindrome;
	
public class palindrome {	
	public static boolean isPalindrome(String s){
		int l = s.length();
		for(int i=0 ; i<l/2 ;i++){
			if(s.charAt(i)!=s.charAt(l-i-1)){
				return false;
			}
		}
		return true;
	}
}