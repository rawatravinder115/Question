class reverse{


    public static void display(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
        System.out.print(arr[i]+" ");
    
        }
    }
    public static void rev(int[] arr)
    {
        int left=0;
        int right=arr.length-1;
        int temp=0;
        while(left<right)
        { 
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            right--;
            left++;
        }

    }
    public static void main(String[] args){
        int N=5;
        int[] arr={4,2,8,6,4};
        rev(arr);
        display(arr);

    }
}
