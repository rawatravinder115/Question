class partition2array{
    public static void partition(int[] arr)
    {
        int v=arr[arr.length-1];
        int i=0,j=0;
        while(j<arr.length)
        {
          int temp=arr[i];
          if(arr[j]<=v)
          {
              arr[i]=arr[j];
              arr[j]=temp;
              i++; 
        }
        j++;
        }

    }
    public static void main(String[] args)
    {
        // int[] arr ={3,10,12,9,5,12,13,6,2,15,20,10};
        // int[] arr ={3,10,12,9,5,12,13,6,2,15,20,10};
        int[] arr={3,10,9,5,6,2};
        partition(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        
    }
}