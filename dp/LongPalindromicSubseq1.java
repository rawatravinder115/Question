class LongPalindromicSubseq1{
    public static void main(String[] args) {
        String str="tmvsaslm";
        System.out.print(lps(str));
    }
    public static int lps(String str){
        int[][] dp=new int[str.length()][str.length()];
        for(int dia=0;dia<dp.length;dia++){
            int sp=0,ep=dia;
            while(ep<dp.length){
                if(dia == 0){
                    dp[sp][ep]=1;
                }else if(dia == 1){
                    if(str.charAt(sp)== str.charAt(ep)){
                        dp[sp][ep]=2;
                    }else{
                        dp[sp][ep]=1;
                    }
                }else{
                    if(str.charAt(sp) == str.charAt(ep)){
                        dp[sp][ep]=dp[sp+1][ep-1]+2;
                    }else{
                        dp[sp][ep]=Math.max(dp[sp+1][ep], dp[sp][ep-1]);
                    }
                }
                sp++;
                ep++;
            }
        }
        return dp[0][dp[0].length-1];
    }
}