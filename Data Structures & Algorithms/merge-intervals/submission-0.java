class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
            return a[0]-b[0];
            return a[1]-b[1];
        });

        List<int[]> ans=new ArrayList();
        ans.add(intervals[0]);
        int prev[]=intervals[0];
        int n=intervals.length;
        for(int i=1;i<n;i++){
            int curr[]=intervals[i];
            if(prev[1]>= curr[0]){
                prev[1]=Math.max(curr[1],prev[1]);
            }else{
                ans.add(curr);
                prev=curr;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
