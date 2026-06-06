class Solution {
    public String minWindow(String s, String t) {
        int reqFreq[]=new int[128];
        int winFreq[]=new int[128];
        for(char c:t.toCharArray()){
            reqFreq[c]++;
        }

        int ans=Integer.MAX_VALUE;
        String sans="";
        int l=0;
        int n=s.length();
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            winFreq[c]++;

            while(check(winFreq,reqFreq)){
                int currL=Math.min(ans,r-l+1);
                if(currL < ans){
                    ans=currL;
                    sans=s.substring(l,r+1);
                }
                winFreq[s.charAt(l++)]--;
            }
        }

        return sans;

    }
    public boolean check(int a[],int b[]){
        for(int i='A';i<='z';i++){
            if(a[i]<b[i])
            return false;
        }
        return true;
    }
}
