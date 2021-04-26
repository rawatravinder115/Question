class staircasedp{
    public static int stairM(int n, int[] dp)
    { if(n==0){
        return 1 ;

    }
    if(dp[n]!=0)
    {
        return dp[n];
    } int ans=0;
       if(n-1>=0){ 
           ans+= stairM(n-1,dp);
        }

       if(n-2>=0) {
           ans+= stairM(n-2,dp);
        }
       if(n-3>=0) {
           ans+= stairM(n-3,dp);
        }
        dp[n]=ans;
        return ans;
    }
    public static int stairT(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
        { int ans=0;
            if(i-1>=0){
               ans+=dp[i-1];
            }
            if(i-2>=0)
            {
                ans+=dp[i-2];
            }
            if(i-3>=0){
                ans+=dp[i-3];
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public static void main(String[] args)
    {
        int n=5;
        int[] dp=new int[n+1];
        System.out.print(stairM(n,dp)+" "+stairT(n));
    }
}