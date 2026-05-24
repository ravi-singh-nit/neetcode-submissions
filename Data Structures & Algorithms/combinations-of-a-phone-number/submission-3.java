class Solution {
    private static final String[] KEYPAD = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList();
        StringBuilder sb= new StringBuilder();
        getAll(digits,0,sb,ans);
        return ans;
    }
    public void getAll(String digits,int n,StringBuilder sb, List<String> ans){
        if(n==digits.length()){
            if(sb.length()!=0)
            ans.add(sb.toString());
            return;
        }

        for(char c:KEYPAD[digits.charAt(n)-'0'].toCharArray()){
            sb.append(c);
            getAll(digits,n+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
