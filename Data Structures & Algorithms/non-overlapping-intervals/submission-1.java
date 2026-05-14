class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
            return a[0]-b[0];
            return a[1]-b[1];
        });

        int prev[]=intervals[0];
        int n=intervals.length;
        int count=0;
        for(int i=1;i<n;i++){
            int curr[]=intervals[i];
            if(prev[1]>curr[0]){
                count++;
                if(curr[1]<prev[1])
                {
                    prev=curr;
                }
                

            }else{
                prev =curr;
            }
        }
        return count;

    }
}
