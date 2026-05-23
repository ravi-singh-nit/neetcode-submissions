class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map=new HashMap();
        for(int i=0;i<n;i++){
            map.put(i+1,new ArrayList());
        }

        for(int a[]:times){
            map.get(a[0]).add(new int[]{a[1],a[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.add(new int[]{k,0});
        Set<Integer> vis=new HashSet();
        int ans=0;
        
        while(pq.size()>0){
            int curr[]=pq.poll();
            if(vis.contains(curr[0]))
            continue;
            ans=Math.max(ans,curr[1]);
            vis.add(curr[0]);
            for(int a[]:map.get(curr[0])){
                if(vis.contains(a[0]))
                continue;
                pq.add(new int[]{a[0],curr[1]+a[1]});
            }
        }
        if(vis.size()!=n)
        return -1;
        return ans;

    }
}
