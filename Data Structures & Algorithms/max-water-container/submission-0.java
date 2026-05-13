class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length-1;
        int ans=0;
    
        while(l<r){
            int width=r-l;
            int minh=0;
            if(heights[l]<heights[r]){
                minh=heights[l];
                l++;
            }else {
                minh=heights[r];
                r--;
            }
            ans=Math.max(ans,width*minh);

        }
        return ans;
        
    }
}
