package Week1;

/**
 * 
 * @author vbtapper
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction 
 * (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 *	Output: 5
 *		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *            Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 *  Output: 0
 *		Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class Profit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {7, 1, 5, 3, 6, 4};
		int[] B = {5, 11, 3, 50, 60, 90};
		
		System.out.println(maxProfitByK(B, 2));

	}
	
	public static int maxProfit(int[] prices) {
        int profit = 0;
        
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++) {
        	
        	if(prices[i] > buy) {
        		if(prices[i] - buy > profit) {
        			profit = prices[i] - buy;
        		}
        	}
        	else {
        		buy = prices[i];
        	}
        }
        
        return profit;
    }
	
	public static int maxProfitByK(int[] prices, int k) {
		int maxProfit = 0;
		
		for(int j = 1; j <= k; j++) {
			int buy = prices[0];
			int profit = 0;
			for(int i = 1; i < prices.length; i++) {
				if(prices[i] > buy) {
					if(prices[i] - buy > profit) {
						profit = prices[i] - buy;
						
						System.out.println(profit);
					}
				}
			}
			
			maxProfit += profit;
		}
		
		return maxProfit;
	}

}
