class numpattern2{
    public static void main(String[] args){
        int n=6;
        for(int cr=0;cr<=n-1;cr++){
            int ncr=1;
            for(int cc=0;cc<=cr;cc++){
                System.out.print(ncr+" ");
                int ncrpo=ncr*(cr-cc)/(cc+1);
                ncr=ncrpo;
            }System.out.println();
        }

    }
}


/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1

*/