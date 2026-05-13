class Solution {
    public boolean isValidSudoku(char[][] board) {
        return rowCheck(board) && columnCheck(board) && boxCheck(board);
    }
    public boolean rowCheck(char board[][]){
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet();
            for(int j=0;j<9;j++){
                char current=board[i][j];
                if(current != '.' && set.contains(current))
                return false;
                set.add(current);
            }
        }
        return true;
    }

    public boolean columnCheck(char board[][]){
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet();
            for(int j=0;j<9;j++){
                char curr = board[j][i];
                if(curr != '.' && set.contains(curr))
                return false;
                set.add(curr);
            }
        }
        return true;
    }
    public boolean boxCheck(char board[][]){
        int row[]={0,3,6};
        int col[]={0,3,6};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int sr=row[i];
                int sc=col[j];
                Set<Character> set=new HashSet();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        char curr=board[sr+k][sc+l];
                        if(curr!='.'&&set.contains(curr))
                            return false;
                        set.add(curr);
                    }
                }
            }
        }
        return true;
    }
}
