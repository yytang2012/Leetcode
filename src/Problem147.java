public class Problem147 {
	public static void main(String[] args) {
		Problem147 p = new Problem147();
		
	}

	Problem147() {
		Solution mSolution = new Solution();
		ListNode head = null;
		int[] node = {14,5,-3,1,8,5,11,15};
		head = initializeList(node);
		head = mSolution.insertionSortList(head);
		ListNode p = head;
		while(p != null){
			System.out.println("val = " + p.val);
			p = p.next;
		}
	}
	
	public ListNode initializeList(int[] node){
		if(node.length == 0)
			return null;
		ListNode head = new ListNode(node[0]);
		ListNode tail = head;
		ListNode p = null;
		for(int i = 1, len = node.length; i < len; i ++){
			p = new ListNode(node[i]);
			tail.next = p;
			tail = tail.next;
		}
		return head;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		public ListNode insertionSortList(ListNode head) {
			ListNode tail = head;
			ListNode p = null;
			
			if(head == null || head.next == null)
				return head;
			while(tail != null && tail.next != null) {
				p = tail.next;
				
				if(p.val < head.val) {
					tail.next = p.next;
					p.next = head;
					head = p;
				}else {
					ListNode tmp = head;
					while(tmp != tail && tmp.next.val < p.val){
						tmp = tmp.next;
					}
					if(tmp == tail)
						tail = p;
					else{
						tail.next = p.next;
						p.next = tmp.next;
						tmp.next = p;						
					}
				}
			}
			return head;
		}		
	}
	class Solution2 {
		public ListNode insertionSortList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}

			return insertNode(head.next, head);
		}

		private ListNode insertNode(ListNode head, ListNode p) {
			ListNode n;
			assert(p != null);

			if (head == null) {
				p.next = null;
				return p;
			}

			head = insertNode(head.next, head);

			if (head.val > p.val) {
				p.next = head;
				return p;
			}

			n = head;

			while (n.next != null && n.next.val < p.val) {
				n = n.next;
			}

			
p.next = n.next;
			n.next = p;
			return head;
		}
	}
}
