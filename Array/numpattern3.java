class numpattern3{
    public static void main(String[] args){
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" "+"  ");

            } for(int k=0;k<=i-1;k++){
                
                System.out.print(k+i+"  ");
                // sum=sum+1;
            }
            for(int l=1;l<=i-1;l++){
                if(i==1){
                    System.out.print(" ");
                }else{
                     System.out.print((2*i)-l-1+" ");
                }
            }
             System.out.println();
        }
    }
}


/*

          1
       2  3  2
    3  4  5  4  3
 4  5  6  7  6  5  4

*/