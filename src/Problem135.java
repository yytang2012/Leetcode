
public class Problem135 {

	Problem135(){
		Solution mSolution = new Solution();
		int[] ratings = {2,2};
		int res = mSolution.candy(ratings);
		System.out.println("res = " + res);
	}
	
	public static void main(String[] args){
		Problem135 p = new Problem135();
	}
	
	public class Solution{
		public int candy(int[] ratings){
			int len = ratings.length;
			int[] nums = new int[len];
			// step 1: scan from left to right
			nums[0] = 1;
			for(int i = 1; i < len; i ++){
				if(ratings[i] <= ratings[i-1])
					nums[i] = 1;
				else
					nums[i] = nums[i-1] + 1;
			}
			
			int res = nums[len-1];
			for(int i = len - 2; i >= 0; i --){
				if(nums[i] <= nums[i+1]){
					if(ratings[i] > ratings[i+1])
						nums[i] = nums[i+1] + 1;
				}
				res += nums[i];
			}
			return res;
		}
	}
}
