class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m+1][n+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(word1,word2,m-1,n-1,dp);
    }

    public int recurmemo(String s1,String s2,int m,int n,int dp[][]){
        if(m< 0)
        return n+1;

        if(n<0)
        return m+1;

        if(dp[m][n]!=-1)
        return dp[m][n];

        if(s1.charAt(m)==s2.charAt(n))
        return recurmemo(s1,s2,m-1,n-1,dp);

        int insert =1+recurmemo(s1,s2,m,n-1,dp);
        int delete=1+recurmemo(s1,s2,m-1,n,dp);
        int replace=1+recurmemo(s1,s2,m-1,n-1,dp);

        return dp[m][n]=Math.min(insert,Math.min(delete,replace));


    }
}
