import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Problem207 {
	
	Problem207() {
		int numCourses = 2;
		int[][] prerequisites = {{0, 1}};
		Solution mSolution = new Solution();
		boolean ans = mSolution.canFinish(numCourses, prerequisites);
		System.out.println("the answer is : " + ans);
	}
	
	public static void main(String[] args) {
		Problem207 m = new Problem207();
	}
	public class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			boolean ans = true;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			List<LinkedList<Integer>> courses = new ArrayList<LinkedList<Integer>>(numCourses);
			for(int i = 0; i < numCourses; i ++) {
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				courses.add(tmp);
			}

			int[] coursesDegree = new int[numCourses];
			System.out.println("num = " + courses.size());
			
			Arrays.fill(coursesDegree, 0);
			int len = prerequisites.length;
			for(int i = 0; i < len; i ++) {
				coursesDegree[prerequisites[i][0]] ++;
				LinkedList<Integer> course = courses.get(prerequisites[i][1]);
				course.add(prerequisites[i][0]);
			}
			
			for(int i = 0; i < numCourses; i ++) {
				if(coursesDegree[i] == 0) {
					stack.push(i);
				}
			}
			
			while(stack.isEmpty() == false) {
				int index = stack.pop().intValue();
				LinkedList<Integer> course = courses.get(index);
				while(course.isEmpty() == false) {
					int tmp = course.pop().intValue();
				
					if(--coursesDegree[tmp] == 0) {
						stack.push(tmp);
					}
				}
				
			}
			
			for(int i = 0; i < numCourses; i ++) {
				LinkedList<Integer> course = courses.get(i);
				if(course.isEmpty() == false) {
					ans = false;
					break;
				}
			}
			return ans;
		}
	}
}
