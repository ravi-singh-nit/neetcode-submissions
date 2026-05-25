class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int l=0,r=0;
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int index=0;
        while(r<n){
            pq.add(nums[r]);
            // System.out.println(pq+"\n\n");
            if(r-l+1 >= k){
                ans[index++]=pq.peek();
                pq.remove(nums[l++]);
            }
            r++;
        }
        return ans;
    }
}
