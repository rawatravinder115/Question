class MaxSumIncSubseq{
    public static void main(String[] args) {
       int[] arr= {-4,2,-3,30,12,29,-2,40,13};
       System.out.print(maxsum(arr));
    }
    public static int maxsum(int[] arr) {
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<dp.length;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>=arr[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+arr[i];
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]> max){
                max=dp[i];
            }
        }
        return max ;
        
    }
}