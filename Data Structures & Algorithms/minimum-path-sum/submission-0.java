class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(m-1,n-1,grid,dp);
    }

    public int recurmemo(int m,int n,int grid[][],int dp[][]){
        if(m<0 || n<0 )
        return 10000;
        if(m==0 && n==0)
        return grid[0][0];

        if(dp[m][n]!=-1)
        return dp[m][n];
        return dp[m][n]=Math.min(recurmemo(m-1,n,grid,dp) , recurmemo(m,n-1,grid,dp))+grid[m][n];
    }
}