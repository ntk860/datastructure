package Arrays;

public class Introduction {

	/**
	 * Add a value to an one dimensional array
	 * adding a value takes linear time.
	 * @param arr 
	 * @param value
	 * @param index
	 */
	void addValue(int[] arr, int value, int index) {
		arr[index] = value;
	}
	
	/**
	 * print the values of one dimensional array
	 * @param arr
	 */
	void printValues(int[] arr) {
		for (int value : arr) {
			System.out.println(value);
		}
	}
	
	/**
	 * Access time for an array is constant
	 * @param arr
	 * @param pos
	 * @return
	 */
	int getValue(int[] arr, int pos) {
		return arr[pos];
	}
	
	/**
	 * add a value to a multidimensional array
	 * the running time is also constant here
	 * @param arr
	 * @param value
	 * @param pos
	 * @param arrN
	 */
	void addToMultidimensional(int[][] arr, int value, int pos, int arrN) {
		arr[pos][arrN] = value;
	}
	
	/**
	 * printing time is quadratic nxm
	 * where n - is the size of each array
	 * and m - is the number of arrays
	 * 
	 * @param arr
	 */
	void printMultidimensional(int[][] arr) {
		for (int[] arrays : arr) {
			for(int value: arrays) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Introduction demo = new Introduction();
		
		int[] intArray = new int[20];
		int[][] mArray = new int[3][3];

		/**
		 * one dimensional
		 */
		System.out.println("Adding values from 1 to 20 to a one dimensional array");
		for(int i=0; i < 20; i++) {
			demo.addValue(intArray, i+1, i);
		}
		
		System.out.println("Print the values of one dimensional Array");
		demo.printValues(intArray);
		
		System.out.println("access value on position 0");
		System.out.println(demo.getValue(intArray, 0));
		/**
		 * end of one dimensional
		 * 
		 * Multidimensional Arrays
		 */
		
		System.out.println("Adding value to a multidimensional array 3x3");
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				demo.addToMultidimensional(mArray, i+j, i, j);
			}
		}
		
		System.out.println("Printing values from multidimensional array");
		demo.printMultidimensional(mArray);
	}

}
