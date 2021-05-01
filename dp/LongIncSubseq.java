//  LOngest Increasing subseq 
// sequence  should be in the increasing order 

class LongIncSubseq{
    public static void main(String[] args) {
        int[] arr={2,7,9,5,11,-2,3,17,4};
        System.out.print(longsubseq(arr));
    }
    public static int longsubseq(int[] arr) {
    int[] dp=new int[arr.length];
    dp[0]=1;
    for(int i=1;i<dp.length;i++){
        int max=0;
        for(int j=i-1;j>=0;j--){
            if(arr[i]>arr[j]){
                max=Math.max(max,dp[j]);
            }
        }
        dp[i]=max+1;
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