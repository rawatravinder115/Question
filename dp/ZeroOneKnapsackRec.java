 class ZeroOneKnapsackRec{
     public static void main(String[] args) {
         int [] prices={15,14,10,45,30};
         int[] weight={2,5,1,3,4};
         int cap=7;
         System.out.print(knapsack(prices,weight,0,cap));
     }
     public static int knapsack(int[] prices,int[] weight,int idx,int cap) {
       if(idx == weight.length){
          if(cap >= 0){
            return 0;
          }else{
            return Integer.MIN_VALUE;
          }
          
       }  
       int r1=knapsack(prices, weight, idx+1, cap);
       int r2=prices[idx]+knapsack(prices, weight, idx+1, cap-weight[idx]);
       return Math.max(r1,r2);
     }
 }