#include<iostream>
#include<vector>
using namespace std;
void ceilfloor(vetcor<int> &arr , int data)
{
    int left=0;
    int right= arr.size()-1;
    while(left<=right)
    {
         int mid=(left+right)/2;
          if(mid==data)
          {
              
          }
           
    }
}
int main()
{
    vector<int> arr{ 10,20,30,40,50,60,70};
    cout<<"enter the element to find in array";
    int data;
    cin>>data;
    ceilfloor(arr, data);

}