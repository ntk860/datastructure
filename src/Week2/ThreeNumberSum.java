package Week2;

import java.util.*;

public class ThreeNumberSum {

	public static void main(String[] args) {
		int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
		
		List<Integer[]> result = threeNumberSum(arr, 0);
		
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).length; j++)
				System.out.print(result.get(i)[j] + " ");
			
			System.out.println();
		}

	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> result = new ArrayList<Integer[]>();
		
		Arrays.sort(array);
		
		for(int k = 0; k < array.length; k++) {
			int i = k + 1;
			int j = array.length - 1;
			
			int cn = array[k];
			while(i < j) {
				int sum = cn  + array[i] + array[j];
				
				if(sum == targetSum) {

					Integer[] tmpArr = new Integer[3];
					
					tmpArr[0] = array[i];
					tmpArr[1] = array[j];
					tmpArr[2] = cn;
					
					Arrays.sort(tmpArr);
					result.add(tmpArr);	
					
					i++;
					j--;
				}
				else {
					if (sum < targetSum)
						i++;
					else
						j--;
				}
			}
		}
		
		
		return result;
	}
	
}
