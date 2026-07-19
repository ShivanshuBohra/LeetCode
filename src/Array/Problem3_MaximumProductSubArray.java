package Array;

public class Problem3_MaximumProductSubArray {
	
//	Unlike Kadane's Algorithm for sum, we cannot discard a negative product because multiplying it by another negative number can produce the maximum positive product.
//
//	Therefore, maintain:
//	• maxProductEndingHere
//	• minProductEndingHere
//
//	Whenever the current element is negative, swap max and min before updating them.
	
	public static void maxProduct(int[] arr) {
		
		int maxProductEndingHere = arr[0];
		int minProductEndingHere = arr[0];
		int ans = arr[0];
		
		for(int i =1; i<arr.length ;i ++) {
			
			if(arr[i]<0) {
				int temp = maxProductEndingHere;
				maxProductEndingHere = minProductEndingHere;
				minProductEndingHere = temp;
			}
			maxProductEndingHere = Math.max(arr[i], maxProductEndingHere * arr[i]);
			minProductEndingHere = Math.min(arr[i], minProductEndingHere * arr[i]);
			
			ans = Math.max(ans, maxProductEndingHere);
			
			
		}
		
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		int[] arr = {2,3,-2,4};  //output (6)
		int[] arr2 = {-2,0,1};   //output(1)
		int[]  arr3 = {-2, 3, -4} ; //Output (24)
		int[] arr4 = {2, -5, -2, -4, 3}; 
		int[] arr5 = {-1, -2, -9, -6};
		maxProduct(arr);
		maxProduct(arr2);
		maxProduct(arr3);
		maxProduct(arr4);
		maxProduct(arr5);
		
	}
}
