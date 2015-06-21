
public class Problem006 {

	Problem006(){
		Solution mSolution = new Solution();
		String s = "PAYPALISHIRING";
		int nRows = 3;
		String res = mSolution.convert(s, nRows);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem006 p = new Problem006();
	}
	
	public class Solution{
		public String convert(String s, int nRows) {
			if(s == null || s.length() == 0 || nRows <= 0){
				return "";
			}
			
			if(nRows == 1){
				return s;
			}
			
			StringBuilder sb = new StringBuilder();
			int interval = 2 * nRows - 2;
			for(int i = 0; i < nRows; i ++){
				for(int j = i; j < s.length(); j += interval){
					sb.append(s.charAt(j));
					
					if(i != 0 && i != nRows - 1){
						int tmp = j + interval - 2*i;
						if(tmp < s.length()){
							sb.append(s.charAt(tmp));
						}
					}
				}
			}
			
			return sb.toString();
		}
	}
}
