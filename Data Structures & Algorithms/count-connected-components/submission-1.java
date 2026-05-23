class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> map=new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList());
        }
        for(int a[]:edges){
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }
        int ans=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(i,map,vis,-1);
            }
        }
        return ans;
    }

    public void dfs(int s,Map<Integer,List<Integer>> map,boolean vis[],int p){
        vis[s]=true;
        for(int i:map.get(s)){
            if(i==p)
            continue;
            if(vis[i]==false)
                dfs(i,map,vis,s);
        }

    }


}
