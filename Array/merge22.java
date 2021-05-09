class merge22{
    public static void main(String[] args) {
        int[] arr={2,8,5,6,3,9,7,4};
    int[] ans=merge(arr,0,arr.length-1);
    for(int i=0;i<ans.length;i++){
        System.out.print(ans[i]+" ");
    }
    }
    public static int[] merge(int[] arr,int lo,int hi){
        if(lo==hi){
            int[] baseans=new int[1];
            baseans[0]=arr[lo];
            return baseans;
        }
        int mid=(lo+hi)/2;
       int[] left= merge(arr, lo, mid);
       int[] right= merge(arr, mid+1, hi);
       int[] ans= mergesort(left,right);
       return ans;
    }
    public static int[] mergesort(int[] a, int[] b)
    {
        int[] ans= new int[a.length+b.length];
        int i=0, j=0,k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
            {
            ans[k]=a[i];
            i++;
            }
            else{
                ans[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<a.length)
        {
            ans[k]=a[i];
            i++ ; k++;
        }
        while(j<b.length)
        {
            ans[k]=b[j];
            j++; k++;
        }
        return ans;
    }
    
}
