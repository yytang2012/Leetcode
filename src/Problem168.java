
public class Problem168 {

	Problem168(){
		Solution mSolution = new Solution();
		int num = 26*26;
		String res = mSolution.convertToTitle(num);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem168 p = new Problem168();
	}
	
	public class Solution {
	    public String convertToTitle(int n) {
	        StringBuilder sb = new StringBuilder();
	        while(n > 0){
	        	sb.append((char)('A' + (n - 1) % 26));
	        	n = (n - 1) / 26;
	        }
	        String res = sb.reverse().toString();
	        
	        return res;
	    }
	}
}
