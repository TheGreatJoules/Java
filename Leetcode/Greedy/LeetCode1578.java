public class LeetCode1578 {
	public int minCost(String s, int[] cost) {
		int result = 0;
		for (int i = 0, j = 0; j < s.length(); i++, j++) {
			int max = cost[i];
			int sum = max;
			while (j < s.length() && i < s.length() && s.charAt(j) == s.charAt(i)) {
				sum += cost[j];
				max = Math.max(max, cost[j]);
				i++;
				j++;
			}
			result += max != sum ? sum - max : 0;
		}
		return result;
	}
}