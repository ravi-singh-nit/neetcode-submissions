class Solution {
    int m,n;
    int dir[]={1,0,-1,0,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        List<List<Integer>> ans=new ArrayList();
        boolean avisited[][]=new boolean[m][n];
        boolean pvisited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dfs(heights,i,j,pvisited);
                }

                if(i== m-1 || j==n-1){
                    dfs(heights,i,j,avisited);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(avisited[i][j] && pvisited[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;

        
    }


    public void dfs(int grid[][],int i,int j,boolean visited[][]){
        if(visited[i][j])
        return ;


        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            if(ni>=0 && ni<m && nj>=0 && nj<n && grid[i][j]<=grid[ni][nj]){
                dfs(grid,ni,nj,visited);
            }
        }
    }
}
