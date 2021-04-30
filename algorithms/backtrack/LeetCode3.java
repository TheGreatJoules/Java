import java.util.*;

public class LeetCode3 {
	// *** Approach 1 ***
	// Brute Force
	public int lengthOfLongestSubstring01(String s) {
		int res = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; i++) {
				if (checkRepetition(s, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res;
	}

	private boolean checkRepetition(String s, int start, int end) {
		int[] chars = new int[126];
		for (int i = start; i < end; i++) {
			char c = s.charAt(i);
			chars[c]++;
			if (chars[c] > 1) {
				return false;
			}
		}
		return true;
	}

	// *** Approach 2 ***
	// Sliding Window
	private int lengthOfLongestSubstring02(String s) {
		int[] chars = new int[128];
		int n = s.length();
		int i = 0;
		int j = 0;
		int res = 0;
		while (j < n) {
			char r = s.charAt(j);
			chars[r]++;
			while (chars[r] > 1) {
				char l = s.charAt(i);
				chars[l]--;
				i++;
			}
			res = Math.max(res, j - i + 1);
			j++;
		}
		return res;
	}


	// *** Approach 3 ***
	// Sliding Window Optimized ***
	public int lengthOfLongestSubstring03(String s) {
		int ans = 0;
		int n = s.length();
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
}