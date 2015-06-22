import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Problem129 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	
	
	Problem129() {
		TreeNode root = createTree();
		Solution mSolution = new Solution();
		int sum = mSolution.sumNumbers(root);
		System.out.println("sum = " + sum);
	}
	
	String[] input = {"1", "2", "3", null, null, "4", null, null, "5"};
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	int index;
	TreeNode createTree() {
		index = 0;		
		int len = input.length;
		if(input[index] == null)
			return null;
		
		int elm = Integer.parseInt(input[index++]);
		TreeNode root = new TreeNode(elm);
		queue.offer(root);
		while(index < len && queue.isEmpty() == false) {
			TreeNode e = queue.poll();
			if(input[index] == null) {
				e.left = null;
			}
			else {
				int lelm = Integer.parseInt(input[index]);
				e.left = new TreeNode(lelm);		
				queue.offer(e.left);
			}
			index ++;
			
			if(input[index] == null) {
				e.right = null;
			}
			else {
				int relm = Integer.parseInt(input[index]);
				e.right = new TreeNode(relm);
				queue.offer(e.right);
			}
			index ++;
		}
		return root;
	}
	
	public static void main(String[] args) {
		Problem129 m = new Problem129();
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
		int sum = 0;
	    public int sumNumbers(TreeNode root) {
	    	sum = 0;
	    	if(root == null)
	    		return sum;
	        travTree(root, 0);
	        return sum;
	    }
	    public void travTree(TreeNode root, int vals) {
	    	vals = vals*10 + root.val;
	    	if(root.left == null && root.right == null) {
	    		sum += vals;
	    		return;
	    	}
	    	if(root.left != null) {
	    		travTree(root.left, vals);
	    	}
	    	if(root.right != null) {
	    		travTree(root.right, vals);
	    	}
	    }
	}
}
