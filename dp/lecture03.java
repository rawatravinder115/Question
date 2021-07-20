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

    public int countps_DP(String s, int i, int j, int[][] dp) {

        int n = s.length();
        for (int gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; j++, i++) {

                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (dp[i][j] != 0)
                    return dp[i][j];
                    int middleString = dp[i + 1][j - 1];
                int excludingLast = dp[i][j - 1];
                int excludingFirst = dp[i + 1][j];
                int ans = excludingFirst + excludingLast;
                dp[i][j] = (s.charAt(i) == s.charAt(j) ? ans + 1 : ans - middleString);
            }
        }
        return dp[0][n - 1];
    }

    public static void solve() {
        String s = "GeeksforGeeks";
        String t = "GeeksQuiz";

}