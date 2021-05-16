import java.util.*;
class dijkstraAlgo{

    static class edge{
        int src; // source 
        int nbr; // neoubor
        int wt;  // weight
        edge(int v1,int v2, int wt){
            this.src=v1;
            this.nbr=v2;
            this.wt=wt;
        }
    }
   public static void addedge(ArrayList<ArrayList<edge>> graph, int src , int nbr,int wt){
     
    graph.get(src).add(new edge(src,nbr,wt));
    graph.get(nbr).add(new edge(nbr,src,wt));
   }
// interface == a contract to fnuction 
   static class bfshelper implements Comparable<bfshelper>{
    int vtx;
    String path;
    int cost;
    bfshelper(int v,String p,int wt){
        this.vtx=v;
        this.path=p;
        this.cost=wt;
    }
    public int compareTo(bfshelper other){
        // if(this.cost == other.cost){
        //     return this.vtx-other.vtx;
        // }else{
        return this.cost - other.cost;
        //}
    }
}
// Collections.reverseOrder for max order this block of priortyqueue <>
     public static void   dijkstra(ArrayList<ArrayList<edge>> graph, int s){
         PriorityQueue<bfshelper> pq=new PriorityQueue<>();
        // PriorityQueue<bfshelper> pq=new PriorityQueue<>(Collection.reverseOrder);
        // for max priortyqueue
         boolean[] visited=new boolean[graph.size()];
         bfshelper root = new bfshelper(s, ""+s, 0); 
         // "" if we put this in front of int type it will convert into string 
        pq.add(root);
        while( pq.size()> 0){
            // remove
            bfshelper cv =pq.remove();
         // mark
            if(visited[cv.vtx] == true){
                continue;
            }else{
                visited[cv.vtx]= true;
            }
            // work
            System.out.println(cv.path+ " @ " + cv.cost);
            for(int i=0;i<graph.get(cv.vtx).size();i++){
                edge ce= graph.get(cv.vtx).get(i);
                if(visited[ce.nbr] == false){
                    bfshelper newvtx= new bfshelper(ce.nbr,cv.path+" -> "+ce.nbr, cv.cost+ce.wt);
                    pq.add(newvtx);
                }
            }
        }
     }    

    public static void main(String[] args) {
        ArrayList<ArrayList<edge>> graph= new ArrayList<>();
        for(int i=0;i<=6;i++){
            graph.add(new ArrayList<edge>());
        }
        addedge(graph,0,1,10);
        addedge(graph,0,3,40);
        addedge(graph,1,2,10);
        addedge(graph,2,3,10);
        addedge(graph,2,5,20); 
        addedge(graph,3,4,2); 
        addedge(graph,4,5,3);
        addedge(graph,5,6,3);
        addedge(graph,4,6,8);
        // boolean[] visited =new boolean[graph.size()];
        dijkstra(graph, 0);
    }
}