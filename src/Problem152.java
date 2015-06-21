
public class Problem152 {

	Problem152(){
		Solution mSolution = new Solution();
		int[] A = {2,3,-2,4};
		int res = mSolution.maxProduct(A);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem152 p = new Problem152();
	}
	
	public class Solution{
		public int maxProduct(int[] A){
			int len = A.length;	
			if(A == null || len == 0)
				return 0;
			
			int minElement = A[0];
			int maxElement = A[0];
			int res = A[0];
			
			for(int i = 1; i < len; i ++){
				int a = minElement * A[i];
				int b = maxElement * A[i];
				
				minElement = Math.min(Math.min(a, b), A[i]);
				maxElement = Math.max(Math.max(a, b), A[i]);
				res = Math.max(res,  maxElement);
			}
			return res;
		}
	}
}
