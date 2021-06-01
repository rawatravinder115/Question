#include<iostream>
using namespace std;

void printinc(int a , int b){
    if(a == b+1){
        return;
    }
    cout<< a <<" ";
    printinc(a+1,b);
}
void printdec(int a , int b){
    if(a == b+1){
        return;
    }
    printdec(a+1,b);
     cout<< a <<" ";
}
void printincdec(int a,int b){
    if(a== b+1){
        return;
    }
    if(a % 2 == 0){ // even
        cout<< a <<" ";
        }
    printincdec(a+1,b);
    if(a % 2 != 0){  //odd
    cout<< a<<" ";
    }
}
void solve(){
    int a,b;
    cin>> a>> b;
    printinc(a,b);// increasing 
    cout<<endl;
    printdec(a,b); //  decreaing
    cout<< endl;
    printincdec(a,b); 
}
int main(){
    solve();
    // printinc(1,10);
    return 0;
}