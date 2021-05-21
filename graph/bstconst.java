import java.util.*;
class bstconst{
     
     static class node{
         int data;
         node right;
         node left;
         node(int d){
             this.data=d;
             this.left=this.right=null;
         }
     }
     public static node construct(int [] data,int sp,int ep){
        if(sp>ep){
            return null;
        }else if(sp == ep){
            return new node(data[sp]);
        }
        int mid=(sp+ep)/2;

        node root =new node(data[mid]); 
          root.left =construct(data,sp,mid-1);
          root.right =construct(data,mid+1,ep);
         return root;
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

  public static int max(node root){
      if(root == null){
          return Integer.MAX_VALUE;
      }
      while(root.right != null){
          root=root.right;
      }
      return root.data;
  }

  public static int min(node root){
    if(root == null){
        return Integer.MIN_VALUE;
    }
    while(root.left != null){
        root=root.left;
    }
    return root.data;
}

public static boolean find(node root,int val){
    if(root == null){
        return false;
    }
    if(root.data == val){
      return true;
    }
    if(val < root.data){
        return find(root.left,val);
    }else{
        return find(root.right,val);
    }
}
     public static void main(String[] args){
         int[] data={10,20,30,40,50,60,70,80,90,100};
        node root= construct(data,0,data.length-1);
        display(root);
        System.out.println();
        System.out.println(" max    " + max(root));
        System.out.println(" min    " + min(root));
        System.out.println(" find   " + find(root, 40));
     }
}