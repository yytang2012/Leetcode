
public class Problem200 {
	char grid[][] = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
	Problem200(){
		Solution mSolution = new Solution();
		int ans = mSolution.numIslands(grid);
		System.out.println("ans = " + ans);
	}
	
	public static void main(String[] args) {
		Problem200 m = new Problem200();
	}
	
	public class Solution {
		public int numIslands(char[][] grid) {
			
			int row = grid.length;			
			if(row == 0)
				return 0;
			int col = grid[0].length;	
			if(col == 0)
				return 0;
			int ans = 0;			
			//System.out.println("row = " + row + "," + "col = " + col);
						
			for(int i = 0; i < row; i ++)
				for(int j = 0; j < col; j ++) {
					if(grid[i][j] == '1') {
						ans ++;
						dfs(grid, i, j);
					}
				}
			return ans;
		}
		
		void dfs(char[][] grid, int r, int c) {
			int col = grid[0].length;
			int row = grid.length;
		//	System.out.println("r = " + r + "," + "c = " + c);
			grid[r][c] = '0';
			if(c - 1 >= 0 && grid[r][c-1] == '1') {
				dfs(grid, r, c - 1);
			}
			if(c + 1 < col && grid[r][c+1] == '1') {
				dfs(grid, r, c + 1);
			}
			
			if(r + 1 < row && grid[r+1][c] == '1') {
				dfs(grid, r + 1, c);
			}
			if(r - 1 >= 0 && grid[r-1][c] == '1') {
				dfs(grid, r - 1, c);
			}
		}
	}
}
