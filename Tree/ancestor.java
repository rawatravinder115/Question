import java.util.*;
// import java.ArrayList;
class ancestor{

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

        public static ArrayList<Integer> ancestor(node root,int val){
                if(root==null){
                    return null;
                }
                if(root.data == val){
                   ArrayList<Integer> ans =new ArrayList<>();
                   ans.add(root.data);
                   return ans;
                }
                   for(int i=0;i<root.child.size();i++){
                       ArrayList<Integer> recans =ancestor(root.child.get(i),val);
                       if(recans!= null){
                           recans.add(root.data);
                           return recans;
                       }
                   }
                   return null;
                }

                public static int lca(node root,int d1,int d2){
                    ArrayList<Integer> ans1=ancestor(root,d1);
                    ArrayList<Integer> ans2=ancestor(root,d2);
                    int i=ans1.size()-1;
                    int j=ans2.size()-1;
                    while(i>=0 && j>=0){
                        if(ans1.get(i)!= ans2.get(j)){
                            break;
                        }
                        i--;
                        j--;
                    }
                    return ans1.get(i+1);
                }
    public static void main(String[] args){
        int [] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        treeconstruct(data);
        System.out.print(lca(root,80,90));
        
        
        
    }
}