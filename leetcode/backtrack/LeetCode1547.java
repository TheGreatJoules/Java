import java.util.*;

class LeetCode1547 {

	/************ BottomUp /************/
	public int minCost1(int n, int[] cuts) {
		Arrays.sort(cuts);
		int clength = cuts.length + 2;
		int[] arr = new int[clength];
		int[][] dp = new int[clength][clength];
		// Add the total length to the last index
		arr[clength + 1] = n;
		// Iterate through the entire arr and add it new array
		// Skip the first index to include zero
		for (int i = 0; i < cuts.length; i++) {
			arr[i + 1] = cuts[i];
		}

		// Sliding window
		for (int l = 2; l < clength; l++) {
			int i = 0;
			int j = l;
			// Move j towards the end
			while (j < clength) {
				// Calculate the current rodlength
				int rodlength = arr[j] - arr[i];
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], rodlength + dp[i][k] + dp[k][j]);
				}
				// Move down and left
				i++;
				j++;
			}
		}

		return dp[0][clength - 1];
	}

	/************ TopDown /************/
	public int minCost2(int n, int[] cuts) {
		Arrays.sort(cuts);
		int clength = cuts.length;
		int[][] dp = new int[clength][clength];
		return backtracking2(cuts, dp, 0, clength - 1, 0, n);
	}

	private int backtracking2(int[] cuts, int[][] dp, int left, int right, int rL, int rR) {
		if (left > right) {
			return 0;
		}

		int rodlength = rR - rL;
		int cost = Integer.MAX_VALUE;

		for (int i = left; i < right; i++) {
			int leftSide = backtracking2(cuts, dp, left, i-1, rL, cuts[i]);
			int rightSide = backtracking2(cuts, dp, i+1, right, cuts[i], rR);
			int total = rodlength + leftSide + rightSide;
			cost = Math.min(cost, total);
		}

		return dp[right][left] = cost;
	}
}