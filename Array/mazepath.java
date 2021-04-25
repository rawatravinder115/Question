class mazepath{

    public static int count(int cr, int cc,int er,int ec, String path)
    {   if(cr==er && cc==ec)
        {
          System.out.println(path);
          return 1;
        }
        int ans=0;
        if(cc+1<=ec)
        { 
            ans += count(cr,cc+1,er,ec,path+'h');
         }
          if(cr+1<=er)
          {
           ans += count(cr+1,cc,er,ec,path+'v');
         }      
         return ans;
    }
    public static void main(String[] args)
    {
        System.out.println(count(0,0,2,2,""));
    }
}