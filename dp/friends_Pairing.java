class friends_pairing{
    public static void main(String[] args) {
        
    }

    public static int friends_pairing_problemDPMemo(int n, int[] dp) {

        if (n <= 1)
            return dp[n] = 1;

        if (dp[n] != 0)
            return dp[n];

        int single = friends_pairing_problemDPMemo(n - 1, dp);
        int pair_up = friends_pairing_problemDPMemo(n - 2, dp) * (n - 1);

        return dp[n] = (single + pair_up);
    }

    public static int friends_pairing_problemDPTabu(int n, int[] dp) {

        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                dp[i] = 1;
                continue;
            }

            int single = dp[i - 1];
            int pair_up = dp[i - 2] * (i - 1);

            dp[i] = (single + pair_up);
        }
        return dp[n];
    }
}