class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans= new ArrayList();
        if(n==1){
            ans.add(0);
            return ans;
        }
        //return new ArrayList(0);
        Map<Integer,Set<Integer>> map= new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new HashSet());
        }

        int indegree[]=new int[n];
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            map.get(u).add(v);
            map.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> queue= new LinkedList();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                queue.add(i);
                indegree[i]--;
            }
        }

        while(n>2){
            int s=queue.size();
            n-=s;
            while(s-->0){
                int curr= queue.poll();
                for(int nbr : map.get(curr)){
                    indegree[nbr]--;

                    if(indegree[nbr]==1){
                        queue.add(nbr);
                    }
                }
            }
        }
        
        while(queue.size()>0){
            ans.add(queue.poll());
        }
        return ans;

    }
}