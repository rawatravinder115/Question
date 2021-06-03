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

int n = 8;
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
int Gcc_DFS(int src ,vector<bool> &vis){
    vis[src] =true;
    int count = 0 ;
    for(Edge e : graph[src]){
        if(!vis[e.v]){
            count+=Gcc_DFS(e.v , vis);
        }
    }
    return count+1;
}

 int Gcc(){
    vector<bool> vis(n, false);
    int count= 0; 
    int maxSize = 0;
    for(int i = 0;i < n; i++){
        if(!vis[i]){
            count++;
            maxSize = max(maxSize  , Gcc_DFS(i, vis));
        }
    }
    cout<<maxSize<<endl;
    return count;
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
    // addEdge(graph, 3, 4, 2);
    addEdge(graph, 4, 5, 2);
    addEdge(graph, 4, 6, 3);
    addEdge(graph, 5, 6, 8);
    // addEdge(graph, 2,5,2);
    display(graph);
    cout<<endl;
}


int main(){
    constructgraph();
    cout<<Gcc()<<endl;
}