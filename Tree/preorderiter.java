import java.util.*;
class preorderiter{
    static node root=null;
    static class node{
        int data;
        node left;
        node right;
        node(int d){
            this.data=d;
            this.left = this.right =null;
        }
    }
 public static void treeconstruct(int[] data){
    ArrayList<node> cplist=new ArrayList<>();
     for(int i=0;i<data.length;i++){
        if(data[i] == -1){
        cplist.remove(cplist.size()-1);
        }else{
            node currnode= new node(data[i]);
            if(root == null){
                root= currnode;
            }else{
                node cp=cplist.get(cplist.size()-1);
                if(cp.left == null){
                    cp.left= currnode;
                }else{
                    cp.right = currnode;
                }
            }
            cplist.add(currnode);
        }
     }
 }

 public static void preorder(node root){
     ArrayList<node> stack = new ArrayList<>();
     stack.add(root);
     while(stack.size()>0){
         node currnode = stack.remove(stack.size()-1);
         System.out.print(currnode.data+" ");
         if(currnode.right!= null){
             stack.add(currnode.right);
         }
         if(currnode.left!= null){
             stack.add(currnode.left);
         }
     }
 }
    public static void main(String[] args){
        int [] data={10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
        treeconstruct(data);
        preorder(root);
        
    }
}