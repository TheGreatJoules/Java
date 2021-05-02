import java.util.*;

public class Sort1 {
	public int minSteps(int[] piles) {
		int len = piles.length;
		if (len <= 1) {
			return 0;
		}

		Arrays.sort(piles);
		int res = 0;
		int distincetNums = 0;
		for (int i = 1; i < len; i++) {
			if (piles[i] == piles[i - 1]) {
				res += distincetNums;
			}
			distincetNums++;
		}

		return res;
	}
}