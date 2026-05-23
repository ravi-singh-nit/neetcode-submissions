class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length+1][2];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(0,1,prices,dp);
    }

    public int recurmemo(int n,int buy,int nums[],int dp[][]){
        if(nums.length == n)
        return 0;

        if(dp[n][buy]!=-1)
        return dp[n][buy];

        if(buy==1)
        return dp[n][buy]=Math.max(-nums[n]+recurmemo(n+1,0,nums,dp),recurmemo(n+1,buy,nums,dp));

        return dp[n][buy]=Math.max(nums[n]+recurmemo(n+1,1,nums,dp),recurmemo(n+1,buy,nums,dp));
    }
}