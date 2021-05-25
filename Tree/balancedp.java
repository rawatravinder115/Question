import java.util.*;
class balancedp{
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
    static class balhelper{
        int h=0;
        boolean b=true;
    }

    public static balhelper isbalanced(node root){
        if(root == null){
            balhelper baseans=new balhelper();
            return baseans;
        }
      
        balhelper left=isbalanced(root.left);
        balhelper right= isbalanced(root.right);
        balhelper myans= new balhelper();
        myans.b=left.b && right.b &&(left.h-right.h>=-1 && left.h-right.h<=1 );
        myans.h=Math.max(left.h,right.h)+1;
        return myans;

    }

 public static void main(String[] args){
    int [] data={10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
    treeconstruct(data);
    balhelper ans=isbalanced(root);
    System.out.println(ans.b+" "+ans.h);
    
}
}