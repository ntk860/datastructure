package arrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProblemsTest {

	Problems demo = new Problems();
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	/**
	@Test
	void rotateLeft() {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		
		System.out.println("ProblemsTest.rotateLeft()");
		demo.leftRotate(arr, 2);
		demo.printArray(arr);
	}

	@Test
	void countRotations() {
		System.out.println("ProblemsTest.countRotations()");
		
		int[] arr = new int[]{7, 9, 11, 12, 15};
		System.out.println(demo.countRotations(arr));
		
	}
	
	@Test
	void countDuplicate() {
		System.out.println("ProblemsTest.countDuplicate()");
		
		int[] arr = new int[]{3, 2, 1, 2, 4, 1, 3};
		System.out.println(demo.countDuplicate(arr, 7)); 
	}
	
	@Test
	void twoSum() {
		System.out.println("ProblemsTest.twoSum()");
		int[] arr = {2, 15, 11, 7};
		int[] result = demo.twoSum(arr, 9);
		
		demo.printArray(result);
	}
	
	@Test
	void isPalindrome() {
		System.out.println("ProblemsTest.isPalindrome(\"AA\")");
		System.out.println(Problems.isPalindrome("AA"));
	}
	
	@Test
	void leftRotateString() {
		System.out.println("ProblemsTest.leftRotateString(\"ABCBA\", 4)");
		System.out.println(Problems.leftRotateString("ABCBA", 4));
	}
	
	@Test
	void rightRotateString() {
		System.out.println("ProblemsTest.rightRotateString(\"AABCB\", 4)");
		System.out.println(Problems.rightRotateString("AABCB", 4));
	}
	
	@Test
	void timesPalindromeRotated() {
		System.out.println("ProblemsTest.timesPalindromeRotated(\"AABCB\")");
		System.out.println(demo.timesPalindromeRotated("AABCB"));
	}
	
	@Test
	void longestPalindrome() {
		System.out.println("ProblemsTest.longestPalindrome(\"AAAAVAAAV\")");
		System.out.println(demo.longestPalindrome("AAAAVAAAV"));
	}
	
	@Test
	void lengthOfLongestSubstring() {
		System.out.println("ProblemsTest.lengthOfLongestSubstring()");
		//abcdefaaaaagghdmnbvcxd
		System.out.println(demo.lengthOfLongestSubstring("aabvbccddddddplkompfnsef"));
	}
	
	*/
	
	@Test
	void isIsomorphic() {
		System.out.println("ProblemsTest.isIsomorphic()");
		System.out.println(demo.isIsomorphic("aab", "aaa"));
	}
	
	@Test
	void findNthDigit() {
		System.out.println("ProblemsTest.findNthDigit()");
		System.out.println(demo.findNthDigit(20));
	}
	
	@Test
	void partition() {
		System.out.println("ProblemsTest.partition()");
		System.out.println(demo.partition("aab"));
	}
	
	@Test
	void wordBreak() {
		System.out.println("ProblemsTest.wordBreak()");
		
		String word = "andcat";
		List<String> wordDict = new LinkedList<>();
		
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		
		System.out.println(demo.wordBreak(word, wordDict));
		
	}
	
	@Test
	void KadaneCircular() {
		int[] arr = new int[] {2, 1, -5, 4, -3, 1, -3 , 4, -1};
		System.out.println("ProblemsTest.KadaneCircular()");
		System.out.println(demo.KadaneCircular(arr, 9));
	}
	
	@Test
	void frequencyGame() {
		int[] arr = new int[] {7, 3, 15, 2, 15, 3, 8, 5, 2, 3, 30, 2, 4, 30, 15, 30};
		System.out.println("ProblemsTest.frequencyGame()");
		
		System.out.println(demo.frequencyGame(arr, 16));
	}
	
	@Test
	void countStringsUnderConditions() {
		System.out.println("ProblemsTest.countStringsUnderConditions()");
		System.out.println(demo.countStringsUnderConditions(3));
	}
	
	@Test
	void decodeString() {
		System.out.println("ProblemsTest.decodeString()");
		System.out.println(demo.decodeString("2[abc]3[cd]ef"));
		//System.out.println(demo.decodeString("3[a]2[bc]"));
		//System.out.println(demo.decodeString("3[a2[c]]"));
	}

}
