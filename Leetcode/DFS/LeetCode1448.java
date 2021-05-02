public class LeetCode1448 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public int goodNodes(TreeNode root) {
		return dfs(root, root.val);
	}

	private int dfs(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}

		return dfs(node.left, Math.max(val, node.val)) + dfs(node.right, Math.max(val, node.val)) + (node.val >= val ? 1 : 0);
	}
}