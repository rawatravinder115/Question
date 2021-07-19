class lecture03{
    public static void main(String[] args) {
        
    }

    // Count Palindromic Subsequences
    public int countps(String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (i == j)
            return dp[i][j] = 1;

        if (dp[i][j] != 0)
            return dp[i][j];
            int middleString = countps(s, i + 1, j - 1, dp);
        int excludingLast = countps(s, i, j - 1, dp);
        int excludingFirst = countps(s, i + 1, j, dp);

        int ans = excludingFirst + excludingLast;
        return dp[i][j] = (s.charAt(i) == s.charAt(j) ? ans + 1 : ans - middleString);

    }
}