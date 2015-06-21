
public class Problem24 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	Problem24() {
		int[] a = {1, 2, 3, 4, 5, 6};
		ListNode head = new ListNode(a[0]);
		ListNode p = head;
		for(int i = 1; i < a.length; i ++) {
			ListNode tmp = new ListNode(a[i]);
			p.next = tmp;
			p = p.next;
		}
		Solution mSolution = new Solution();
		p = mSolution.swapPairs(head);		
		
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		Problem24 m = new Problem24();
	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public ListNode swapPairs(ListNode head) {
	    	ListNode h = head;
	    	if(h == null || h.next == null) {
	    		return h;
	    	}
	    	head = h.next;
	    	h.next = head.next;
	    	head.next = h;
	    	
	        ListNode p = h.next;	        
	        while(p != null && p.next != null) {
	        	ListNode tmp = p.next;
	        	h.next = tmp;
	        	p.next = tmp.next;
	        	tmp.next = p;
	        	h = p;
	        	p = h.next;
	        }
	        
	        return head;
	    }
	}
}
