
public class Problem202 {
	
	Problem202(int n){
		Solution mSolution = new Solution();
		boolean res =mSolution.isHappy(n);
		if(res)
			System.out.println(n + " is a Happy Number");
		else
			System.out.println(n + " is not a Happy Number");
	}

	public static void main(String[] args){
		int n = 20;
		Problem202 m = new Problem202(n);
	}
	public class Solution{
		public boolean isHappy(int n){
			boolean res = false;
			int ant1 = oneStepConvert(n);
			int ant2 = twoStepConvert(n);
			
			while(true){
				if(ant1 == 1 || ant2 == 1){
					res = true;
					break;
				}
				if(ant1 == ant2){
					res = false;
					break;
				}
				ant1 = oneStepConvert(ant1);
				ant2 = twoStepConvert(ant2);
				//System.out.println("ant1 = " + ant1 + "," + "ant2 = " + ant2);
			}
			return res;
		}
		
		int oneStepConvert(int n){
			int ant = 0;
			while(n != 0){
				int tmp = n%10;
				ant += tmp*tmp;
				n = n/10;
			}
			return ant;
		}
		
		int twoStepConvert(int n){
			int ant = oneStepConvert(n);
			ant = oneStepConvert(ant);
			return ant;
		}
	}
}
