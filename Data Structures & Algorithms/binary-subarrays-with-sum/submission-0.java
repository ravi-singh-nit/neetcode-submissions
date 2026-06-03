class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return uptoKSum(nums,goal)-uptoKSum(nums,goal-1);
    }

    public int uptoKSum(int nums[],int goal){
        if(goal <0)
        return 0;
        int l=0;
        int n=nums.length;
        int currSum=0;
        int ans=0;

        for(int r=0;r<n;r++){
            currSum+=nums[r];
            while(currSum > goal){
                currSum-=nums[l++];
            }

            ans+=r-l+1;
        }
        return ans;
    }
}