// with tabular 
class finodp1{
    public static long tabular(int n)
    {
        int[] dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int nm1=dp[i-1];
            int nm2=dp[i-2];
            dp[i]=nm1+nm2;
        }
       return  dp[n];
    }
    public static void main(String[] args)
    {
        int n=45;
       System.out.print(tabular(n));

    }
}