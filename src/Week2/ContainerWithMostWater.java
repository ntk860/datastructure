package Week2;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		
		int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(heights));

	}
	
	private static int[] findFirstMax(int[] height) {
		int[] result = new int[2];
		
		int max = height[0];
		int position = 0;
		for(int i = 1; i < height.length; i++) {
			if(height[i] > max) {
				max = height[i];
				position = i;
			}
		}
		
		result[0] = max;
		result[1] = position;
		
		return result;
		
	}
	
	private static int[] findSecondMax(int[] height, int firstMAx) {
		int[] result = new int[2];
		
		int secondMax = height[0];
		int position = 0;
		
		for(int i = 1; i < height.length; i++) {
			if(secondMax < height[i] && height[i] != firstMAx) {
				secondMax = height[i];
				position = i;
			}
		}
		
		result[0] = secondMax;
		result[1] = position;
		
		return result;
	}
	
	private static int calculateDistance(int positionFirstMAx, int positionSecondMax) {
		return Math.abs(positionFirstMAx - positionSecondMax);
	}
	
	public static int maxArea(int[] height) {
        
		int max = findFirstMax(height)[0];
		int maxPosition = findFirstMax(height)[1];
		
		int secondMax = findSecondMax(height, max)[0];
		int secondMaxPosition = findSecondMax(height, max)[1];
		
		int distance = calculateDistance(maxPosition, secondMaxPosition);
		
		return secondMax * distance;
    }

}
