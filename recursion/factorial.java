import java.util.Scanner;
class factorial{ 
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        int n=scn.nextInt();
       System.out.print(fact(n));
       
    }
    public static int fact(int n){
        // if(n==1){
        //     return 1;
        // }
        // int ans=fact(n-1);
        // return ans*n;
        return n<=1?1:fact(n-1)*n;
    }
    
}