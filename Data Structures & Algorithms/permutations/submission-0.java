class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList();
        boolean vis[]=new boolean[nums.length];
        recurmemo(nums,new ArrayList(),vis);
        return ans;
    }

    public void recurmemo(int nums[],List<Integer> list,boolean vis[]){
        if(list.size()==nums.length){
            ans.add(new ArrayList(list));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]==true)
            continue; 

            list.add(nums[i]);
            vis[i]=true;
            recurmemo(nums,list,vis);
            vis[i]=false;
            list.remove(list.size()-1);
        }
    }
}
