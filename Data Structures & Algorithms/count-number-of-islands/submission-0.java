class Solution {
    int m,n;
    int dir[]={1,0,-1,0,1};
    public int numIslands(char[][] grid) {
         m=grid.length;
         n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char grid[][],int i,int j){
        if(i<0 || i >= m || j<0 || j>=n || grid[i][j]=='0')
        return;

        grid[i][j]='0';
        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            dfs(grid,ni,nj);
        }
    }
}
