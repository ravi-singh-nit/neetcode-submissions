class Solution {
    int dir[]={1,0,-1,0,1};
    public void islandsAndTreasure(int[][] grid) {
        LinkedList<Node> queue=new LinkedList();
        int m=grid.length;
        int n=grid[0].length;
        int INF=2147483647;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.add(new Node(i,j));
                }
            }
        }
       // System.out.println("queuue size "+queue.size());
        int dist =1;
        while(queue.size()>0){
            int s=queue.size();
            while(s-->0){
                Node curr= queue.poll();
               // System.out.println("poppeded node "+curr.x +" "+curr.y);
                for(int i=0;i<4;i++){
                    int nx=curr.x+dir[i];
                    int ny=curr.y+dir[i+1];
                    // System.out.println("next  node "+nx +" "+ny);
                    if(nx < 0  || nx >= m || ny < 0 || ny >= n  || grid[nx][ny]==-1)
                    continue;
                
                    if(grid[nx][ny]==INF){
                      //  System.out.println("setting "+nx +" "+ny+"  "+grid[nx][ny]);
                        grid[nx][ny]=dist;
                        queue.add(new Node(nx,ny));
                    }
                    
                }
            }
            dist++;
        }
        

    }
}

class Node{
    int x;
    int y;

    public Node(int i,int j){
        x=i;
        y=j;
    }
}
