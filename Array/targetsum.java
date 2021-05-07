import java.util.*;
class targetsum{
    public static void target(int []arr, int t){
         Arrays.sort(arr);
         int left=0;
         int right=arr.length-1;
         while(left<right){
         if(arr[left]+arr[right]==t){
             System.out.println(arr[left]+" and "+arr[right]);
             left++;
             right--;
         }else if(arr[left]+arr[right]<t){
             left++;
         }else{
             right--;
         }

         }
    }
    public static void main(String[] args){
        int n=7;
        int [] arr={1,2,3,1,2,4,1};
        int target=7;
        target(arr,target);

    }
}