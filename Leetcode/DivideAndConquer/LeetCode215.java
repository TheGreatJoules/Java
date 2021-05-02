public class LeetCode215 {
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);	
	}

	private int quickSelect(int[] nums, int left, int right, int k) {
		int pivot = left;
		// Put nums that are <= than pivot to the left
		// Put nums that are > than pivot to the right
		for (int i = left; i < right; i++) {
			if (nums[i] <= nums[right]) {
				swap(arr, pivot++, i);
			}
		}
		swap(arr, pivot, high);
		// Count the nums that are > than pivot from right
		int count = right - pivot + 1;
		// Pivot is the one
		if (count == k) {
			return nums[pivot];
		}
		// Pivot is too small, so it must be on the right side
		if (count > k) {
			return quickSelect(nums, pivot+1, right, k);
		} 
		// pivot is too big, so it must be on the left
		else {
			return quickSelect(nums, left, pivot-1, k-count)
		}
	}
}