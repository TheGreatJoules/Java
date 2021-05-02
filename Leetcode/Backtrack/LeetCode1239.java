import java.util.*;

public class LeetCode1239 {
	public int maxLength(List<String> arr) {
		return dfs(arr, 0, 0, "");
	}

	private int dfs(List<String> arr, int ans, int start, String path) {
		if (hasDup(path)) {
			return 0;
		}
		ans = path.length();
		for (int i = start; i < arr.size(); i++) {
			ans = Math.max(ans, dfs(arr, ans, i+1, path + arr.get(i)));
		}

		return ans;
	}

	private boolean hasDup(String p) {
		Set<Character> set = new HashSet<>();
		for (char c : p.toCharArray()) {
			if (set.contains(c)) {
				return true;
			}
			set.add(c);
		}
		return false;
	}
}