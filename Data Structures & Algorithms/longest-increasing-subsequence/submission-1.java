class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n+1][n+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return recurmemo(nums,nums.length-1,-1,dp);
    }


    public int recurmemo(int nums[],int n,int prev,int dp[][]){
        if(n<0)
        return 0;

        if(dp[n+1][prev+1]!=-1)
        return dp[n+1][prev+1];
    
        int take=0;
        if(prev == -1 || nums[prev] > nums[n])
        take = 1+ recurmemo(nums,n-1,n,dp);

        int noTake= recurmemo(nums,n-1,prev,dp);

        return dp[n+1][prev+1]=Math.max(take,noTake);
    }
}
