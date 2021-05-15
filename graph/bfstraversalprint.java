import java.lang.reflect.Array;
import java.util.*;
class bfstraversalprint{
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
 static class bfshelper{
     int vtx;
     String path;
     int cost;
     bfshelper(int v,String p,int wt){
         this.vtx=v;
         this.path=p;
         this.cost=wt;
     }
 }
   public static void bfstraversal(ArrayList<ArrayList<edge>> graph,int s){
    Queue<bfshelper> qu=new LinkedList<>();   
    boolean[] visited=new boolean[graph.size()];
    qu.add(new bfshelper(s, ""+s+"-> ", 0));
    visited[s]=true;
    while(qu.size() >0){
        bfshelper cv=qu.remove();
        System.out.println(cv.path +" @ "+ cv.cost);
        for( int e =  0 ; e < graph.get(cv.vtx).size() ; e++ ){
            edge ce = graph.get(cv.vtx).get(e);
            if( visited[ce.nbr] == false ){
                visited[ce.nbr] = true;
                qu.add( new bfshelper( ce.nbr, cv.path + ce.nbr+" -> ",cv.cost+ce.wt) );
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
    addedge(graph,3,4,2); 
    addedge(graph,4,5,3);
    addedge(graph,5,6,3);
    addedge(graph,4,6,8);
    bfstraversal(graph,0);
   }
}