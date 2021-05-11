// in this question we required to find a chahcter whisch has a maximum frequency 
// in the hashamap  .  we have given a string i in which  we have to find the occcurence of character 

import java.util.*;
class MaxOccur{

    public static void main(String[] args) {
        String str="aaasssddddgggrrrrvvvhhhggggg";
        char ch =MostFreqchar(str);
        System.out.println();
        System.out.print(ch);
    }
    public static  Character MostFreqchar(String str) {
        HashMap<Character ,Integer > hm =new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(hm.containsKey(ch)){
              int freq =hm.get(ch);
              hm.put(ch, freq + 1);
            }else{
                hm.put(ch,1);
            }
        }
        char ans=str.charAt(0);
        int freq =1;
        for(char ch : hm.keySet() ){
            int cfreq = hm.get(ch);
            if( cfreq > freq){
                ans =ch;
                freq=hm.get(ch);
            }
        }
        for(char ch : hm.keySet()){
            System.out.print(ch);
        }
        return ans;
    }
}
