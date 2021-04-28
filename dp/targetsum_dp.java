class targetsum_dp{
    public static void main(String[] args) {
        int[] arr={4,2,7,1,3};
        System.out.print(targetsum(arr,10));
    }
    public static boolean targetsum(int [] arr,int t) {
        boolean[][] dp=new boolean[arr.length+1][t+1];
        dp[0][0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i-1][j] == true){
                    dp[i][j]=true;
                }else if(j-arr[i-1] >=0 && dp[i-1][j-arr[i-1]] == true){
                 dp[i][j] =true;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}