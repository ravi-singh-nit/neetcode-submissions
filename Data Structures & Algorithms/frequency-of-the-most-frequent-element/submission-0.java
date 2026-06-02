class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        int l=0;
        int ans=0;
        int n=nums.length;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while((r-l+1)*nums[r] -sum > k){
                sum-=nums[l++];
            }
            ans=Math.max(ans,r-l+1);

        }
        return ans;
    }
}