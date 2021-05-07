class sorting{

    public static void display(int [] arr1){
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }System.out.println();
    }
    public static void swap(int []arr1,int a,int b){
                   
                    int temp=arr1[a];
                    arr1[a]=arr1[b];
                    arr1[b]=temp;
    }
    public static void bubble(int [] arr1,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr1[j]>arr1[j+1]){
                    // int temp=arr1[j];
                    // arr1[j]=arr1[j+1];
                    // arr1[j+1]=temp;
                    swap(arr1,j, j+1);
                }
            }
        }
    }
       
    public static void insertion(int [] arr){
        
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
    public static void selection(int []arr3){
      
        for(int i=0;i<arr3.length-1;i++){
            for(int j=i+1;j<arr3.length;j++){
                if(arr3[i]>arr3[j]){
                    swap(arr3,i,j);
                }
            }
        }

    }

    public static void main(String[] args){
        int n=4;
        int[] arr1={7,2,6,3};
        int[] arr2={1,2,3,0};
        int[] arr3={2,0,5,8};
        bubble(arr1,n);
        display(arr1);
        insertion(arr2);
        display(arr2);
        selection(arr3);
        display(arr3);

    }
}