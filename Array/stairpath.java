class stairpath{

    public static void main(String[] args) {
        stairpath(4, "");
    }
    public static void stairpath(int n,String path){
        
        if(n==0){
            System.out.println(path);
            return;
        }
        if(n-1>=0)
        stairpath(n-1, path+'1');
        if(n-2>=0)
        stairpath(n-2, path+'2');
        if(n-3>=0)
        stairpath(n-3, path+'3');
    }
}