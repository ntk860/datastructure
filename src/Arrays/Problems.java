package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
	 * Third Solution below
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
		
		int low = 0;
		int high = s.length() - 1;
		boolean result = true;
		
		while(low <= high) {
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
	 * 
	 * O(n^2)
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
	
	/**
	 * Calculate the length of the largest palindrome 
	 * substring of a given string.
	 */
	public int longestPalindrome(String s) {
		
		int low = 0;
		int max = 0;
		
		while(low <= s.length()) {
			int high = s.length();
			while(high >= low) {
				String subStr = s.substring(low, high);
				if(subStr.length() > 2) {
					if(isPalindrome(subStr)) {		
						max = Math.max(subStr.length(), max);
					}
				}
				high--;
			}
			low++;
		}
		
		return max;
	}
	
	/**
	 * Working on better solution 
	 * Its solved on leetcode with runtime of nˆ2
	 * this version is being improved
	 * @param s
	 * @return
	 */
	public String lengthOfLongestSubstring(String s) {
     
		if(s.length() == 0) 
			return null;
		
		char[] sequences = s.toCharArray();
        HashSet<String> tmpSet = new HashSet<>();
        
        int i = 1;
        tmpSet.add(Character.toString(sequences[0]));
        String tmpStr = Character.toString(sequences[0]);
        
        String maxStr = null;
        int maxVal = 1;
        while(i <= s.length() - 1) {
        
            if(tmpSet.contains(Character.toString(sequences[i])) || i == s.length() - 1) {
            	if(i == s.length() - 1) {
            		if(!tmpSet.contains(Character.toString(sequences[i]))) {
            			tmpStr = tmpStr.concat(Character.toString(sequences[i]));
        			}
        		}
            	
        		maxVal = Math.max(tmpStr.length(), maxVal);
        		maxStr = tmpStr;
        		System.out.println(tmpSet);
        		
        		tmpSet.clear();
        		tmpStr = "";
                
            } else {
                tmpSet.add(Character.toString(sequences[i]));
                tmpStr = tmpStr.concat(Character.toString(sequences[i]));
            }
        	
            i++;
            
        }

        System.out.println(maxVal);
        return maxStr;
    
    }
	
	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * Since the array is sorted we only need to the value from one of the sides 
	 * of the array having the middle as pivot. We start from left to right and
	 * search until 
	 *  
	 */
	public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        int result = -1;
        while(low <= high) {
            if(target == nums[low])
                result = low;
            else if (target == nums[high])
                result = high;
            
            low++;
            high--;
        } 
        
        return result;
    }
	
	/**
	 * 
	 */
	public String decodeString(String s) {
        String result = "";
        
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> helperStack = new Stack<>();
        
        // fill the main stack
        for(char c : s.toCharArray()) {
        	mainStack.push(c);
        }
        
        while(!mainStack.isEmpty()) {
        	char val = mainStack.pop();
        	
        	if(val != '[') 
        		helperStack.push(val);
        	else {
        		
        		int n = Character.getNumericValue(mainStack.pop());
        		char tmpChar = helperStack.pop();
        		String tmpStr = "";
        		tmpStr += tmpChar;
        	
        		while(tmpChar != ']') {
        			tmpChar = helperStack.pop();	
        			if(tmpChar != ']')
        				tmpStr += tmpChar;
        		}
        		
        		for(int i=1; i <= n; i++) {
        			result = result + tmpStr;
        		}
        	
        	}
        }
        
        System.out.println(helperStack);
        return result;
    }
	
	/**
	 * Given two strings s and t, determine if they are isomorphic.
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while 
     * preserving the order of characters. No two characters may map to the same 
     * character but a character may map to itself.
     * 
     * O(n*m) - n is the length of s and m is the length of t
     * Auxiliar space O(n*m)
	 */
	public boolean isIsomorphic(String s, String t) {
        boolean result = true;
        
        //representing characters from s
        char[] A = s.toCharArray();
        
        // helper set for s
        HashSet<Character> helperA = new HashSet<>();
        
        //representing characters from t
        char[] B = t.toCharArray();
        
        //helper set for t
        HashSet<Character> helperB = new HashSet<>();
        
        int countA = 1;
        helperA.add(A[0]);
        
        for(int i = 1; i <= s.length() - 1; i++) {
        	if(!helperA.contains(A[i]) || i == s.length()-1) {
        		if(i == s.length() - 1 && helperA.contains(A[i])) {
        			countA++;
            	}
        		
        		int countB = 1;
        		helperB.add(B[i-1]);
        		
        		for(int j = i; j <= t.length() - 1; j++) {
        			if(!helperB.contains(B[j])) {
        				break;
        			}
        			else {
        				countB++;
        			}	
        		}
        		
        		if(countA != countB) {
    				result = false;
    				break;
    			}
    			else {
    			
        			helperA.clear();
        			helperB.clear();
        			
        			helperA.add(A[i]);
        			countA = 1;
    			}
        	}
        	else {
        		countA++;
        	}
        }
        
        return result;
    }
	
	public int findNthDigit(int n) {
		
		if(n == 0)
			return 0;
	
		String tmp = "";
        int i;
        for(i=1; i <= n; i++) {
            tmp = tmp.concat(String.valueOf(i));
        }
        
        System.out.println(tmp);
        
        return Integer.valueOf(tmp.substring(n-1, i - 1));
	}
	
	/**
	 * Given a string s, partition s such that every 
	 * substring of the partition is a palindrome.
	 *
	 * Return all possible palindrome partitioning of s.
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		
		List<List<String>> result = new LinkedList<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			int j = i + 1;
			
			List<String> tmpList = new LinkedList<>();
			while(isPalindrome(s.substring(i, j))) {
				
				tmpList.add(s.substring(i, j));
				j++;
				
				if(j >= n)
					break;
			}
			
			if(tmpList.size() > 0)
				result.add(tmpList);
		}
		
		return result;
        
    }
	
	/**
	 * Given a non-empty string s and a dictionary wordDict containing 
	 * a list of non-empty words, determine if s can be segmented into 
	 * a space-separated sequence of one or more dictionary words.

	 * Note:
	 * The same word in the dictionary may be reused multiple times 
	 * in the segmentation. You may assume the dictionary does not 
	 * contain duplicate words.
	 * 
	 * O(sizeOf(wordDict)^2 + length(s))
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean result = false;
        
        for(int i = 0; i <= wordDict.size() - 1; i++) {
        	for(int j = i + 1; j <= wordDict.size() - 1; j++) {
        		
        		int lengthSubstr = wordDict.get(i).length() + wordDict.get(j).length();
            	int subIndex = 0;
            	
            	while(lengthSubstr <= s.length()) {
            		
            		String subStr = s.substring(subIndex, lengthSubstr);
            		if(wordDict.get(i).concat(wordDict.get(j)).compareTo(subStr) == 0) {
            			System.out.println(subStr);
                		
            			result = true;
            			break;
            		}

            		subIndex = lengthSubstr;
            		lengthSubstr += lengthSubstr; 
            		
            	}
        	}
        	
        	if(result)
        		break;
        }
        
        return result;
    }
}
