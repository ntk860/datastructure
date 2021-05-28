package arrays;

/**
 * 
 * @author vbspace
 * 
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 */
public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        // add smallest
        
        //add all small from the left of smallest compared with the pivot
        
        // add the pivot
        
        //add all bigger from the left of the smallest compared with the pivot
        
        //add all from the right of the pivot
        
        return result;
    }
	
	public static int[] transformNegatives(int[] nums) {
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0) result[i] = (-1) * nums[i];
			else result[i] = nums[i];
		}
		
		return nums;
	}
	
	public static int findSmallestPosition(int[] nums) {
		int smallestPosition = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < smallestPosition) smallestPosition = i;
		}
		
		return smallestPosition;
	}
	
	/**
	 * Find the pivot, which is the first number
	 * on the right of the smallest.
	 * 
	 * What Happened if there is not pivot ?
	 * @param nums
	 * @param smallestPosition
	 */
	public static int findPivot(int[] nums, int smallestPosition) {
		if(nums.length == 1) return nums[0];
		if(smallestPosition + 1 == nums.length) return nums[smallestPosition];
		
		return nums[smallestPosition + 1];
	}
	
	/**
	 * 
	 * @param nums
	 * @param smallestPosition
	 * @return
	 */
	public static int[] findSmallestFromPivot(int[] nums, int smallestPosition) {
		return new int[]{};
	}
	
	/**
	 * 
	 * @param nums
	 * @param smallestPosition
	 * @return
	 */
	public static int[] findBiggestFromPivot(int[] nums, int smallestPosition) {
		return new int[]{};
	}
	
	/**
	 * 
	 * @param nums
	 * @param pivotPosition
	 * @return
	 */
	public static int[] getAllFromRightOfPivot(int nums[], int pivotPosition) {
		return new int[]{};
	}
	
}
