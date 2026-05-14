class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        Boolean dp[]=new Boolean[s.length()+1];
        for(String s1: wordDict)
        set.add(s1);
        return check(s,0,set,dp);
    }

    public boolean check(String s, int index,Set<String> set,Boolean dp[]){
        if(index==s.length())
        return true;

        if(dp[index]!=null)
        return dp[index];

        for(int i=index;i<s.length();i++){
            if(set.contains(s.substring(index,i+1))){
                if(check(s,i+1,set,dp))
                return dp[index]=true;
            }
        }
        return dp[index]=false;
    }
}
