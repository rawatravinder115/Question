import java.util.*;
class fibo{
    public static void  main(String[] args)
    {
      Scanner scn = new Scanner(System.in);
      int n=scn.nextInt();
      int sum=0;
      int rem=1;
      int let=0;
      System.out.print(sum+" ");
      for(int i=0;i<n;i++)
      {  
          let=sum;
          sum=sum+rem;
          System.out.print(sum+" ");
          rem=let;

      }
    }
}