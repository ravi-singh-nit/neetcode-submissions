class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu= new DSU(n+1);
        for(int a[]:edges){
            if(!dsu.union(a[0],a[1]))
            return a;
        }
        return null;
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
        }
        Arrays.fill(rank,1);
    }

    public int findParent(int x){
        if(x==par[x])
        return x;

        return par[x]=findParent(par[x]);
    }

    public boolean union(int x,int y){
        int px=findParent(x);
        int py=findParent(y);

        if(px==py)
        return false;

        if(rank[px] > rank[py]){
            par[py]=px;
        }else if(rank[py] > rank[px]){
            par[px]=py;
        }else{
            par[px]=py;
            rank[py]++;
        }
        return true;
    }
}
