#include<iostream>
#include<vector>
 using namespace std;
 vector<string> floodfill(vector<vector<int>> &arr , int i, int j)
 {   if(i==arr.size() && j==arr[0].size())
 {
     vector<string> base;
     base.push_back("");
     return base;
 }
     arr[i][j]=1;
     vector<string>myans;
     //up
     if(i-1>=0 && arr[i-1][j]!=0)
     {
         vector<string>recans=floodfill(arr,i-1,j);
         for(int i=0;i<arr.size();i++)
         {
             myans.push_back("u"+recans[i]);
         }
     }
     //left
      if(j-1>=0 && arr[i][j-1]!=0)
     {
         vector<string>recans=floodfill(arr,i,j-1);
         for(int i=0;i<arr.size();i++)
         {
             myans.push_back("l"+recans[i]);
         }
     }
      // down
     if(i+1>=0 && arr[i+1][j]!=0)
     {
         vector<string>recans=floodfill(arr,i+1,j);
         for(int i=0;i<arr.size();i++)
         {
             myans.push_back("d"+recans[i]);
         }
     }

      if(j+1>=0 && arr[i][j+1]!=0)
     {
         vector<string>recans=floodfill(arr,i,+1);
         for(int i=0;i<arr.size();i++)
         {
             myans.push_back("r"+recans[i]);
         }
     }
     arr[i][j]=0;
     return myans;
 }
 
 int main()
 {
     vector<vector<int>> arr={ {0,0,0,0,0},
                               {0,1,0,0},
                               {0,0,0,0}, 
                               {0,0,1,0,0},
                               {0,1,0,0,0} };
      vector<string>ans =floodfill(arr,0,0);

      for(int i=0;i<ans.size();i++)
    {
        cout<<ans[i];
    }
                 
 }