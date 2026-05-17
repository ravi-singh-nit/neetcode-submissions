class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        for(int i:stones){
            queue.add(i);
        }

        while(queue.size()>1){
            int first=queue.poll();
            int second=queue.poll();
            int diff=Math.abs(first-second);
            if(diff!=0)
            queue.add(diff);
        }
        if(queue.size()==0)
        return 0;
        return queue.poll();
        
    }
}
