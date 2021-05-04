class Tiling2x1{
    public static void main(String[] args) {
       System.out.println(tiles(5));
       System.out.print(tilesrecu(5));
    }
 public static int tiles(int n) {
     int[] dp=new int[n+1];
     dp[1]=1;
     dp[2]=2;
     for(int i=3;i<dp.length;i++){
         dp[i]=dp[i-1]+dp[i-2];
     }
     return dp[n];
 }
 // recursive solution 
 public static int tilesrecu(int n) {
    if(n<=0){
        return 0;
    }
    if(n==1 || n == 2){
        return n;
    }
    int a1=tilesrecu(n-1);
    int a2=tilesrecu(n-2);
    return a1+a2;
}
}


