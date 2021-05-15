import java.util.*;
class shortlongpath{
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

   public static void shortlongpath(ArrayList<ArrayList<edge>> graph , int s,  int d,boolean[]visited,String psf,int csf){
    // psf == path so far 
    // csf == cost so far
    if(s==d ){
        psf+=d; 
       if(csf<mincost){
           mincost=csf;
           minpath=psf;
       }
       if(csf> maxcost){
           maxcost=csf;
           maxpath=psf;
       }
        return;
    }
    visited[ s]= true;
    for(int e=0 ;e<graph.get(s).size();e++){
        edge ce=graph.get(s).get(e);
        if(visited[ce.nbr] == false){
           shortlongpath(graph,ce.nbr,d,visited,psf+s+" -> ",csf+ce.wt);
        }
    }
    visited[s]=false;  
    }

    static int mincost= Integer.MAX_VALUE;
    static int maxcost= Integer.MIN_VALUE;
    static String minpath="";
    static String maxpath="";
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
    boolean[] visited =new boolean[graph.size()];
    shortlongpath(graph,0,6,visited,"",0);
    System.out.println(mincost+" @ "+minpath);
    System.out.print(maxcost+" @ "+maxpath);
   }


}