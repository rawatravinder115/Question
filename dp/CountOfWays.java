class CountOfWays{
    public static void main(String[] args) {
        
    }

    // geeksforgeeks :
    // https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/
    public static int count_of_ways_DPMemo(int n, int k, int[][] dp) {
        if (n == k || k == 1)
            return dp[k][n] = 1;

        if (dp[k][n] != 0)
            return dp[k][n];

        int NewGroup = count_of_ways_DPMemo(n - 1, k - 1, dp);
        int ExistingGroup = count_of_ways_DPMemo(n - 1, k, dp) * k;

        return dp[k][n] = NewGroup + ExistingGroup;
    }

    public static void count(int n, int k) {
        // int n=5,k=3;
        if (n < k)
            return;
        int[][] dp = new int[k + 1][n + 1];
        System.out.println(count_of_ways_DPMemo(n, k, dp));
        // Display2d(dp);
        System.out.println(count_of_ways_DPTabu(n, k, dp));
        // Display2d(dp);
    }

    public static int count_of_ways_DPTabu(int n, int k, int[][] dp) {
        int K = k, N = n;
        for (k = 1; k <= K; k++) {
            for (n = 0; n <= N; n++) {

                if (n < k) {
                    continue;
                }

                if (n == k || k == 1) {
                    dp[k][n] = 1;
                    continue;
                }

                int NewGroup = dp[k - 1][n - 1];
                int ExistingGroup = dp[k][n - 1] * k;

                dp[k][n] = NewGroup + ExistingGroup;
            }
        }

        return dp[K][N];
    }
}