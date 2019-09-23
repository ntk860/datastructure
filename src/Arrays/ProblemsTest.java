package Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
	}*/
	
	@Test
	void isPalindrome() {
		System.out.println("ProblemsTest.isPalindrome()");
		System.out.println(Problems.isPalindrome("ABCBA"));
	}
	
	@Test
	void leftRotateString() {
		System.out.println("ProblemsTest.leftRotateString()");
		System.out.println(Problems.leftRotateString("ABCBA", 4));
	}
	
	@Test
	void rightRotateString() {
		System.out.println("ProblemsTest.rightRotateString()");
		System.out.println(Problems.rightRotateString("AABCB", 4));
	}
	
	@Test
	void timesPalindromeRotated() {
		System.out.println("ProblemsTest.timesPalindromeRotated()");
		System.out.println(demo.timesPalindromeRotated("AABCB"));
	}

}
