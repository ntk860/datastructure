package Week1;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;

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
		
		System.out.println(isAnagramV2(s, t));
		//System.out.println(isAnagram(s, t));

	}

	public static boolean isAnagram(String s, String t) {
        boolean result = true;
        
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        
        for(int i = 0; i < s.length(); i++) {
        	if(arrS[i] != arrT[i]) {
        		result = false;
        		break;
        	}
        }
        
        return result;
    }
	
	private static Hashtable<Character, Integer> fillMap(Hashtable<Character, Integer> cmap, char c) {
		if(cmap.containsKey(c)) {
			int counter = cmap.get(c);
			
			counter++;
			cmap.put(c, counter);
		}
		else {
			cmap.put(c, 1);
		}
		
		return cmap;
	}
	
	public static boolean isAnagramV2(String s, String t) {
		boolean result = true;
		
		Hashtable<Character, Integer> helperTableS = new Hashtable<Character, Integer>();
		Hashtable<Character, Integer> helperTableT = new Hashtable<Character, Integer>();
		
		// assuming len(s) == len(t)
		for(int i = 0; i < s.length(); i++) {
			
			fillMap(helperTableS, s.charAt(i));
			fillMap(helperTableT, t.charAt(i));
			
		}
		
		for(Entry<Character, Integer> letterCounter : helperTableS.entrySet()) {
			if(helperTableT.containsKey(letterCounter.getKey())) {
				int counterT = helperTableT.get(letterCounter.getKey());
			
				if(counterT != letterCounter.getValue()) {
					result = false;
					break;
				}
			}
			else {
				result = false;
				break;
			}
		}
		
		return result;
	}
}
