class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                int dista =a[0]*a[0]+a[1]*a[1];
                int distb =b[0]*b[0]+b[1]*b[1];
                return distb-dista;
            }
        ); 

        for(int a[]:points){
            pq.add(a);
            if(pq.size()>k)
                pq.poll();
        }
        int ans[][]=new int[pq.size()][2];
        int i=0;
        while(pq.size()>0){
            ans[i]=pq.poll();
            i++;
        }
        return ans;


    }
}
