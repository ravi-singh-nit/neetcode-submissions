class Solution {
    int m ,n;
    int dir[]={1,0,-1,0,1};
    public void solve(char[][] board) {
         m=board.length;
         n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==m-1 ||j==0 ||j==n-1){
                    if(board[i][j]=='O'){
                        //System.out.println("calling for "+i+" "+j);
                        dfs(board,i,j);
                    }
                }
            }
        }
       // print(board);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }

    }
    public void print(char grid[][]){
        for(char ch[]:grid){
            for(char c:ch){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    public void dfs(char grid[][],int i,int j){
        if(i < 0 || i>=m || j<0 ||j>=n || grid[i][j]!='O')
        return ;

        grid[i][j]='#';
        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            dfs(grid,ni,nj);
        }
    }
}
