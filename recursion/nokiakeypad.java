import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class nokiakeypad{
    public static void main(String[] args) {
        String str;
        Scanner scn =new Scanner(System.in);
        str=scn.nextLine();
        // System.out.print(str);
        // System.out.print(nokiakeypad01(str));
        // System.out.print(nokiakeypad02(str,""));
        System.out.print(nokiakeypad03(str,""));

    }

    public static ArrayList<String> words=new ArrayList<String>(Arrays.asList("?.",",;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
    
    // return type ===============================================================================
    public static ArrayList<String>  nokiakeypad01(String str){
        if(str.length() == 0){
            ArrayList<String> baseans = new ArrayList<>();
            baseans.add("");
            return baseans;
        }
        int idx = str.charAt(0) - '0';
        String word = words.get(idx);
        ArrayList<String> smallans = nokiakeypad01(str.substring(1));
        ArrayList<String> ans= new ArrayList<>();
        for(String s : smallans){
            for(int i = 0; i < word.length() ;i++){
                ans.add(word.charAt(i)+s);
            }
        }
        return ans;
    }

    public static int nokiakeypad02(String str , String ans){
        if(str.length() == 0){
            System.out.println(ans + " ");
            return 1 ;
        }
        int idx = str.charAt(0) -'0';
        String word = words.get(idx);
        int count = 0;
        for(int i = 0 ; i < word.length() ;i++){
            count+=nokiakeypad02(str.substring(1),ans + word.charAt(i));
        }
        return count;
    }
 // in this we consider two digit number also .
    public static int nokiakeypad03(String str , String ans){
        if(str.length() == 0){
            System.out.println(ans + " ");
            return 1 ;
        }
        int idx = str.charAt(0) -'0';
        String word = words.get(idx);
        int count = 0;
        for(int i = 0 ; i < word.length() ;i++){
            count+=nokiakeypad02(str.substring(1),ans + word.charAt(i));
        }

        if(str.length() > 1){
            int idx1 = str.charAt(1) - '0';
            int sum =idx*10 + idx1;
            if(sum > 10 && sum <= 11){
                word = words.get(sum);
                for(int i =0 ;i < word.length() ;i++)
                    count+=nokiakeypad03(str.substring(2) , ans + word.charAt(i));
            }
        }
        return count;
    }
}