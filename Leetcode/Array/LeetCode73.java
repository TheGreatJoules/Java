import java.util.*;

public class LeetCode73 {
	// Approach1: Additional Memory
	public void setZeroes01(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// Approach2: Space Efficient
	public void setZeroes02(int[][] matrix) {
		boolean isCol = false;
		int r = matrix.length;
		int c = matrix[0].length;
		for (int i = 0; i < r; i++) {
			if (matrix[i][0] == 0) {
				isCol = true;
			}
			for (int j = 1; j < c; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int j = 0; j < c; j++) {
				matrix[0][j] = 0;
			}
		}

		if (isCol) {
			for (int i = 0; i < r; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// Approach3: Optimized Space Efficient
	/*
	 * Store states of each row in the first of that row, 
	 * and store states of each column in the first of that column.
	 * In the first phase, use matrix elements to set states in a top down way.
	 * In the second phase, use states to set matrix elements in a bottom up way.
	 */
	public void setZeroes03(int[][] matrix) {
		int col0 = 1;
		int r = matrix.length;
		int c = matrix[0].length;

		for (int i = 0; i < r; i++) {
			if (matrix[i][0] == 0) {
				col0 = 0;
			}
			for (int j = 1; j < c; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
 			}
		}

		for (int i = r-1; i >= 0; i--) {
			for (int j = c-1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (col0 == 0) {
				matrix[i][0] = 0;
			}
		}
	}
}