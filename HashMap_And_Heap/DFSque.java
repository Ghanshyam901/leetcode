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

    //// 130

    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(i == 0 || j == 0 || n-1 == i || m-1 == j ){
                    if(grid[i][j] == 'O'){
                        DFS_surrounded(grid,i,j,dir);
                    }
                }
            }
        }
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == '#'){
                    grid[i][j] = 'O';
                }else if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void DFS_surrounded(char [][] grid, int i, int j, int [][] dir){
        grid[i][j] = '#';
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int d=0; d<dir.length; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >=0 && c>= 0 && r < n && c < m && grid[r][c] == 'O' ){
                DFS_surrounded(grid,r,c,dir);
            }
        }
        
    }

    // Number Of Distinct Island
    public static void dfs(int [][] arr , int row, int col){
        arr[row][col] = 0;
        
        if(row-1 >= 0 && arr[row-1][col] == 1){
            psf.append("u");
            dfs(arr,row-1,col);
        }
        
        if(col +1 <arr[0].length && arr[row][col+1] ==1){
            psf.append("r");
            dfs(arr, row,col+1);
        }
        
        if(row + 1 < arr.length && arr[row+1][col] == 1 ){
            psf.append("d");
            dfs(arr,row+1,col);
        }
        if(col - 1 >= 0 && arr[row][col-1] == 1){
            psf.append("l");
            dfs(arr,row,col-1);
        }
        psf.append("z");
        
        
    }
    public static StringBuilder psf = new StringBuilder();
    
    public static int numberofDistinctIslands(int[][] arr) {
      //write your code here
      
      HashSet<String> set = new HashSet<>();
      
      
      for(int i = 0; i< arr.length; i++){
          for(int j =0; j<arr[0].length; j++){
              if(arr[i][j] == 1){
                  psf = new StringBuilder();
                  psf.append("x");
                  dfs(arr,i,j);
                  set.add(psf.toString());
                  
              }
          }
      }
      return set.size();
    }
    public static void main(String[] args) {
        
    }
}
