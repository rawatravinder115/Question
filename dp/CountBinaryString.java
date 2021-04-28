class CountBinaryString{
    public static void main(String[] args) {
        System.out.print(cbst(6));
    }
    public static int cbst(int n) {
        int[] eAt0=new int[n+1];
        int[] eAt1=new int[n+1];
        eAt0[1]=eAt1[1]=1;
        for(int i=2;i<=n;i++){
            eAt0[i]=eAt1[i-1];
            eAt1[i]=eAt0[i-1]+eAt1[i-1];
        }
        int ans=eAt0[n]+eAt1[n];
        return ans;
    }
}