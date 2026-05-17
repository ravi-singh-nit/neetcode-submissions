class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList();
        recurmemo(n,n,"");
        return ans;
    }

    public void recurmemo(int left,int right,String pattern){
        if(left==0 && right ==0){
            ans.add(pattern);
            return ;
        }

        if(left > right || left <0 || right<0)
        return ;

        recurmemo(left-1,right,pattern+"(");
        recurmemo(left,right-1,pattern+")");
    }
}
