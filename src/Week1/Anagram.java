package Week1;

import java.util.Arrays;

/**
 * 
 * @author vbtapper
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *	Output: true
 *		Example 2:
 *
 *	Input: s = "rat", t = "car"
 *	Output: false
 */
public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s, t));

	}

	public static boolean isAnagram(String s, String t) {
        boolean result = true;
        
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        
        for(int i=0; i < s.length(); i++) {
        	if(arrS[i] != arrT[i]) {
        		result = false;
        		break;
        	}
        }
        
        return result;
    }
}
