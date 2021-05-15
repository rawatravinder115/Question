import java.util.*;
class Kthlargepath{
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

   static int ceilcost=Integer.MAX_VALUE;
   static int floorcost=Integer.MIN_VALUE;
   static String ceilpath="";
   static String floorpath="";

   public static void ceilfloor(ArrayList<ArrayList<edge>> graph , int s,  int d,boolean[]visited,String psf,int csf,int factor){
    if(s==d ){
        psf+=d; 
       if(csf > factor){
           if(ceilcost>csf){
               ceilcost=csf;
               ceilpath=psf;
           }
       }
       if(csf < factor){
          if(csf > floorcost) {
               floorcost=csf;
           floorpath=psf;
        }
       }
        return;
    }
    visited[ s]= true;
    for(int e=0 ;e<graph.get(s).size();e++){
        edge ce=graph.get(s).get(e);
        if(visited[ce.nbr] == false){
           ceilfloor(graph,ce.nbr,d,visited,psf+s+" -> ",csf+ce.wt,factor);
        }
    }
    visited[s]=false;  
    }
   public static void Kthlargestpath(ArrayList<ArrayList<edge>> graph , int s,  int d,int k){
      int factor = Integer.MAX_VALUE;
    boolean[] visited= new boolean[graph.size()];
      for(int i=0;i<k;i++){ 
       floorcost=Integer.MIN_VALUE;
       ceilfloor(graph, 0, 6, visited,"", 0, factor);
       factor=floorcost;
}
System.out.println("floor ="+floorcost+" @ "+ floorpath);
       
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
    boolean[] visited =new boolean[graph.size()];
    // ceilfloor(graph,0,6,visited,"",0,45);
    // System.out.println(ceilcost+" @ "+ceilpath);
    // System.out.print(floorcost+" @ "+floorpath);
    Kthlargestpath(graph,0,6,2);

   }
}