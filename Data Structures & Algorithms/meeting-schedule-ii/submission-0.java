/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
            int n=intervals.size();
            int start[]=new int[n];
            int end[]=new int[n];
            for(int i=0;i<n;i++){
                start[i]=intervals.get(i).start;
                end[i]=intervals.get(i).end;
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int fs=0,ss=0;
            int count=0,ans=0;
            while(fs<n && ss<n){
                if(start[fs]<end[ss]){
                    count++;
                    fs++;
                }else{
                    ss++;
                    count--;
                }

                ans=Math.max(ans,count);
            }
            return ans;
    }
}
