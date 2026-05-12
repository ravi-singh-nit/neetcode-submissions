class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int i: nums){
            int count=0;
            if(set.contains(i)){
                int start=i;
                while(set.contains(start)){
                    count++;
                    start++;
                }
                start=i-1;
                while(set.contains(start)){
                    count++;
                    start--;
                }
            }
            max=Math.max(max,count);
        }
        return max;
        
    }
}
