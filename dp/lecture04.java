class lecture04{
    public static void main(String[] args) {
        // target();
        Knapsack();
    }

    public static void target() {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        int[][] dp = new int[coins.length + 1][tar + 1];
        
        // System.out.println(targetSum(coins, 0, tar, dp));
        // System.out.println(targetSum02(coins, coins.length, tar, dp));

        System.out.println(targetSum02_DP(coins, tar));
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

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int ans = coinChange_(coins, amount, dp);
        return ans != (int) 1e8 ? ans : -1;
    }
}