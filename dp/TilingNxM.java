class TilingNxM{
    public static void main(String[] args) {
        int n=5, m=3;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }else if(i==m){
                dp[i]=2;
            }else{
                dp[i]=dp[i-1]+dp[i-m];
            }
        }
        System.out.print(dp[n]);
    }
}