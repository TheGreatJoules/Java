import java.util.*;

public class Palindrome {
	public int getNumberOfSwaps(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}

		int totalSwaps = 0;
		if (isShuffledPalindrome(s)) {
			char[] ch = s.toCharArray();
			int i = 0;
			int j = s.length() - 1;
			while (i < j) {
				int k = j;
				while (i < k && ch[i] != ch[k]) {
					k--;
				}

				// When there are no matching characters
				if (i == k) {
					swap(ch, i, i + 1);
					totalSwaps++;
				} else {
					while (k < j) {
						swap(ch, k, k + 1);
						totalSwaps++;
						k++;
					}
				}
				i++;
				j--;
			}

			return totalSwaps;
		}

		return -1;
	}

	private void swap(char[] ch, int k, int i) {
		char temp = ch[k];
		ch[k] = ch[i];
		ch[i] = temp;
	}

	private boolean isShuffledPalindrome(String s) {
		int[] occurance = new int[26];
		int oddCount = 0;
		for (int i = 0; i < s.length(); i++) {
			occurance[s.charAt(i) - 'a']++;
		}

		for (int value : occurance) {
			if (value % 2 != 0) {
				oddCount++;
			}
		}

		return oddCount >= 1;
	}
}