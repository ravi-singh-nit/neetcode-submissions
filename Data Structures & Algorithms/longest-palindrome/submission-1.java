class Solution {
    public int longestPalindrome(String s) {
        int count[]=new int[126];
        for(char c:s.toCharArray()){
            count[c-'A']++;
        }
        boolean hasOdd=false;
        int ans=0;
        for(int x :count){
            if(x%2==0){
                ans+=x;
            }else{
                ans+=x-1;
                hasOdd=true;
            }
        }

        if(hasOdd){
            ans++;
        }

        return ans;
    }
}