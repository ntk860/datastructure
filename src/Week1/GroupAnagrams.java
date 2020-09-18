package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author vbtapper
 * 
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * 		["ate","eat","tea"],
 * 		["nat","tan"],
 * 		["bat"]
 * ]
 * 
 * Constrains n >= 2, m >= 1
 * n length of the main array
 * m length of the strings on the array of strings
 * 
 * Time : O(n^2 + log m + m^2) = O(n^2 + m^2)
 * Space: O(n)
 * 
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));

	}

	public static String sort(String str) {
	
		char [] cStr = str.toCharArray();
		Arrays.sort(cStr);
		
		return new String(cStr);
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        
		List<List<String>> result = new ArrayList<List<String>>();
		Set<String> helperSet = new HashSet<String>();
		
		for(int i = 0; i < strs.length; i++) {
			List<String> tmpR = new ArrayList<String>();
			
			if(!helperSet.contains(sort(strs[i]))) {
				tmpR.add(strs[i]);
				helperSet.add(sort(strs[i]));
				
				for(int j = i + 1; j < strs.length; j++) {
					if(sort(strs[i]).compareTo(sort(strs[j])) == 0) {
						tmpR.add(strs[j]);
					}
				}
				
				result.add(tmpR);
			}
		}
		
		return result;
    }
}
