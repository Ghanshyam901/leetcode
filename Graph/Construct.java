import java.util.ArrayList;


public class Construct {
    public static class Edge{
        int v;
        int w;

        Edge(int v, int w){
            this.v = v;
            this.w = w;

        }
    }
    

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
    }

    public static void Display(ArrayList<Edge> [] graph, int v, int w){
        for(int i =0; i<v; i++){
            System.out.println(i +"->");
            for(Edge e : graph[i]){
                System.out.println("(" + e.v +", "+ e.w +")");

            }
            System.out.println();

        }
    }

    public static int findEdge(ArrayList<Edge> [] graph, int u, int v){
        for(int i =0; i<graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v){
                return i;
            }
        }

        return -1;
    }
  

    public static void removeEdge(ArrayList<Edge> [] graph, int u, int v){
         int idx1 = findEdge(graph, u, v);
         graph[u].remove(idx1);

         int idx2 = findEdge(graph, v, u);
         graph[v].remove(idx2);
    }

    public static void removeVtx(ArrayList<Edge> [] graph, int u){
        for(int i = graph[u].size(); i>=0; i--){
            Edge e = graph[u].get(i);
            removeEdge(graph, u, e.v);
        }
    }
    @SuppressWarnings("unchecked")  // FOR REMOVING EROOR MSG 
    public static void constructGraph() {
        int V = 7;
     
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i =0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);

        // addEdge(graph, 2, 7, 2);
        // addEdge(graph, 2, 8, 4);
        // addEdge(graph, 7, 8, 3);

        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        addEdge(graph, 0, 6, 3);

    }

    public static void main(String[] args) {
        
    }
    
}
