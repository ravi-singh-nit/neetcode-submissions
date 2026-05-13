class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i])
            continue;
            List<List<Integer>> pair= getTwoSum(nums,i+1,n-1,-nums[i]);
            for(List<Integer> temp:pair){
                temp.add(nums[i]);
                Collections.sort(temp);
                ans.add(temp);
            }
        }
        return ans;
    }

    public List<List<Integer>> getTwoSum(int nums[],int l, int r, int target){
        List<List<Integer>> ans=new ArrayList();
        int start=l;
        while(l<r){
            if(l!=start && nums[l]==nums[l-1]){
                l++;
                continue;
            }

            int sum=nums[l]+nums[r];
            if(sum>target){
                r--;
            }else if(sum<target){
                l++;
            }else{
                List<Integer> tans=new ArrayList();
                tans.add(nums[l]);
                tans.add(nums[r]);
                ans.add(tans);
                l++;
                r--;
            }
            
        }
        return ans;
    }
}
