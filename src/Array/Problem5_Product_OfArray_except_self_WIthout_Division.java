package Array;

import java.util.Arrays;

// Create 2 arrays one with all products to left and one with all products to right 
// Then product at a particular index is product of left and product of right
public class Problem5_Product_OfArray_except_self_WIthout_Division {
	
	private static int[] productArray(int[] arr) {
		int length = arr.length;
		
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] =1;
		right[length-1] =1;
		int[] ans = new int[length];

		
		for(int i =1; i<length ;i++) {
			left[i] = arr[i-1]* left[i-1];
		}
		
		for(int i =length-2; i>=0 ;i--) {
			right[i] = arr[i+1]* right[i+1];
		}

		for(int i =0; i<length ;i++) {
			ans[i] = left[i]* right[i];
		}
		
		
		return ans;
	}
	
   public static void main(String[] args) {
	   int[] arr = {1,2,3,4};
		int[]  arr2 = {-1 ,0,-3,4,-1};
		int[]  arr3 = {0,0,1,5,-9};
		

	System.out.println(Arrays.toString(productArray(arr)));
	System.out.println(Arrays.toString(productArray(arr2)));
	System.out.println(Arrays.toString(productArray(arr3)));
}



}
