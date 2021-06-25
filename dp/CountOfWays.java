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
}