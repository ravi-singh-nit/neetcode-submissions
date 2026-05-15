class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans=recurmemo(coins,n-1,amount);
        return ans ==Integer.MAX_VALUE-1?  -1:ans;
    }

    public int recurmemo(int nums[],int n,int sum){
        if(n<0 || sum < 0)
        return Integer.MAX_VALUE-1;

        if(sum==0)
        return 0;

        int take = 1 + recurmemo(nums,n,sum-nums[n]);

        int noTake = recurmemo(nums,n-1,sum);

        return Math.min(take,noTake);

    }
}
