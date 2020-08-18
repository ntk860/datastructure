package Week1;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArray(int[] nums) {
        
		int maxSum = 0;
		int tmpSum = nums[0];
		
		for(int i = 1; i <= nums.length - 1; i++) {
			
			tmpSum += nums[i];
			
			if(tmpSum > 0) {
				int tsum = tmpSum;
				int tindex = i;
				while(true) {
					
					if(tsum <= 0 || tindex == nums.length - 1)
						break;
					
					if(tsum > maxSum)
						maxSum = tsum;
					
					tindex++;
					tsum += nums[tindex];	
				}
				
				tmpSum = nums[i];
			}
			else {
				tmpSum = nums[i];
			}
		}
		
		return maxSum;
    }
}
