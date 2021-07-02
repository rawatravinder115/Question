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
}