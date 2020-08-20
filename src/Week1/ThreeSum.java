package Week1;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 0, 1, 2, -1, -4};
		
		System.out.println(threeSum(nums));

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> helperList = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
        	int count = 1;
        	int sum = nums[i];
        	helperList.add(nums[i]);
        	
        	for(int k = i + 1; k < nums.length; k++) {
        		
        		sum += nums[k];
        		helperList.add(nums[k]);
        		
        		if(count == 2) {
        			
        			if(sum == 0) {

        				System.out.println(helperList);
         				result.add(helperList);
        			}
        			
        			count = 0;
        			sum = nums[i];
        			
        			helperList.clear();
        			helperList.add(nums[i]);
        		}
        		
        		count++;
        	}
        }
        
        return result;
    }

}
