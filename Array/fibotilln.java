import java.util.*;
class fibotilln{
    public static void fibotilln(int n)
    {
        long first = 1;
        long  second = 0;

        // System.out.print(first+" ");
        // System.out.print(second+" ");
        System.out.print(second+" ");
        System.out.print(first+" ");
        
        for(int i=0;i<n-2;i++)
        {  
            
            long  sum=first+second;
            if(n>sum){
                System.out.print(sum+" ");
            }
            second = first;
            first = sum;
            
            
        }
    }
    public static void main(String[] args)
    {
          Scanner scn = new Scanner(System.in);
          int n=scn.nextInt();
         fibotilln( n);

    }
}