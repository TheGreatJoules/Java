import java.util.*;


public class Solution {
	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = fillMatrix(n);
		for (int[] nums : matrix) {
			System.out.println(Arrays.toString(nums));
		}

		System.out.println(isValid(matrix, n));
	}

	public static int[][] fillMatrix(int n) {
		int max = n*n;
	    int[][] nums = new int[n][n];
	    int row = n/2;
	    int col = n-1;

	    for(int i = 1; i <= max; i++) {
	    	nums[row][col] = i;
	        row -= 1;
	        col += 1;

	        if(row < 0 && col < n) {
	            row = n - 1;
	        }
	        else if(col == n && row >=0) {
	            col = 0;
	        }

	        if(row >= 0 && col != n && nums[row][col] != 0) {
	            row = row + 1 == n ? 0 : row + 1;
	            col = col - 2 < 0 ? n - 1 - Math.abs(col - 2) : col - 2;
	        }

	        if((row == n || row == -1) && (col == -1 || col == n)) {
	            row = 0;
	            col = n - 2;
	        }
	    }
	    return nums;
	}

	private static boolean isValid(int[][] matrix, int n) {
		int sumLIN = 0;
		for (int j = 0; j < n; j++) {
			sumLIN += matrix[0][j];
		}

		for (int i = 1; i < n; i++) {
			int temp = 0;
			for (int j = 0; j < n; j++) {
				temp += matrix[i][j];
			}
			if (temp != sumLIN) {
				return false;
			}
		}

		for (int j = 0; j < n; j++) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				temp += matrix[i][j];
			}
			if (temp != sumLIN) {
				return false;
			}
		}

		int sumLeftDIA = 0;
		for (int i = 0, j = 0; i < n && j < n; i++, j++) {
			sumLeftDIA += matrix[i][j];
		}

		int sumRightDIA = 0;
		for (int i = 0, j = n-1; i < n && j >= 0; i++, j--) {
			sumRightDIA += matrix[i][j];
		}

		if (sumLIN != sumLeftDIA && sumLIN != sumRightDIA) {
			return false;
		}

		return true;
	}

}