class lt1791{

    // leetcode 1791 -> Find Center of Star Graph 
   
        public int findCenter01(int[][] edges) {
        int x = edges[0][0], y = edges[0][1];
        return (y == edges[1][0] || y == edges[1][1]) ? y : x;
    }

    public int findCenter02(int[][] edges) {
    
        int n =edges.length;
        int[] countnode= new int[n+2];
        
//         Since, It is given that graph has n vertex and n-1 edges, so (n-1+2) = (n+1) (length of vertex degree array which means this array contains vertex up to n.
// For example -> edges = [[1,2],[2,3],[4,2]] vertexes are -> (1, 2, 3, 4) -> edge length = 3 and size of array = 5 which contains vertex up to number 4.
// Note : Here is no meaning of vertex number zero so its degree also will be zero which does not affect our solution.


        
        for(int i=0 ; i < edges.length;i++){
             countnode[edges[i][0]]++;
             countnode[edges[i][1]]++;
        }
        int centernode =0;
        for(int i=0;i<countnode.length;i++){
            if(countnode[i] == n){
                centernode = i;
            }
        }
        return centernode;
    }
}