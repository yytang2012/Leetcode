
public class Problem136 {

	Problem136(){
		Solution mSolution = new Solution();
		int[] A = {1,2,1};
		int res = mSolution.singleNumber(A);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem136 p = new Problem136();
	}
	
	public class Solution {
		public int singleNumber(int[] A){
			int res = 0;
			
			for(int i = 0, len = A.length; i < len; i ++){
				res = res ^ A[i];
			}
			return res;
		}
	}
}
