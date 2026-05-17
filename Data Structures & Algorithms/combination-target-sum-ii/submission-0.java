class Solution {
     List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans=new ArrayList();
        Arrays.sort(nums);
        recurmemo(nums,nums.length-1,target,new ArrayList());
        return ans;
    }

    public void recurmemo(int nums[],int n,int sum,List<Integer> list){
        if(sum == 0){
            ans.add(new ArrayList(list));
            return;
        }

        if(sum<0 || n<0)
        return;

        list.add(nums[n]);
        recurmemo(nums,n-1,sum-nums[n],list);
        list.remove(list.size()-1);

        while(n>0 && nums[n]==nums[n-1])
        n--;
        recurmemo(nums,n-1,sum,list);
    }
}
