class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,char[]> possible=new HashMap();
        possible.put(2,new char[]{'a','b','c'});
        possible.put(3,new char[]{'d','e','f'});
        possible.put(4,new char[]{'g','h','i'});
        possible.put(5,new char[]{'j','k','l'});
        possible.put(6,new char[]{'m','n','o'});
        possible.put(7,new char[]{'p','q','r','s'});
        possible.put(8,new char[]{'t','u','v'});
        possible.put(9,new char[]{'w','x','y','z'});
        List<String> ans=new ArrayList();
         allPossible(digits,"",0,possible,ans);
         return ans;
    }

    public void allPossible(String s,String sol, int n,Map<Integer,char[]> map,List<String> ans){
        if(n==s.length()){
            if(sol.length()!=0)
            ans.add(sol);
            return;
        }

        char ch[]=map.get(s.charAt(n)-'0');
        for(char c:ch){
            allPossible(s,sol+c,n+1,map,ans);
        }
    }
}
