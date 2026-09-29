class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> pq= new PriorityQueue<Node>((a,b)->a.val-b.val);
        Map<Integer,Integer> map=new HashMap();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> me: map.entrySet()){
            if(pq.size()<k){
                pq.add(new Node(me.getKey(), me.getValue()));
            }else if(pq.peek().val < me.getValue()){
                pq.poll();
                pq.add(new Node(me.getKey(),me.getValue()));
            }
        }
        int ans[]=new int[k];
        int i=0;
       // System.out.println("priorityQueue size "+pq.size()+"\n"+pq);
        for(Node node : pq){
            ans[i++]=node.key;

        }
        return ans;

    }
}

class Node{
    int key;
    int  val;

    public Node(int a,int b){
        key=a;
        val=b;
    }

    public String toString(){
        return key+" "+val;
    }
}

