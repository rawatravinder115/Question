import java.util.*;
class hamiltonianpath{
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

   public static void pathAndcycle(ArrayList<ArrayList<edge>> graph ,int s, ArrayList<Integer> psf,boolean[] visited,int os){
  if(psf.size() == graph.size()-1){
      psf.add(s);
      for(int i=0;i<psf.size();i++){
          System.out.print(psf.get(i)+" ");
      }
      boolean iscycle=false;
      for(int e=0; e<graph.get(s).size();e++){
          edge ce=graph.get(s).get(e);
          if(ce.nbr == os){
              iscycle= true;
              break;
          }
      }
      if(iscycle ){
          System.out.println(".");
      }
      System.out.println();
      psf.remove(psf.size()-1);
      return;
  }
    visited[s]= true;
    psf.add(s);
    for(int e=0;e<graph.get(s).size();e++){
        edge ce=graph.get(s).get(e);
      if(visited[ce.nbr] == false) {
            pathAndcycle(graph,ce.nbr,psf,visited,os);
        }
    }

    psf.remove(psf.size()-1);
    visited[s]=false;
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
    addedge(graph,2,5,20); // for hamiltanion cycle 
    addedge(graph,3,4,2);
    addedge(graph,4,5,3);
    addedge(graph,5,6,3);
    addedge(graph,4,6,8);
    boolean[] visited =new boolean[graph.size()];
    ArrayList<Integer> ans=new ArrayList<>();
    pathAndcycle(graph,0,ans,visited,0);
   }
}