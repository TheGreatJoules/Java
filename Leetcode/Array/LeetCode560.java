import java.util.*;

public class LeetCode560 {
	// Approach1: Brute Force
	public int subarraySum1(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start+1; end <= nums.length; end++) {
				int sum = 0;
				for (int i = start; i < end; i++) {
					sum += nums[i];
				}
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	// Approach2: Using Cumulative sum
	public int subarraySum2(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length+1];
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = sum[i-1] + nums[i-1];
		}
		for (int start = 0; start < nums.length; start++) {
			for (int end = start +1; end <= nums.length; end++) {
				if (sum[end] - sum[start] == k) {
					count++;
				}
			}
		}
		return count;
	}

	// Approach3: Without Space
	public int subarraySum3(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	// Approach4: Using Hashmap
	public int subarraySum4(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum-k)) {
				count += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}