import java.util.*;
class pathprint{
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

   public static void path(ArrayList<ArrayList<edge>> graph , int s,  int d,boolean[]visited,String str){
   if(s==d ){
       str+=d; 
       System.out.println(str);
       return;
   }
   visited[ s]= true;
   for(int e=0 ;e<graph.get(s).size();e++){
       edge ce=graph.get(s).get(e);
       if(visited[ce.nbr] == false){
          path(graph,ce.nbr,d,visited,str+s+" -> ");
       }
   }
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
    addedge(graph,3,4,2);
    addedge(graph,4,5,3);
    addedge(graph,5,6,3);
    addedge(graph,4,6,8);
    boolean[] visited =new boolean[graph.size()];
    path(graph,0,6,visited,"");
   }
}