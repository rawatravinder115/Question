import java.util.*;
class gtree{

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
    public static void display(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+"->");
        for(int i=0;i<root.child.size();i++){
            System.out.print(root.child.get(i).data+" ");
        }
        System.out.println(".");
        for(int i=0;i<root.child.size();i++){
            display(root.child.get(i));
        }
    }

    public static int size(node root){
        if(root==null){
            return 0;
        }
        int count =1;
        for(int i=0;i<root.child.size();i++){
            count+=size(root.child.get(i));
        }
        return count;
    }
    public static int max(node root){
        if(root== null){
            return -1;
        }
        int mymax=root.data;
        for(int i=0;i<root.child.size();i++){
            int childmax=max(root.child.get(i));
            if(childmax>mymax){
                mymax=childmax;
            }
        }
        return mymax;
    }
    public static boolean present(node root, int val){
        if(val== root.data){
          return true;
        }
        if(root==null){
            return false;
        }
        
        for(int i=0;i<root.child.size();i++){
            boolean ans=present(root.child.get(i), val);
            if(ans == true){
             return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int [] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        treeconstruct(data);
        display(root);
        System.out.println();
        System.out.println("size ="+size(root));
        System.out.println();
        System.out.println("max value in tree ="+max(root));
        System.out.println();
        System.out.print(present(root,120));


    }
}