
public class Problem162 {

	Problem162(){
		Solution mSolution = new Solution();
		int[] num = {0, 1};
		int res = mSolution.findPeakElement(num);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem162 p = new Problem162();
	}
	
	public class Solution{
		public int findPeakElement(int[] num){
			int left = 0;
			int right = num.length - 1;
			int mid = 0;
			
			while(left < right){
				mid = (left + right) / 2;
				if(num[mid] > num[mid + 1]){
					right = mid;
				}
				else {
					left = mid + 1;
				}
			}
			
			return left;
		}
	}
}
