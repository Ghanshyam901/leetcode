

public class DFSquestion {
    

    // 200. Number of Islands

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int count =0;
        for(int i =0; i<n; i++){
        for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    NumsOFislandDFS(grid,i,j,dir);
                    count++;
                }
            }
        }
        return count;
        
        
    }
    public void NumsOFislandDFS(char[][] grid, int r, int c, int[][] dir){
        
        grid[r][c] = '0';
        
        for(int d =0; d<dir.length; d++){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            
            if(x>=0 && y>=0 && x<grid.length && y < grid[0].length && grid[x][y] == '1'){
                NumsOFislandDFS(grid,x,y,dir);
            }
        }
        
    }


    // 695. Max Area of Island

    public int maxAreaOfIsland(int[][] grid) {
        
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        int m = grid[0].length;
        int maxLand =0;
        
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j]== 1){
                    int area = dfs_Area(grid,i,j,dir);
                    maxLand = Math.max(area,maxLand);
                }
            }
        }
        return maxLand;
    }
    
    
    public int dfs_Area(int[][] grid, int r, int c , int [][] dir){
         int n = grid.length;
        int m = grid[0].length;
        int size =0;
        
        grid[r][c] = 0;
        for(int d =0; d<dir.length; d++){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            
            if(x>=0 && y >= 0 && x < n && y < m && grid[x][y] == 1 ){
                size +=dfs_Area(grid,x,y,dir);
            }
        }
        return size+1;
    }


    public static void main(String[] args) {
        
    }
}
