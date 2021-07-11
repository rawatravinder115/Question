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

    public static void count(int n, int k) {
        // int n=5,k=3;
        if (n < k)
            return;
        int[][] dp = new int[k + 1][n + 1];
        System.out.println(count_of_ways_DPMemo(n, k, dp));
        Display2d(dp);
        System.out.println(count_of_ways_DPTabu(n, k, dp));
        Display2d(dp);
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

    // leetcode 5 : longest palindromic subsequence
    public static String longestPalindromeSubstring(String str) {
        int n = str.length();
        int maxlen = 0;
        int si = 0, ei = 0;
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0)
                    dp[i][j] = gap + 1;

                if (maxlen < dp[i][j]) {
                    maxlen = dp[i][j];
                    si = i;
                    ei = j;
                }
            }
        }
        return str.substring(si, ei + 1);
    }

    public static int longestPalindromeSubseq_rec(String str, int si, int ei, int[][] dp, boolean[][] ispalindrome) {
        if (ispalindrome[si][ei])
            return dp[si][ei] = ei - si + 1;

        if (dp[si][ei] != 0)
            return dp[si][ei];

        int len = 0;
        if (str.charAt(si) == str.charAt(ei))
            len = longestPalindromeSubseq_rec(str, si + 1, ei - 1, dp, ispalindrome) + 2;
        else
            len = Math.max(longestPalindromeSubseq_rec(str, si + 1, ei, dp, ispalindrome),
                    longestPalindromeSubseq_rec(str, si, ei - 1, dp, ispalindrome));

        return dp[si][ei] = len;
    }

    public static int longestPalindromeSubseq_DP(String str, int si, int ei, int[][] dp, boolean[][] ispalindrome) {

        for (int gap = 0; gap < str.length(); gap++) {
            for (si = 0, ei = gap; ei < str.length(); si++, ei++) {

                if (ispalindrome[si][ei]) {
                    dp[si][ei] = ei - si + 1;
                    continue;
                }

                int len = 0;
                if (str.charAt(si) == str.charAt(ei))
                    len = dp[si + 1][ei - 1] + 2;
                else
                    len = Math.max(dp[si + 1][ei], dp[si][ei - 1]);

                dp[si][ei] = len;
            }
        }
        return dp[0][str.length() - 1];
    }

    // leetcode 547 :

    public int countSubstrings(String str) {
        int n = str.length();
        int count = 0;
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = 1;
                    else if (gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0)
                    dp[i][j] = gap + 1;

                count += dp[i][j] != 0 ? 1 : 0;
            }
        }
        return count;
    }

    // leetcode 115 : Distinct Subsequences
    public static int numDistinct_SubSequence(String s, String t, int n, int m, int[][] dp) {
        if (m == 0) // bcoz we can find the subseq for the "" blank also.
            return dp[n][m] = 1;
        if (m > n) // bcoz we can find the subseq for the string whose is greater than the another
                   // string
            return dp[n][m] = 0;

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        if (s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = numDistinct_SubSequence(s, t, n - 1, m - 1, dp)
                    + numDistinct_SubSequence(s, t, n - 1, m, dp);

        return dp[n][m] = numDistinct_SubSequence(s, t, n - 1, m, dp);

    }

    public static int numDistinct_SubSequence_DP(String s, String t, int n, int m, int[][] dp) {

        int N = n, M = m;
        for (n = 0; n <= N; n++) {
            for (m = 0; m <= M; m++) {
                if (m == 0) {// bcoz we can find the subseq for the "" blank also.
                    dp[n][m] = 1;
                    continue;
                }
                if (m > n) { // bcoz we can find the subseq for the string whose is greater than the another
                             // string
                    dp[n][m] = 0;
                    continue;
                }
                if (s.charAt(n - 1) == t.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + dp[n - 1][m];
                else
                    dp[n][m] = dp[n - 1][m];
            }
        }
        return dp[N][M];
    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = numDistinct_SubSequence(s, t, n, m, dp);
        // int ans = numDistinct_SubSequence_DP(s, t, n, m, dp);

        // if start from the begining
        // int ans = numDistinct_SubSequence_DP02(s, t,0 , 0, dp);
        Display2d(dp);

        return ans;

    }


}