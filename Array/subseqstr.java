class subseqstr{
    public static void subseq(String ques, String ans)
    {
     if(ques.length()==0)
     {
         System.out.println(ans);
         return; 
     }
     char ch= ques.charAt(0);
    //  roq = rest of quotent
     String roq=ques.substring(1);
     subseq(roq, ans+ch);
     subseq(roq , ans);
    
    }
  public static void main(String[] args)
 {
     subseq("abc",".");
 }
}