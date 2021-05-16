import java.util.*;
class connectedcomponent{
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

   public static void getcomponent(ArrayList<ArrayList<edge>> graph,ArrayList<Integer> comp,boolean[] visited,int s){
       visited[s] = true;
       comp.add(s);
       for(int e=0;e<graph.get(s).size();e++){
           edge ce=graph.get(s).get(e);
           if(visited[ce.nbr] == false){
               getcomponent(graph, comp, visited, ce.nbr);
           }
       }
   }
   public static int contcomp(ArrayList<ArrayList<edge>> graph){
       boolean[] visited=new boolean[graph.size()];
       int count=0;
       for(int v=0;v<graph.size();v++){
           if(visited[v] == false){
               count++;
               ArrayList<Integer> singlecomp=new ArrayList<>();
               getcomponent(graph,singlecomp,visited,v);
               System.out.println(singlecomp);
           }
       }
      return count;
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
    // addedge(graph,2,5,20); // for hamiltanion cycle 
    // addedge(graph,3,4,2); // for this question
    addedge(graph,4,5,3);
    addedge(graph,5,6,3);
    addedge(graph,4,6,8);
    // boolean[] visited =new boolean[graph.size()];
   int comp= contcomp(graph);
   System.out.print(comp);

    }
}