package Array;

public class Problem1_Maximum_Sum_SubArray {
	
	//	core idea of Kadane's Algorithm.
//	At every element, you have two choices:
//		1> Start a new subarray from the current element.
//		2> Continue the previous subarray by adding the current element.
// A negative previous sum only decreases the total. so if previous sum is negative start new sum		

	public static int getMaxSubArray(int[] arr){
		
		int maxSofar =arr[0];
		int currentSum =arr[0];
		
		for (int i =1 ; i<arr.length ;i++) {
	
			// A negative previous sum only decreases the total. so if previous sum is negative start new sum		
			if(currentSum<0) {
				currentSum =0 ;
			}
			
			currentSum = currentSum + arr[i];
			maxSofar = Math.max(currentSum, maxSofar);
		}
		return maxSofar;
		
	}

	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(getMaxSubArray(arr));
		
		
	}
}
