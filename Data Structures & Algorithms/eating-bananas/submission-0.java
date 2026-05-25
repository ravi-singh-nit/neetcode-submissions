class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for(int i:piles){
            max=Math.max(max,i);
        }

        int r=max;
        int l=1;
        int ans=h+1;
        while(l<=r){
            int mid =l +(r-l)/2;
            int hours=caculateHours(piles,mid);
            if(hours<=h){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;

    }

    public int caculateHours(int nums[],int k){
        int h=0;
        for(int i:nums){
            int p=(int)Math.ceil(i/(1.0*k));
            h+=p;
            //System.out.println(p+" ");
        }
       // System.out.println(k+ " "+h);
        return h;
    }
}
