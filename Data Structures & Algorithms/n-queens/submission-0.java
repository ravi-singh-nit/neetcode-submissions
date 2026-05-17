class Solution {
    int n;
    List<List<String>> ans; 
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        ans=new ArrayList();
        char grid[][]=new char[n][n];
        for(char ch[]:grid)
        Arrays.fill(ch,'.');
        recur(grid,0);
        return ans;
    }

    public void recur(char grid[][],int r){
        if(r==n){
            List<String> lans=new ArrayList();
            for(char c[]:grid){
                lans.add(String.valueOf(c));
            }
            ans.add(lans);
            return;
        }

        for(int j=0;j<n;j++){
            if(isSafe(grid,r,j)){
                grid[r][j]='Q';
                recur(grid,r+1);
                grid[r][j]='.';
            }
        }

    }

    public boolean isSafe(char grid[][],int r,int c){
        //col check
        for(int i=r-1;i>=0;i--){
            if(grid[i][c]=='Q')
                return false;
        }

        //left diagonal
        for(int i=r-1,j=c-1;i>=0 &&j>=0;i--,j--){
            if(grid[i][j]=='Q')
            return false;
        }

        //right diagonal
        for(int i=r-1,j=c+1;i>=0 &&j<n;i--,j++){
            if(grid[i][j]=='Q')
            return false;
        }

        return true;
    }
}
