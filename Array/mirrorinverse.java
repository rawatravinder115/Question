// class mirrorinverse{
    
//     public static boolean compare(int []arr,int[] arr1){
           
//        boolean ismirror=false;
//        for(int i=0;i<arr.length;i++)
//        {
//          if(arr[i]==arr1[i]){
//              ismirror=true;
//          }
//        } 
//  return ismirror;

//     }

//     public static void inverse(int[] arr1){
//         int m=arr1.length-1;
//         for(int i=0;i<=m/2;i++){
//             int temp=arr1[i];
//             arr1[i]=arr1[m-1+i];
//             arr1[m-1+i]=temp;
//         }


//     }
//     public static void display(int[] arr) {
//         for(int i=0;i<arr.length;i++)
//         {
//         System.out.print(arr[i]+" ");
//         } 
//         System.out.println();
//     }
//     public static void rev(int[] arr)
//     {
//         int left=0;
//         int right=arr.length-1;
//         int temp=0;
//         while(left<right)
//         { 
//             temp=arr[left];
//             arr[left]=arr[right];
//             arr[right]=temp;
//             right--;
//             left++;
//         }

//     }
//     public static void main(String[] args){
//      int[] arr={1,2,3,0};
//      int []arr1=new int[4];
//      for(int i=0;i<arr1.length;i++){
//          arr1[i]=arr[i];
//      }
//      rev(arr);
//     display(arr);
//     // display(arr1);
//     inverse(arr);
//     display(arr);
//    System.out.print(compare(arr,arr1));
//     }
// }
 class mirrorinverse{

    public static boolean compare(int []ann,int[] arr){
           
        boolean ismirror=false;
        for(int i=0;i<arr.length;i++)
        {
          if(ann[i]==arr[i]){
              ismirror=true;
          }
        } 
  return ismirror;
 
     }
    public static void reverse(int [] arr){
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
    public static int [] mirror(int[] arr){
    
    int[] ans=new int[arr.length];
    for(int i=0;i<arr.length;i++){
        ans[arr[i]]=i;
    }
       return ans; 
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Scanner scn=new Scanner(System.in);
        int n=4;
        int[] arr={1,2,3,0};
        int[]ann=mirror(arr);
       for(int i=0;i<n;i++){
           System.out.print(ann[i]+" ");  
       }
       System.out.println();
       reverse(arr);
       System.out.print(compare(ann, arr));
    }
}