class Solution {
    int dir[]={1,0,-1,0,1};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        int m=grid.length;
        int n=grid[0].length;

        boolean vis[][]=new boolean[m][n];
       // vis[0][0]=true;

        while(pq.size()>0){
            int curr[]=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int cost=curr[2];

            if(vis[r][c])
            continue;

            vis[r][c]=true;

            if(r==m-1 && c==n-1)
            return cost;

            for(int k=0;k<4;k++){
                int nr = r+dir[k];
                int nc = c+dir[k+1];
                if(nr>=0 && nr <m && nc>=0 && nc <n && vis[nr][nc]==false){
                    pq.add(new int[]{nr,nc,Math.max(cost,grid[nr][nc])});
                }
            }
        }
        return -1;
    }
}
