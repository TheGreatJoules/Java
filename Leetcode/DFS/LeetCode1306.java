public class LeetCode1306 {
	public boolean canReach(int[] arr, int start) {
		return dfs(arr, start);
	}

	private boolean dfs(int[] arr, int start) {
		if (start < 0 || start > arr.length-1 || arr[start] < 0) {
			return false;
		}

		if (arr[start] == 0) {
			return true;
		}

		arr[start] = arr[start] * -1;

		return dfs(arr, start + arr[start]) || dfs(arr, Math.abs(start - arr[start]));
	}
}