class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int nextSmaller[]=nextSmaller(heights,n);
        int prevSmaller[]=prevSmaller(heights,n);
        // print(nextSmaller);
        // print(prevSmaller);
        int ans=0;
        for(int i=0;i<n;i++){
            int length=heights[i];
            int width=nextSmaller[i]-prevSmaller[i]-1;
            ans=Math.max(ans,length*width);
        }
        return ans;
        
    }

    public int[] nextSmaller(int nums[],int n){
        int ans[]=new int[n];
        Stack<Integer> st= new Stack();
        int r=n-1;
        while(r>=0){
            int curr=nums[r];
            while(st.size()!=0 && curr <= nums[st.peek()])
            st.pop();

            if(st.size()==0)
            ans[r]=n;
            else
            ans[r]=st.peek();

            st.push(r);
            r--;
        }
        return ans;
    }
    public void print(int a[]){
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }

    public int[] prevSmaller(int nums[],int n){
        int ans[]=new int[n];
        Stack<Integer> st= new Stack();
        for(int i=0;i<n;i++){
            int curr=nums[i];
            while(st.size()>0 && nums[st.peek()] >= curr)
            st.pop();

            if(st.size()==0)
            ans[i]=-1;
            else
            ans[i]=st.peek();

            st.push(i);
        }
        return ans;
    }
}
