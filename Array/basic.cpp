#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> arr)
{
    for(int i=0;i<arr.size();i++)
    {
        cout<<arr[i]<<" ";
        
    }cout<<endl;
}
void fn(vector<int> arr)
{
    for(int i=0;i<arr.size();i++)
    {
        arr[i]=arr[i]+20;
        
    }
    display(arr);
}

int main()
{
    vector<int> arr(5,10);
    fn(arr);
    display(arr);
    return 0;

}