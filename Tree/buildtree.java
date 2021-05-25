// build array from pre order and inorder arrrangement 

import java.util.*;
class buildtree{
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
public static node build(int []pre ,int [] in,int ps, int pe, int is, int ie){

    if(is== ie || ps== pe){
        node basenode=new node(pre[ps]);
        return basenode;
    }
    if(is> ie || ps> pe){
        return null;
    }
    node croot =new node(pre[ps]);
    int i=is;
    int count=0;
    while(pre[ps]!= in[i]){
        i++;
        count++;
    }
    croot.left= build(pre , in ,ps+1, ps+count,is, i-1);
    croot.right= build(pre, in, ps+count+1, pe, i+1, ie);
    return croot;
}
public static void display(node root){
    if(root == null){
        return;
    }
    if(root.left != null){
        System.out.print(root.left.data +" -> ");
    }
    System.out.print(root.data+" ");

    if(root.right!= null){
        System.out.print(" <- "+ root.right.data);
    }
System.out.println(".");
if(root.left!=null){
   display(root.left);
}
if(root.right!=null){
  display(root.right);
}
}
  public static void main(String[] args) {
   
     int[] pre={10,20,30,4,5,40,1,80,50,60,2,90,70,100,3};
     int [] in ={4,30,5,20,1,40,80,10,2,60,90,50,100,70,30};
     // build tree with pre[NLR] and inorder[LNR]
      node croot1 = build(pre,in, 0,pre.length-1,0,in.length-1);
      display(croot1);

  }
}