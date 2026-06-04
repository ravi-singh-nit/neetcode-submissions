class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        //src, step, cost
        queue.offer(new int[]{src, 0, 0});
        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int steps = curr[1];
            int cost = curr[2];

            if(steps > k+1){
                continue;
            }

            if(steps > bestStops[node]){
                continue;
            }

            bestStops[node] = steps;

            if(node == dst){
                return cost;
            }
           

            for(int[] neigh : adj.get(node)){
                int v = neigh[0];
                int w = neigh[1];
                queue.offer(new int[]{v, steps+1, cost+w});
            }
        }

        return -1;
    }
}