class LongCommonSubseq{
    public static void main(String[] args) {
        String str1="abcd";
        String str2="abed";
        System.out.print(lcs(str1,str2));
    }
    public static int lcs(String a,String b) {
        int[][] dp=new int[a.length()+1][b.length()+1];
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }else{
                 dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
       return dp[0][0]; 
    }
}