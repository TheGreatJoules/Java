import java.util.*;

public class LeetCode698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) {
			return false;
		}

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % k != 0) {
			return false;
		}

		Arrays.sort(nums);
		return dfs(nums, new boolean[nums.length], k, 0, sum / k, nums.length - 1);
	}

	private boolean dfs(int[] nums, boolean[] visited, int k, int currentSum, int targetSum, int position) {
		// If k is 0, nothing will be left unvisited!
		// This is the conclusion for simple math
		if (k == 0) {
			return true;
		}

		// Begin next sum search
		// Critial point: start search from nums.length -1, NOT POSITION
		if (currentSum == targetSum) {
			return dfs(nums, visited, k-1, 0, targetSum, nums.length - 1);
		}

		for (int i = position; i >= 0; i--) {
			// Skip Case 1
			// Of course you can't visit what's already visited
			if (visited[i]) {
				continue;
			}

			// Skip Case 2
			// If the last position (i + 1) is not visited, 
			// It does not work for current position.
			// And of course this position (i) has same value,
			// It won't work as well, skip it.
			if (i + 1 < nums.length && nums[i+1] == nums[i] && !visited[i+1]) {
				continue;
			}
			
			// Skip Case 3
			// No need to explain, just out of range
			if (currentSum + nums[i] > targetSum) {
				continue;
			}

			visited[i] = true;
			if (dfs(nums, visited, k, currentSum + nums[i], targetSum, i-1)) {
				return true;
			}
			visited[i] = false;
		}
		return false;
	}
}