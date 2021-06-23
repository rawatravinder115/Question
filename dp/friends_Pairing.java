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
    
}