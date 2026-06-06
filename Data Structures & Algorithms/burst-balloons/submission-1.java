class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int coins[]=new int[n+2];
        int dp[][]= new int[n+2][n+2];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        for(int i=0;i<n;i++){
            coins[i+1]=nums[i];
        }
        coins[0]=coins[n+1]=1;

        return recurmemo(coins,1,n,dp);
    }

    public int recurmemo(int coins[],int l,int r,int dp[][]){
        if(l>r)
        return 0;
        if(dp[l][r]!=-1)
        return dp[l][r];

        int max=0;
        for(int k=l;k<=r;k++){
            int currMax = recurmemo(coins,l,k-1,dp) + 
                        recurmemo(coins,k+1,r,dp)+
                        coins[l-1]*coins[k]*coins[r+1];
            max=Math.max(max,currMax);
        }
        return dp[l][r]=max;
    }
}
