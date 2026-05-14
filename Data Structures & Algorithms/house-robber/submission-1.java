class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return memo(nums,n-1,dp);
    }

    public int memo(int nums[],int index,int dp[]){
        if(index<0)
        return 0;

        if(dp[index]!=-1)
        return dp[index];

        int take = nums[index] + memo(nums,index-2,dp);
        int noTake= 0 + memo(nums,index-1,dp);

        return dp[index]=Math.max(take,noTake);

    }


}
