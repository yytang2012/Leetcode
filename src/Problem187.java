import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Repeated DNA Sequences
 * */
public class Problem187 {
	
	Problem187(){
		final String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> res;
		Solution mSolution = new Solution();
		
		res = mSolution.findRepeatedDnaSequences(s);
		
		
		for(Iterator<String> mIter = res.iterator(); mIter.hasNext();){
			String str = mIter.next();
			System.out.println(str);
		}		
	}
	public static void main(String[] args){

		System.out.print("hello, I am yytang\n");
		Problem187 m = new Problem187();		
	}
	
	public class Solution{
		public List<String> findRepeatedDnaSequences(String s){
			final int mask = 0x3fffffff;
			List<String> res = new LinkedList<String>();
			
			if(s.length() <= 10){
				return res;
			}
			
			int i, cur;
			for(i = 0, cur = 0; i < 10; i ++){
				cur = ((cur << 3) & mask) + (s.charAt(i)&7);
			}
			Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
			hashMap.put(cur, 1);
			
			while(i < s.length()){
				cur = ((cur << 3) & mask) + (s.charAt(i++)&7);
				if(hashMap.containsKey(cur)){
					int cnt = hashMap.get(cur);
					if(cnt == 1){
						res.add(s.substring(i-10, i));
					}
					hashMap.put(cur, ++cnt);
				}
				else{
					hashMap.put(cur, 1);
				}
			}
			
			return res;
		}
	}
}
