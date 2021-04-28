class ArrangeBuilding{
    public static void main(String[] args) {
     System.out.print(building(3));   
    }
  public static long building(int n) {
     long[] space=new long[n+1];
     long[] building=new long[n+1];
     space[1]=building[1]=1;
     for(int i=2;i<=n;i++){
         building[i]=space[i-1];
         space[i]=space[i-1]+building[i-1];
     }
     long ans=space[n]+building[n];
      return ans;
  }
}