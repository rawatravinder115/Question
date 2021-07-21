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
        int[][] dp = new int[s.length()][t.length()];
        System.out.println(longestCommonSubstring(s, t, 0, 0, dp));
        // System.out.println(longestCommonSubstring_DP(s, t, 0, 0, dp));
        Display2d(dp);
    }

    public static void leetcode() {
        // int[] a = { 1, 3, 7, 1, 7, 5 };
        // int[] b = { 1, 9, 2, 5, 1 };
        // System.out.println(maxUncrossedLines(a, b));

        int[] a = { 2, 1, -2, 5 };
        int[] b = { 3, 0, -6 };
int[][] dp = new int[a.length + 1][b.length + 1];
        System.out.println(maxUncrossedLines_DP(a, b, 0, 0, dp));
    }

    public static void coin() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        int[] dp = new int[tar + 1];
        // int ans=coinChangePermutation(arr, tar, dp);
        // int ans = coinChangePermutation_DP(arr, tar, dp);
        int ans = coinChangeCombination_DP(arr, tar, dp);
        Display1d(dp);
        System.out.println(ans);
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

    public static int longestCommonSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        return longestCommonSubsequence01(s, t, n, m, dp);
    }
}

