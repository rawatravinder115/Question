class insertionsort{
     
    // public static void swap(int[] arr,int a,int b){
    //     int temp=arr[a];
    //     arr[a]=arr[b];
    //     arr[b]=temp;
    // }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void inser(int [] arr){
        
       for(int i=1;i<arr.length;i++){
         int key=arr[i];
         int j=i-1;
        while(j>=0 && arr[j]<key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
}
    public static void main(String[] args)
    {
        int[] arr={4,3,2,10,12,1,5,6};
        inser(arr);
        display(arr);
    } 
}