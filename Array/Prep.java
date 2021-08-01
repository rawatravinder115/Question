import java.util.*;

class prep{
    public static void main(String[] args) {
        
    }

    public static int fifthEle(String str , int MAX_CHAR , int y){

        int n = str.length();

        int [] count = new int[MAX_CHAR];

        int [] index = new int[MAX_CHAR];

        for(int i=0;i<MAX_CHAR;i++){
            count[i]=0;
            index[i]=n;
        }

        for(int i =0;i<n;i++){
            char x = str.charAt(i);
            ++count[x];

            if(count[x] == 1){
                index[i] = i;
            }

            if(count[x] == 2){
                index[x] = n;
            }
        }

        Arrays.sort(index);

    return index[y-1] != n ? index[y-1] : -1;

    }
}