

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

    //463. Island Perimeter

    public int islandPerimeter(int[][] grid) {
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        int m = grid[0].length;
        
        int onesCount =0;
        int nbrsCount =0;
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 1){
                    onesCount++;
                    
                    for(int d =0; d<dir.length; d++){
                        int r = i+ dir[d][0];
                        int c = j+dir[d][1];
                        
                        if( r >=0 && c >= 0 && r<n && c < m && grid[r][c] == 1){
                            nbrsCount++;
                        }
                    }
                }
            }
        }
        
        return 4 * onesCount - nbrsCount;
    }


    ///130. Surrounded Regions

    public void solve(char[][] grid) {
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        int m = grid[0].length;
        
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                
                   if(i ==0 || j == 0 || i == n-1 || j == m-1 ){
                    if(grid[i][j] == 'O'){
                        DFS_REGION(grid,i,j,dir);
                    }
                    
                }
            }
        }
            
            
            for(int i=0; i<n; i++){
                for(int j =0; j<m; j++){
                    if(grid[i][j] == 'O'){
                        grid[i][j] = 'X';
                    }else if(grid[i][j] == '#'){
                        grid[i][j] = 'O';
                    }
                }
            }
        }
    
    
    
    public void DFS_REGION(char[][] grid, int i, int j, int [][] dir){
        
        grid[i][j] ='#';
           int n = grid.length;
        int m = grid[0].length;
        
        for(int d = 0; d< dir.length; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 'O'){
                DFS_REGION(grid,r,c,dir);
            }
        }
        
    }


    public static void main(String[] args) {
        
    }
}
