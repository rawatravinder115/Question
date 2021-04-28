class ZeroOneKnapsack{
    public static void main(String[] args) {
        int [] prices={15,14,10,45,30};
         int[] weight={2,5,1,3,4};
         int cap=7;
         System.out.print(knapsack(prices,weight,cap));
    }
    public static int knapsack(int [] prs,int [] wts,int cap) {
        int[][] dp=new int[wts.length+1][cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int val=wts[i-1];
                int price=prs[i-1];
              if(j-val>=0){
                  dp[i][j]=Math.max(dp[i-1][j], price+dp[i-1][j-val]);
              }else{
                  dp[i][j]=dp[i-1][j];
              }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}