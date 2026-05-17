class Solution {
    int m,n;
    int dir[]={1,0,-1,0,1};
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(matrix,i,j,dp));
            }
        }
        return ans;
    }

    public int dfs(int grid[][],int i,int j,int dp[][]){

        if(dp[i][j]!=-1)
        return dp[i][j];
        int max=1;
        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j + dir[k+1];

            if(ni >=0 && ni<m && nj>=0 && nj < n && grid[ni][nj] > grid[i][j]){
                max=Math.max(max,1+dfs(grid,ni,nj,dp));
            }
        }
        return dp[i][j]=max;
    }
}
