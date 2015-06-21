import java.util.List;
import java.util.ArrayList;


public class Problem93 {

	Problem93() {
		Solution mSolution = new Solution();
		String s = "25525511135";
		ArrayList<String> res = (ArrayList<String>) mSolution.restoreIpAddresses(s);
		for(String ss : res){
			System.out.println(ss);
		}
	}
	
	public static void main(String[] args) {
		Problem93 p = new Problem93();
	}
	
	public class Solution {
		
		public List<String> restoreIpAddresses(String s) {
			List<String> result = dfs(s, 4);  
			if(result == null)
				result = new ArrayList<String>();
			return result;
		}
		
		ArrayList<String> dfs(String s, int pieces){
			int len = s.length();
			if(len < pieces || len > pieces * 3){
				return null;
			}
			
			ArrayList<String> res = new ArrayList<String>();
			for(int i = 0; i < Math.min(3, len); i ++) {
				int num = Integer.parseInt(s.substring(0, i + 1));
				if((s.charAt(0) > '0' || i == 0) && num >=0 && num <= 255){
					if(pieces == 1 && i == (len - 1)){
						res.add(s);
						return res;
					}
					else{
						ArrayList<String> tmp  = dfs(s.substring(i+1), pieces - 1);
						if(tmp != null){
							for(String r : tmp){
								String ss = "" + num + '.' + r;
								res.add(ss);
							}
						}
						
					}
				}
				else{
					break;
				}
			}
			return res;
		}
	}
}
