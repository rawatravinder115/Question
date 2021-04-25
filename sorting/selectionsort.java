class selectionsort{ 
    public static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void selection(int[] arr)
    {
     for(int i=0; i<arr.length-1;i++)
     {
         for(int j=i+1;j<arr.length-1;j++)
         {
          if(arr[i]>arr[j])
          {
              swap(arr,i,j);
          }
         }
        
     }
    }
    public static void main(String[] args)
    {
        int[] arr={2,8,6,5,3,7,9,4};
        selection(arr);
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
}