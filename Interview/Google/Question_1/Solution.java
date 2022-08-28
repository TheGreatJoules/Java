import java.util.*;

/*
	Question 1:
	- You are given an array of integers. Your task is to create pairs of them, 
	such that every created pair has the same sum. 
	- This sum is not specified, but the number of created pairs should be the 
	maximum possible. Each array element may belong to one pair only.
	
	Assume that:
	- N is an integer within the range [2 .. 50]
	- Each element of array A is an integer within the range [1..1_000]
	
*/

class Solution{
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println("[1, 9, 8, 50, 2] ->" + obj.maxNumPair(new int[]{1, 9, 8, 50, 2}));
		// System.out.println("[2, 2, 2, 3] ->" + obj.maxNumPair(new int[]{2, 2, 2, 3}));
		// System.out.println("[5, 5] ->" + obj.maxNumPair(new int[]{5, 5}));
		// System.out.println("[2,2,2,2] ->" + obj.maxNumPair(new int[]{2,2,2,2}));
	}
	
	private int m = 1_000;
	public int maxNumPair(int[] nums){
		Map<Integer, Integer> freq = new HashMap<>();
		for(int num: nums){
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		int maxCount = 0;
		for(int i = 0; i <= m; i++){
			int currentCount = 0;
			for(int j = 0; j <= i/2; j++){
				int k = i - j;
				int localCount = Math.min(freq.getOrDefault(j, 0), freq.getOrDefault(k, 0));
				if(j != k){
					currentCount +=  localCount;
				}else {
					currentCount +=  localCount / 2;
				}
				
			}
			maxCount = Math.max(currentCount, maxCount);
		}
		
		return maxCount;
	}
}