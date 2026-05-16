class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans=new ArrayList();
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
        recurmemo(nums,n,sum-nums[n],list);
        list.remove(list.size()-1);

        recurmemo(nums,n-1,sum,list);
    }
}
