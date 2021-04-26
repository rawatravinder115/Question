class minpathdp{  
public static int[][] minmazepath(int [][] cost)
{
    int [][] dp=new int[cost.length][cost[0].length];
    dp[dp.length-1][dp[0].length-1]=cost[cost.length-1][cost[0].length-1];
    // int er=cost.length-1,ec=cost[0].length-1;
 for(int i=dp.length-1;i>=0;i--){
     for(int j=dp[0].length-1;j>=0;j--){
         if(i==dp.length-1 && j==dp[0].length-1){

         } else if(i==dp.length-1){
             dp[i][j]=cost[i][j]+dp[i][j+1];
         }else if(j==dp[0].length-1){
             dp[i][j]=cost[i][j]+dp[i+1][j];
         }else{
             if(dp[i+1][j]>dp[i][j+1]){
                 dp[i][j]=cost[i][j]+dp[i][j+1];
             }else{
                 dp[i][j]=cost[i][j]+dp[i+1][j];
             }
         }

     }
 }
 
 printPath(0,0,"",dp); 
 return dp;
}

public static void printPath(int i,int j,String path,int[][] dp){
    if(i==dp.length-1 && j == dp[0].length-1){
        System.out.println(path);
        return; 
    }else if(i==dp.length-1){
        printPath(i, j+1, path+'h', dp);
    }else if(j==dp[0].length-1){
        printPath(i+1, j, path+'v', dp);
    }else{
        int min = (dp[i][j+1]<dp[i+1][j]?dp[i][j+1]:dp[i+1][j]);
        if(min == dp[i][j+1]){
            printPath(i, j+1, path+'h', dp);
        }
        if(min == dp[i+1][j]){
            printPath(i+1, j, path+'v', dp);
        }
    }
}
    public static void main(String[] args)
    {
        int[][] cost={{3,8,30,7,4},
                     {8,10,15,2,18},
                     {6,29,27,13,15},
                     {10,19,10,1,3},
                     {4,8,20,2,6}};
                       
         int [][] arr=minmazepath(cost);   
         for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr.length;j++){
                 System.out.print(arr[i][j]+" ");
             }
              System.out.println();
         }  
        
    }
}