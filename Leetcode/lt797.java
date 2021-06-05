
class lt797{

// 6ms

public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
    int n = graph.length-1;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    path.add(0);
    
    boolean [] vis = new boolean[n+1];
    
    dfs(graph,0,n,path,ans,vis);
    
    return ans;
}

public static void dfs(int[][] gp,int src ,int dst,List<Integer> path,
                       List<List<Integer>> ans,boolean[] vis)
{
    
    if(src == dst){
        List<Integer> list=new ArrayList<>(path);
        ans.add(list);
        return;
    }
    
    vis[src]=true;
    for(int i : gp[src]){
        if(!vis[i]){
            path.add(i);
            dfs(gp,i,dst,path,ans,vis);
            path.remove(path.size()-1);
        }
    }
    
    vis[src]=false;
}

//

}