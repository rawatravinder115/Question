import java.util.ArrayList;

class graphBasic {

    public static class Edge {
        int v, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int n = 7;
    public static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        constructgraph();
        display(graph);
        // System.out.println(findEdge(3,4));
        // removeEdge(3,4);
        // display(graph);
        // removeVertex(3);
        // display(graph);
        boolean[] vis = new boolean[n];
        // System.out.println(haspath(0,6,vis));
        // System.out.println(hasAllpath(0,6,vis,0,""));
        // preorder(0,vis,0,"");
        AllSolution pair = new AllSolution();
        CeilandFloor(0, 6, vis, 0, "", pair, 30);
        System.out.println(pair.heavyw + "->" + pair.lightw + "->" + pair.ceil + "->" + pair.floor);

    }

    public static void constructgraph() {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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

    public static void addEdge(ArrayList<ArrayList<Edge>> gp, int u, int v, int w) {
        gp.get(u).add(new Edge(v, w));
        gp.get(v).add(new Edge(u, w));
    }

    public static void display(ArrayList<ArrayList<Edge>> graph) {

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for (Edge e : graph.get(i)) {
                System.out.print("(" + e.v + "," + e.w + "),");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findEdge(int v1, int v2) {
        int i = 0;
        for (i = 0; i < graph.size(); i++) {
            Edge e = graph.get(v1).get(i);
            if (e.v == v2)
                break;
        }
        return i;
    }

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);
        graph.get(u).remove(idx1);
        graph.get(v).remove(idx2);
    }

    public static void removeVertex(int vtx) {
        // int i=0;
        while (graph.get(vtx).size() != 0) {
            int i = graph.get(vtx).size() - 1;
            Edge e = graph.get(vtx).get(i);
            removeEdge(vtx, e.v);
        }
    }

    public static boolean haspath(int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        boolean res = false;
        for (Edge e : graph.get(src)) {
            if (!vis[e.v])
                res = res || haspath(e.v, dest, vis);
        }
        return res;
    }

    public static int hasAllpath(int src, int dest, boolean[] vis, int w, String ans) {
        if (src == dest) {
            System.out.println(ans + dest + " @ " + w);
            return 1;
        }
        vis[src] = true;
        int count = 0;
        for (Edge e : graph.get(src)) {
            if (!vis[e.v]) {
                count += hasAllpath(e.v, dest, vis, w + e.w, ans + src + " ");
            }
        }
        vis[src] = false;
        return count;
    }

    public static void preorder(int src, boolean[] vis, int w, String ans) {

        vis[src] = true;
        System.out.println(ans + " @ " + w);
        for (Edge e : graph.get(src)) {
            if (!vis[e.v]) {
                preorder(e.v, vis, w + e.w, ans + e.v + " ");
            }
        }
        vis[src] = false;
    }

    public static class AllSolution {
        int lightw = (int) 1e7;
        int heavyw = 0;
        int ceil = 0;
        int floor = (int) 1e7;
    }

    public static void CeilandFloor(int src, int dest, boolean[] vis, int w, String ans, AllSolution pair, int data) {
        if (src == dest) {
            pair.heavyw = Math.max(pair.heavyw, w);
            pair.lightw = Math.min(pair.lightw, w);

            if (data < w) {
                pair.ceil = Math.min(pair.ceil, w);
            }
            if (data > w) {
                pair.floor = Math.max(pair.floor, w);
            }
            return;
        }
        vis[src] = true;
        for (Edge e : graph.get(src)) {
            if (!vis[e.v])
                CeilandFloor(e.v, dest, vis, w + e.v, ans + src, pair, data);
        }
        vis[src] = false;
    }
}