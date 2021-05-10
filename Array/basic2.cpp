#include<iostream>
#include<vector>
using namespace std;
int display(vector<int> &arr,int n,int m,int loc)
{ 
    if(n==arr.size())
    {
        return loc;
    }
    
    if(m==arr[n])
    {
        loc=n;
    }

      display(arr,n+1,m,loc);
    // return recAns;
  }

int main()
  {
      vector<int> arr={20,30,80,20,50,80};
      int  myans = display(arr,0,80,0);
      cout<<myans;
      
    }