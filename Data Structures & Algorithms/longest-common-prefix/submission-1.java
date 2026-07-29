class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int min=minLen(strs);
        String ans="";
        for(int i=0;i<min;i++){
            char c=strs[0].charAt(i);
            int f=0;
            for(int j=1;j<n;j++){
                if(c!=strs[j].charAt(i)){
                    f=1;
                    break;
                }
            }
            if(f==1)
            break;
            ans=strs[0].substring(0,i+1);
        }
        return ans;
        
    }

    public int minLen(String s[]){
        int min=Integer.MAX_VALUE;
        for(String s1:s){
            min=Math.min(s1.length(),min);
        }
        return min;
    }
}