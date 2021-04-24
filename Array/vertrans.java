class vertrans{
    public static void main(String[] args){
        int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
        display(arr);
        rotate(arr);
        display(arr);
    }
        public static void transpose(int[][] arr)
        {
            for(int i=0;i<arr.length;i++)
            {
                for(int j=i+1;j<arr[0].length;j++)
                {
                    int temp=0;
                    temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }

        }
    
        
    public static void rotate(int[][] arr)
    {       transpose(arr);
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length/2;j++)
            {
                int temp=0;
                temp=arr[i][j];
                arr[i][j]=arr[arr.length-i-1][j];
                arr[arr.length-i-1][j]=temp;
            }
        }

    }
    public static void display(int [][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+" ");
                
            }
            System.out.println();
        }
        System.out.println();
    }


    
}

