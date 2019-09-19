package Arrays;

public class Problems {

	/**
	 * Print a given array to the console
	 * @param arr
	 */
	void printArray(int[] arr) {
		for(int val: arr)
			System.out.print(val + " ");
		
		System.out.println();
	}
	
	/**
	 * 
	 * Time complexity : O(n * d)
	 * Auxiliary Space : O(1)
	 * @param arr
	 * @param unit
	 * @return
	 */
	public int[] leftRotate(int[] arr, int unit) {
		
		for(int i = 1; i <= unit; i++) {
			arr = leftRotatebyOne(arr, arr.length); 
		}
		
		return arr;
	}

	/**
	 * This method rotate an array by one
	 * The idea that I used here is to check the edge cases first
	 * and then change values at the middle of the array by
	 * saving the next value to be override.
	 * 
	 * 
	 * @param arr - array with values
	 * @param d - size of the array
	 * @return - the array rotated by one
	 */
	public int[] leftRotatebyOne(int[] arr, int d) {
	
		int next = 0, saved = 0;
		for(int i = d-1; i >= 0; i--) {
			if(i == d - 1) {
				saved = arr[i-1];
				arr[i-1] = arr[i];
			}
			else if(i == 0) {
				arr[d - 1] = next;
			}
			else {
				next = arr[i-1];
				arr[i-1] = saved;
				saved = next;
			}
		}
		
		return arr;
	}

	/**
	 * Consider an array of distinct numbers sorted in increasing order. 
	 * The array has been rotated (clockwise) k number of times. 
	 * Given such an array, find the value of k.
	 * 
	 * The idea here is to find the position of the
	 * maximum element of the array, but when the max
	 * is at the last position should return 0 because
	 * the array didn't rotate or rotated the number of 
	 * times that equal to the number of elements that 
	 * the array has. [This solution was easy to find - in less than one minute]
	 * 
	 * Time complexity : O(n)
	 * Auxiliary Space : O(1)
	 * 
	 * @param arr
	 * @return
	 */
	int countRotations(int[] arr) {
		int pos = 0;
		int max = arr[0];
		
		for(int i=1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				pos = i;
			}
		}
		
		if(max == arr[arr.length - 1]) 
			return 0;
		
		return pos+1;
	}

}
