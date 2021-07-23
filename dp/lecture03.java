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

    public static int longestCommonSubsequence01(String s, String t, int i, int j, int[][] dp) {

        if (i == s.length() || j == t.length())
            return dp[i][j] = 0;

        if (dp[i][j] != 0)
            return dp[i][j];

            int ans = 0;
            if (s.charAt(i) == t.charAt(j)) {
                ans = longestCommonSubsequence01(s, t, i + 1, j + 1, dp);
            } else {
                ans = Math.max(longestCommonSubsequence01(s, t, i + 1, j, dp),
                        longestCommonSubsequence01(s, t, i, j + 1, dp));
            }
    
            return dp[i][j] = ans;
        }

        public static int longestCommonSubsequence_DP(String s, String t, int i, int j, int[][] dp) {

            for (i = s.length(); i >= 0; i--) {
                for (j = t.length(); j >= 0; j--) {
    
                    if (i == s.length() || j == t.length()) {
                        dp[i][j] = 0;
                        continue;
                    }

                    int ans = 0;
                    if (s.charAt(i) == t.charAt(j)) {
                        ans = dp[i + 1][j + 1];
                    } else {
                        ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
    
                    dp[i][j] = ans;
                }
            }
            return dp[0][0];
        }

        public static int longestCommonSubstring(String s, String t, int i, int j, int[][] dp) {
            if (i == s.length() || j == t.length())
                return dp[i][j] = 0;
    
            if (dp[i][j] != 0)
                return dp[i][j];
            
                int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = longestCommonSubstring(s, t, i + 1, j + 1, dp) + 1;
        }
        count = Math.max(count,
                Math.max(longestCommonSubstring(s, t, i + 1, j, dp), longestCommonSubstring(s, t, i, j + 1, dp)));

        return dp[i][j] = count;
    }

    public static int longestCommonSubstring_DP(String s, String t, int i, int j, int[][] dp) {
        for (i = s.length(); i >= 0; i--) {
            for (j = t.length(); j >= 0; j--) {
                if (i == s.length() || j == t.length()) {
                    dp[i][j] = 0;
                    continue;
                }

                int count = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    count = dp[i + 1][j + 1] + 1;
                }
                count = Math.max(count, Math.max(dp[i + 1][j], dp[i][j + 1]));

                dp[i][j] = count;
            }
        }
        return dp[0][0];
    }

    public static int maxUncrossedLines(int[] a, int[] b) {

        int[][] dp = new int[a.length + 1][b.length + 1];
        int ans = maxUncrossedLines01(a, b, 0, 0, dp);
        Display2d(dp);

        return ans;
    }

    public static int maxUncrossedLines01(int[] a, int[] b, int i, int j, int[][] dp) {

        if (i == a.length || j == b.length)
            return dp[i][j] = 0;

        if (dp[i][j] != 0)
            return dp[i][j];
            int count = 0;
        if (a[i] == b[j]) {
            count = maxUncrossedLines01(a, b, i + 1, j + 1, dp) + 1;
        } else {
            count = Math.max(maxUncrossedLines01(a, b, i + 1, j, dp), maxUncrossedLines01(a, b, i, j + 1, dp));
        }
        return dp[i][j] = count;
    }

    public static int maxUncrossedLines_DP(int[] a, int[] b, int i, int j, int[][] dp) {

        for (i = a.length; i >= 0; i--) {
            for (j = b.length; j >= 0; j--) {
                if (i == a.length || j == b.length) {
                    dp[i][j] = 0;
                    continue;
                }
                int count = 0;
                if (a[i] == b[j]) {
                    count = dp[i + 1][j + 1] + 1;
                } else {
                    count = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = count;
            }
        }
        return dp[0][0];
    }

    // leetcode 1458 : Max Dot Product of Two Subsequences

    public int maxDotProduct(int[] nums1, int[] nums2,int i, int j ,int [][] dp )
    {
        if( i == nums1.length || j == nums2.length)
        return (int)-1e8;
    
        int val= nums1[i]*nums2[j];
        int a = maxDotProduct(nums1, nums2, i+1, j+1, dp) + val;
    int b= maxDotProduct(nums1, nums2, i+1, j, dp);
    int c = maxDotProduct(nums1, nums2, i, j+1, dp);

    return Math.max(Math.max(a, b), Math.max(c, val));
    }
}

