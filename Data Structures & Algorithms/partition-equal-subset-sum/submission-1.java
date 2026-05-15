class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)
        sum+=i;
        if(sum%2==1)
        return false;

        int n=nums.length;
        Boolean dp[][]=new Boolean[n+1][sum+1];

        return recurmemo(nums,n-1,sum/2,dp);
        
    }

    public boolean recurmemo(int nums[],int n,int sum,Boolean dp[][]){
        if(n<0|| sum<0)
        return false;

        if(sum==0)
        return true;

        if(dp[n][sum]!=null)
        return dp[n][sum];

        boolean take=recurmemo(nums,n-1,sum-nums[n],dp);
        boolean noTake=recurmemo(nums,n-1,sum,dp);

        return dp[n][sum]=take||noTake;
    }
}
