// max sum of non adjacent element 

class MaxNonAdjSum{
    public static void main(String[] args) {
        int[] arr={2,5,9,4,6,3};
        System.out.print(adjacentsum(arr));
    }
    public static int  adjacentsum(int [] a) {
        int[] include=new int[a.length];
        int[] exclude=new int[a.length];
        include[0]=a[0];
        exclude[0]=0;
        for(int i=1;i<a.length;i++){
            include[i]=a[i]+exclude[i-1];
            exclude[i]=Math.max(include[i-1], exclude[i-1]);
        }
        return Math.max(include[a.length-1], exclude[a.length-1]);
        
    }
}