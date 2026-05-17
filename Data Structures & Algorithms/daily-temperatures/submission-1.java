class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int ans[]=new int[n];
        int r=n-1;
        Stack<Integer> st=new Stack();
        while(r>=0){
            int curr = temperatures[r];
            while(st.size()!=0 &&  temperatures[st.peek()] <= curr)
            st.pop();

            if(st.size()==0){
                ans[r]=0;
            }else{
                ans[r]=st.peek()-r;
            }
            st.push(r);
            r--;

        }
        return ans;
    }
}
