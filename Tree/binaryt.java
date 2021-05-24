import java.util.*;
class binaryt{

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
  public static int size(node root){ 
    if(root == null){
        return 0;
    }
    int mysize =1;
    if(root.left != null){
        mysize+=size(root.left);
    }
    if(root.right!= null){
        mysize+=size(root.right);
    }
    return mysize;
  }
 
  public static int height(node root){
      if(root== null){
          return 0;
      }

      int myheight=0;
      if(root.left!= null){
          myheight=height(root.left);
      }
      if(root.right!= null){
          myheight=Math.max(myheight,height(root.right));
      }
      return myheight+1;
  }
  
  public static int max(node root) {
      if(root== null){
          return -1;
      }
      int mymax=root.data;
      if(root.left!=null){
          mymax=Math.max(mymax,max(root.left));
      }
      if(root.right!= null){
          mymax=Math.max(mymax, max(root.right));
      }
      return mymax;
  }

  public static boolean find(node root,int val){
      if(root == null )
      return false;

      if(root.data == val){
          return true;
      }
      boolean ans=false;
      if(root.left!= null){
           ans=find( root.left, val);
          if(ans)
          return true;
      }
    if(root.right!= null){
        ans=find(root.right, val);
        if(ans)
        return true;
    }
return false;
  }
    public static void  main(String[] args) {
        int [] data={10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
        treeconstruct(data);
        display(root);
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println(max(root));
        System.out.println(find(root,50));

    }
}