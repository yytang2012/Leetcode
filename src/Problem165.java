
public class Problem165 {

	Problem165(){
		Solution mSolution = new Solution();
		String version1 = "1.00";
		String version2 = "1.0";
		int res = mSolution.compareVersion(version1, version2);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem165 p = new Problem165();
	}
	
	public class Solution{
		public int compareVersion(String version1, String version2){
			String[] v1 = version1.split("\\.");
			String[] v2 = version2.split("\\.");
			
			int i = 0;
			int len = Math.min(v1.length, v2.length);
			for(; i < len; i ++){
				long tmp1 = Long.valueOf(v1[i]).longValue();
				long tmp2 = Long.valueOf(v2[i]).longValue();
				if(tmp1 < tmp2)
					return -1;
				if(tmp1 > tmp2)
					return 1;
			}
			
			for(int j = i; j < v1.length; j ++){
				long tmp = Long.valueOf(v1[j]).longValue();
				if(tmp > 0)
					return 1;
			}
			
			for(int j = i; j < v2.length; j ++){
				long tmp = Long.valueOf(v2[j]).longValue();
				if(tmp > 0)
					return -1;
			}
			return 0;			
		}		
	}
}
