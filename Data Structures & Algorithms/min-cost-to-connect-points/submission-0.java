class Solution {
    public int getDistance(int i,int j,int points[][]){
        return Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);

    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DSU dsu= new DSU(n);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.add(new int[]{getDistance(i,j,points),i,j});
            }
        }

        int edgeCount=0;
        int totalCost=0;
        while(edgeCount != n-1){
            int curr[]=pq.poll();
            if(dsu.union(curr[1],curr[2])){
                totalCost+=curr[0];
                edgeCount++;
            }
        }

        return totalCost;
        
    }
}

class DSU{
    int par[];
    int rank[];

    public DSU(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        if(x==par[x])
        return x;
        
        return par[x]=find(par[x]);
    }


    public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);


        if(px==py)
        return false;

        if(rank[px] > rank[py]){
            par[py]=px;
        }else if(par[py]> rank[px]){
            par[px]=py;
        }else{
            par[px]=py;
            rank[py]++;
        }
        return true;
    }
}