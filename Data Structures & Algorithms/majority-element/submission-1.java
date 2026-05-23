class Solution {
    public int majorityElement(int[] nums) {
        int candi =0;
        int votes =0;
        for(int i:nums){
            if(votes ==0){
                candi=i;
                votes=1;
            } else{
                if(candi==i)
                votes++;
                else
                votes--;
            }
        }
        return candi;
        
    }
}