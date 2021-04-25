class mazepathalldir{
    public static int floodfill(int [][]arr,int i,int j,String path )
    {   

        if(i==arr.length-1 && j==arr[0].length-1)
        {
         System.out.println(path);
         return 1;
        }
        int ans=0;
        arr[i][j]=1;
        if(i-1>=0 && arr[i-1][j]!=1)
        {
            ans+=floodfill(arr, i-1, j, path+'u');
        }
        if(j-1>=0 && arr[i][j-1]!=1)
        {
            ans+= floodfill(arr, i, j-1, path+'l');
        }
         if(i+1<arr.length && arr[i+1][j]!=1)
         {
             ans+=floodfill(arr, i+1, j, path+'d');
         }
         if(j+1<arr[0].length && arr[i][j+1]!=1)
         {
             ans +=floodfill(arr, i, j+1, path+'r');
         }
         arr[i][j]=0;
         return ans ;
    }
    public static void main(String[] args)
    {
         int[][] arr={{0,0,0,0,0,0},
                      {0,1,0,1,0,0},
                      {0,0,0,0,0,0},
                      {0,0,1,0,1,0},
                      {1,0,0,0,0,0},
                      {0,0,0,0,0,0}};
         System.out.print(floodfill(arr,0,0,""));
    }
    
}