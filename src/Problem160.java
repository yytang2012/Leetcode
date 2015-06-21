/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem160 {

	public static void main(String[] args){
		Problem160 p = new Problem160();
	}
	Problem160(){
		Solution mSolution = new Solution();
		int[] a = {1,3,5,7,9,11};
		int[] b = {2,4};
		ListNode headA = initializeList(a);
		ListNode headB = initializeList(b);
		mergeList(headA, headB, 4);
		ListNode res = mSolution.getIntersectionNode(headA, headB);
		
		System.out.println("res = " + res.val);
	}	
	
	ListNode initializeList(int[] array){
		ListNode res = null;
		if(array.length != 0){
			res = new ListNode(array[0]);
		}
		ListNode p = res;
		for(int i = 1, len = array.length; i < len; i ++){
			p.next = new ListNode(array[i]);
			p = p.next;
		}
		return res;
	}
	
	void mergeList(ListNode a, ListNode b, int step){
		ListNode p1 = a;
		ListNode p2 = b;
		
		while(p2.next != null){
			p2 = p2.next;
		}
		for(int i = 0; i < step; i ++){
			p1 = p1.next;
		}
		p2.next = p1;		
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
			next = null;
		}
	}
	
	public class Solution{
		public ListNode getIntersectionNode(ListNode headA, ListNode headB){
			ListNode p1 = headA;
			ListNode p2 = headB;
			
			int lenA = 0;
			while(p1 != null){
				p1 = p1.next;
				lenA ++;
			}
			
			int lenB = 0;
			while(p2 != null){
				p2 = p2.next;
				lenB ++;
			}
			
			p1 = headA;
			p2 = headB;
			
			if(lenA > lenB){
				int tmp = lenA - lenB;
				while(tmp -- != 0){
					p1 = p1.next;
				}
			}
			if(lenA < lenB){
				int tmp = lenB - lenA;
				while(tmp -- != 0){
					p2 = p2.next;
				}
			}
			
			while(p1 != null && p2 != null){
				if(p1 == p2){
					return p1;
				}
				p1 = p1.next;
				p2 = p2.next;
			}
			return null;
		}
	}
}
