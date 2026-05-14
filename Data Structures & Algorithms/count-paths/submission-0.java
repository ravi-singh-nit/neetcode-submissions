class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurMemo(m,n,dp);
    }

    public int recurMemo(int m,int n,int dp[][]){
        if(m==1 || n==1)
        return 1;
        if(m<1 || n<1)
        return 0;

        if(dp[m][n] != -1)
        return dp[m][n];

        return dp[m][n]=recurMemo(m-1,n,dp)+recurMemo(m,n-1,dp);
    }
}
