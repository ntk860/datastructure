package Week3;

public class SubArraySort {

	public static void main(String[] args) {
		int[] array = {2, 1};
		
		subArraySort(array);

	}
	
	public static void subArraySort(int[] array) {
		int startingPosition = -1;
		int endingPosition = -1;
		
		int minUnsorted = Integer.MAX_VALUE;
		int maxUnsorted = Integer.MIN_VALUE;
		
		for(int i = 1; i <= array.length - 1; i++) {
			if(array[i-1] >= array[i]) {
				if(minUnsorted >= array[i]) {
					minUnsorted = array[i];
					startingPosition = i;
				}
			}
			
			if(i == array.length - 1) {
				if(array[i-1] > array[i]) {
					if(maxUnsorted <= array[i]) {
						maxUnsorted = array[i];
						endingPosition = i;
					}
				}
			}
			else {
				if(array[i+1] < array[i]) {
					if(maxUnsorted <= array[i]) {
						maxUnsorted = array[i];
						endingPosition = i;
					}
				}
			}
		}
		
		if(startingPosition != -1) {
			for(int i = 0; i < array.length; i++) {
				if(minUnsorted < array[i]) {
					startingPosition = i;
					break;
				}
			}
		}
		
		System.out.println(endingPosition);
		if(endingPosition != -1) {
			for(int i = array.length - 1; i > endingPosition; i--) {
				if(maxUnsorted >= array[i]) {
					endingPosition = i;
					break;
				}
			}
		}
		
		System.out.println(startingPosition + " " + endingPosition);
	}

}
