class Solution {
    int dir[]={1,0,-1,0,1};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0,ans=0;
        LinkedList<Node> queue=new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new Node(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)
        return 0;
        int time=1;
        while(queue.size()>0){
            int s=queue.size();
            while(s-->0){
                Node curr = queue.poll();
                for(int i=0;i<4;i++){
                    int nx=curr.x+dir[i];
                    int ny=curr.y+dir[i+1];
                    if(nx< 0  || nx >= m || ny <0 || ny >=n || grid[nx][ny]!=1)
                    continue;
                    ans=time;
                    grid[nx][ny]=0;
                    fresh--;
                    queue.add(new Node(nx,ny));
                }
                
            }
            time++;
        }
        if(fresh!=0)
        return -1;
        return ans;
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
