

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



    public static void main(String[] args) {
        
    }
}
