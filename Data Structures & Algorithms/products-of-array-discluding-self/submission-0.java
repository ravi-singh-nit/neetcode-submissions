class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        int left[]=new int[nums.length];
        int n=nums.length;
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }

        int right[]= new int[nums.length];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        // print(left);
        // print(right);
        for(int i=0;i<n;i++){
            result[i]=left[i]*right[i];
        }
        return result;
    }

    public void print(int a[]){
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}  
