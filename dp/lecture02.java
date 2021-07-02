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
}