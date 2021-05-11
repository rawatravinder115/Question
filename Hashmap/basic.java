import java.util.*;
class basic{

    public static void main(String[] args) {
        HashMap<String, Integer> hm=new HashMap<>();
          hm.put("india" ,10000);
          hm.put("pakistan" , 1000);
          hm.put("china", 29998);
          Set<String> keys= hm.keySet();
          System.out.println("hashmap : " + hm.toString()); // to print hashmap in this order hashmap : {china=29998, pakistan=1000, india=10000};
          for(String key : keys){
              System.out.println(hm.get(key));
          }
          hm.remove("pakistan");

          for(String key : keys){
            System.out.println(hm.get(key));
        }
        if(hm.containsKey("vietnam"))
        hm.put("pakistan" , 1000);
        else 
        System.out.println("keys doesnt exists ");

    }
}  