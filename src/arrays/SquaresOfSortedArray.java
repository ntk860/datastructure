package arrays;

import java.util.Stack;

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
		int[] result = sortedSquares(new int[]{-7,-3,2,3,11});
		
		for(int numb : result) System.out.println(numb);

	}

	public static int[] sortedSquares(int[] nums) {
		int currentPosition = 0;
        int[] result = new int[nums.length];
        
        // transform the negatives into positives
        int[] transformedArr = transformNegatives(nums);
        
        // add smallest
        result[currentPosition++] = transformedArr[findSmallestPosition(transformedArr)];
        
        //add all small from the left of smallest compared with the pivot
        int pivotPosition = findSmallestPosition(transformedArr) == findPivotPosition(transformedArr, findSmallestPosition(transformedArr)) ? findSmallestPosition(transformedArr) : findPivotPosition(transformedArr, findSmallestPosition(transformedArr));
        
        Stack<Integer> smallestFromLeft = findSmallestFromPivot(transformedArr, pivotPosition, findSmallestPosition(transformedArr));
        
        while(!smallestFromLeft.isEmpty()) {
        	result[currentPosition++] = smallestFromLeft.pop();
        }
        
        // add the pivot if its position is different compared to the position of the smallest
        if(findSmallestPosition(transformedArr) != findPivotPosition(transformedArr, findSmallestPosition(transformedArr))) result[currentPosition++] = transformedArr[pivotPosition];
        
        //add all bigger from the left of the smallest compared with the pivot
        Stack<Integer> biggerFromTheLeft = findBiggestFromPivot(transformedArr, pivotPosition, findSmallestPosition(transformedArr));
        while(!biggerFromTheLeft.isEmpty()) {
        	result[currentPosition++] = biggerFromTheLeft.pop();
        }
        
        //add all from the right of the pivot
        for(int i = pivotPosition + 1; i < transformedArr.length; i++) result[currentPosition++] = transformedArr[i];
        
        // calculate the square
        for(int i = 0; i < result.length; i++) result[i] = result[i] * result[i];
        
        return result;
        
    }
	
	public static int[] transformNegatives(int[] nums) {
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0) result[i] = (-1) * nums[i];
			else result[i] = nums[i];
		}
		
		return result;
	}
	
	public static int findSmallestPosition(int[] nums) {
		int smallestPosition = 0;
		int smallest = nums[0];
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < smallest) {
				smallestPosition = i;
				smallest = nums[i];
			}
		}
		
		return smallestPosition;
	}
	
	/**
	 * Find the pivot position, which is the first number
	 * on the right of the smallest.
	 * 
	 * @param nums
	 * @param smallestPosition
	 */
	public static int findPivotPosition(int[] nums, int smallestPosition) {
		if(nums.length == 1) return 0;
		if(smallestPosition + 1 == nums.length) return smallestPosition;
		
		return smallestPosition + 1;
	}
	
	/**
	 * 
	 * @param nums
	 * @param smallestPosition
	 * @return
	 */
	public static Stack<Integer> findSmallestFromPivot(int[] nums, int pivotPosition, int smallestPosition) {
		Stack<Integer> result = new Stack<Integer>();
		
		for(int i = smallestPosition - 1; i >= 0; i--) {
			if(nums[i] <= nums[pivotPosition]) result.push(nums[i]);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param nums
	 * @param pivotPostion
	 * @return
	 */
	public static Stack<Integer> findBiggestFromPivot(int[] nums, int pivotPosition, int smallestPosition) {
		Stack<Integer> result = new Stack<Integer>();
		
		for(int i = smallestPosition - 1; i >= 0; i--) {
			if(nums[i] > nums[pivotPosition]) result.push(nums[i]);
		}
		
		return result;
	}
	
}
