public class DFSque {

  //200

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
        
        int count =0;
        for(int i =0; i<n;i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs_numIslands(grid,i,j,dir);
                }
            }
        }
        return count;
        
    }
    
    
    public void dfs_numIslands(char [][] grid, int i,int j, int[][] dir){
        int n = grid.length;
        int m = grid[0].length;
        
        grid[i][j] ='*';
        for(int d=0;d<dir.length;d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >=0 && c >= 0 && r < n && c< m && grid[r][c] == '1'){
                dfs_numIslands(grid,r,c,dir);
            }
        }
    }
// =============================================
//695

public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    
    int maxArea = 0;
   int [][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
    
    for(int i =0; i<n; i++){
        for(int j =0; j<m; j++){
            if(grid[i][j] == 1){
                int area = DFS_maxAreaOfIsland(grid, i, j, dir);
                maxArea = Math.max(area, maxArea);
            }
        }
    }
    
    return maxArea;
}


public int DFS_maxAreaOfIsland(int [][] grid, int i, int j, int[][] dir){
    int n = grid.length;
    int m = grid[0].length;
    
    grid[i][j] = 0;
    
    int size =0;
    
    for(int d =0; d<dir.length; d++){
        int r = i + dir[d][0];
        int c = j + dir[d][1];
        
        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
            size+=DFS_maxAreaOfIsland(grid,r,c,dir);
        }
    }
    return size+1;
}


// 463

public int islandPerimeter(int[][] grid) {
        
    int n = grid.length;
    int m = grid[0].length;
    int oneCount =0;
    int nbrCount =0;
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    for(int i =0; i<n; i++){
        for(int j =0; j<m; j++){
            if(grid[i][j] == 1){
                oneCount++;
               for(int d=0; d<dir.length; d++){
                   int r = i + dir[d][0];
                   int c = j + dir[d][1];
                   
                   if(r >=0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                       nbrCount++;
                   }
               }
            }
        }
    }
    return 4 * oneCount-nbrCount;
}
    public static void main(String[] args) {
        
    }
}
