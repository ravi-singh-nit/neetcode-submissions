class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int ans=1000000;
        int currSum =0;
        int n=nums.length;
        for(int r=0;r<n;r++){
            currSum+=nums[r];
            while(currSum >= target){
                ans=Math.min(ans,r-l+1);
                currSum-=nums[l++];
            }
        }
        return ans==1000000 ? 0:ans;

    }
}