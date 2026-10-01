class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int pp[]=new int[n];
        int sp[]=new int[n];
        pp[0]=1;
        for(int i=1;i<n;i++){
            pp[i]=pp[i-1]*nums[i-1];
        }

        sp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            sp[i]=sp[i+1]*nums[i+1];
        }

      //  System.out.println("prefix \n"+print(pp)+" suffix \n"+print(sp));
        for(int i=0;i<n;i++){
            ans[i]=pp[i]*sp[i];
        }


        return ans;

    }

    public String print(int nums[]){
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        return "";
    }
}  
