class lt1791{
   
        public int findCenter(int[][] edges) {
        int x = edges[0][0], y = edges[0][1];
        return (y == edges[1][0] || y == edges[1][1]) ? y : x;
    }

}