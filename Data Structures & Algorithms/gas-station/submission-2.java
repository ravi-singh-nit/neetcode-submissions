class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int extraGas =0,n=gas.length;
        for(int i=0;i<n;i++){
            extraGas+=gas[i]-cost[i];
        }
        if(extraGas <0)
        return -1;


        int start=0;
        int extra=0;
        for(int i=0;i<n;i++){
            extra+=gas[i]-cost[i];
            if(extra<0){
                extra=0;
                start=i+1;
            }

        }
        return start;
    }
}
