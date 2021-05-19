import java.util.*;
class levelprint{
    static node root=null;
    static class node{
        int data;
        ArrayList<node> child;
        node(int d){
            this.data =d;
            child=new ArrayList<>();
             }
         }
    public static void treeconstruct(int [] data){
        // cp current parent list 
        ArrayList<node> cplist= new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i]==-1){
            cplist.remove(cplist.size()-1);
            }else{
                node currnode=new node(data[i]);
                if(root== null){
                   root = currnode;
                }else{
                    node cp= cplist.get(cplist.size()-1);
                    cp.child.add(currnode);
                }
                cplist.add(currnode);
            }
        }
    }

    public static void displaylo(node root){
        Queue<node> qu=new LinkedList<>();
        qu.add(root);
        while(qu.size() >0){
            node currnode= qu.remove();
            System.out.print(currnode.data +" ");
            for(int i=0;i<currnode.child.size();i++){
                qu.add(currnode.child.get(i) );
            }
        }
    }
    public static void main(String[] args){
        int [] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        treeconstruct(data);
        // lo level order 
        displaylo(root);
    }
}