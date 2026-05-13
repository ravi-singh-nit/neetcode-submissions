class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,n=s.length();
        int ans=0;
        Map<Character,Integer> map=new HashMap();
        while(r<n){
            char c=s.charAt(r);
            if(map.containsKey(c)){
                l=Math.max(map.get(c)+1,l);
            }
            map.put(c,r);
            ans=Math.max(r-l+1,ans);
            r++;
        }
        return ans;
        
    }
}
