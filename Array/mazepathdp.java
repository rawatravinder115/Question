class mazepathdp{
    public static int mazepathT( int er, int ec)
    {
        int[][] dp= new int[er+1][ec+1];
        dp[0][0]=1;
        for(int i=0;i<er;i++){
            for(int j=0;j<ec;j++)
            { if(i==0 && j==0){

            }else if(i==0){
                dp[i][j]=dp[i][j+1];
            }else if(j==0){
                dp[i][j]=dp[i+1][j];
            }else{
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }

            }
        }
        return dp[er][ec];
    } 
    public static void main(String[] args)
    {
     System.out.print(mazepathT(3,3));

    }
}