class numpattern4{
    public static void main(String[] args)
    {
        int n=5;
        // int mid=(n+1)/2;
        // for(int i=1;i<=mid;i++){
        //     // for space in upper right part
        //     for(int j=1;j<=mid-i;j++){
        //         System.out.print("  ");
        //     }
        //     // for the number in upper middle  part
        //     for(int k=0;k<=i-1;k++){
        //         System.out.print(i+k+" ");
        //     }
        //     // for the number in upper left  part
        //     for(int l=1;l<=i-1;l++){
        //         if(i==1){
        //             System.out.print("  ");
        //         }else{
        //             System.out.print((2*i)-l-1+" ");
        //         }
        //     }
        //     System.out.println();
        // }
        // for(int i=1;i<=mid-1;i++){
        //     //for the number in lower right  part
        //     for(int j=1;j<=i;j++){
        //         System.out.print("  ");
        //     }
        //      //the number in lower right  part
        //      for(int k=0;k<=2*(mid-2)-i;k++){
        //         if(i!=2) {System.out.print(k+i+1+" ");
        //     }else{
        //         System.out.print(1);
        //     }
        //      }
        //      for(int l=1;l<=i;l++){
        //          if(i==1)
        //              {System.out.print(i+l);
        //             }
        //      }

        //     System.out.println();
        // }
        int sp = n / 2, st = 1; 
  
        // Outer for loop for number of lines 
        for (int i = 1; i <= n; i++) { 
  
            // Inner for loop for printing space 
            for (int j = 1; j <= sp; j++) 
                System.out.print(" "); 
  
            // Inner for loop for printing number 
            int count = st / 2 + 1; 
            for (int k = 1; k <= st; k++) { 
                System.out.print(count); 
                if (k <= st / 2) 
                    count++; 
                else
                    count--; 
            } 
  
            // To goto next line 
            System.out.println(); 
            if (i <= n / 2) { 
  
                // sp decreased by 1 
                // st increased by 2 
                sp = sp - 1; 
                st = st + 2; 
            } 
  
            else { 
  
                // sp increased by 1 
                // st decreased by 2 
                sp = sp + 1; 
                st = st - 2; 
            } 
    }
}
}