class lecture02{
    public static void main(String[] args) {
        
    }


    public static void leetcode() {
        String s = "babgbag";
        String t = "bag";

        System.out.println(numDistinct(s, t));

    }

    public static void Display1d(int[] dp) {
        for (int i : dp)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void Display2d(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // substring and subsequence ====================
    public static boolean[][] isPalindromeSubstring(String str) {

        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = true;
                else
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
            }
        }
        return dp;
    }

    // geeksforgeeks: https://www.geeksforgeeks.org/gold-mine-problem/
    public static int goldmine_DPMemo(int sr, int sc, int[][] gold, int[][] dp) {

        if (sc == gold[0].length - 1)
            return dp[sr][sc] = gold[sr][sc];

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
        int maxgold = 0;
        for (int d = 0; d < dir.length; d++) {

            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x < gold.length && y < gold[0].length) {
                maxgold = Math.max(maxgold, goldmine_DPMemo(x, y, gold, dp));
            }
        }

        return dp[sr][sc] = maxgold + gold[sr][sc];
    }

    public static int goldmine_DPTabu(int sr, int sc, int[][] gold, int[][] dp) {

        for (sc = gold[0].length - 1; sc >= 0; sc--) {
            for (sr = gold.length - 1; sr >= 0; sr--) {

                if (sc == gold[0].length - 1) {
                    dp[sr][sc] = gold[sr][sc];
                    continue;
                }

                int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
                int maxgold = 0;
                for (int d = 0; d < dir.length; d++) {

                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];

                    if (x >= 0 && y >= 0 && x < gold.length && y < gold[0].length) {
                        maxgold = Math.max(maxgold, dp[x][y]);
                    }
                }

                dp[sr][sc] = maxgold + gold[sr][sc];
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public static int count_of_ways_DPMemo(int n, int k, int[][] dp) {
        if (n == k || k == 1)
            return dp[k][n] = 1;

        if (dp[k][n] != 0)
            return dp[k][n];

        int NewGroup = count_of_ways_DPMemo(n - 1, k - 1, dp);
        int ExistingGroup = count_of_ways_DPMemo(n - 1, k, dp) * k;

        return dp[k][n] = NewGroup + ExistingGroup;
    }
}