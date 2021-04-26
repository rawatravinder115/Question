// with memoization 


class fibodp{
    public static int fibo(int n, int [] dp)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int nm1=fibo(n-1, dp);
        int nm2=fibo(n-2, dp);
        dp[n]=nm1+nm2;
        return nm1+nm2;
    }
    public static  void main(String[] args)
    {
        int n=45;
        int[] dp= new int[n+1];
        System.out.print(fibo(n,dp));
    }
}