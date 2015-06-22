
public class Problem98 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	Problem98() {
		Solution mSolution = new Solution();
		
	}
	
	public static void main(String[] args) {
		Problem98 m = new Problem98();
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	    	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    public boolean isValidBST(TreeNode root, long min, long max) {
	    	if(root == null) 
	    		return true;
	    	
	    	if(root.val > min && root.val < max &&
	    			isValidBST(root.left, min, root.val) &&
	    			isValidBST(root.right, root.val, max))
	    		return true;
	    	return false;
	    }
	}
}
