class Solution {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        int n=nums.length;
        if(n==1)
        return true;
        for(int i=1;i<n;i++){
            if(max<i)
            return false;

            max=Math.max(max,i+nums[i]);
            if(max>=n-1)
            return true;

        }
        return false;
    }
}
