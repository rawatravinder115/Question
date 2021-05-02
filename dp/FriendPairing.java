class FriendPairing{
    public static void main(String[] args) {
        int n=4;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i == 1){
                dp[1]=1;
            }else if(i ==2){
                dp[i]=2;
            }else{
                dp[i]=dp[i-1]+(i-1)*(dp[i-2]);
            }
        }
        System.out.print(dp[n]);
    }
}