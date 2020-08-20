package Week1;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] arr1 = {2, 3, -2, 4};

		System.out.println("Max sub array " + maxSubArray(arr));
		System.out.println("Max prod array " + maxProduct(arr1));
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
					
					if(tsum > maxSum) {
						maxSum = tsum;
					}
					
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
	
	public static int maxProduct(int[] nums) {
        
		int result = 0;
		
		int tmpProd = nums[0];
		for(int i = 1; i < nums.length; i++) {
			
			tmpProd *= nums[i];
			if(tmpProd > 0) {
				int tindex = i;
				int tprod = tmpProd;
				
				while(true) {
					if(tmpProd <= 0 || tindex == nums.length - 1) 
						break;
					
					if(tprod > result) {
						result = tprod;
					}
					
					tindex++;
					tprod *= nums[tindex]; 
				}
			}
			else {
				tmpProd = nums[i];
			}
		}
		
		return result;
    }
}
