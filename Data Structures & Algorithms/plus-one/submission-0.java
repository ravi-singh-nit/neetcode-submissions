class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int sum=0,carry=1;
        for(int i=n-1;i>=0;i--){
            sum=digits[i]+carry;
            carry=sum/10;
            sum=sum%10;
            digits[i]=sum;
            if(carry==0)
            return digits;
        }
        if(carry!=0){
            int ans[]=new int[n+1];
            ans[0]=1;
            int k=1;
            for(int i:digits){
                ans[k++]=i;
            }
            return ans;
        }
        return null;


    }
}
