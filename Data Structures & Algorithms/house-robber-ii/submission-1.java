class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        return nums[0];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int excludingLast=recur(0,n-2,nums,dp);
        Arrays.fill(dp,-1);
        int excludingFirst=recur(1,n-1,nums,dp);
        return Math.max(excludingLast,excludingFirst);
    }

    public int recur(int s,int end,int nums[],int dp[]){
        if(s>end)
        return 0;

        if(dp[s]!=-1)
        return dp[s];

        int take = nums[s]+recur(s+2,end,nums,dp);

        int noTake =recur(s+1,end,nums,dp);

        return dp[s]=Math.max(take,noTake);
    }
}
