class CountPalindromicSubseq{
    public static void main(String[] args) {
        String str="abcbbc";
        System.out.print(palindromiccount(str));
    }
    public static int palindromiccount(String str) {
        boolean[][] dp=new boolean[str.length()][str.length()];
        int count=0;
        for(int dia=0;dia<dp.length;dia++){
            int sp=0, ep=dia;
            while(ep<dp.length){
                if(dia == 0){
                    dp[sp][ep]=true;
                }else if(dia == 1){
                  if(str.charAt(sp) == str.charAt(ep)){
                    dp[sp][ep]=true;
                  }else{
                    dp[sp][ep]=false;
                  }
                }else{
                    if(str.charAt(sp) == str.charAt(ep)){
                        dp[sp][ep]=  dp[sp+1][ep-1];
                    }else{
                        dp[sp][ep]= false;
                    }
                }
                if( dp[sp][ep]== true){
                    count++;
                }
                sp++;
                ep++;
            }
        }
return count;
    }
}