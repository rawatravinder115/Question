class bubblesort{
    public static void swap(int[] arr ,int a, int b)
    {
       int  temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void bubble(int[] arr)
    {
     for(int i=0;i<arr.length-1;i++)
       {
           for(int j=0;j<arr.length-1-i;j++)
           {
            {
                if(arr[j]>arr[j+1])
                {
                swap(arr,j,j+1);
                }
            }
       
           }
    }
     
    }
    public static void main(String[] args)
    {
        int[] arr={2,8,6,5,3,7,9,4};
        bubble(arr);
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        
    }
}