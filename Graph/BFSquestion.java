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




    public static void main(String[] args) {
        
    }
}
