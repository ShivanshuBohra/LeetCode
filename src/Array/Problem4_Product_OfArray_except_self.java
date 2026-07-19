package Array;

import java.util.Arrays;

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
		
	int[] output = productArraywithDivison(arr);
	System.out.println(Arrays.toString(output));
		
	}

}
