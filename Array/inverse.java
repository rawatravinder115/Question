import java.io.*;
import java.util.*;

public class inverse {
    
    public static void inverse(int[]arr2,int N){
        int mid=N/2;
        for(int i=0;i<mid;i++){
            int temp=arr2[i];
            arr2[i]=arr2[mid+i];
            arr2[mid+i]=temp;
        }
    }
    
    public static boolean compare(int[]a,int[]b){
        boolean isinverse=false;
        for(int i=0;i<a.length;i++){
            
            if(a[i]==b[i]){
                 isinverse=false;
              }
        }
        return  isinverse;
    }
 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scn=new Scanner(System.in);
        int N=4;
        int[] arr1={1,2,3,0};
        int[] arr2={3,0,1,2};
        // for(int i=0;i<N;i++){
        //     arr1[i]=scn.nextInt();
        // }
        // for(int i=0;i<N;i++){
        //     arr2[i]=scn.nextInt();
        // }
        inverse(arr2,N);
        System.out.print(compare(arr1,arr2));
        
    }
}