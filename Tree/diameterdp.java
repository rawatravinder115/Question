import java.util.*;
class diameterdp{
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
 static class diahelper{
     int d =0; // diameter
     int h =0; // height 
 }
 public static diahelper diameterdp(node root){
     if(root == null){
         diahelper baseans=new diahelper();
         return baseans;
     }

    diahelper left=diameterdp(root.left);
    diahelper right=diameterdp(root.right);
    diahelper myans = new diahelper();
    myans.d= Math.max(left.h+right.h+1, Math.max(left.d , right.d));
    myans.h= Math.max(left.h, right.h)+1;
    return myans;
 }

 public static void main(String[] args){
    int [] data={10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
    treeconstruct(data);
    diahelper ans= diameterdp(root);
    System.out.println(ans.d+" "+ ans.h);
}
}