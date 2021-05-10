#include<iostream>
#include<vector>
using namespace std;int main()
int rotated(vector<int> &arr)
{
    int left=0;
    int right=arr.size()-1;
    while(left<=right)
    {
        int mid=(left+right)/2;
         if(arr[mid]>arr[left])
         { 
            left=mid+1;
         }
         else if(arr[mid]<arr[left])
         {
             right=mid-1;
         } 
    }
}
{
    vector<int> arr{ 9,10,11,12,13,14,15,16,17,1,2,3,5,8}
    rotated(arr);

}