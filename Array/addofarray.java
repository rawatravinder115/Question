class addofarray{
    public static int [] addition(int [] a, int[] b){
        
    int[] ans=new int[a.length];
  if(a.length==b.length){
      for(int i=a.length-1;i>=0;i--){
    int borrow=0;
    int sum=a[i]+b[i]+borrow;
    if(sum>=10 && i!=0){
        int rem=sum%10;
        ans[i]=rem;
        sum=sum/10;
        borrow=sum;
        
}else{
   ans[i]=sum+borrow;
    }
    }

}else{
    for(int i=a.length-1;i>0;i--){
        int borrow=0;
    int sum=a[i]+b[i-1]+borrow;
    if(sum>=10 && i!=0){
        int rem=sum%10;
        ans[i]=rem;
        sum=sum/10;
        borrow=sum;
        
}else{
   ans[i]=sum;
    }
    }
    }
    return ans;
}
    

public static void main(String[] args) {
    // int m=4;
    int[] amm={1,0,2,9,5};
    // int n=5;
    int[] ann={3,5,5,9,7};
    int []arr=addition(ann,amm);
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }

}
}