import java.util.ArrayList;
public class basic{

    public static class Edge{
        int v =0;
        int w= 0;
        Edge(int v ,int w ){
            this.v = v;
            this.w = w;
        }
    }

    public static int n=7;
    public static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        Construct();
    }

    public static void Construct(){
        graph = new  ArrayList<>();
        for (int i = 0; i < n ; i++) {
            graph.add(new ArrayList<Edge>());
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 3);
        addEdge(graph, 5, 6, 8);
        display(graph);
    }

    public static void display(ArrayList<ArrayList<Edge>> gp){
        for (int i = 0; i < gp.size() ; i++) {
            System.out.print( i + "->");
            for (Edge e : graph.get(i)) {
                System.out.print("("+ e.v + ","+ e.w+")");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void addEdge(ArrayList<ArrayList<Edge>> gp ,int u, int v ,int w ){
        gp.get(u).add(new Edge(v,w));
        gp.get(v).add(new Edge(u,w));
    }
}