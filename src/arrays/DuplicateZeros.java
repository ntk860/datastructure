package arrays;

/**
 * 
 * @author vbspace
 * Problem Statement : https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 * 
 * A = [1, 0, 2, 3, 0, 4, 5, 0]
 * 
 * After Duplication
 * A = [1, 0, 0, 2, 3, 0, 0, 4]
 *
 */
public class DuplicateZeros {

	public static void main(String[] args) {
		int[] arr = new int[] {0, 0, 0, 1, 2, 3, 4, 0, 5, 6, 9, 0, 0, 0, 0, 1, 2, 4, 6, 6, 6, 5, 0};
		
		duplicateZeros(arr);
		for(int numb : arr) System.out.print(numb + " ");

	}
	
	public static void duplicateZeros(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				shitArrayToRight(arr, i);
				i++;
			}
		}
    }
	
	public static void shitArrayToRight(int[] arr, int startingPoint) {
		int i = arr.length - 1;
		while(i >= startingPoint) {
			if(i == startingPoint) {
				arr[i] = 0;
				break;
			}
			else {
				arr[i] = arr[i - 1];
			}
			
			i--;
		}
	}

}
