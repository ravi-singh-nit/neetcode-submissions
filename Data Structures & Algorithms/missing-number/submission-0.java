class Solution {
    public int missingNumber(int[] nums) {
        int ans=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            ans=(ans^nums[i]);
        }
        for(int i=0;i<=n;i++){
            ans=(ans^i);
        }
        return ans;
    }

}
