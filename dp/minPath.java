class minPath{
    public static void main(String[] args) {
        
    }

    // leetcode 46 :Minimum Path Sum
    public static int minpath_DPTabu(int sr, int sc, int[][] dp, int[][] grid) {

        for (sr = grid.length - 1; sr >= 0; sr--) {
            for (sc = grid[0].length - 1; sc >= 0; sc--) {
                if (sr == grid.length - 1 && sc == grid[0].length - 1) {
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }

                int mincost = (int) 10e8;
                if (sr + 1 < grid.length)
                    mincost = Math.min(mincost, dp[sr + 1][sc]);
                if (sc + 1 < grid[0].length)
                    mincost = Math.min(mincost, dp[sr][sc + 1]);

                dp[sr][sc] = mincost + grid[sr][sc];
            }
        }
        return dp[0][0];
    }
}