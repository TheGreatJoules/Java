public class LeetCode312 {
	
	private int maxCoins(int[] nums) {
		int n = nums.length + 2;
		int[] new_nums = new int[n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < nums.length; i++) {
			new_nums[i+1] = nums[i];
		}
		new_nums[0] = new_nums[n-1] = 1;
		return backtrack(new_nums, dp, 0, n-1);
	}

	private int backtrack(int[] nums, int[][] dp, int left, int right) {
		if (left + 1 == right) {
			return 0;
		}

		if (dp[left][right] != 0) {
			return dp[left][right];
		}

		int ans = Integer.MIN_VALUE;
		for (int i = left; i < right; i++) {
			int leftSide = backtrack(nums, dp, left, i);
			int rightSide = backtrack(nums, dp, i, right);
			int total = leftSide + nums[left]*nums[i]*nums[right] + rightSide;
			ans = Math.max(ans, total);
		}

		return dp[left][right] = ans;
	}
}