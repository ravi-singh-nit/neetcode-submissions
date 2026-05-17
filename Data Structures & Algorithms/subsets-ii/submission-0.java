class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList();
        Arrays.sort(nums);
        recurmemo(nums,nums.length-1,new ArrayList());
        return ans;
    }

    public void recurmemo(int nums[],int n,List<Integer> list){
        if(n<0){
            ans.add(new ArrayList(list));
            return ;
        }

        list.add(nums[n]);
        recurmemo(nums,n-1,list);
        list.remove(list.size()-1);

        while(n>0 && nums[n-1]==nums[n])
        n--;

        recurmemo(nums,n-1,list);
    }
}
