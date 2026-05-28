class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int ans[]=new int[cost.length];
        Arrays.fill(ans,-1);
        int zeroIndex=recurmemo(0,cost,ans);
        Arrays.fill(ans,-1);
        int firstIndex=recurmemo(1,cost,ans);
        return Math.min(zeroIndex,firstIndex);
    }

    public int recurmemo(int index,int cost[],int ans[]){
        if(index==cost.length)
        return 0;

        if(index>= cost.length)
        return 500;
        if(ans[index]!=-1)
        return ans[index];

        return ans[index]=cost[index]+ Math.min(recurmemo(index+1,cost,ans),recurmemo(index+2,cost,ans));
    }
}
