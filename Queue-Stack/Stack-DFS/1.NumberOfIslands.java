/**
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

DFS
Time=(m*n)
SPACE = (m+n)
*/
class Solution {
    // A function to check if a given cell (row, col) can be included in DFS 
    private boolean isSafe(char[][] grid, int row, int col, boolean[][] visited){
        //row and col are in range && value is 1 and not yet visited
        return (row>=0 && row<grid.length) && (col>=0 && col<grid[0].length) && (grid[row][col]=='1' && !visited[row][col]);
    }
    
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 4 neighbors as adjacent vertices 
    private void DFS(char[][] grid, int i, int j, boolean[][] visited){
        //Mark this cell as visited
        visited[i][j] =true;
        // check and marks neighbours are safe or not
        int rowNbr[] = new int[]{-1,0,0,1};
        int colNbr[] = new int[]{0,-1,1,0,};
        //iterate over all eight neighbours
        for(int k=0;k<4;k++){
            if(isSafe(grid,i+rowNbr[k],j+colNbr[k], visited)){
                DFS(grid, i+rowNbr[k], j+colNbr[k], visited);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    DFS(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}
