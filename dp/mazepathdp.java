class mazepathdp{
    public static int mazepathT( int er, int ec)
    {
        int[][] dp= new int[er+1][ec+1];
        dp[er][ec]=1;
        for(int i=er;i>=0;i--){
            for(int j=ec;j>=0;j--)
            { if(i==er && j==ec){

            }else if(i==er){
                dp[i][j]=dp[i][j+1];
            }else if(j==ec){
                dp[i][j]=dp[i+1][j];
            }else{
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }

            }
        }
        return dp[0][0];
    } 
    public static void main(String[] args)
    {
     System.out.print(mazepathT(3,3));

    }
}