class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();

        int dp[][]=new int[m+1][n+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }

        return recurmemo(s,t,m-1,n-1,dp);
    }

    public int recurmemo(String s,String t,int m,int n,int dp[][]){
        if(n<0)
        return 1;
        if(m<0)
        return 0;

        if(dp[m][n]!=-1)
        return dp[m][n];

        int take=0;
        if(s.charAt(m)==t.charAt(n))
         take=recurmemo(s,t,m-1,n-1,dp);

        int notake=recurmemo(s,t,m-1,n,dp);
         return dp[m][n]=take+notake;


    }
}
