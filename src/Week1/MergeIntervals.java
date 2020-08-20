package Week1;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] arr = { {1,3}, {2,6}, {8,10}, {15,18} };
		int[][] arr1 = { {1,4}, {1,5} };

		print2DArray(merge(arr));
		System.out.println();
		print2DArray(merge(arr1));
	}

	public static int[][] merge(int[][] intervals) {
		int[][] result = new int[intervals.length-1][2];
        
		int k = 0;
        for(int i = 0; i < intervals.length - 1; i++) {
        	if(intervals[i][1] > intervals[i+1][0]) {
        		int a = intervals[i][0];
        		int b = intervals[i+1][1];
        		
        		int[] tmpArr = {a, b};
        		result[k++] = tmpArr;
      
        	}
        	else {
        		int a = intervals[i+1][0];
        		int b = intervals[i+1][1];
        		
        		int[] tmpArr = {a, b};
        		result[k++] = tmpArr;
        	}
        }
        
        return result;
    }
	
	public static void print2DArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print("[" + arr[i][j] + "]");
			}
			System.out.print(", ");
		}
	}
}
