class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        Pair pa[]=new Pair[n];
        for(int i=0;i<n;i++){
            double time=(double)(target-position[i])/speed[i];
            pa[i]=new Pair(position[i],time);
        }
        Arrays.sort(pa,(a,b)->b.pos-a.pos);
        
        int ans=0;
        double prevTime=0;
        for(int i=0;i<n;i++){
            double currTime=pa[i].time;

            if(currTime > prevTime){
                ans++;
                prevTime=currTime;
            }
        }
        return ans;
    }
}

class Pair{
    int pos;
    double time;

    public Pair(int pos,double time){
        this.pos=pos;
        this.time=time;
    }
}
