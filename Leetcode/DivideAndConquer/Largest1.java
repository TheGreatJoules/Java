import java.util.*;

public class Largest1 {
	public int Largest(int[] nums) {
		int n = nums.length;
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (set.contains(nums[i])) {
				res = Math.max(res, Math.abs(nums[i]));
			} else {
				set.add(nums[i] * -1);
			}
		}

		return res;
	}
}