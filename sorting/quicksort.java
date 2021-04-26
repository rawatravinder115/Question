class quicksort{
    public static int partition(int[] arr, int lo ,int hi )
    {
        int pivot=arr[hi];
        int i=lo,j=lo; 
        while(j<=hi)
        {
          int temp=arr[i];
          if(arr[j]<=pivot)
          {
              arr[i]=arr[j];
              arr[j]=temp;
              i++;
        }
            j++;
        }
        return i-1;

    }
    public static void quicksort(int[] arr, int lo, int hi)
    {
        if(lo>=hi)
        {
            return;
        }
        int pivotindex=partition(arr,lo,hi);
        quicksort(arr, lo, pivotindex-1);
        quicksort(arr, pivotindex+1, hi);
    }
    public static void main(String[] args)
    {
        int[] arr ={3,10,12,9,5,12,13,6,2,15,20,10};
        
        quicksort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        
    }
}