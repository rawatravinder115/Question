// in this question we generally take a random tree and check whether its a 
//binary scearch tree or not 



import java.util.*;

class isbst{
  
    static node root=null;
    static class node{
        node left;
        node right;
        int data;
        node(int d){
            this.data=d;
            this.left = this.right = null;
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
     static class bsthelper{
         int min=Integer.MAX_VALUE;
         int max=Integer.MIN_VALUE;
         boolean isbst=true;
     }
    
     public static bsthelper bst(node root){
         if(root== null){
            bsthelper baseans=new bsthelper();
            return baseans; 
         }else if(root.left == null && root.right == null){
            bsthelper baseans= new bsthelper();
            baseans.max=root.data;
            baseans.min=root.data;
            return baseans;
         }
        bsthelper left=bst(root.left);
        bsthelper right=bst(root.right);
        bsthelper myans=new bsthelper();
        myans.isbst= left.isbst && right.isbst&&(root.data >left.max && root.data < right.min);
         if(myans.isbst ) {
             if(root.left != null){
                 myans.min=left.min;
             }else{
                 myans.min= root.data;
             }
             if(root.right != null){
                 myans.max=right.max;
             }else{
                 myans.max=root.data;
             }
         }
         return myans;

     }
    public static void main(String[] args) {
        int[] data={50,25,12,-1,40,35,-1,45,-1,-1,-1,70,60,-1,80};
        treeconstruct(data);
       bsthelper ans= bst(root);
       System.out.print(ans.isbst+" "+ans.max+" "+ans.min);
    }
}