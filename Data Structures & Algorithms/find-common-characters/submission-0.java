class Solution {
    public List<String> commonChars(String[] words) {
        int prev[]=new int[26];
        int n=words.length;
        prev=calculateFrequency(words[0]);
        for(int i=1;i<words.length;i++){
            String s1=words[i];
            int curr[]=calculateFrequency(s1);
            minimize(prev,curr);
        }

        List<String> ans= new ArrayList();
        for(int i=0;i<26;i++){
            for(int j=prev[i];j>0;j--){
                char c=(char)('a'+i);
                ans.add(""+c);
            }
        }
        return ans;
        

    }

    public void minimize(int a[],int b[]){
        for(int i=0;i<26;i++){
            a[i]=Math.min(a[i],b[i]);
        }
    }


    public int[] calculateFrequency(String s){
        int count[]=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        return count;
        
    }
}