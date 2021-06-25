class goldmine{
     public static void main(String[] args) {
         int[][] gold={{0,1,4,2,8,2},
                       {4,3,6,5,0,4},
                        {1,2,4,1,4,6},
                        {2,0,7,3,2,2},
                      {3,1,5,9,2,4},
                    {2,7,0,8,5,1}};
        System.out.print(goldmine(gold));        
     }
     public static int goldmine(int[][] gold) {
        int[][] dp=new int[gold.length][gold[0].length];
        for(int c=dp[0].length-1;c>=0;c--){
            for(int r=dp.length-1;r>=0;r--){
               if(c==dp[0].length-1){
                 dp[r][c]=gold[r][c];
               }else if(r ==0){
                dp[r][c]=gold[r][c]+(Math.max(dp[r][c+1], dp[r+1][c+1]));
               }else if(r == dp.length-1){
                dp[r][c]=gold[r][c]+(Math.max(dp[r][c+1], dp[r-1][c+1]));
               }else{
                dp[r][c]=gold[r][c]+(Math.max(dp[r-1][c+1],(Math.max(dp[r][c+1], dp[r+1][c+1]))));
               }
            }
        }
         int max=dp[0][0];
        for(int r=0;r<dp.length;r++){
         if(max<dp[r][0]) max=dp[r][0];
        }
        return max;
     }

     public static int goldmine_DPMemo(int sr, int sc, int[][] gold, int[][] dp) {

      if (sc == gold[0].length - 1)
          return dp[sr][sc] = gold[sr][sc];

      if (dp[sr][sc] != 0)
          return dp[sr][sc];

      int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
      int maxgold = 0;
      for (int d = 0; d < dir.length; d++) {

          int x = sr + dir[d][0];
          int y = sc + dir[d][1];

          if (x >= 0 && y >= 0 && x < gold.length && y < gold[0].length) {
              maxgold = Math.max(maxgold, goldmine_DPMemo(x, y, gold, dp));
          }
      }

      return dp[sr][sc] = maxgold + gold[sr][sc];
  }
}