class CountEncoding{
    public static void main(String[] args) {
        String str="1123"; // "1303" , "1209" ,"100", "303"
        System.out.print(countencoding(str));
    }
    public static int countencoding(String str) {
        int[] dp=new int[str.length()];
        // only digit
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            // if (i-1)th character is zero and ith character is non zero  -> only one choice
            if(str.charAt(i-1)== '0' && str.charAt(i)!='0'){
                    dp[i]=dp[i-1];
            }else{
                if(str.charAt(i)!= '0'){
                    dp[i]=dp[i-1];
                }
                if((Integer.parseInt(str.substring(i-1,i+1)))<= 26){
                    if(i-2 < 0){  // for the case of '12' bcoz i-2 in this case will be -ve 
                        dp[i]+=1;
                    }else{
                        dp[i]+=dp[i-2];
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
}