class lt997{
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
    
        
    int[]  trustcount = new int[n+1];
        
    
     for(int i=0;i<trust.length;i++)
        {
            trustcount[trust[i][0]]--;
            trustcount[trust[i][1]]++;
        }
        
        
    for(int i=0;i<trustcount.length;i++){
        if(trustcount[i] == n-1)
            return i;
    }
    return -1;
    }
}