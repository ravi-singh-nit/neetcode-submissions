class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer dp[][]=new Integer[n][n];
        return recur(0,piles.length-1,piles,dp)>0;
    }

    public int recur(int l,int r,int nums[],Integer dp[][]){
        if(l==r)
        return nums[l];

        if(l>r)
        return 0;

        if(dp[l][r]!=null)
        return dp[l][r];

        int left =nums[l]-recur(l+1,r,nums,dp);
        int right=nums[r]-recur(l,r-1,nums,dp);
        return dp[l][r]=Math.max(left,right);
    }
}