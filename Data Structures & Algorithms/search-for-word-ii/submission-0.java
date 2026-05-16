class Solution {
    int m,n;
    List<String> ans;
    int dir[]={1,0,-1,0,1};
    public List<String> findWords(char[][] board, String[] words) {
        Node root= new Node();
        ans=new ArrayList();
        m=board.length;
        n=board[0].length;
        for(String s:words){
            insert(s,root);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root);
            }
        }
        return ans;
    }


    public void insert(String s,Node root){
        for(char c:s.toCharArray()){
            if(root.next[c-'a']==null){
                root.next[c-'a']=new Node();
            }
            root=root.next[c-'a'];
        }
        root.word=s;
    }


    public void dfs(char grid[][],int i,int j,Node root){

        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        if(i<0 || i>=m || j<0 || j >= n || grid[i][j]=='*'||
        root == null || root.next[grid[i][j]-'a']==null)
        return ;
        char c =grid[i][j];
        grid[i][j]='*';

        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];
            dfs(grid,ni,nj,root.next[c-'a']);
        }
        grid[i][j]=c;
    }
}

class Node{
    String word;
    Node next[];

    public Node(){
        word=null;
        next=new Node[26];
    }
}
