#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> &myans)
{
    for(int i=0;i<myans.size();i++)
    {
        cout<<myans[i];
    }
}

vector<int> allocc(vector<int> &arr,int idx,int data,int count)
{ 
    if(idx==arr.size())
    {
        vector<int> baseans(count,0);
        return baseans;
    }
    
    if(data==arr[idx])
    {
        count++;
    }

      vector<int> recans= allocc(arr,idx+1,data,count);
      if(arr[idx]==data)
      {
          recans[count-1]=idx;
      }
      return recans;
  }

int main()
  {
      vector<int> arr={20,30,20,50,80};
      vector<int>  myans = allocc(arr,0,20,0);
      display(myans);
      
    }