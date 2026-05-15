class Solution {
    int area;
    int ans;
    int dir[]={1,0,-1,0,1};
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        ans=area=0;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    area=0;
                    dfs(grid,i,j);
                    ans=Math.max(area,ans);
                }
            }
        }
        return ans;

    }
    public void dfs(int grid[][],int i,int j){
        if(i<0 || i>=m ||j<0 ||j>=n || grid[i][j]==0)
        return ;

        grid[i][j]=0;
        area++;

        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            dfs(grid,ni,nj);
        }
    }
}
