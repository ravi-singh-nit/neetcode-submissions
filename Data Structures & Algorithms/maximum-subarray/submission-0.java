class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sumSofar=0;
        for(int i:nums){
            sumSofar+=i;
            max=Math.max(sumSofar,max);
            if(sumSofar<0)
            sumSofar=0;
        }
        return max;
    }
}
