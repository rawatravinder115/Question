#include<iostream>
#include<vector>
using namespace std;

class Edge{
    public:
    int v , w = 0 ;
    Edge(int v , int w){
        this->v = v ;
        this->w = w ; 
    }
};
// int n = 7 ;
// // vector<vector<Edge*>>graph;
// vector<vector<Edge*>> graph(n, vector<Edge*>());
// void addEdge(vector<vector<Edge*>> &gp , int v ,int u , int w){
//     gp[u].push_back(new Edge(u,w));
//      gp[v].push_back(new Edge(u,w));
// }

// void display(vector<vector<Edge*>> &gp){
//      for(int i = 0 ; i < gp.size() ; i++){
//          cout<<i<<"->";
//          for(Edge *e : gp[i]){
//              cout<<"(" << e->v <<","<< e->w <<"),";
//          }
//          cout<<endl;
//      }
//     cout<<endl;
//  }

 //****************************************************************
 int n = 7 ;
 vector<vector<Edge>> graph(n, vector<Edge>());
void addEdge(vector<vector<Edge>> &gp , int v ,int u , int w){
    gp[u].push_back( Edge(v,w));
     gp[v].push_back( Edge(u,w));
}

void display(vector<vector<Edge>> &gp){
     for(int i = 0 ; i < gp.size() ; i++){
         cout<<i<<"->";
         for(Edge e : gp[i]){
             cout<<"(" << e.v <<","<< e.w <<"),";
         }
         cout<<endl;
     }
    cout<<endl;
 }

 int findEdge(int v1  ,int v2 ){
     int i=0;
     for(i=0; i < graph[v1].size() ; i++){
         Edge e=graph[v1][i];
         if(e.v == v2){
             break;
         }
     }
     return i;
 }

void removeEdge(int u , int v){
    int idx1=findEdge(u,v);
    int idx2=findEdge(v,u);

    graph[u].erase(graph[u].begin()+ idx1);
    graph[v].erase(graph[v].begin()+ idx2);

}
 void removeVertex(int vtx){
    while(graph[vtx].size() !=0){
        // int vtx2 = graph[vtx][graph[vtx].size()-1];

        Edge e = graph[vtx].back();
        removeEdge(vtx , e.v);
    }
}
bool hasPath(int src  , int dest , vector<bool> vis){
    if(src == dest)
    return true;

    vis[src] = true; 
    bool res = false;
    for(Edge e : graph[src]){
        if(!vis[e.v])
        res = res || hasPath(e.v, dest , vis);
    }
    return res;
    // return false;
}

int AllhasPath(int src  , int dest , vector<bool> &vis, int w ,string ans){
    if(src == dest){
        cout<<ans<<dest<<" @ "<<w<<endl;
    return 1;
    }

    vis[src] = true; 
    int count= 0;
    for(Edge e : graph[src]){
        if(!vis[e.v])
        count+=AllhasPath(e.v, dest , vis, w+e.w , ans+to_string(src)+" ");
    }
    vis[src]=false;
    return count;
}
void preOrder(int src , vector<bool >&vis , int w ,string ans){
    vis[src] =true;
    cout<<ans<<" @ "<<w<<endl;
    for(Edge e : graph[src])
      if(!vis[e.v])
        preOrder(e.v , vis , w+ e.w , ans+to_string(e.v)+" ");
    
    vis[src] =false;
}

class allsolutionPair{
    public:
    int lightw=1e7;
    int heavyw=0;
    int ceil =1e7;
    int floor=0;
};
void Allsolution(int src  , int dest , vector<bool> &vis, int w ,string ans , allsolutionPair &pair ,int data){
    if(src == dest){
        cout<<ans<<dest<<endl;
        pair.heavyw=max(pair.heavyw,w);
        pair.lightw=min(pair.lightw,w);

        if(data < w){
            pair.ceil = min(pair.ceil, w);
        }
        if(data > w){
            pair.floor = max(pair.floor , w);
        }

    return ;
    }

    vis[src] = true; 
    for(Edge e : graph[src]){
        if(!vis[e.v])
        Allsolution(e.v, dest , vis, w+e.w , ans+to_string(src)+" " , pair , data );
    }
    vis[src]=false;
}

void constructgraph(){

    // for(int i=0;i<N;i++){
    //     vector<Edge*> a;
    //      graph.push_back(a);
    //  }
    addEdge(graph, 0, 1, 10);
    addEdge(graph, 0, 3, 10);
    addEdge(graph, 1, 2, 10);
    addEdge(graph, 2, 3, 40);
    addEdge(graph, 3, 4, 2);
    addEdge(graph, 4, 5, 2);
    addEdge(graph, 4, 6, 3);
    addEdge(graph, 5, 6, 8);
    display(graph);
    cout<<endl;
}

void set1(){
    // removeEdge(4,3);
    // removeVertex(3);
    // display(graph);
    vector<bool> vis(n ,false);
    // cout<<hasPath(0,6,vis)<<endl;
    // cout<<AllhasPath(0,6,vis,0,"");
    // preOrder(0 , vis , 0 ,to_string(0)+"");
    allsolutionPair pair;
    Allsolution(0 ,6,vis,0,"", pair ,30);
    cout<<pair.heavyw<<"->"<<pair.lightw<<"->"<<pair.ceil<<"->"<<pair.floor <<endl;
}
void solve(){
    constructgraph();
    set1();
}

int main(){
    solve();
}