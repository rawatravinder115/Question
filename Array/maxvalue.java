class maxvalue{ 
    
    public static int max(int[] arr, int mymax){
        for(int i=1;i<arr.length-1;i++){
            int temp=0;
            if(mymax<arr[i]){
                 mymax=arr[i];
            }
        }
        return mymax;
    }
    public static void main(String[] args){
        int N=4;
        int[] arr={2,8,6,4};
        max(arr,arr[0]);
        System.out.print(max(arr,arr[0]));
       
    }
}