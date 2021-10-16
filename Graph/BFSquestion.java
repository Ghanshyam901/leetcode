import java.sql.Array;
import java.util.LinkedList;
import java.util.Arrays;


public class BFSquestion {
    
    //785
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int [] vis = new int[n];
        Arrays.fill(vis,-1);
        
        for(int i =0; i<n; i++){
            if(vis[i] == -1 && !BFS_isBiparite(graph,i,vis) ){
                return false;
            }
        }
        return true;
    }
    public boolean BFS_isBiparite(int [][] graph, int src, int [] vis){
        
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        
        int markColor = 0;
        while(que.size() != 0){
            int size = que.size();
            
            while(size-- > 0){
                int rmv = que.removeFirst();
                if(vis[rmv] != -1){
                    if(markColor != vis[rmv]){
                        return false;
                    }
                    continue;
                }
                vis[rmv] = markColor;
                for(int v : graph[rmv]){
                    if(vis[v] == -1){
                        que.addLast(v);
                    }
                }
            }
            markColor = (markColor+1)%2;
        }
        return true;
    } 


    // =============================
    // 994
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<Integer> que = new LinkedList<>();
        
        int time =0; 
        int orangeCount =0;
        int min =0;
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 2){
                  que.addLast(i*m+j);
                }else if(grid[i][j] == 1){
                    orangeCount++;
                }
            }
        }
        
        if(orangeCount ==0 ) return 0;
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(que.size() != 0){
            int size = que.size();
            
            while(size-- > 0){
                int rmidx = que.removeFirst();
                int sr = rmidx /m;
                int sc = rmidx % m;
                
                for(int d =0; d<dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r >=0 && c>=0 && r<n && c < m && grid[r][c] == 1){
                        grid[r][c] = 2;
                        que.addLast(r *m +c);
                        orangeCount--;
                        if(orangeCount == 0) return time +1;
                    }
                }
            }
            time++;
        }
        return -1;
        
    }

    ///====
    // 1091
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length ==0) return 0;
        
         int n = grid.length;
         int m = grid[0].length;
         // if(n == 0 || m == 0) return 0;
         if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        
         int Spath = 1;
        LinkedList<Integer> que = new LinkedList<>();
        int [][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        
        que.addLast(0);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rmidx = que.removeFirst();
                int sr = rmidx/m;
                int sc  = rmidx % m;
                
                if(sr == n-1 && sc == m-1){
                 return Spath;
                }
                
                for(int d =0; d<dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r >=0 && c>=0 && r<n && c<m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        que.addLast(r*m+c);
                        
                    }
                }
                
            }
            Spath++;
        }
        
        return -1;
    }
/// 542

public int[][] updateMatrix(int[][] mat) {
        
    if(mat.length == 0 || mat[0].length ==0) return mat;
    int n = mat.length; 
    int m = mat[0].length;
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] vis = new boolean[n][m];
    LinkedList<Integer> que = new LinkedList<>();
    
    for(int i =0; i<n; i++){
        for(int j =0; j<m; j++){
            if(mat[i][j] == 0){
                que.addLast(i*m+j);
                vis[i][j] = true;
            }
        }
    }
    
    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int rmidx = que.removeFirst();
            int sr = rmidx / m;
            int sc = rmidx % m;
            
            for(int d =0; d<dir.length; d++){
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];
                
                if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
                    mat[r][c] = mat[sr][sc]+1;
                    vis[r][c] = true;
                    que.addLast(r * m + c);
                    
                }
            }
        }
    }
    return mat;
}



    public static void main(String[] args) {
        
    }
}
