package arrays;

/**
 * 
 * @author vbspace
 * 
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1:
 * 		Input: nums = [1,1,0,1,1,1]
 *		Output: 3
 *
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *		Input: nums = [1,0,1,1,0,1]
 *		Output: 2
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
		System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxOnes = 0;
        
        for(int entry : nums) {
            if(entry == 1) counter++;
            
            if(entry == 0) {
                if(counter > maxOnes) maxOnes = counter;
                counter = 0;
            }
        }
        
        if(counter > maxOnes) return counter;
        return maxOnes;
    }

}
