class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return productUpToK(nums,k);
    }

    public int productUpToK(int nums[],int k){
        if(k<=1)
        return 0;
        int pro =1;
        int l=0;
        int count =0;
        int n=nums.length;
        for(int r=0;r<n;r++){
            pro*=nums[r];
            while(pro >= k){
                pro/=nums[l++];
            }

            count+=r-l+1;
        }
        return count;
    }
}