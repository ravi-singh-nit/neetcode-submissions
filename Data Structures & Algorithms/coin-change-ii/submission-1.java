class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(coins,coins.length-1,amount,dp);
    }

    public int recurmemo(int nums[],int n,int amount,int dp[][]){
        if(n < 0)
        return amount == 0 ? 1 :0;

        if(amount < 0)
        return 0;

        if(dp[n][amount]!=-1)
        return dp[n][amount];

        return dp[n][amount]=recurmemo(nums,n,amount-nums[n],dp) + recurmemo(nums,n-1,amount,dp);
    }
}
