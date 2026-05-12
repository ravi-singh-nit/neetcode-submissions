class Solution {
    public boolean isAnagram(String s, String t) {
        int nums[]=new int[26];
        if(s.length()!=t.length())
        return false;
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-'a']++;
            nums[t.charAt(i)-'a']--;
        }
        for(int i:nums){
            if(i!=0)
                return false;
        }
        return true;
    }
}
