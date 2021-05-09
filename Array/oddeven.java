class oddeven{
    public static void main(String[] args) {
        // int num=6;
        print(5);
    }
    public static void print(int n) {
        if(n<=0){
            return;
        }
        System.out.println(n);
        if(n%2 == 1){
            print(n-2);
        } 
        if(n%2==0){
            print(n+1);
        }
    }
}