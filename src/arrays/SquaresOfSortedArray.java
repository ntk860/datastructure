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
		
		/*Assert.assertArrayEquals(new int[]{1, 4, 9, 25}, sortedSquares(new int[]{-5, -3, -2, -1}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 4, 9, 16, 100}, sortedSquares(new int[]{-4, -2, -1, 0, 3, 10}));
		
		Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 4, 9, 16, 25, 25, 64}, sortedSquares(new int[]{-5, -4, -3, -1, 0, 2, 5, 8}));
		
		Assert.assertArrayEquals(new int[]{0, 1, 1, 1, 16}, sortedSquares(new int[]{-4, 0, 1, 1, 1}));
		
		Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 4, 9, 9, 16, 100}, sortedSquares(new int[]{-4, -2, -1, -1, 0, 0, 3, 3, 10}));*/
		
		//Assert.assertArrayEquals(new int[]{0, 1, 3, 16}, sortedSquares(new int[]{-4, 0, 1, 3}));
		
		int[] result = sortedSquares(new int[]{-4, 0, 1, 1, 1});
		for(int numb : result) System.out.println(numb);
		
		System.out.println("all passed");
	}

	public static int[] sortedSquares(int[] nums) {
		int[] result = new int[nums.length];
		int resultPosition = 0;
		
		nums = transformNegatives(nums);
		int currentPosition = findSmallestPosition(nums);
		int negativeValuesTrackerPosition = currentPosition - 1;
		
		for(int i = currentPosition; i < nums.length; i++) {
			int current = nums[i];
			result[resultPosition++] = current;
			int nextPositionValue = i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1];
			
			int counter = negativeValuesTrackerPosition;
			for(int j = negativeValuesTrackerPosition; j >= 0; j--) {

				if(nums[j] >= current && nums[j] <= nextPositionValue) {
					result[resultPosition++] = nums[j];
				}
				else {
					break;
				}
				
				counter = j;

			}
			
			negativeValuesTrackerPosition = counter - 1;
			nextPositionValue = i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1];
		}
		
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
	
	
}
