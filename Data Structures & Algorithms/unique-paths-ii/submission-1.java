class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(m-1,n-1,obstacleGrid,dp);
    }

    public int recurmemo(int m,int n,int grid[][],int dp[][]){
        if(m<0 || n<0 || grid[m][n]==1)
        return 0;
        if(m==0 && n==0)
        return 1;
        if(dp[m][n]!=-1)
        return dp[m][n];
        return dp[m][n]=recurmemo(m-1,n,grid,dp) + recurmemo(m,n-1,grid,dp);
    }
}