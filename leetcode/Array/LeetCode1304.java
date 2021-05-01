public class LeetCode1304 {
	public int[] sumZero(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n -1; i++) {
			arr[i] = (i+1) * -1;
			arr[n-1] = Math.abs(arr[i]);
		}
		return arr;
	}
}