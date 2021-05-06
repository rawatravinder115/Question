class plusone{
    public static void main(String[] args) {
        int[] arr ={1,2,9};
        int sum= arr[arr.length-1] +1;
        if(sum >= 10){
            int rem = sum/10;
            arr[arr.length-1] = rem;
            arr[arr.length-2] =arr[arr.length-2] + 1;
        }else{
            arr[arr.length-1] = sum;
        }
        for(int i = 0; i > arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}