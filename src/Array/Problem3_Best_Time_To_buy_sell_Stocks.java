package Array;

public class Problem3_Best_Time_To_buy_sell_Stocks {
	 

//		Maintain the minimum buying price seen so far.
//		For each day:
//		1. Calculate the profit if the stock is sold today.
//		2. Update the maximum profit.
//		3. Update the minimum buying price if today's price is lower.
	public static void findMaxProfit(int[] arr) {
		
		int minBuyingPrice =arr[0];
		int maxProfit = 0;
		int profit =0;
		
		for (int i=1 ; i<arr.length;i++) {
			profit = arr[i] - minBuyingPrice;
			if(profit > maxProfit) {
				maxProfit = profit;
			}
			if(arr[i]< minBuyingPrice) {
				minBuyingPrice = arr[i];
			}
		}
		
		System.out.println(maxProfit);
	}

	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		//Output 5 : buy on day2(price =1) and sell at day5(price =6) . profit =5 
		int[] arr2 = {7,6,4,3,1};
		//Output 0 : no profit day found
		
		findMaxProfit(arr);
		findMaxProfit(arr2);

	}
}
