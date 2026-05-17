class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recurmemo(nums,nums.length-1,target);
    }

    int recurmemo(int nums[],int n,int target){
        if(n < 0 )
        return target == 0 ?  1:0;
        return recurmemo(nums,n-1,target+nums[n]) +recurmemo(nums,n-1,target-nums[n]);
    }
}
