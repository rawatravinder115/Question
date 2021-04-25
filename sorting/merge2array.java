class merge2array{
    public static void merge(int[] a, int[] b)
    {       int i=0;
        int j=0;
             while(i!=a.length && j!=b.length)
            {
                if(a[i]<b[j])
                { System.out.print(a[i]+" ");
                i++;
                }
                else{
                    System.out.print(b[j]+" ");
                    j++;
                }
        }
            while(i<a.length)
            {
                System.out.print(a[i]+" ");
                i++;
            }
            while(j<b.length)
            {
                System.out.print(b[j]+" ");
                j++;
            }

}
    public static void main(String[] args)
    {
        int[] arr1={2,8,5,4};
        int[] arr2={9,6,1,7};
        merge(arr1,arr2);
    }
}