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
	 * 
	 */
	@Test
	void rotateLeft() {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		
		System.out.println("ProblemsTest.rotateLeft()");
		demo.leftRotate(arr, 2);
		demo.printArray(arr);
	}

	/**
	 * 
	 */
	@Test
	void countRotations() {
		System.out.println("ProblemsTest.countRotations()");
		
		int[] arr = new int[]{7, 9, 11, 12, 15};
		System.out.println(demo.countRotations(arr));
		
	}

}
