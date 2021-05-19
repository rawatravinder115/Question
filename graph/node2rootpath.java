import java.util.ArrayList;

class node2rootpath{
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

    public static ArrayList<Integer> path(node root,int val){
     if(root==null){
         return null;
     }
     if(root.data == val){
        ArrayList<Integer> ans =new ArrayList<>();
        ans.add(root.data);
        return ans;
     }
        for(int i=0;i<root.child.size();i++){
            ArrayList<Integer> recans =path(root.child.get(i),val);
            if(recans!= null){
                recans.add(root.data);
                return recans;
            }
        }
        return null;
    }

    public static void main(String[] args){
        int [] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        treeconstruct(data);
        ArrayList<Integer> path=path(root,120);
        System.out.println(path);
    }
}