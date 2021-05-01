class LongBiotonicSubseq{
    public static void main(String[] args) {
        int[] arr={10,22,9,33,21,50,41,60,80,1};
        System.out.print(biotonic(arr));
    }
    public static int biotonic(int[] arr) {
        int[] dp1=new int[arr.length]; // longest increasing subseq from left
        dp1[0]=1;
        for(int i=1;i<dp1.length;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    max=Math.max(max,dp1[j]);
                }
                dp1[i]=max+1;
            }
        }
        int[] dp2=new int[arr.length]; // longest increasing subseq from right
        dp2[dp2.length-1]=1;
        for(int i=dp2.length-2;i>=0;i--){
            for(int j=i+1;j<dp2.length;j++){
                int max=0;
                if(arr[i]>arr[j]){
                    max=Math.max(max,dp2[j]);
                }
                dp2[i]=max+1;
            }
        }
        int mymax=0;
        for(int i=0;i<dp1.length;i++){
            int ans=dp1[i]+dp2[i]-1;
            mymax=Math.max(mymax, ans);
        }
        return mymax;
    }
}