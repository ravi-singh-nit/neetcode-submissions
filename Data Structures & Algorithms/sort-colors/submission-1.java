class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int start=0,end=n-1,mid=0;

        while(mid<=end){
            if(nums[mid] == 0){
                swap(start,mid,nums);
                start++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(mid,end,nums);
                end--;
            }
        }
        //return nums;
    }

    public void swap(int s,int e,int nums[]){
        int t=nums[s];
        nums[s]=nums[e];
        nums[e]=t;
    }
}