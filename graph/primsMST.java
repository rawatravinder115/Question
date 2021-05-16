import java.util.*;
class primsMST{
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
   static class primshelper implements Comparable<primshelper>{
       int vtx;
       int par;
       int wt;
       primshelper(int v,int p,int dis){
           this.vtx=v;
           this.par=p;
           this.wt=dis;
       }
       public int compareTo(primshelper other ){
           return this.wt - other.wt;
       }
   }
   public static void prims(ArrayList<ArrayList<edge>>graph){
       ArrayList<ArrayList<edge>> mst= new ArrayList<>();
       for(int i=0;i<graph.size();i++){
           mst.add(new ArrayList<edge>());
       }
       PriorityQueue<primshelper> pq=new PriorityQueue<>();
       primshelper rootnode=new primshelper(2, -1,0);
       pq.add(rootnode);
       boolean[] visited =new boolean[graph.size()];
       while( pq.size()> 0){
        // remove
        primshelper cv =pq.remove();
     // mark
        if(visited[cv.vtx] == true){
            continue;
        }else{
            visited[cv.vtx]= true;
        }
        if(cv.par != -1){
            addedge(mst,cv.vtx, cv.par, cv.wt);
        }
        for(int i=0;i<graph.get(cv.vtx).size();i++){
            edge ce= graph.get(cv.vtx).get(i);
            if(visited[ce.nbr] == false){
                primshelper newvtx= new primshelper(ce.nbr,cv.vtx,ce.wt);
                pq.add(newvtx);
            }
        }
    }
    display(mst);
 }    
 public static void display(ArrayList<ArrayList<edge>> graph){
    for(int i=0;i<graph.size();i++){
        System.out.print(i+" ->");
        for(int j=0;j<graph.get(i).size();j++){
            edge ce= graph.get(i).get(j);
            System.out.print("["+ce.nbr+" @ "+ce.wt+"],");
        }
        System.out.println();
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
        addedge(graph,0,6,30);
        prims(graph);
    }
}