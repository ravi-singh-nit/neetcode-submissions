class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int ans=nums[0];

        int n=nums.length;

        for(int i=1;i<n;i++){
            int curr= nums[i];
            if(curr <0){
                int temp=max;
                max=min;
                min=temp;
            }

            max=Math.max(curr, max*curr);
            min=Math.min(curr, min*curr);

            ans=Math.max(max,ans);

        }
        return ans;
    }
}
