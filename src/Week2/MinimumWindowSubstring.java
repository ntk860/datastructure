package Week2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author vbtapper
 *
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 *
 *	Example:
 *
 *	Input: S = "ADOBECODEBANC", T = "ABC"
 *	Output: "BANC"
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		System.out.println(minWindow(s, t));

	}
	
	public static String minWindow(String s, String t) {
        String result = "";
        
        Set<Character> charactersOfT = new HashSet<Character>();
        
        // copying all characters of t to a helper set
        for(int i = 0; i < t.length(); i++)
        	charactersOfT.add(t.charAt(i));
        
        int counter = 1;
        int mainCounter = 0;
        int startPosition = 0;
        for(int i = 0; i < s.length(); i++) {
        	
        	if(charactersOfT.contains(s.charAt(i))) {
        		mainCounter++;
        	}
        	
        	if(counter > t.length()) {
    			if(mainCounter == t.length()) {
    				// found window
    				result = s.substring(startPosition, i+1);
    				break;
    			}
    			else {
    				counter = 1;
    				mainCounter = 1;
    				startPosition = i;
    			}
    		}

        	counter++;        	
        }
        
        return result;
    }

}
