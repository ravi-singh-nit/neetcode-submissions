class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int ssf =0;
        int maxSum=nums[0];

        int msf=0;
        int minSum=nums[0];

        for(int i:nums){
            total+=i;

            ssf+=i;
            ssf=Math.max(ssf,i);
            maxSum=Math.max(ssf,maxSum);

            msf+=i;
            msf=Math.min(msf,i);
            minSum=Math.min(msf,minSum);
        }

        if(maxSum<0)
        return maxSum;

        return Math.max(maxSum,total-minSum);
    }
}