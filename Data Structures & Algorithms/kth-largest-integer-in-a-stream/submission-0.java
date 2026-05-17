class KthLargest {
    PriorityQueue<Integer> queue;
    int capacity;

    public KthLargest(int k, int[] nums) {
        queue=new PriorityQueue<>();
        capacity=k;

        for(int i:nums){
            add(i);
        }

        
    }
    
    public int add(int i) {
        if(queue.size()<capacity){
                queue.add(i);
            }else{
                int cmin=queue.peek();
                if(cmin < i){
                    queue.poll();
                    queue.add(i);
                }
        }
        return queue.peek();
        
    }
}
