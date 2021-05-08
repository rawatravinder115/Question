class numpattern5{
    public static void main(String[] args){
        int n=4;
        for(int i=1;i<=n;i++){ 
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            for(int k=1;k<=2*(n-i)-1;k++){
                System.out.print("*"+" ");
            }
            for(int l=i;l>=1;l--){
                if(i<=3)
               {
                  System.out.print(l+" ");
                }else{
                    System.out.print(l-1+" ");
                }
            }
            System.out.println();
        } 
        
    }
}