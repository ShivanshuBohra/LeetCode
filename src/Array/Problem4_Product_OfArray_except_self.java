package Array;

import java.util.Arrays;

// Find product of whole array and then divide product  with current index
//Handle Zeros when diving as divide by 0 will give arhtmentic exception
public class Problem4_Product_OfArray_except_self {
	
	public static int[] productArraywithDivison(int[] nums) {
		int zeroCount = 0;
	int product = 1;
    int[] ans = new int[nums.length];
    
	for (int num : nums) {
	    if (num == 0)
	        zeroCount++;
	    else
	        product *= num;
	}

	for (int i = 0; i < nums.length; i++) {

	    if (zeroCount > 1) {
	        ans[i] = 0;
	    }
	    else if (zeroCount == 1) {
	        ans[i] = (nums[i] == 0) ? product : 0;
	    }
	    else {
	        ans[i] = product / nums[i];
	    }
	}
	
	return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int[]  arr2 = {-1 ,0,-3,4,-1};
		int[]  arr3 = {0,0,1,5,-9};
		

	System.out.println(Arrays.toString(productArraywithDivison(arr)));
	System.out.println(Arrays.toString(productArraywithDivison(arr2)));
	System.out.println(Arrays.toString(productArraywithDivison(arr3)));

		
	}

}
