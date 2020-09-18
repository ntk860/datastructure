package Week2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringRepeatingCharacter {

	public static void main(String[] args) {
		String s = "abcxhcbba";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        
		int maxCounter = 0;
		
		Set<Character> helperCounter = new HashSet<Character>();
		Set<String> foundStrings = new HashSet<String>();
		
		
		helperCounter.add(s.charAt(0));
		int tmpCounter = 1;
		int startPosition = 0;
		
		for(int i = 1; i < s.length(); i++) {
			if(!helperCounter.contains(s.charAt(i))) {
				helperCounter.add(s.charAt(i));
				tmpCounter++;
			}
			else {
				if(!foundStrings.contains(s.substring(startPosition, i-1))) {
					foundStrings.add(s.substring(startPosition, i-1));
					
					if(tmpCounter > maxCounter) {
						maxCounter = tmpCounter;
					}
					
					helperCounter.clear();
					helperCounter.add(s.charAt(i));
					tmpCounter = 1;
				}
				
				startPosition = i;
			}
		}
		
		return maxCounter;
    }
}
