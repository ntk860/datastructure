package arrays;

import java.util.Stack;
import org.junit.Assert;
/**
 * 
 * @author vbspace
 * 
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4, -2 ,-1,0 , 3, 10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 */
public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Assert.assertArrayEquals(new int[]{1, 4, 9, 25}, sortedSquares(new int[]{-5, -3, -2, -1}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 4, 9, 16, 100}, sortedSquares(new int[]{-4, -2, -1, 0, 3, 10}));
		
		Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 4, 9, 16, 25, 25, 64}, sortedSquares(new int[]{-5, -4, -3, -1, 0, 2, 5, 8}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 1, 1, 16}, sortedSquares(new int[]{-4, 0, 1, 1, 1}));
		
		Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 4, 9, 9, 16, 100}, sortedSquares(new int[]{-4, -2, -1, -1, 0, 0, 3, 3, 10}));
		
		//Assert.assertArrayEquals(new int[]{0, 1, 3, 16}, sortedSquares(new int[]{-4, 0, 1, 3}));
		
		System.out.println("all passed");
	}

	public static int[] sortedSquares(int[] nums) {
		int currentPosition = 0;
        int[] result = new int[nums.length];
        
        // transform the negatives into positives
        int[] transformedArr = transformNegatives(nums);
        
        // add the smallest
        result[currentPosition++] = transformedArr[findSmallestPosition(transformedArr)];
        
        //add all small from the left of smallest compared with the pivot
        int pivotPosition = findPivotPosition(transformedArr, findSmallestPosition(transformedArr));
        
        Stack<Integer> smallestFromLeft = findSmallestFromPivot(transformedArr, pivotPosition, findSmallestPosition(transformedArr));
        
        while(!smallestFromLeft.isEmpty()) {
        	int val = smallestFromLeft.pop();
        	result[currentPosition++] = val;
        }
        
        
        // add the pivot if its position is different compared to the position of the smallest
        // loop over in case the numbers are equal after the smallest
        int pivotSmallestDistance = findPivotPosition(transformedArr, findSmallestPosition(transformedArr)) - findSmallestPosition(transformedArr);
        if(pivotSmallestDistance > 1) {
        	int i = findSmallestPosition(transformedArr) + 1;
        	while(i <= pivotPosition) result[currentPosition++] = transformedArr[i++];
        	
        }
        else if(pivotSmallestDistance == 1) {
        	result[currentPosition++] = transformedArr[pivotPosition];
        }
        
        
        //add all bigger from the left of the smallest compared with the pivot
        Stack<Integer> biggerFromTheLeft = findBiggestFromPivot(transformedArr, pivotPosition, findSmallestPosition(transformedArr));
        while(!biggerFromTheLeft.isEmpty()) {
        	int val = biggerFromTheLeft.pop();
        	result[currentPosition++] = val;
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
			if(nums[i] <= smallest) {
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
		
		int result = smallestPosition + 1;
		while(nums.length != result + 1) {
			if(nums[result] != nums[result + 1]) break;
			result++;
		}	
		
		return result;
	}
	
	/**
	 * 
	 * @param nums
	 * @param smallestPosition
	 * @return
	 */
	public static Stack<Integer> findSmallestFromPivot(int[] nums, int pivotPosition, int smallestPosition) {
		Stack<Integer> result = new Stack<Integer>();
		
		for(int i = 0; i <= smallestPosition - 1; i++) {
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
		
		for(int i = 0; i <= smallestPosition - 1; i++) {
			if(nums[i] > nums[pivotPosition]) {
				result.push(nums[i]);
			}
		}
		
		return result;
	}
	
}
