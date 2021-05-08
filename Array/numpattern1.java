class numpattern1{
    public static void main(String[] args){
        int sum=0, temp=1,count=0,n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
             System.out.print(sum+" ");
             sum=count+temp;
             temp=count;
             count=sum;
            }
            System.out.println();
        }
    }
}

/*

0
1 1
2 3 5
8 13 21 34

*/