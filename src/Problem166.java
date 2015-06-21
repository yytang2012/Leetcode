import java.util.HashMap;
import java.util.Map;


public class Problem166 {

	Problem166(){
		Solution mSolution = new Solution();
		int numerator = 7;
		int denominator = -12;
		String res = mSolution.fractionToDecimal(numerator, denominator);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem166 p = new Problem166();		
	}
	
	public class Solution {
	    public String fractionToDecimal(int numerator, int denominator) {
	        long num = numerator;
	        long den = denominator;
	        boolean isNegative = (num * den) < 0;
	        
	        num = Math.abs(num);
	        den = Math.abs(den);
	        String res = isNegative ? "-" + Long.toString(num/den) : Long.toString(num/den);
	        
	        if(num%den == 0)
	        	return res;       
	        
	        num = num % den;
	        res = res + "." + getDec(num, den);
	        return res;
	    }
	    
	    String getDec(long num, long den){
	    	Map<Long, Integer> hashMap = new HashMap<Long, Integer>();
	    	StringBuilder sb = new StringBuilder();
	    	
	    	int i = 0;
	    	while(num != 0 && !hashMap.containsKey(num)){
	    		hashMap.put(num, i++);
	    		num = num * 10;
	    		sb.append(num / den);
	    		num = num % den;
	    	}
	    	
	    	if(num != 0){
	    		int pos = hashMap.get(num);
	    		sb.insert(pos, '(');
	    		sb.append(')');
	    	}
	    	
	    	return sb.toString();
	    }
	}
}
