package arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		/*int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
		int[] nums2 = new int[] {2, 5, 6};
		int m = 3, n = 3;*/
		
		/*int[] nums1 = new int[] {0};
		int[] nums2 = new int[] {1};
		int m = 0, n = 1;*/
		
		/*int[] nums1 = new int[] {-1,3,0,0,0,0,0};
		int[] nums2 = new int[] {0,0,1,2,3};
		int m = 2, n = 5;*/
		
		/*int[] nums1 = new int[] {1, 2, 3, 0, 0};
		int[] nums2 = new int[] {4, 5};
		int m = 3, n = 2;*/
		
		int[] nums1 = new int[] {0, 0, 0, 0};
		int[] nums2 = new int[] {1, 2, 3};
		int m = 0, n = 3;
		
		merge(nums1, m, nums2, n);
		
		for(int numb : nums1) System.out.print(numb + " ");

	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0, i = 0;
		
        while(i < nums2.length && j < nums1.length) {
        	if(nums2[i] <= nums1[j] || (j >= m && nums1[j] == 0)) {
        		shiftToRight(nums1, j, nums2[i]);
        		i++;
        	}
        	
        	j++;
        }
    }
	
	public static void shiftToRight(int[] arr, int starting, int toAdd) {
		for(int i = arr.length - 1; i > starting; i--) {
			arr[i] = arr[i - 1];
		}
		
		arr[starting] = toAdd;
	}

}
