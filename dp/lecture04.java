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

    public static int coinChange_(int[] coins, int tar, int[] dp) {
        if (tar < 0)
            return -1;
            if (tar == 0)
            return 0;

        if (dp[tar] != 0)
            return dp[tar];

        int minHeight = (int) 1e8;
        for (int ele : coins) {
            if (tar - ele >= 0) {
                int rMinHeight = coinChange_(coins, tar - ele, dp);
                if (rMinHeight != 1e8 && rMinHeight + 1 < minHeight)
                    minHeight = rMinHeight + 1;
            }
        }

        return dp[tar] = minHeight;
    }

    public static int targetSum(int[] coins, int idx, int tar, int[][] dp) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0)
                return dp[idx][tar] = 1;

            return dp[idx][tar] = 0;
        }

        if (dp[idx][tar] != 0)
            return dp[idx][tar];
            int count = 0;
        if (tar - coins[idx] >= 0)
            count += targetSum(coins, idx + 1, tar - coins[idx], dp);

        count += targetSum(coins, idx + 1, tar, dp);

        return dp[idx][tar] = count;
    }
}