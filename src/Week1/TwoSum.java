package Week1;

/**
 * 
 * @author vbtapper
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 *	You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 *   return [0, 1].
 *   
 *  The best way to approach this kind of problem 
 *  is to find a formula to help with a solution 
 *  that only takes O(n)
 *  
 *  The formula on this case is to subtract the target
 *  to elements and see if there is a number that equals
 *  the result of the subtraction
 *  
 *  The first solution would be to compare 
 *  all the elements but this solution is going
 *  to be O(n^2)
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		
		int arr[] = findSum(nums, target);
		
		System.out.println(arr[0] + " " + arr[1]);
		
	}
	
	public static int[] findSum(int arr[], int target) {
		
		int element = arr[0];
		int fposition = 0;
	
		int result[] = new int[2];
		
		for(int i = 1; i < arr.length; i++) {
			if(target - element == arr[i]) {
				result[0] = fposition;
				result[1] = i;
			}
			
			fposition = i;
		}
		
		return result;
	}
	

}
