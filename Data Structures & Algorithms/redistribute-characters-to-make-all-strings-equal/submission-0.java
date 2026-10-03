class Solution {
    public boolean makeEqual(String[] words) {
        int count[]=new int[26];
        int n=words.length;
        for(String s:words){
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
        }

        for(int x:count){
            if(x%n!=0)
            return false;
        }
        return true;


    }
}