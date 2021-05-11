import java.util.*;
class printCommonElement{
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,2,3,5,6,8,8};
        int [] b={3,4,5,6,7,8,9,4,8,6,8,3};
        //printcommon01(a,b); // with no repeated element 
        printcommon02(a,b); // with  repeated element and order .
    }
    public static void printcommon01(int[] a ,int[] b){

        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i= 0 ; i<a.length;i++){
        if(hm.containsKey(a[i])){
            hm.put(a[i] , hm.get(a[i])+1);
        }else{
             hm.put(a[i], 1);
        }
        }

        for(int i= 0;i<b.length;i++){
            if(hm.containsKey(b[i])){
                System.out.print(b[i]+" ");
            }
        }
    }
    public static void printcommon02(int[] a ,int[] b){

        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i= 0 ; i<a.length;i++){
        if(hm.containsKey(a[i])){
            hm.put(a[i] , hm.get(a[i])+1);
        }else{
             hm.put(a[i], 1);
        }
        }

        for(int i= 0;i<b.length;i++){
            if(hm.containsKey(b[i])){
                System.out.print(b[i]+" ");
                int freq=hm.get(b[i]);
                freq--;

                if(freq > 0){
                    hm.put(b[i] , freq);
                }else{
                    hm.remove(b[i]);
                }
            }
        }
    }
}