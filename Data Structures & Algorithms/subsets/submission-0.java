class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList();
        recurmemo(nums,nums.length-1,new ArrayList());
        return ans;
    }

    public void recurmemo(int nums[],int n,List<Integer> list){
        if(n<0){
            ans.add(new ArrayList(list));
            return;
        }
        list.add(nums[n]);
        recurmemo(nums,n-1,list);
        list.remove(list.size()-1);

        recurmemo(nums,n-1,list);

    }
}
