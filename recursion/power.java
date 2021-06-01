import java.util.Scanner;
class power{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) {
        solve();
    }
    public static  void solve(){
     int a=scn.nextInt();
     int b=scn.nextInt();
     System.out.print(powerbtr(a,b));
     System.out.println();
     System.out.print(power(a,b));
    }
    // best approach for power to minimize operation
    public static int powerbtr(int a ,int b) {
      if(b==0) return 1;
      int ans=powerbtr(a,b/2);
      ans*=ans;
      return b%2==0?ans:ans*a;
    }
    // basic solution for power
    public  static int power(int a,int b) {
            if(b==0) return 1;
            int ans=power(a,b-1);
            return ans*a;
    }
}