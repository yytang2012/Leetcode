import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// flag[i] = true  -- if s[0..i] belongs to dict
// flag[i+1] = true -- if f[0..k]=true and s[k+1..i+1] belongs to dict
public class Problem139 {
	
	Problem139(){
		Solution mSolution = new Solution();
		String s= "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		boolean res = mSolution.wordBreak(s, dict);
		System.out.println("the answer is " + (res ? "yes": "no"));
	}
	
	public static void main(String[] args){
		Problem139 p = new Problem139();
	}
	
	public class Solution {
		public boolean wordBreak(String s, Set<String> dict) {
			int len = s.length();
			boolean[] flag = new boolean[len];
			
			for(int i = 0; i < len; i ++){
				if(dict.contains(s.substring(0, i + 1))){
					flag[i] = true;
				}
			}
			
			for(int i = 1; i < len; i ++){
				for(int j = i - 1; j >= 0; j --){
					if(flag[j] && dict.contains(s.substring(j + 1, i + 1))){
						flag[i] = true;
						break;
					}
				}
			}
			
			return flag[len - 1];
		}
	}
}
