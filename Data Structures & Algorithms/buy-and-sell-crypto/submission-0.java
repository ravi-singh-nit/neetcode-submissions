class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int min=200;
        for(int i:prices){
            profit=Math.max(profit,i-min);
            min=Math.min(i,min);
        }
        return profit;
        
    }
}
