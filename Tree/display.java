import java.util.*;
class display{
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
 public static void post(node root){
     if(root== null){
         return;
     }
         post(root.left);
        post(root.right);
        System.out.print(root.data+",");
 }
 public static void pre(node root){
     if(root == null){
         return;
     }
     System.out.print(root.data+" ");
     pre(root.left);
    pre(root.right);

 }
 public static void inorder(node root){
    if(root == null){
        return;
    }
      inorder(root.left);
  System.out.print(root.data+" ");
   inorder(root.right);
 }
 public static void  main(String[] args) {
    int [] data={10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
    treeconstruct(data);
    // post LRN LEFT RIGHT NODE
    System.out.println("postorder");
    post(root);

    System.out.println();
    System.out.println("preorder");
    // PRE NLR NODE LEFT RIGHT 
    pre(root);
    System.out.println();
    System.out.println("inorder between order");
    // INORDER LNR LEFT NODE RIGHT
    inorder(root);
 }
}