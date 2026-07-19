package Array;

public class Problem2_Print_Maximum_Sum_SubArray {
	
//	 "How do you print the maximum sum subarray?" The answer is:
//
//		Maintain tempStart whenever you restart the subarray.
//		When you find a new maximum sum, update start = tempStart and end = current index.
//		Print elements from start to end.
	public static void printMaximumSumSubArray(int[] arr) {
		
		
		int currentSum = arr[0];
		int maxSumSoFar = arr[0];
		
		int start = 0;
		int end =0;
		int tempStart =0;
		
		for(int i =1 ;i<arr.length ;i ++) {
			
            // If previous sum is negative, discard it and start a new subarray
			if(currentSum<0) {
				currentSum =0;
				tempStart =i;
			}
			
            currentSum += arr[i];  

			if(currentSum>maxSumSoFar) {
				start = tempStart;
				end = i;
				maxSumSoFar =  currentSum;
			}
			
		}
		
		System.out.println("Max sum is : " + maxSumSoFar);
      for(int i= start ; i<=end ; i++) {
	   System.out.println(arr[i]);
        }
	}
	
	public static void main(String[] args) {
		 int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		 printMaximumSumSubArray(arr);
	}

}
