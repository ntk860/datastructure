package Week1;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author vbtapper
 *
 *	https://leetcode.com/problems/contains-duplicate/
 *
 *	Given an array of integers, find if the array contains any duplicates.
 *
 *	Your function should return true if any value appears at least 
 *  twice in the array, and it should return false if every element is distinct.
 *  
 *  Solutions
 *  
 *  Version 1
 *  	Version basically compare all values with each
 *  	other and it going to cost O(n^2) but space of O(1)
 *  
 *  Version 2
 *  	We can store the numbers that we already saw
 *  	if we find them again it is because its a duplicate
 *  	its going to take O(n) and space of O(n)
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1};
		boolean r = containsDuplicate(nums);
		
		System.out.println(r);
		

	}
	
	public static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        Set<Integer> duplicates = new HashSet<Integer>(); 
        
        for(int i=0; i < nums.length; i++) {
        	if(!duplicates.contains(nums[i])) {
        		duplicates.add(nums[i]);
        	}
        	else {
        		result = true;
        		break;
        	}
        }
        
        return result;
    }

}
