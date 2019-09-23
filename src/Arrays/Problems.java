package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Problems {

	/**
	 * Print a given array to the console
	 * @param arr
	 */
	void printArray(int[] arr) {
		for(int val: arr)
			System.out.print(val + " ");
		
		System.out.println();
	}
	
	/**
	 * 
	 * Time complexity : O(n * d)
	 * Auxiliary Space : O(1)
	 * @param arr
	 * @param unit
	 * @return
	 */
	public int[] leftRotate(int[] arr, int unit) {
		
		for(int i = 1; i <= unit; i++) {
			arr = leftRotatebyOne(arr, arr.length); 
		}
		
		return arr;
	}

	/**
	 * This method rotate an array by one
	 * The idea that I used here is to check the edge cases first
	 * and then change values at the middle of the array by
	 * saving the next value to be override.
	 * 
	 * 
	 * @param arr - array with values
	 * @param d - size of the array
	 * @return - the array rotated by one
	 */
	public int[] leftRotatebyOne(int[] arr, int d) {
	
		int next = 0, saved = 0;
		for(int i = d-1; i >= 0; i--) {
			if(i == d - 1) {
				saved = arr[i-1];
				arr[i-1] = arr[i];
			}
			else if(i == 0) {
				arr[d - 1] = next;
			}
			else {
				next = arr[i-1];
				arr[i-1] = saved;
				saved = next;
			}
		}
		
		return arr;
	}

	/**
	 * Consider an array of distinct numbers sorted in increasing order. 
	 * The array has been rotated (clockwise) k number of times. 
	 * Given such an array, find the value of k.
	 * 
	 * The idea here is to find the position of the
	 * maximum element of the array, but when the max
	 * is at the last position should return 0 because
	 * the array didn't rotate or rotated the number of 
	 * times that equal to the number of elements that 
	 * the array has. [This solution was easy to find - in less than one minute]
	 * 
	 * Time complexity : O(n)
	 * Auxiliary Space : O(1)
	 * 
	 * @param arr
	 * @return
	 */
	int countRotations(int[] arr) {
		int pos = 0;
		int max = arr[0];
		
		for(int i=1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				pos = i;
			}
		}
		
		if(max == arr[arr.length - 1]) 
			return 0;
		
		return pos+1;
	}
	
	/**
	 * This problem asks to find the first number that has 
	 * a duplicated on a unsorted array.
	 * 
	 * The first solution would be to compare all the 
	 * elements against each other, and this will make the 
	 * runtime O(nˆ2)
	 * 
	 * The above solution witch is the second solution
	 * sort the array and loop until the before last element
	 * and compare the current position with its right neighbor
	 * and the runtime here is O(nlog n)
	 * 
	 * In third solution we can achieve a running time of 
	 * O(n) but take additional space using a hashset
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int countDuplicate(int[] arr, int n) {
		
		/**
		 * sort the array
		 */
		Arrays.sort(arr);
		int number = 0;
		
		for(int i = 0; i < n - 1; i++) {
		
			if(arr[i] == arr[i + 1]) {
				number = arr[i];
				break;
			}
		}
		
		return number;
	}
	
	/**
	 * Given an array of integers, return indices of the two 
	 * numbers such that they add up to a specific target.
	 * 
	 * 1 - SOLUTION
	 *  would be to compare all elements against each other
	 *  until we find the two values. Runtime O(n^2)
	 *  
	 * 2- SOLUTION 
	 * Sort the array
	 * use two pointer one at the beginning and 
	 * the other at the end of the array
	 * and then move up when value is smaller than 
	 * the target and move down when the value is greater
	 * than the target until the two pointers cross
	 * 
	 * 3 - SOLUTION 3
	 * Using hashmap
	 * 
	 * Third Solution above
	 */
	public int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		HashMap<Integer, Integer> complements = new HashMap<Integer, Integer>();
		
		for(int i=0; i < nums.length; i++) {
			if(complements.containsKey(nums[i])) {
				result[0] = complements.get(nums[i]);
				result[1] = i;
				
				break;
			}
			else {
				/*
				 * add the complement as a key to the value index
				 * to be retrieved as map.containsKey if necessary
				 */
				complements.put(target - nums[i], i);
			}
		}
		
		return result;
	}
	
	/**
	 * PROBLEM: Check if a string is a palindrome or not
	 * 
	 * I got to this solution, after analyzing what happens
	 * from the left and the right of the string. All the 
	 * items are equals, until we reach the middle of the string
	 * 
	 * running time is O(len(s)) = O(n)
	 */
	public static boolean isPalindrome(String s) {
		
		if(s.length() % 2 == 0)
			return false;
		
		int low = 0;
		int high = s.length() - 1;
		boolean result = true;
		
		while(low != high) {
			if(s.charAt(low) != s.charAt(high)) {
				result = false;
				break;
			}
				
			low++;
			high--;
		}
		
		return result;
	}
	
	/**
	 * PROBLEM: Left rotate the characters of a string 
	 * based on a given value.
	 * 
	 * SOLUTION: O(n*m)
	 */
	public static String leftRotateString(String s, int m) {
		char[] charsFromS = s.toCharArray();
		
		for(int j = 1; j <= m; j ++) {
			char fchar = charsFromS[0];
			for(int i=0; i < s.length()-1; i++) {
				charsFromS[i] = charsFromS[i + 1];
			}
			charsFromS[s.length() - 1] = fchar;
		}
		
		return String.valueOf(charsFromS);
	}
	
	/**
	 * This method right rotate a string 
	 * based on a given value
	 * 
	 * @param s
	 * @return
	 */
	public static String rightRotateString(String s, int m) {
		char[] charsFromS = s.toCharArray();
		
		for(int j = 1; j <= m; j ++) {
			
			char current = charsFromS[0]; 
			char saved = 0;
			for(int i=0; i < s.length()-1; i++) {
				saved = charsFromS[i + 1];
				
				charsFromS[i + 1] = current;
				current = saved;
			}
			charsFromS[0] = saved;
		}
		
		return String.valueOf(charsFromS);
	}
	
	/**
	 * Check how many times a palindrome string
	 * was left rotated
	 * 
	 * Assuming that the string passed is always palindrome
	 * and left rotated
	 */
	public int timesPalindromeRotated(String s) {
		int counter = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(isPalindrome(s)) 
				break;
			else {
				s = rightRotateString(s, 1);
				counter++;
			}
		}
		
		return counter;
	}
}
