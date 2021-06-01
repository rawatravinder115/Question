#include<iostream>
#include<vector>
using namespace std;

vector<string> words={"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
vector<string> nokiakeypad(string str){
    if(str.length() == 0){
        vector<string> base;
        base.push_back("");
        return base;
    }
    int idx=str[0]-'0';
    string word=words[idx];
    vector<string> smallans=nokiakeypad(str.substr(1));
    vector<string> myans;

   for(string s: smallans){
       for(int i=0;i<word.length();i++){
           myans.push_back(word[i]+s);
       }
   }
   return myans;
}
// void type 
int nokiakeypad01(string str,string ans){
    if(str.length() == 0){
        cout<<ans<<endl;
        return 1;
    }
    int idx=str[0] - '0';
    string word=words[idx];
    int count =0;
    for(int i=0;i<word.length();i++){
        count+=nokiakeypad01(str.substr(1),ans+word[i]);
    }
    return count;
}

 // if we consider two digit number at the time 
int nokiakeypad02(string str,string ans){
    if(str.length() == 0){
        cout<<ans<<endl;
        return 1;
    }
    int idx=str[0] - '0';
    string word=words[idx];
    int count =0;
    for(int i=0;i<word.length();i++){
        count+=nokiakeypad02(str.substr(1),ans+word[i]);
    }

    if(str.length() >1){
        int idx1=str[1]-'0';
        int num=idx*10+idx1;
        if(num>=10 && num<=11 ){
            word=words[num];
            for(int i=0;i<word.length();i++){
        count+=nokiakeypad02(str.substr(2),ans+word[i]);
    }
        }
    }
    return count;
}
 
 int main(){
     string str;
     cin>>str;
    //  vector<string> ans=nokiakeypad(str);
    //  for(string s:ans){
    //      cout<<s<<" ";
    //  }
    //  cout<<"########################"<<endl;
    //  cout<<nokiakeypad01(str,"")<< endl;
     cout<<"########################"<<endl;
     cout<<nokiakeypad02(str,"");
 }