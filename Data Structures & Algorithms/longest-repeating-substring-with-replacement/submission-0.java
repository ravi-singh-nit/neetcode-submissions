class Solution {
    public int characterReplacement(String s, int k) {
        int start=0,end=0;
        int maxCharCount=0;
        int count[]=new int[26];
        int ans=0,n=s.length();

        for( end=0;end<n;end++){
            count[s.charAt(end)-'A']++;
            maxCharCount= Math.max(maxCharCount, count[s.charAt(end)-'A']);
            while(end-start+1 - maxCharCount > k ){
                count[s.charAt(start)-'A']--;
                start++;
            }
            ans=Math.max(end-start+1,ans);
        }
        return ans;
    }
}
