class Solution {
    int dir[]={1,0,-1,0,1};
    int m,n;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,i,j,word,0))
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char grid[][],int i, int j,String s,int index){
        if(index==s.length())
        return true;
        if(i<0|| i>= m|| j<0 || j>=n || s.charAt(index)!=grid[i][j])
        return false;
        char c=grid[i][j];
        grid[i][j]='#';
        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            if(dfs(grid,ni,nj,s,index+1))
            return true;
        }
        grid[i][j]=c;
        return false;
    }
}
