class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(0,1,prices,dp);
    }

    public int recurmemo(int n,int buy,int prices[],int dp[][]){
        if(n >= prices.length)
        return 0;
        
        if(dp[n][buy]!=-1)
        return dp[n][buy];

        if(buy==1){
            return dp[n][buy]=Math.max(-prices[n]+recurmemo(n+1,0,prices,dp),recurmemo(n+1,buy,prices,dp));
        }

        return dp[n][buy]=Math.max(prices[n]+recurmemo(n+2,1,prices,dp),recurmemo(n+1,buy,prices,dp));
    }
}
