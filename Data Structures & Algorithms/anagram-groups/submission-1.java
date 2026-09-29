class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap();
        for(String s:strs){
            String sorted = getSorted(s);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                map.put(sorted, new ArrayList());
                map.get(sorted).add(s);
            }
        }
        List<List<String>> ans= new ArrayList();
        for(Map.Entry<String,List<String>> me: map.entrySet()){
            ans.add(me.getValue());
        }
        return ans;
    }

    public String getSorted(String s){
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
