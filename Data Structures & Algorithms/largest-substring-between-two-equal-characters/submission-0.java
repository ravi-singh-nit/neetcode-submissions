class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> start=new HashMap();
        HashMap<Character,Integer> end = new HashMap();
        HashMap<Character,Integer> count = new HashMap();
        int n=s.length();
        int ans=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(start.containsKey(c)==false){
                start.put(c,i);
            }
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for(int i=n-1;i>=0;i--){
            char c=s.charAt(i);
            if(end.containsKey(c)==false){
                end.put(c,i);
            }
        }

        for(char c:s.toCharArray()){
            if(count.get(c)>1){
                ans=Math.max(ans,end.get(c)-start.get(c)-1);
            }
        }
        return ans;
    }
}